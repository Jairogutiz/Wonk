package com.example.jairo.quizz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StartActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }
    public void startQuiz (View view) {

        int quizCategory = 0; //All

        switch (view.getId()){
            case R.id.optionsBtn:
                quizCategory = 1;
                break;

            case  R.id.aboutBtn:
                quizCategory = 2;
                break;

            case  R.id.extraBtn:
                quizCategory = 3;
                break;
        }
            //Buttons links
        if (quizCategory == 0) {

                Intent intent = new Intent(getApplicationContext(), PlayActivity.class);
                intent.putExtra("OPTION_CATEGORY", quizCategory);
                startActivity(intent);

        }else if (quizCategory ==1){

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("OPTION_CATEGORY", quizCategory);
                startActivity(intent);

        }else if (quizCategory ==2){

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("OPTION_CATEGORY", quizCategory);
                startActivity(intent);

        }else if (quizCategory ==3){

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("OPTION_CATEGORY", quizCategory);
                startActivity(intent);
        }



    }

}
