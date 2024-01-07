package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button startbutton;
    TextView resulttextview;
    TextView pointsTextview;
    Button button;
    Button button1;
    Button button2;
    Button button3;
    TextView sumtextview;
    TextView timerTextView;
    Button playAgainButton;
    ArrayList<Integer> answers=new ArrayList<Integer>();
    int locationofcorrectanswer;
    int score=0;
    int numberofquestions=0;

//    public void playAgain(View view){
//        score=0;
//        numberofquestions=0;
//        timerTextView.setText("30s");
//        pointsTextview.setText("0/0");
//        resulttextview.setText("");
//        playAgainButton.setVisibility(View.INVISIBLE);
//        generatequestion();
//        new CountDownTimer(30000,1000){
//
//            @Override
//            public void onTick(long millisUntilFinished) {
//                timerTextView.setText(String.valueOf(millisUntilFinished/1000 + "s"));
//
//            }
//
//            @Override
//            public void onFinish() {
//                playAgainButton.setVisibility(View.VISIBLE);
//                timerTextView.setText("0s");
//                resulttextview.setText("Your Score : " + Integer.toString(score)+"/"+ Integer.toString(numberofquestions));
//
//            }
//        }.start();
//    }

   public void generatequestion(){
        Random rand=new Random();
        int a= rand.nextInt(21);
        int b= rand.nextInt(21);
        sumtextview.setText(Integer.toString(a) + "+"+ Integer.toString(b));
        locationofcorrectanswer= rand.nextInt(4);
        answers.clear();
       int incorrectanswer;
        for(int i=0;i<4;i++){
            if(i==locationofcorrectanswer){
                answers.add(a+b);
            }else{
                incorrectanswer=rand.nextInt(41);
                while(incorrectanswer==a+b){
                    incorrectanswer=rand.nextInt(41);
                }
                answers.add(incorrectanswer);
            }
        }
       button.setText(Integer.toString(answers.get(0)));
       button1.setText(Integer.toString(answers.get(1)));
       button2.setText(Integer.toString(answers.get(2)));
       button3.setText(Integer.toString(answers.get(3)));
    }


    public void chooseAnswer(View view){
//      Log.i("Tag",(String) view.getTag());
        if(view.getTag().toString().equals(Integer.toString(locationofcorrectanswer))){
//            //Log.i("correct","correct");
            score++;
            resulttextview.setText("CORRECT!!");
        }else {
            resulttextview.setText("WRONG!!");
//
        }
        numberofquestions++;
        pointsTextview.setText(Integer.toString(score)+"/" +Integer.toString(numberofquestions));

        generatequestion();

   // playAgain(findViewById(R.id.playagainbutton));
    }
//    public void start(View view){
//          startbutton.setVisibility(View.INVISIBLE);
//
//   }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startbutton = (Button) findViewById(R.id.startbutton);
        sumtextview = (TextView) findViewById(R.id.sumtextview);
        button = (Button) findViewById(R.id.button);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        resulttextview = (TextView) findViewById(R.id.resulttextview);
        pointsTextview = (TextView) findViewById(R.id.pointstextview);
        timerTextView = (TextView) findViewById(R.id.timerTextView);
        playAgainButton=(Button) findViewById(R.id.playagainbutton);
      generatequestion();
      //playAgain(findViewById(R.id.playagainbutton));


        new CountDownTimer(30000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(String.valueOf(millisUntilFinished/1000 + "s"));

            }

            @Override
            public void onFinish() {
                timerTextView.setText("0s");
                resulttextview.setText("Your Score : " + Integer.toString(score)+"/"+ Integer.toString(numberofquestions));

            }
        }.start();

    }
}