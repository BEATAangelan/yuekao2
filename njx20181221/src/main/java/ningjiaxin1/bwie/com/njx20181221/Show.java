package ningjiaxin1.bwie.com.njx20181221;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import ningjiaxin1.bwie.com.njx20181221.adapter.XRecyclaAdapter;
import ningjiaxin1.bwie.com.njx20181221.bean.Goods;
import ningjiaxin1.bwie.com.njx20181221.persenter.IPersentermpl;
import ningjiaxin1.bwie.com.njx20181221.view.IView;

public class Show extends AppCompatActivity implements IView {
    private String path="http://www.zhaoapi.cn/product/searchProducts?";
    private XRecyclerView xRecyclerView;
    private XRecyclaAdapter adapter;
    private int Page=1;
    IPersentermpl iPersentermpl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        xRecyclerView=findViewById(R.id.xRecy);
        xRecyclerView.setLoadingMoreEnabled(true);
        xRecyclerView.setPullRefreshEnabled(true);
        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                Page=1;
                init();
            }

            @Override
            public void onLoadMore() {
                Page++;
                init();
            }
        });
        init();
    }
    public void init(){
        iPersentermpl = new IPersentermpl(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xRecyclerView.setLayoutManager(linearLayoutManager);
        Map<String,String> map=new HashMap<>();
        map.put("keywords","手机");
       map.put("page",1+"");
        adapter=new XRecyclaAdapter(this);
        xRecyclerView.setAdapter(adapter);
        iPersentermpl.startRequest(path,map,Goods.class);
       // xRecyclerView.setAdapter(adapter);
    }
    @Override
    public void setOnSuccess(Object o) {
        Goods bean= (Goods) o;
        List<Goods.DataBean> data = bean.getData();
        if(Page==1){
            adapter.setList(data);
        }else
        {
            adapter.addList(data);
        }
        xRecyclerView.refreshComplete();
        xRecyclerView.loadMoreComplete();
    }
    //解绑
    public void de(){
       iPersentermpl.onDestoy();
    }
}
