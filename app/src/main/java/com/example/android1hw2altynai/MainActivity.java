package com.example.android1hw2altynai;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText1, editText2, editText3;
    private TextView textView;
    private Button button;
    private String set;
    private double int1, int2, int3;

    public static String KEY = "key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!(editText1.getText().toString().equals("") && editText2.getText().toString().equals("")
                        && editText3.getText().toString().equals(""))) {
                    int1 = Integer.parseInt(editText1.getText().toString());
                    int2 = Integer.parseInt(editText2.getText().toString());
                    int3 = Integer.parseInt(editText3.getText().toString());
                    set = Double.valueOf(int1 + int2 / int3).toString();
//                textView.setText(int1 + "+" + int2 + "/" + int3 + "=" + set);
                } else {
                    Toast.makeText(MainActivity.this, "is empty!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void init() {
        button = findViewById(R.id.btn1);
        textView = findViewById(R.id.txt_view);
        editText1 = findViewById(R.id.et_text1);
        editText2 = findViewById(R.id.et_text2);
        editText3 = findViewById(R.id.et_text3);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY, set);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        set = savedInstanceState.getString(KEY);
        textView.setText(set);
    }
}



