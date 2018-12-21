package ningjiaxin1.bwie.com.njx20181221;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import ningjiaxin1.bwie.com.njx20181221.bean.User;
import ningjiaxin1.bwie.com.njx20181221.sql.UserDao;
import ningjiaxin1.bwie.com.njx20181221.view.IView;
import ningjiaxin1.bwie.com.njx20181221.view.Pull;

public class MainActivity extends AppCompatActivity {
    private Button button_fan,button_cha;
    private EditText edit_name;
    private UserDao dao;
    private Pull pull;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_cha = findViewById(R.id.button_cha);
        edit_name = findViewById(R.id.edit_shou);
        pull = findViewById(R.id.pull);
        init();
    }
    private void init(){
        dao = new UserDao(this);
        List<User> select = dao.select();
        for(int i=0;i<select.size();i++) {
            TextView textView = new TextView(MainActivity.this);
            textView.setText(select.get(i).getName());
            pull.addView(textView);
        }
        button_cha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    TextView textView = new TextView(MainActivity.this);
                    textView.setText(edit_name.getText());
                    textView.setTextColor(Color.BLUE);
                    pull.addView(textView);
                    dao.add(textView.getText().toString());
                Intent intent = new Intent(MainActivity.this, Show.class);
                startActivity(intent);
            }
        });
    }

}
