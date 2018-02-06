package com.akakou.hobby.ankicho;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import ankicho.AnkichoController;
import ankicho.AnkichoWord;

public class ShowQuestionActivity extends AppCompatActivity {
    AnkichoController ankichoController = AnkichoController.getInstance();
    AnkichoWord ankichoWord = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_question);
    }

    protected void onStart() {
        super.onStart();

        // 問題を表示
        TextView questionTextView = (TextView)findViewById(R.id.question_text);
        ankichoWord = ankichoController.giveOne();
        questionTextView.setText(ankichoWord.question);
    }

    public void onClick(View v) {
        Intent intent = new Intent(this, ShowAnswerActivity.class);
        intent.putExtra("answer", ankichoWord.answer);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }
}
