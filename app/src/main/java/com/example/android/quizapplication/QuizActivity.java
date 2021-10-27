package com.example.android.quizapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class QuizActivity extends Activity {
    //Instatiate widgets
    TextView score;
    TextView noOfQuestions;
    TextView question;
    RadioGroup radioGroup;
    RadioButton radioBOne;
    RadioButton radioBTwo;
    RadioButton radioBThree;
    Button submit;
    Button submit2;
    Button submit3;


    int totalQuestions = 0;
    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //Initialise TextView and set username to the TextView
        TextView name = findViewById(R.id.username);
        Bundle bundle = getIntent().getExtras();
        String username = bundle.getString("user");
        name.setText(String.valueOf(username));


        Question question1 = new Question("What course are you studying ?", "Java", "Android Basics", "Kotlin", "Android Basics");
        Question question2 = new Question("Which is not a Layout ?", "LinearLayout", "RelativeLayout", "TextView", "TextView");
        Question question3 = new Question("Which dimension is used for TextSize ?", "sp", "tx", "dp", "sp");

        TextView score = findViewById(R.id.score_text_view);
        TextView noOfQuestions = findViewById(R.id.noOfQuestions_text_view);
        TextView question = findViewById(R.id.question_text_view);
        question.setText(question1.getMquestion());
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        RadioButton radioBOne = findViewById(R.id.radioBOne);
        radioBOne.setText(question1.getOption1());
        RadioButton radioBTwo = findViewById(R.id.radioBTwo);
        radioBTwo.setText(question1.getOption2());
        RadioButton radioBThree = findViewById(R.id.radioBThree);
        radioBThree.setText(question1.getOption3());
        Button submit = findViewById(R.id.submit_btn);
        Button submit2 = findViewById(R.id.submit2_btn);
        Button submit3 = findViewById(R.id.submit3_btn);
        Button end = findViewById(R.id.end_btn);
        ImageView image = findViewById(R.id.image);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  boolean isCheccked;
                if (radioBTwo.isChecked()) {
                    count += 1;
                    totalQuestions += 1;
                    noOfQuestions.setText("Number Of Question " + totalQuestions + " /3");
                    score.setText("Score: " + count);
                    question.setText(question2.getMquestion());
                    radioBOne.setText(question2.getOption1());
                    radioBTwo.setText(question2.getOption2());
                    radioBThree.setText(question2.getOption3());
                    submit.setVisibility(View.GONE);
                    submit2.setVisibility(View.VISIBLE);


                } else {
                    count += 0;
                    totalQuestions += 1;
                    noOfQuestions.setText("Number Of Question " + totalQuestions + " /3");
                    question.setText(question2.getMquestion());
                    radioBOne.setText(question2.getOption1());
                    radioBTwo.setText(question2.getOption2());
                    radioBThree.setText(question2.getOption3());
                    submit.setVisibility(View.GONE);
                    submit2.setVisibility(View.VISIBLE);
                }

                submit2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (radioBThree.isChecked()) {
                            count += 1;
                            totalQuestions += 1;
                            noOfQuestions.setText("Number Of Question " + totalQuestions + " /3");
                            score.setText("Score: " + count);
                            question.setText(question3.getMquestion());
                            radioBOne.setText(question3.getOption1());
                            radioBTwo.setText(question3.getOption2());
                            radioBThree.setText(question3.getOption3());
                            submit2.setVisibility(View.GONE);
                            submit3.setVisibility(View.VISIBLE);

                        } else {
                            totalQuestions += 1;
                            noOfQuestions.setText("Number Of Question " + totalQuestions + " /3");
                            count += 0;
                            question.setText(question3.getMquestion());
                            radioBOne.setText(question3.getOption1());
                            radioBTwo.setText(question3.getOption2());
                            radioBThree.setText(question3.getOption3());
                            submit2.setVisibility(View.GONE);
                            submit3.setVisibility(View.VISIBLE);

                        }
                    }

                });
                submit3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (radioBOne.isChecked()) {
                            totalQuestions += 1;
                            noOfQuestions.setText("Number Of Question " + totalQuestions + " /3");
                            count += 1;
                            score.setText("Score: " + count);
                            submit3.setVisibility(View.GONE);
                            end.setVisibility(View.VISIBLE);
                        } else {
                            totalQuestions += 1;
                            noOfQuestions.setText("Number Of Question " + totalQuestions + " /3");
                            count += 0;

                            submit3.setVisibility(View.GONE);
                            end.setVisibility(View.VISIBLE);


                        }
                    }

                    ;

                });

            }

            ;
        });
    }

    public void end(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

