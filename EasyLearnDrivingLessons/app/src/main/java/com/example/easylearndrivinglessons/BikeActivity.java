package com.example.easylearndrivinglessons;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class BikeActivity extends AppCompatActivity {

    private QuestionLibary ql=new QuestionLibary();
    private Button mb1;
    private Button mb2;
    private Button mb3;
    private Button mb4;
    private TextView qu;
    ImageView pic;

    private String mAnswer;
    private TextView asw;
    int score=0;
    private int qnum=0;


    ArrayList<Integer> number = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);
        qnum=0;
        number.add(0);
        number.add(1);
        number.add(2);
        number.add(3);
        number.add(4);
        number.add(5);
        number.add(6);
        number.add(7);
        number.add(8);
        number.add(9);

        Collections.shuffle(number);

        //pic.findViewById(R.id.imageView2);
        asw=(TextView)findViewById(R.id.score1);
        qu=(TextView)findViewById(R.id.question);
        mb1=(Button)findViewById(R.id.choice1);
        mb2=(Button)findViewById(R.id.choice2);
        mb3=(Button)findViewById(R.id.choice3);
        mb4=(Button)findViewById(R.id.choice4);
        asw.setText("Score: "+score);
        updateQuestion(number.get(qnum));




        mb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qnum++;
                if(qnum==10){
                    end();
                }

                else if(mb1.getText()==mAnswer){
                    score++;
                    asw.setText("Score: "+score);
                    updateQuestion(number.get(qnum));

                }
                else{
                    updateQuestion(number.get(qnum));
                }
            }
        });

        mb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qnum++;
                if(qnum==10){
                    end();
                }

                else if(mb2.getText()==mAnswer){
                    score++;
                    asw.setText("Score: "+score);
                    updateQuestion(number.get(qnum));

                }
                else{
                    updateQuestion(number.get(qnum));
                }
            }
        });

        mb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qnum++;
                if(qnum==10){
                    end();
                }

                else  if(mb3.getText()==mAnswer){
                    score++;
                    asw.setText("Score: "+score);
                    updateQuestion(number.get(qnum));

                }
                else{
                    updateQuestion(number.get(qnum));
                }
            }
        });

        mb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qnum++;
                if(qnum==10){
                    end();
                }

                else if(mb4.getText()==mAnswer){
                    score++;
                    //asw.setText((Integer.toString(score)));
                    asw.setText("Score: "+score);
                    updateQuestion(number.get(qnum));

                }
                else{
                    updateQuestion(number.get(qnum));
                }
            }
        });





    }

    private void updateQuestion(int num){
        if(qnum==10){  end();
        }


        // pic.setImageIcon(ql.myImages.get(num));
        qu.setText(ql.getQuestionBike(num));
        mb1.setText(ql.getChoiceBike1(num));
        mb2.setText(ql.getChoiceBike2(num));
        mb3.setText(ql.getChoiceBike3(num));
        mb4.setText(ql.getChoiceBike4(num));

        mAnswer=ql.getCorrectBike(num);

    }


    private void end(){
        AlertDialog.Builder alertDialogBuilder =new AlertDialog.Builder(BikeActivity.this);
        alertDialogBuilder
                .setMessage("Test Finished your score is "+score)
                .setCancelable(false)
                .setPositiveButton("Retry",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(getApplicationContext(), BikeActivity.class));
                            }
                        })
                .setNegativeButton("Exit",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });
        AlertDialog alertDialog=alertDialogBuilder.create();
        alertDialog.show();
    }
}
