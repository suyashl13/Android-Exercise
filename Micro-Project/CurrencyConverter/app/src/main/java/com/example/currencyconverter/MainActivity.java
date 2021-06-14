package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Formatter;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView autoComp;

    EditText amount;
    TextView textView;

    Button convertBtn;

    String [] currencies = {
            "Euro", "Pound", "Dollar", "Dinar", "Rubel", "Canadian Dollar", "Australian Dollar", "Yen"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Grab Elements
        autoComp = findViewById(R.id.autoCompleteTextView2);
        amount = findViewById(R.id.amountText);
        textView = findViewById(R.id.result);
        convertBtn = findViewById(R.id.convertBtn);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, currencies);

        autoComp.setAdapter(adapter);

        convertBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
               String txt = autoComp.getText().toString();
               String z = amount.getText().toString();
               if (txt.equals(String.valueOf(""))){
                   autoComp.setError("Please select valid currency.");
                   return;
               }
                double n,k;
                n = Double.parseDouble(z);
                textView.setText("");
                Formatter formatter = new Formatter();
                DecimalFormat numberFormat = new DecimalFormat("#.00");
               switch (txt){
                   case "Euro":
                       n = Double.parseDouble(z);
                       textView.setText("");
                       formatter = new Formatter();
                       k = n * 0.012;
                       numberFormat = new DecimalFormat("#.00");
                       textView.setText(""+ numberFormat.format(k) + " Euro(s)");
                       break;
                   case "Pound":
                       n = Double.parseDouble(z);
                       textView.setText("");
                       formatter = new Formatter();
                       k = n * 0.0097;
                       numberFormat = new DecimalFormat("#.00");
                       textView.setText(""+ numberFormat.format(k) + " Pound(s)");
                       break;
                   case "Dollar":
                       n = Double.parseDouble(z);
                       textView.setText("");
                       formatter = new Formatter();
                       k = n * 0.014;
                       numberFormat = new DecimalFormat("#.00");
                       textView.setText(""+ numberFormat.format(k) + " Dollar(s)");
                       break;
                   case "Dinar":
                       n = Double.parseDouble(z);
                       textView.setText("");
                       formatter = new Formatter();
                       k = n * 0.0041;
                       numberFormat = new DecimalFormat("#.00");
                       textView.setText(""+ numberFormat.format(k) + " Dinar(s)");
                       break;
                   case "Rubel":
                       n = Double.parseDouble(z);
                       textView.setText("");
                       formatter = new Formatter();
                       k = n * 1.01;
                       numberFormat = new DecimalFormat("#.00");
                       textView.setText(""+ numberFormat.format(k) + "Rubel(s)");
                       break;
                   case "Canadian Dollar":
                       n = Double.parseDouble(z);
                       textView.setText("");
                       formatter = new Formatter();
                       k = n * 0.017;
                       numberFormat = new DecimalFormat("#.00");
                       textView.setText(""+ numberFormat.format(k) + " Canadian Dollar(s)");
                       break;
                   case "Australian Dollar":
                       n = Double.parseDouble(z);
                       textView.setText("");
                       formatter = new Formatter();
                       k = n * 0.018;
                       numberFormat = new DecimalFormat("#.00");
                       textView.setText(""+ numberFormat.format(k) + " Aus Dollar(s)");
                       break;
                   case "Yen":
                       n = Double.parseDouble(z);
                       textView.setText("");
                       formatter = new Formatter();
                       k = n * 3.43;
                       numberFormat = new DecimalFormat("#.00");
                       textView.setText(""+ numberFormat.format(k) + " Yen(s)");
                       break;


                   default:
                       autoComp.setError("Please select valid currency.");
                       return;
               }
            }
        });

    }
}