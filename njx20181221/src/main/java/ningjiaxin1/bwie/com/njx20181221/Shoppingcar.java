package ningjiaxin1.bwie.com.njx20181221;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ningjiaxin1.bwie.com.njx20181221.R;

import ningjiaxin1.bwie.com.njx20181221.adapter.XRecyclaAdapter;
import ningjiaxin1.bwie.com.njx20181221.bean.Goods;
import ningjiaxin1.bwie.com.njx20181221.persenter.IPersentermpl;
import ningjiaxin1.bwie.com.njx20181221.view.IView;

public class Shoppingcar extends AppCompatActivity implements IView {
    @Override
    public void setOnSuccess(Object o) {

    }
//    private String path="http://www.zhaoapi.cn/product/getCarts?";
//    private ShangPinAdapter adapter;
//    private RecyclerView shangrecyclerView;
//    IPersentermpl iPersentermpl;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_shoppingcar);
//    }
//   public void init(){
//       iPersentermpl = new IPersentermpl(this);
//       shangrecyclerView = findViewById(R.id.sj_recycle);
//       LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//       linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//       shangrecyclerView.setLayoutManager(linearLayoutManager);
//       Map<String,String> map=new HashMap<>();
//       map.put("uid",71+"");
//       adapter=new ShangPinAdapter(this);
//       shangrecyclerView.setAdapter(adapter);
//       iPersentermpl.startRequest(path,map,Goods.class);
//       // xRecyclerView.setAdapter(adapter);
//   }
//    @Override
//    public void setOnSuccess(Object o) {
//        Goods bean= (Goods) o;
//        List<Goods.DataBean> data = bean.getData();
//        //adapter.setList(data);
//    }
    private void jian(){

    }
    public void getsum(){
        int totle=0;
        int sum=0;

    }
}
