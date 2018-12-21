package ningjiaxin1.bwie.com.njx20181221.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ningjiaxin1.bwie.com.njx20181221.bean.User;

public class UserDao {
    private Sql sql;
    private SQLiteDatabase database;
    public UserDao(Context context){
        sql=new Sql(context);
        database=sql.getReadableDatabase();
    }
    public void add(String name){
        ContentValues values = new ContentValues();
        values.put("name",name);
        database.insert("user",null,values);
    }
    public List<User> select(){
        List<User> list = new ArrayList<>();
        Cursor query = database.query("user", null, null, null, null, null, null);
        while (query.moveToNext()){
            String name = query.getString(query.getColumnIndex("name"));
            User user = new User(name);
            list.add(user);
        }
        return list;
    }
}
