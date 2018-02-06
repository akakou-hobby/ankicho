package com.akakou.hobby.ankicho;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import ankicho.AnkichoController;
import ankicho.AnkichoWord;

public class ShowAnswerActivity extends AppCompatActivity {
    AnkichoWord ankichoWord;
    AnkichoController ankichoController = AnkichoController.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_answer);

        // 問題と正答の表示
        Intent intent = getIntent();
        ankichoWord = (AnkichoWord) intent.getSerializableExtra("word");

        TextView questionTextView = (TextView)findViewById(R.id.question_text);
        questionTextView.setText(ankichoWord.question);
        TextView answerTextView = (TextView)findViewById(R.id.answer_text);
        answerTextView.setText(ankichoWord.answer);
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
