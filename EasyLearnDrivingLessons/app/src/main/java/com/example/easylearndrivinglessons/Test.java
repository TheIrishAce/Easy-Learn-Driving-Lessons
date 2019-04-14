package com.example.easylearndrivinglessons;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Test extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Button gen = findViewById(R.id.General);
        gen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                startActivity(new Intent(Test.this, GeneralActivity.class));
            }
        });

        Button car = findViewById(R.id.Car);
        car.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                startActivity(new Intent(Test.this, CarActivity.class));
            }
        });

        Button bike = findViewById(R.id.Bike);
        bike.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                startActivity(new Intent(Test.this, BikeActivity.class));
            }
        });
    }
}
