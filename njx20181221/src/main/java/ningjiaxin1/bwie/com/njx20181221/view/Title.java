package ningjiaxin1.bwie.com.njx20181221.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import ningjiaxin1.bwie.com.njx20181221.R;

public class Title extends LinearLayout {
    Button button_fan,button_shou;
    EditText edit_shou;
    Context context;
    public Title(Context context) {
        super(context);
        init();
    }

    public Title(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Title(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    public void init(){
        View view = View.inflate(context, R.layout.title_shou, null);
        button_fan= findViewById(R.id.button_fan);
         button_shou = findViewById(R.id.button_cha);
         edit_shou= findViewById(R.id.edit_shou);
         button_shou.setOnClickListener(new OnClickListener() {
             @Override
             public void onClick(View v) {
                 if(monsetCallBack!=null){
                     monsetCallBack.getdata(edit_shou.getText().toString());
                 }
             }
         });
         addView(view);
    }
    //接口回调
    private OnsetCallBack monsetCallBack;
    public interface OnsetCallBack{
        void getdata(String str);
    }
    public void setCallBack(OnsetCallBack onsetCallBack){

        monsetCallBack=onsetCallBack;
    }
}
