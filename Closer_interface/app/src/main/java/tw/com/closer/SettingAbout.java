package tw.com.closer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class SettingAbout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_setting_about );

        ImageButton home = (ImageButton)findViewById(R.id.homeBtn);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoHomePage();
            }
        });
    }

    //home
    public void gotoHomePage() {
        Intent it = new Intent( this, Home.class );
        startActivity(it);
    }
}
