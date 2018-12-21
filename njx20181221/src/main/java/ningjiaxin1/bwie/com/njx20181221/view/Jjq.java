package ningjiaxin1.bwie.com.njx20181221.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import ningjiaxin1.bwie.com.njx20181221.R;

public class Jjq extends LinearLayout implements View.OnClickListener{
    private int num;
    Context context;
    EditText edit;
    public Jjq(Context context) {
        super(context);
        init();
    }

    public Jjq(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Jjq(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.button_jia:
                num++;
                edit.setText(edit.getText().toString());
                break;
            case R.id .button_jian:
                if(num>1){
                    Toast.makeText(context,"我是底线",Toast.LENGTH_SHORT).show();
                }
                else{
                    num--;
                    edit.setText(edit.getText().toString());
                }
                break;
        }
    }
    public void init(){

    }
}
