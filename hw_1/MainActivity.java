package com.mirea.kt.hw_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView zagolovok, monthly, total;
    private EditText Month, Percent, Amount;
    private Button Plus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zagolovok = findViewById(R.id.tvzagolovok);
        Month = findViewById(R.id.editTextMonth);
        Percent = findViewById(R.id.editTextPercent);
        Amount = findViewById(R.id.editTextAmount);
        Plus = findViewById(R.id.buttonPlus);
        monthly = findViewById(R.id.tvmonthly);
        total = findViewById(R.id.tvtotal);
        monthly.setMovementMethod(new ScrollingMovementMethod());


        Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            float month = Float.parseFloat(Month.getText().toString());
            float percent = Float.parseFloat(Percent.getText().toString());
            float amount = Float.parseFloat(Amount.getText().toString());
            int i = 1;
            monthly.setText("");
            total.setText("");
            //double monthly_income = 0;
            double total_income = 0;
            while(i <= month){
                double e = (amount * percent / 100);
                monthly.append(String.valueOf(e) + "\n");
                amount = (float) (amount + e);
                i++;
                total_income += e;
                }
            total.setText(String.valueOf(total_income));
            }
        });
    }

}