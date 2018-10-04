package tw.com.closer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_home );

        ImageButton setting = (ImageButton)findViewById(R.id.settingBtn);
        ImageButton learn = (ImageButton)findViewById(R.id.learnBtn);

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoSettingPage();
            }
        });

        learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoLearnPage();
            }
        });

    }

    //setting
    public void gotoSettingPage() {
        Intent it = new Intent( this, Setting.class );
        startActivity(it);
    }

    //setting
    public void gotoLearnPage() {
        Intent it = new Intent( this, MainActivity.class );
        startActivity(it);
    }
}
