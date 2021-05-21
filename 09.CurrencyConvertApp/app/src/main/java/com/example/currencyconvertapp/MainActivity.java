package com.example.currencyconvertapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Formatter;

public class MainActivity extends AppCompatActivity {

    Button euro, pound, dollar, btc, dinar, rubel, canDollar, ausDollar, yen;
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        euro = findViewById(R.id.euro);
        pound = findViewById(R.id.pound);
        dollar = findViewById(R.id.dollar);
        btc = findViewById(R.id.btc);
        dinar = findViewById(R.id.dinar);
        rubel = findViewById(R.id.rubel);
        canDollar = findViewById(R.id.canDollar);
        ausDollar = findViewById(R.id.ausDollar);
        yen = findViewById(R.id.yen);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);

        euro.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String z = editText.getText().toString();
                if (TextUtils.isEmpty(z)){
                    editText.setError("Empty User Input");
                } else {
                    double n,k;
                    n = Double.parseDouble(z);
                    textView.setText("");
                    Formatter formatter = new Formatter();
                    k = n * 0.012;
                    DecimalFormat numberFormat = new DecimalFormat("#.00");
                    textView.setText(""+ numberFormat.format(k));
                }
            }
        });

        dollar.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String z = editText.getText().toString();
                if (TextUtils.isEmpty(z)){
                    editText.setError("Empty User Input");
                } else {
                    double n,k;
                    n = Double.parseDouble(z);
                    textView.setText("");
                    Formatter formatter = new Formatter();
                    k = n * 0.014;
                    DecimalFormat numberFormat = new DecimalFormat("#.00");
                    textView.setText(""+ numberFormat.format(k));
                }
            }
        });

        pound.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String z = editText.getText().toString();
                if (TextUtils.isEmpty(z)){
                    editText.setError("Empty User Input");
                } else {
                    double n,k;
                    n = Double.parseDouble(z);
                    textView.setText("");
                    Formatter formatter = new Formatter();
                    k = n * 0.0097;
                    DecimalFormat numberFormat = new DecimalFormat("#.00");
                    textView.setText(""+ numberFormat.format(k));
                }
            }
        });

        dinar.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String z = editText.getText().toString();
                if (TextUtils.isEmpty(z)){
                    editText.setError("Empty User Input");
                } else {
                    double n,k;
                    n = Double.parseDouble(z);
                    textView.setText("");
                    Formatter formatter = new Formatter();
                    k = n * 0.0041;
                    DecimalFormat numberFormat = new DecimalFormat("#.00");
                    textView.setText(""+ numberFormat.format(k));
                }
            }
        });

        yen.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String z = editText.getText().toString();
                if (TextUtils.isEmpty(z)){
                    editText.setError("Empty User Input");
                } else {
                    double n,k;
                    n = Double.parseDouble(z);
                    textView.setText("");
                    Formatter formatter = new Formatter();
                    k = n * 3.43;
                    DecimalFormat numberFormat = new DecimalFormat("#.00");
                    textView.setText(""+ numberFormat.format(k));
                }
            }
        });

        canDollar.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String z = editText.getText().toString();
                if (TextUtils.isEmpty(z)){
                    editText.setError("Empty User Input");
                } else {
                    double n,k;
                    n = Double.parseDouble(z);
                    textView.setText("");
                    Formatter formatter = new Formatter();
                    k = n * 0.017;
                    DecimalFormat numberFormat = new DecimalFormat("#.00");
                    textView.setText(""+ numberFormat.format(k));
                }
            }
        });

        ausDollar.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String z = editText.getText().toString();
                if (TextUtils.isEmpty(z)){
                    editText.setError("Empty User Input");
                } else {
                    double n,k;
                    n = Double.parseDouble(z);
                    textView.setText("");
                    Formatter formatter = new Formatter();
                    k = n * 0.018;
                    DecimalFormat numberFormat = new DecimalFormat("#.00");
                    textView.setText(""+ numberFormat.format(k));
                }
            }
        });

        rubel.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String z = editText.getText().toString();
                if (TextUtils.isEmpty(z)){
                    editText.setError("Empty User Input");
                } else {
                    double n,k;
                    n = Double.parseDouble(z);
                    textView.setText("");
                    Formatter formatter = new Formatter();
                    k = n * 1.01;
                    DecimalFormat numberFormat = new DecimalFormat("#.00");
                    textView.setText(""+ numberFormat.format(k));
                }
            }
        });

    }
}