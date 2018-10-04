package tw.com.closer;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import tw.com.closer.data.Common;

public class Main2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //--------------------
                // 返回原Activity
                //--------------------
                finish();
            }
        });
    }

    //=============================================================================
    // 首次載入App時會執行onResume(), 下次Activity由背景回到前景時也會執行onResume()
    //=============================================================================
    @Override
    protected void onResume() {
        super.onResume();

        //------------------------
        // 取得顯示資料物件
        //------------------------
        ImageView imageView=(ImageView)this.findViewById(R.id.imageView);
        TextView textView=(TextView)this.findViewById(R.id.textView);

        //-------------------------------------
        // 取得傳來Bundle中的參數(position)
        //-------------------------------------
        Bundle bundle=getIntent().getExtras();
        int position=bundle.getInt("position");

        //---------------------------------
        // 由靜態變數及指標取得複點擊的資料
        //---------------------------------
        imageView.setImageResource(Common.lives.get(position).getPicture());
        textView.setText(Common.lives.get(position).getInfo());
    }
}
