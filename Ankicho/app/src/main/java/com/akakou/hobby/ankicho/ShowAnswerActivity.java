package com.akakou.hobby.ankicho;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import ankicho.AnkichoController;

public class ShowAnswerActivity extends AppCompatActivity {
    String answer = "";
    AnkichoController ankichoController = AnkichoController.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_answer);

        // 正答の表示
        Intent intent = getIntent();
        answer = intent.getStringExtra("answer");
        TextView answerTextView = (TextView)findViewById(R.id.answer_text);
        answerTextView.setText(answer);
    }

    public void onClick(View v) {

        if (v.getId() == R.id.solve_button) {
            boolean has_more_word = ankichoController.solveOne();

            if (!has_more_word) {
                Intent intent = new Intent(this, FinishActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        }

        finish();
    }
}
