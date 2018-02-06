package com.akakou.hobby.ankicho;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import ankicho.AnkichoController;
import ankicho.AnkichoWordFactory;

public class MainActivity extends AppCompatActivity {
    static final int REQUEST_CSV_GET = 1;
    AnkichoWordFactory ankichoWordFactory = AnkichoWordFactory.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("text/csv");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_CSV_GET);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CSV_GET && resultCode == RESULT_OK) {
            Uri uri = data.getData();

            File file = new File(uri.getPath());
            try {
                InputStream inputStream  = getContentResolver().openInputStream(uri);
                ankichoWordFactory.setBody(inputStream);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            Intent intent = new Intent(this, ShowQuestionActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);


        }
    }
}
