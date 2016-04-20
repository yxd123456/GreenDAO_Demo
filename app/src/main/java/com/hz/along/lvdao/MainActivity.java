package com.hz.along.lvdao;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.xxx.bean.SchoolBean;
import com.xxx.bean.UserBean;
import com.xxx.dao.DaoMaster;
import com.xxx.dao.DaoSession;
import com.xxx.dao.SchoolBeanDao;
import com.xxx.dao.UserBeanDao;

import java.util.List;

import de.greenrobot.dao.query.Query;

public class MainActivity extends AppCompatActivity {

    private DaoSession daoSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDb();

    }

    public void add(View v){
        UserBean note = new UserBean("18", "10086", "picture", "client_id", "LiLei", "beijing", "男", "18");
        getUserBeanDao().insert(note);
        Toast.makeText(this, "增加成功!", Toast.LENGTH_SHORT).show();
    }

    public void delete(View v){
       //getUserBeanDao().deleteByKey("1");
        getUserBeanDao().deleteAll();

    }

    public void change(View v){
        UserBean note = new UserBean("18", "10086", "picture", "client_id", "HanMeiMei", "beijing", "男", "18");
        getUserBeanDao().insertOrReplace(note);
    }

    public void query(View v){
        Query query = getUserBeanDao().queryBuilder().build();

        List<UserBean> notes = query.list();
        Toast.makeText(this, "size"+notes.size(), Toast.LENGTH_SHORT).show();
        if(notes.size() != 0){
            Toast.makeText(this, notes.get(0).getName(), Toast.LENGTH_SHORT).show();

        }

    }

    public void add1(View v){
        SchoolBean schoolBean = new SchoolBean("3", "希望小学");
        getSchoolBeanDao().insert(schoolBean);
        Toast.makeText(this, "增加成功!", Toast.LENGTH_SHORT).show();
    }

    public void delete1(View v){
        //getUserBeanDao().deleteByKey("1");
        getSchoolBeanDao().deleteAll();

    }

    public void change1(View v){
        SchoolBean schoolBean = new SchoolBean("3", "胜利小学");
        getSchoolBeanDao().insertOrReplace(schoolBean);
    }

    public void query1(View v){
        Query query = getSchoolBeanDao().queryBuilder().build();

        List<SchoolBean> notes = query.list();
        Toast.makeText(this, "size"+notes.size(), Toast.LENGTH_SHORT).show();
        if(notes.size() != 0){
            Toast.makeText(this, notes.get(0).getName(), Toast.LENGTH_SHORT).show();

        }

    }

    private void initDb() {

        THDevOpenHelper helper = new THDevOpenHelper(this, "my-db", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();

    }

    private UserBeanDao getUserBeanDao() {
        return daoSession.getUserBeanDao();
    }

    private SchoolBeanDao getSchoolBeanDao(){
        return daoSession.getSchoolBeanDao();
    }

}
