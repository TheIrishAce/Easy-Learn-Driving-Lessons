package com.example.easylearndrivinglessons;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.easylearndrivinglessons.youtubeVideos.VideoActivity;

public class MainActivity extends AppCompatActivity {

    private Switch colorModeSwitch;
    SharedPrefs sharedpref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        colorModeSwitch = findViewById(R.id.colorModeSw);
        checkTheme();
        //themeChanger();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        //themeChanger();
       //variable for map button
        Button mapBtn = findViewById(R.id.NearestTestCentreBtn);
        mapBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                startActivity(new Intent(MainActivity.this, MapsActivity.class));
            }
        });

        Button contactButton = findViewById(R.id.ContactUsBtn);
        contactButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                startActivity(new Intent(MainActivity.this, contact_page.class));
            }
        });

        Button testButton = findViewById(R.id.takeTestBtn);
        testButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                startActivity(new Intent(MainActivity.this, Test.class));
            }
        });

        Button videoButton = findViewById(R.id.VideoLessonsBtn);
        videoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                startActivity(new Intent(MainActivity.this, VideoActivity.class));
            }
        });

        Button insuranceButton = findViewById(R.id.InsuranceBtn);
        insuranceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this, recommended_insurance.class));
            }
        });

        Button schoolsButton = findViewById(R.id.DrivingSchoolBtn);
        schoolsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this, recommended_schools.class));
            }
        });

        Button revisionButton = findViewById(R.id.TestQuestionsBtn);
        revisionButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                startActivity(new Intent(MainActivity.this, RevisionMaterial.class));
            }
        });
    }

    public void setTheme(){
        sharedpref = new SharedPrefs(this);
        if(sharedpref.loadNightModeState()==true){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

    public void checkTheme(){
        if (sharedpref.loadNightModeState()==true){
            colorModeSwitch.setChecked(true);
        }
        colorModeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    sharedpref.setNightModeState(true);
                    restartApp();
                }
                else {
                    sharedpref.setNightModeState(false);
                    restartApp();
                }
            }
        });
    }

    public void restartApp(){
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
