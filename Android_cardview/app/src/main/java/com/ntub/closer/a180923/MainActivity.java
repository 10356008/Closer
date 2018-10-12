package com.ntub.closer.a180923;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.ntub.closer.a180923.adapter.MyAdapter;
import com.ntub.closer.a180923.data.*;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //=============================================================================
    // 首次載入App時會執行onResume(), 下次Activity由背景回到前景時也會執行onResume()
    //=============================================================================
    @Override
    protected void onResume() {
        super.onResume();

        //----------------
        // 資料建立及顯示
        //----------------
        initializeData(this);
    }


    //----------------------
    // 產生資料
    //----------------------
    private void initializeData(Context context) {
        // 產生將顯示的資料
        Common.lives = new ArrayList<Life>();

        for(int i=0; i<Common.pic.length; i++) {
            Common.lives.add(new Life(Common.pic[i], Common.textInfo[i]));
        }

        // 產生 RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.myRecycleView);
        recyclerView.setHasFixedSize(true);

        // 設定 RecycleView的版型
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);

        // 產生一個 MyAdapter物件, 連結將加入的資料
        MyAdapter myAdapter = new MyAdapter(Common.lives);

        // 將結合資料後的 myAdapter 加入 RecyclerView物件中
        recyclerView.setAdapter(myAdapter);
    }
}
