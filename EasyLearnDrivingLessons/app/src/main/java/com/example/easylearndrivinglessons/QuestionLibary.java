package com.example.easylearndrivinglessons;

public class QuestionLibary {
    private String mQuestions []={
            "What does this sign mean",
            "What must a driver do when this sign is accompanied by a white stop line on the road",
            "What must a driver do when this sign is NOT accompanied by a white line on the road",
            "This hand signal means th is driver is.."

    };

    private String mChoice [][]={
            {"Stop, for school crossing ahead","Stop your vehicle","Other traffic must give way to you","Give way to traffic coming from your right"},
            {"Stop at the line","Stop when you have passed the line","Stop only if there is traffic on the major road","No more than one car length past the line"},
            {"No more than one car length past the sign","Stop at the sign","Only if there is traffic at the junction","Only when having passed the sign"},
            {"Slowing down","Turning right","Turning left","Going straight ahead"}

    };

    private String mCa[]={"Stop your vehicle","Stop at the sign","Stop at the sign","Turning right"};

    public String getQuestion(int a){
        String question=mQuestions[a];
        return question;
    }

    public String getChoice1(int a){
        String choice1=mChoice[a][0];
        return choice1;
    }

    public String getChoice2(int a){
        String choice2=mChoice[a][1];
        return choice2;
    }

    public String getChoice3(int a){
        String choice3=mChoice[a][2];
        return choice3;
    }

    public String getChoice4(int a){
        String choice4=mChoice[a][3];
        return choice4;
    }

    public String getCorrect(int a){
        String ans=mCa[a];
        return ans;
    }

}
