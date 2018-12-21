package ningjiaxin1.bwie.com.njx20181221.untils;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;


import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpUntils {
    private static volatile OkHttpUntils instance;
    private OkHttpClient mClient;
    private Handler handler=new Handler(Looper.getMainLooper());
    //单例
    public static OkHttpUntils getInstance() {
        if(instance==null) {
            synchronized (OkHttpUntils.class){
                instance=new OkHttpUntils();
            }
        }
        return instance;
    }
    public OkHttpUntils(){
        mClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build();
    }
    //定义接口
    public interface OkCallBack{
        void onSuccess(Object o);
        void failed(Exception e);
    }
    //post请求
    public void postRequest(String url, Map<String,String> map, final Class clazz, final OkCallBack okCallBack){
        FormBody.Builder builder = new FormBody.Builder();
        for(Map.Entry<String,String> entry:map.entrySet()){
            builder.add(entry.getKey(),entry.getValue());
        }
        FormBody build = builder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(build)
                .build();
        Call call = mClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                       okCallBack.failed(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                Gson gson = new Gson();
                final Object o = gson.fromJson(result, clazz);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                      okCallBack.onSuccess(o);
                    }
                });
            }
        });

    }
}
