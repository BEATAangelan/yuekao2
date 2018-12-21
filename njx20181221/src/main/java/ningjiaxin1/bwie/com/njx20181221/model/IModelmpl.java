package ningjiaxin1.bwie.com.njx20181221.model;

import java.util.Map;

import ningjiaxin1.bwie.com.njx20181221.untils.MCallBack;
import ningjiaxin1.bwie.com.njx20181221.untils.OkHttpUntils;

public class IModelmpl implements IModel{
    MCallBack mCallBack;
    @Override
    public void setRequest(String url, Map<String, String> map, Class clazz, MCallBack callBack) {
        mCallBack=callBack;
        OkHttpUntils.getInstance().postRequest(url, map, clazz, new OkHttpUntils.OkCallBack() {
            @Override
            public void onSuccess(Object o) {
                mCallBack.setdata(o);
            }

            @Override
            public void failed(Exception e) {
               mCallBack.setdata(e);
            }
        });
    }
}
