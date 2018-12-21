package ningjiaxin1.bwie.com.njx20181221.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import ningjiaxin1.bwie.com.njx20181221.R;
import ningjiaxin1.bwie.com.njx20181221.Shoppingcar;
import ningjiaxin1.bwie.com.njx20181221.bean.Goods;

public class XRecyclaAdapter extends RecyclerView.Adapter<XRecyclaAdapter.ViewHolder> {
    private Context context;
    private List<Goods.DataBean> list;

    public XRecyclaAdapter(Context context) {
        this.context = context;
        list=new ArrayList<>();
    }

    public void setList(List<Goods.DataBean> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }
    public void addList(List<Goods.DataBean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public XRecyclaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LinearLayout.inflate(context, R.layout.item, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String[] url = list.get(i).getImages().split("\\|");
        Glide.with(context).load(url[0]).into(viewHolder.image);
        viewHolder.text_price.setText(list.get(i).getPrice()+"");
        viewHolder.text_title.setText(list.get(i).getTitle());
//        viewHolder.button_add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, Shoppingcar.class);
//                context.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text_title,text_price;
        ImageView image;
        Button button_add;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text_title = itemView.findViewById(R.id.text_title);
            text_price = itemView.findViewById(R.id.price);
            image = itemView.findViewById(R.id.image_phone);
           // button_add= button_add.findViewById(R.id.button_add);
        }
    }
    //接口调用
    private OnItemClickListener monItemClickListener;
    public interface OnItemClickListener {
       void setOnClick(int pid);
    }
    public void setonItemClickListener(OnItemClickListener onItemClickListener){
        monItemClickListener=onItemClickListener;
    }
}
