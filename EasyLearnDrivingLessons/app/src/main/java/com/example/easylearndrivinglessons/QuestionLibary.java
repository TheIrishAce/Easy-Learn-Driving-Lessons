package com.example.easylearndrivinglessons;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionLibary {
    private String mQuestions []={
            "What does a stop sign mean",
            "What must a driver do when a stop sign is accompanied by a white stop line on the road",
            "What must a driver do when a stop sign is NOT accompanied by a white line on the road",
            "What does a driver putting there open hand out the window mean  .."

    };


    private String mChoice [][]={
            {"Stop, for school crossing ahead","Stop your vehicle","Other traffic must give way to you","Give way to traffic coming from your right"},
            {"Stop at the line","Stop when you have passed the line","Stop only if there is traffic on the major road","No more than one car length past the line"},
            {"No more than one car length past the sign","Stop at the sign","Only if there is traffic at the junction","Only when having passed the sign"},
            {"Slowing down","Turning right","Turning left","Going straight ahead"}

    };

    private String mCa[]={"Stop your vehicle","Stop at the line","Stop at the sign","Turning right"};

    private String mQuestionsCar []={
            "When parked on a busy road, what should the driver be aware of",
            "What must a driver do when a stop sign is accompanied by a white stop line on the road",
            "What must a driver do when a stop sign is NOT accompanied by a white line on the road"


    };

    private String mChoiceCar [][]={
            {"Stop for school crossing ahead","Before opening the door the driver should make sure it is safe to do so","Other traffic must give way to you","Give way to traffic coming from the right"},
            {"Stop at the line","Stop when you have passed the line","Stop only if there is traffic on the major road","No more than one car length past the line"},
            {"No more than one car length past the sign","Stop at the sign","Only if there is traffic at the junction","Only when having passed the sign"}


    };

    private String mCaCar[]={"Stop your vehicle","Stop at the line","Stop at the sign"};

    private String mQuestionsBike []={
            "What should you always wear while riding a motorcycle",
            "What on a motorcycle should be checked weekly",
            "What should a motorcyclist check before starting the engine",
            "When a motorcyclist is cornering what should they do",
            "What should a motorcyclist avoid overtaking",
            "How should a motorcyclist apply the breaks to stop quickly in an emergency ",
            "What should motorcyclists be aware of when there is melting tar on the road",
            "When should the rear brake of a motorcycle be used on its own",
            "When should a motorcyclist brake firmly",
            "What might cause a rider to loose control of a motorcycle"

    };


    private String mChoiceBike  [][]={
            {"A helmet","a helmet and gloves","Protective clothing and a helmet","Protective clothing, gloves and a helmet"},
            {"Petrol, oil, water, damage, electrics and tyres","tyres and petrol","Tyres","Oil and water"},
            {"That the first gear is selected","That the reverse gear is selected","That the neutral gear is selected","The gear selected doesn't matter"},
            {"Lean in the direction of the turn","Don't lean at all","Lean in the opposite direction of the turn","Lean forwards"},
            {"Causing oncoming traffic to alter course or speed","contacting vehicles as you closely maneuver around them","Speeding up to overtake","Checking his/hers mirrors before overtaking"},
            {"Use the front brake followed by the rear brake","Use the rear brake followed by the front brake","Use the front brake only","Use the rear brake only"},
            {"Melting tar is not good nor bad for tyre grip","Melting tar is good for the tyre grip","Melting tar reduces tyre grip","Melting tar reduces speed"},
            {"During slow maneuvers","During all maneuvers","During high speed maneuvers","During emergencies only"},
            {"Only on the straight","Only in turns","Never brake firmly","Always brake firmly"},
            {"Low fuel levels","Battery power is low","Water on the bikes wheels","Water on the road"}

    };

    private String mCaBike []={"Protective clothing, gloves and a helmet","Petrol, oil, water, damage, electrics and tyres","That the neutral gear is selected","Lean in the direction of the turn","Causing oncoming traffic to alter course or speed","Use the front brake followed by the rear brake","Melting tar reduces tyre grip","During slow maneuvers","Only on the straight","Water on the road"};

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

    public String getQuestionCar(int b){
        String question=mQuestionsCar[b];
        return question;
    }

    public String getChoiceCar1(int a){
        String choice1=mChoiceCar[a][0];
        return choice1;
    }

    public String getChoiceCar2(int a){
        String choice2=mChoiceCar[a][1];
        return choice2;
    }

    public String getChoiceCar3(int a){
        String choice3=mChoiceCar[a][2];
        return choice3;
    }

    public String getChoiceCar4(int a){
        String choice4=mChoiceCar[a][3];
        return choice4;
    }

    public String getCorrectCar(int a){
        String ans=mCaCar[a];
        return ans;
    }

    public String getQuestionBike(int a){
        String question=mQuestionsBike[a];
        return question;
    }

    public String getChoiceBike1(int a){
        String choice1=mChoiceBike[a][0];
        return choice1;
    }

    public String getChoiceBike2(int a){
        String choice2=mChoiceBike[a][1];
        return choice2;
    }

    public String getChoiceBike3(int a){
        String choice3=mChoiceBike[a][2];
        return choice3;
    }

    public String getChoiceBike4(int a){
        String choice4=mChoiceBike[a][3];
        return choice4;
    }

    public String getCorrectBike(int a){
        String ans=mCaBike[a];
        return ans;



    }
}
