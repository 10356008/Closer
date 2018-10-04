package tw.com.closer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_setting);

        ImageButton home = (ImageButton)findViewById(R.id.homeBtn);
        ImageButton userSetting = (ImageButton)findViewById(R.id.userBtn);
        ImageButton aboutSetting = (ImageButton)findViewById(R.id.aboutBtn );
        ImageButton learn = (ImageButton)findViewById(R.id.learnBtn);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoHomePage();
            }
        });

        userSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUserSettingPage();
            }
        });

        aboutSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoAboutSettingPage();
            }
        });

        learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoLearnPage();
            }
        });
    }

    //home
    public void gotoHomePage() {
        Intent it = new Intent( this, Home.class );
        startActivity(it);
    }

    //SettingUser
    public void gotoUserSettingPage() {
        Intent it = new Intent( this, SettingUser.class );
        startActivity(it);
    }

    //SettingAbout
    public void gotoAboutSettingPage() {
        Intent it = new Intent( this, SettingAbout.class );
        startActivity(it);
    }

    public void gotoLearnPage() {
        Intent it = new Intent( this, MainActivity.class );
        startActivity(it);
    }
}
