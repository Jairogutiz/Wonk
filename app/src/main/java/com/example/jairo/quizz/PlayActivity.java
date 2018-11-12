package com.example.jairo.quizz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

public class PlayActivity extends AppCompatActivity {

    private TextView titleText;
    private Button optionBtn1;
    private Button optionBtn2;
    private Button optionBtn3;
    private Button optionBtn4;
    private Button optionBtn5;
    private Button optionBtn6;
    private Button optionBtn7;
    private Button optionBtn8;

    ArrayList<String> optionsArray = new ArrayList<>();

    String optionsTopics[][] = {
            //{"Category", "topic1","topic2", "topic3", "topic4", etc }
            {"Categories"},
            {"Countries", "Geography", "Flags", "Capitals", "Population", "Economy"},
            {"Animals", "Speed", "Life Expectancy", "Weight", "Kingdoms"},
            {"People", "Richest", "Faster", "Followers", "Youtubers", "Instagram"},
            {"Food", "More Fat", "More Proteins", "test"},
            {"Cars", "Horse Power", "Wheels", "whatever", "etc"}

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        titleText = (TextView) findViewById(R.id.titleTextView);
        optionBtn1 = (Button) findViewById(R.id.optionBtn1);
        optionBtn2 = (Button) findViewById(R.id.optionBtn2);
        optionBtn3 = (Button) findViewById(R.id.optionBtn3);
        optionBtn4 = (Button) findViewById(R.id.optionBtn4);
        optionBtn5 = (Button) findViewById(R.id.optionBtn5);
        optionBtn6 = (Button) findViewById(R.id.optionBtn6);
        optionBtn7 = (Button) findViewById(R.id.optionBtn7);
        optionBtn8 = (Button) findViewById(R.id.optionBtn8);

        for (int i=0 ; i < optionsTopics.length; i++){

            optionsArray.add(optionsTopics[i][0]);

            }
        showNextTopics();

        }
        //int to know how many categories there are in order to make the next for loop work
        int numberOfCategories = 0;


            public void showNextTopics(){

                //Set title from optionsArray
                titleText.setText(optionsArray.get(0));



                //Set options
                if (1 < optionsArray.size()) {
                    optionBtn1.setText(optionsArray.get(1));
                    optionBtn1.setVisibility(View.VISIBLE);
                }if (2 < optionsArray.size()) {
                    optionBtn2.setText(optionsArray.get(2));
                    optionBtn2.setVisibility(View.VISIBLE);
                }if (3 < optionsArray.size()) {
                    optionBtn3.setText(optionsArray.get(3));
                    optionBtn3.setVisibility(View.VISIBLE);
                }if (4 < optionsArray.size()) {
                    optionBtn4.setText(optionsArray.get(4));
                    optionBtn4.setVisibility(View.VISIBLE);
                }if (5 < optionsArray.size()) {
                    optionBtn5.setText(optionsArray.get(5));
                    optionBtn5.setVisibility(View.VISIBLE);
                }if (6 < optionsArray.size()) {
                    optionBtn6.setText(optionsArray.get(6));
                    optionBtn6.setVisibility(View.VISIBLE);
                }if (7 < optionsArray.size()) {
                    optionBtn7.setText(optionsArray.get(7));
                    optionBtn7.setVisibility(View.VISIBLE);
                }if (8 < optionsArray.size()) {
                    optionBtn8.setText(optionsArray.get(8));
                    optionBtn8.setVisibility(View.VISIBLE);
                }

                numberOfCategories = optionsArray.size();

    }

        public void openOption (View view){

            //Get pushed button
            Button categorySelected = findViewById(view.getId());
            String btnText = categorySelected.getText().toString();

            int indexSelected = 0;




        for (int i = 0; i < numberOfCategories; i++) {


            if (btnText == optionsArray.get(i)) {

                // Make the buttons invisible again
                optionBtn3.setVisibility(View.INVISIBLE);
                optionBtn4.setVisibility(View.INVISIBLE);
                optionBtn5.setVisibility(View.INVISIBLE);
                optionBtn6.setVisibility(View.INVISIBLE);
                optionBtn7.setVisibility(View.INVISIBLE);
                optionBtn8.setVisibility(View.INVISIBLE);

                //Set title from optionsArray
                titleText.setText(optionsTopics[i][0]);

                 if (1 < optionsTopics[i].length) {
                    optionBtn1.setText(optionsTopics [i][1]);
                    optionBtn1.setVisibility(View.VISIBLE);
                }if (2 < optionsTopics[i].length) {
                    optionBtn2.setText(optionsTopics [i][2]);
                    optionBtn2.setVisibility(View.VISIBLE);
                }if (3 < optionsTopics[i].length) {
                    optionBtn3.setText(optionsTopics [i][3]);
                    optionBtn3.setVisibility(View.VISIBLE);
                }if (4 < optionsTopics[i].length) {
                    optionBtn4.setText(optionsTopics [i][4]);
                    optionBtn4.setVisibility(View.VISIBLE);
                }if (5 < optionsTopics[i].length) {
                    optionBtn5.setText(optionsTopics [i][5]);
                    optionBtn5.setVisibility(View.VISIBLE);
                }if (6 < optionsTopics[i].length) {
                    optionBtn6.setText(optionsTopics [i][6]);
                    optionBtn6.setVisibility(View.VISIBLE);
                }if (7 < optionsTopics[i].length) {
                    optionBtn7.setText(optionsTopics [i][7]);
                    optionBtn7.setVisibility(View.VISIBLE);
                }if (8 < optionsTopics[i].length) {
                    optionBtn8.setText(optionsTopics [i][8]);
                    optionBtn8.setVisibility(View.VISIBLE);
                }

            }
        }








        }


    }

