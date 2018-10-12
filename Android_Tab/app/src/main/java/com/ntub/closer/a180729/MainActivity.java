package com.ntub.closer.a180729;

import android.app.Fragment;
import android.os.Bundle;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
public class MainActivity extends AppCompatActivity {
    private FragmentManager fmgr;
    private FragmentTransaction fragmentTransaction;
    private ViewGroup container;
    private Fragment page1Fragment, page2Fragment, page3Fragment, page4Fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 取得 container, 做為容器使用
        container = (ViewGroup) findViewById(R.id.container);
        // 取得 FragmentManager物件實體
        fmgr = getFragmentManager();
        // 建立四個Fragment物件實體
        page1Fragment = new Page1Fragment();
        page2Fragment = new Page2Fragment();
        page3Fragment = new Page3Fragment();

        // 取得交易物件
        fragmentTransaction = fmgr.beginTransaction();
        // 初始加入第一頁, 並與 container 結合
        fragmentTransaction.add(R.id.container, page1Fragment);
        // 實現動作程序
        fragmentTransaction.commit();
    }
    public void changeToPage1(View view){
        fragmentTransaction = fmgr.beginTransaction();
        fragmentTransaction.replace(R.id.container, page1Fragment);
        fragmentTransaction.commit();
    }
    public void changeToPage2(View view){
        fragmentTransaction = fmgr.beginTransaction();
        fragmentTransaction.replace(R.id.container, page2Fragment);
        fragmentTransaction.commit();
    }
    public void changeToPage3(View view){
        fragmentTransaction = fmgr.beginTransaction();
        fragmentTransaction.replace(R.id.container, page3Fragment);
        fragmentTransaction.commit();
    }
}
