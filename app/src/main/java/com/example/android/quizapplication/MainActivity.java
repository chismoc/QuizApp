package com.example.android.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startQuiz = findViewById(R.id.startQuiz_btn);

        //button clicked to go to quiz activity
        startQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz();
            }
        });
    }

    private void startQuiz() {
        EditText name = findViewById(R.id.name_edit_text);
        String myName = name.getText().toString();
        if(myName != null && !myName.isEmpty()){
            Intent intent = new Intent(this,QuizActivity.class);
            intent.putExtra("user",myName);
            startActivity(intent);

        }else{

            Toast.makeText(this, "Please Enter Your Name", Toast.LENGTH_SHORT).show();

        }}}