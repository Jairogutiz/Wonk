package com.example.jairo.quizz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView countLabel;
    private TextView questionLabel;
    private Button answerBtn1;
    private Button answerBtn2;
    private Button answerBtn3;


    private String rightAnswer;
    private int rightAnswerCount = 0;
    private int quizCount = 1;
    static  final private int QUIZ_COUNT = 10;

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

                    String quizData[][] ={
                            //{"Country", "Right Answer","Choice1", "Choice2", "Choice3" }
                            {"United Arab Emirates","Abu Dhabi"},
                            {"Nigeria","Abuja"},
                            {"Ghana","Accra"},
                            {"Ethiopia","Addis Ababa"},
                            {"Algeria","Algiers"},
                            {"Jordan","Amman"},
                            {"Netherlands","Amsterdam"},
                            {"Andorra","Andorra la Vella"},
                            {"Turkey","Ankara"},
                            {"Madagascar","Antananarivo"},
                            {"Samoa","Apia"},
                            {"Turkmenistan","Ashgabat"},
                            {"Eritrea","Asmara"},
                            {"Kazakhstan","Astana"},
                            {"Paraguay","Asuncion"},
                            {"Greece","Athens"},
                            {"Iraq","Baghdad"},
                            {"Azerbaijan","Baku"},
                            {"Mali","Bamako"},
                            {"Brunei","Bandar Seri Begawan"},
                            {"Thailand","Bangkok"},
                            {"Central African Republic","Bangui"},
                            {"Gambia","Banjul"},
                            {"Saint Kitts and Nevis","Basseterre"},
                            {"China","Beijing"},
                            {"Lebanon","Beirut"},
                            {"Northern Ireland","Belfast"},
                            {"Serbia","Belgrade"},
                            {"Belize","Belmopan"},
                            {"Germany","Berlin"},
                            {"Switzerland","Bern"},
                            {"Kyrgyzstan","Bishkek"},
                            {"Guinea-Bissau","Bissau"},
                            {"Colombia","Bogota"},
                            {"Brazil","Brasilia"},
                            {"Slovakia","Bratislava"},
                            {"Congo, Republic of the","Brazzaville"},
                            {"Barbados","Bridgetown"},
                            {"Belgium","Brussels"},
                            {"Romania","Bucharest"},
                            {"Hungary","Budapest"},
                            {"Argentina","Buenos Aires"},
                            {"Burundi","Bujumbura"},
                            {"Egypt","Cairo"},
                            {"Australia","Canberra"},
                            {"Venezuela","Caracas"},
                            {"Wales","Cardiff"},
                            {"Saint Lucia","Castries"},
                            {"French Guiana","Cayenne"},
                            {"Moldova","Chisinau"},
                            {"Sri Lanka","Colombo"},
                            {"Guinea","Conakry"},
                            {"Denmark","Copenhagen"},
                            {"Senegal","Dakar"},
                            {"Syria","Damascus"},
                            {"Bangladesh","Dhaka"},
                            {"East Timor","Dili"},
                            {"Djibouti","Djibouti"},
                            {"Tanzania","Dodoma3"},
                            {"Qatar","Doha"},
                            {"Ireland","Dublin"},
                            {"Tajikistan","Dushanbe"},
                            {"Scotland","Edinburgh"},
                            {"Sierra Leone","Freetown"},
                            {"Tuvalu","Funafuti4"},
                            {"Botswana","Gaborone"},
                            {"Guyana","Georgetown"},
                            {"Guatemala","Guatemala City"},
                            {"Vietnam","Hanoi"},
                            {"Zimbabwe","Harare"},
                            {"Cuba","Havana"},
                            {"Finland","Helsinki"},
                            {"Solomon Islands","Honiara"},
                            {"Pakistan","Islamabad"},
                            {"Indonesia","Jakarta"},
                            {"South Sudan","Juba"},
                            {"Afghanistan","Kabul"},
                            {"Uganda","Kampala"},
                            {"Nepal","Kathmandu"},
                            {"Sudan","Khartoum"},
                            {"Ukraine","Kiev"},
                            {"Rwanda","Kigali"},
                            {"Jamaica","Kingston"},
                            {"Saint Vincent and the Grenadines","Kingstown"},
                            {"Congo, Democratic Republic of the","Kinshasa"},
                            {"Malaysia","Kuala Lumpur"},
                            {"Kuwait","Kuwait City"},
                            {"Bolivia","La Paz"},
                            {"Gabon","Libreville"},
                            {"Malawi","Lilongwe"},
                            {"Peru","Lima"},
                            {"Portugal","Lisbon"},
                            {"Slovenia","Ljubljana"},
                            {"Togo","Lome"},
                            {"United Kingdom","London"},
                            {"England","London"},
                            {"Angola","Luanda"},
                            {"Zambia","Lusaka"},
                            {"Luxembourg","Luxembourg"},
                            {"Spain","Madrid"},
                            {"Marshall Islands","Majuro"},
                            {"Equatorial Guinea","Malabo"},
                            {"Maldives","Male"},
                            {"Nicaragua","Managua"},
                            {"Bahrain","Manama"},
                            {"Philippines","Manila"},
                            {"Mozambique","Maputo"},
                            {"Lesotho","Maseru"},
                            {"Swaziland","Mbabana"},
                            {"Palau","Melekeok"},
                            {"Mexico","Mexico City"},
                            {"Belarus","Minsk"},
                            {"Somalia","Mogadishu"},
                            {"Monaco","Monaco"},
                            {"Liberia","Monrovia"},
                            {"Uruguay","Montevideo"},
                            {"Comoros","Moroni"},
                            {"Russia","Moscow"},
                            {"Oman","Muscat"},
                            {"Chad","N'Djamena"},
                            {"Kenya","Nairobi"},
                            {"Bahamas","Nassau"},
                            {"Myanmar (Burma)","Nay Pyi Taw2"},
                            {"India","New Delhi"},
                            {"Niger","Niamey"},
                            {"Cyprus","Nicosia"},
                            {"Nauru","No official capital"},
                            {"Mauritania","Nouakchott"},
                            {"Tonga","Nuku'alofa"},
                            {"Norway","Oslo"},
                            {"Canada","Ottawa"},
                            {"Burkina Faso","Ouagadougou"},
                            {"Federated States of Micronesia","Palikir"},
                            {"Panama","Panama City"},
                            {"Suriname","Paramaribo"},
                            {"France","Paris"},
                            {"Cambodia","Phnom Penh"},
                            {"Montenegro","Podgorica"},
                            {"Haiti","Port au Prince"},
                            {"Mauritius","Port Louis"},
                            {"Papua New Guinea","Port Moresby"},
                            {"Trinidad and Tobago","Port of Spain"},
                            {"Vanuatu","Port Vila"},
                            {"Benin","Porto Novo"},
                            {"Czech Republic","Prague"},
                            {"Cape Verde","Praia"},
                            {"South Africa","Pretoria"},
                            {"Kosovo","Pristina"},
                            {"North Korea","Pyongyang"},
                            {"Ecuador","Quito"},
                            {"Morocco","Rabat"},
                            {"Iceland","Reykjavik"},
                            {"Latvia","Riga"},
                            {"Saudi Arabia","Riyadh"},
                            {"Italy","Rome"},
                            {"Dominica","Roseau"},
                            {"Grenada","Saint George's"},
                            {"Antigua and Barbuda","Saint John's"},
                            {"Costa Rica","San Jose"},
                            {"San Marino","San Marino"},
                            {"El Salvador","San Salvador"},
                            {"Yemen","Sanaa"},
                            {"Chile","Santiago"},
                            {"Dominican Republic","Santo Domingo"},
                            {"Sao Tome and Principe","Sao Tome"},
                            {"Bosnia and Herzegovina","Sarajevo"},
                            {"South Korea","Seoul"},
                            {"Singapore","Singapore"},
                            {"Macedonia","Skopje"},
                            {"Bulgaria","Sofia"},
                            {"Sweden","Stockholm"},
                            {"Fiji","Suva"},
                            {"Taiwan","Taipei"},
                            {"Estonia","Tallinn"},
                            {"Kiribati","Tarawa Atoll"},
                            {"Uzbekistan","Tashkent"},
                            {"Georgia","Tbilisi"},
                            {"Honduras","Tegucigalpa"},
                            {"Iran","Tehran"},
                            {"Israel","Tel Aviv1"},
                            {"Bhutan","Thimphu"},
                            {"Albania","Tirana (Tirane)"},
                            {"Japan","Tokyo"},
                            {"Libya","Tripoli"},
                            {"Tunisia","Tunis"},
                            {"Mongolia","Ulaanbaatar"},
                            {"Liechtenstein","Vaduz"},
                            {"Malta","Valletta"},
                            {"Vatican City","Vatican City"},
                            {"Seychelles","Victoria"},
                            {"Austria","Vienna"},
                            {"Laos","Vientiane"},
                            {"Lithuania","Vilnius"},
                            {"Poland","Warsaw"},
                            {"United States","Washington D.C."},
                            {"New Zealand","Wellington"},
                            {"Namibia","Windhoek"},
                            {"Cote d'Ivoire","Yamoussoukro"},
                            {"Cameroon","Yaounde"},
                            {"Armenia","Yerevan"},
                            {"Croatia","Zagreb"},

                    };








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countLabel = (TextView)findViewById(R.id.countLabel);
        questionLabel = (TextView)findViewById(R.id.questionLabel);
        answerBtn1 = (Button)findViewById(R.id.answerBtn1);
        answerBtn2 = (Button)findViewById(R.id.answerBtn2);
        answerBtn3 = (Button)findViewById(R.id.answerBtn3);


        //Recieve quizCategory from StartActivity.
        int quizCategory = getIntent().getIntExtra("QUIZ_CATEGORY", 0);

        Log.v("CATEGORY_TAG", quizCategory + "");

                            //Create quizArray from quizData

                            for (int i=0 ; i < quizData.length; i++){

                                ArrayList<String> tmpArray = new ArrayList<>();

                                tmpArray.add(quizData[i][0]);
                                tmpArray.add(quizData[i][1]);



                                // Add tmpArray to quizArray

                                quizArray.add(tmpArray);
                            }
        showNextQuiz();

    }

                        public void showNextQuiz(){

                            //Update quizCountLabel
                            countLabel.setText("Q" + quizCount);

                            // Generate random number between 0 and 14
                            Random random = new Random();
                            int randomNum = random.nextInt(quizData.length);

                            //pick one quiz set.
                            ArrayList<String> quiz = new ArrayList<>();
                                    quiz.add(quizData[randomNum][0]);
                                    quiz.add(quizData[randomNum][1]);
                                    quiz.add(quizData[randomNum + 1][1]);
                                    quiz.add(quizData[randomNum + 2][1]);

                            // Set question and right answer
                            //Array format : {"Country", "Right Answer","Choice1", "Choice2", "Choice3" }
                            questionLabel.setText(quiz.get(0));
                            rightAnswer = quiz.get(1);

                            //Remove "Country" from quiz and Shuffle choices.
                            quiz.remove(0);
                            Collections.shuffle(quiz);

                            // Set Choices.
                            answerBtn1.setText(quiz.get(0));
                            answerBtn2.setText(quiz.get(1));
                            answerBtn3.setText(quiz.get(2));




                        }


                        //XML onClick
            public void checkAnswer (View view){

                //Get pushed button
                Button answerBtn = (Button) findViewById(view.getId());
                String btnText = answerBtn.getText().toString();

                String alertTitle;

                if (btnText.equals(rightAnswer)) {
                    //Correct
                    alertTitle = "Correct!";
                    rightAnswerCount++;

                }else{
                    //Wrong
                    alertTitle = "Wrong!";
                }

                //CreateDialog
                AlertDialog.Builder builder= new AlertDialog.Builder(this);
                builder.setTitle(alertTitle);
                builder.setMessage("Answer :" + rightAnswer);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(quizCount == QUIZ_COUNT){
                        // Show Result.
                            Intent intent = new Intent(getApplicationContext(),ResultActivity.class);
                            intent.putExtra("RIGHT_ANSWER_COUNT", rightAnswerCount);
                            startActivity(intent);
                    }else {
                        quizCount++;
                        showNextQuiz();
                    }

                    }

                });
                builder.setCancelable(false);
                builder.show();



            }
}
