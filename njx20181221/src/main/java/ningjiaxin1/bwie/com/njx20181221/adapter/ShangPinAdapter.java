package ningjiaxin1.bwie.com.njx20181221.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ningjiaxin1.bwie.com.njx20181221.R;
import ningjiaxin1.bwie.com.njx20181221.bean.Goods;
import ningjiaxin1.bwie.com.njx20181221.bean.Gwc;

//public class ShangPinAdapter extends RecyclerView.Adapter<ShangPinAdapter.ViewHolder> {
//    private Context context;
//    private List<Gwc.DataBean> list;
//
//    public ShangPinAdapter(Context context) {
//        this.context = context;
//        list=new ArrayList<>();
//    }
//
//    @NonNull
//    @Override
//    public ShangPinAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        View view = LayoutInflater.from(context).inflate( R.layout.shangpin,viewGroup, false);
//        ViewHolder viewHolder = new ViewHolder(view);
//        return viewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ShangPinAdapter.ViewHolder viewHolder, int i) {
//        viewHolder.text.setTextColor(list.get(i).getSellerName());
//    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        TextView text;
//        RecyclerView recyclerView;
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            text = itemView.findViewById(R.id.shangjia);
//            recyclerView = itemView.findViewById(R.id.re_pin);
//        }
//    }
//}
