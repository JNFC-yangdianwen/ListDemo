package com.example.first;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    //创建一个list（集合列表），其中为Map泛型
    List<Map<String, Object>> list = new ArrayList<>();
    //定义三个数组（int image[]，String name[],String desc[]）明确数据来源
    private int[]    image = {R.mipmap.blue, R.mipmap.action, R.mipmap.logo_2};
    private String[] name  = {"语文", "数学", "英语"};
    private String[] desc  = {"人文地理", "数据结构", "English"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //使用for循环遍历数据来源
        for (int i = 0; i < image.length; i++) {
            //创建Map对象，添加所需数据
            Map<String, Object> showItem = new HashMap<>();
            showItem.put("pic", image[i]);
            showItem.put("ming", name[i]);
            showItem.put("cha", desc[i]);
            //把Map对象加入到list对象中
            list.add(showItem);
        }
        //创建SimpleAdapter对象，
        // 传入5个参数，context，list对象，layout，Map中的key，Map中的key所对应的值
        SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.mylist_view
                //map中的key
                , new String[]{"pic", "ming", "cha"},
                //map中的value
                new int[]{R.id.image, R.id.text1, R.id.text2});
        ListView show = (ListView) findViewById(R.id.lv_show);
        //绑定监听
        show.setOnItemClickListener(this);
        show.setOnItemLongClickListener(this);
        show.setAdapter(adapter);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(MainActivity.this, "第" + position + "个条目", Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(MainActivity.this, "长按了第" + position + "个条目", Toast.LENGTH_SHORT).show();
        return true;
    }
}