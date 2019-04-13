package com.example.easylearndrivinglessons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class GeneralActivity extends AppCompatActivity {
    private QuestionLibary ql=new QuestionLibary();
    private Button mb1;
    private Button mb2;
    private Button mb3;
    private Button mb4;
    private Button sub;
    private TextView qu;

    private String ans;
    private int score=0;
    private int qnum=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);
        qu=(TextView)findViewById(R.id.question);
        mb1=(Button)findViewById(R.id.choice1);
        mb2=(Button)findViewById(R.id.choice2);
        mb3=(Button)findViewById(R.id.choice3);
        mb4=(Button)findViewById(R.id.choice4);
        sub=(Button)findViewById(R.id.submit);
        updateQuestion();

        mb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mb1.getText()==ans){
                    score=score+1;
                    //updateScore(score);
                    updateQuestion();
                }
                else{
                    updateQuestion();
                }
            }
        });



    }
    private void updateQuestion(){
        qu.setText(ql.getQuestion(qnum));
        mb1.setText(ql.getChoice1(qnum));
        mb2.setText(ql.getChoice2(qnum));
        mb3.setText(ql.getChoice3(qnum));
        mb4.setText(ql.getChoice4(qnum));
        ans=ql.getCorrect(qnum);
        qnum++;
    }
}
