package com.example.tawandama.tariffcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;

public class CashOutActivity extends AppCompatActivity {

    private TextView displayText;
    private EditText amountEditText;
    private Button calcCashOutButton;
    public double tariff = 0;
    public double amount;
    public Boolean booleanData ;
    public String protein;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash_out);


        amountEditText = (EditText)findViewById(R.id.amountEditText);
        calcCashOutButton = (Button)findViewById(R.id.calcCashOut);

        calcCashOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                protein = amountEditText.getText().toString();
                try {
                    amount = Double.valueOf(protein);
                } catch (NumberFormatException e) {
                    amount = 0;
                }
                calculate(amount);
                if (tariff > 0.0)
                    result();
                else{
                    invalid();
                }



            }
        });
    }

    private void result() {
        Toast.makeText(getApplicationContext(), "You want to do a Cash-Out of $"+amount+" . You will be charged $"+tariff,
                Toast.LENGTH_LONG).show();
        amountEditText.setText(null);
    }

    private double calculate(double amt) {

        if (isBetween(amt, 1, 1.99)) {
            tariff = 0.0;
        } else if (isBetween(amt, 2, 5)) {
            tariff = 0.17;
        } else if (isBetween(amt, 5.01, 10)) {
            tariff = 0.26;
        } else if (isBetween(amt, 10.01, 20)) {
            tariff = 0.52;
        } else if (isBetween(amt, 20.01, 30)) {
            tariff = 0.78;
        } else if (isBetween(amt, 30.01, 40)) {
            tariff = 1.04;
        } else if (isBetween(amt, 40.01, 50)) {
            tariff = 1.30;
        } else if (isBetween(amt, 50.01, 60)) {
            tariff = 1.74;
        } else if (isBetween(amt, 60.01, 75)) {
            tariff = 2.00;
        } else if (isBetween(amt, 75.01, 100)) {
            tariff = 2.61;
        } else if (isBetween(amt, 100.01, 150)) {
            tariff = 3.04;
        } else if (isBetween(amt, 150.01, 200)) {
            tariff = 3.39;
        } else if (isBetween(amt, 200.01, 300)) {
            tariff = 4.22;
        } else if (isBetween(amt, 300.01, 400)) {
            tariff = 4.26;
        } else if (isBetween(amt, 400.01, 500)) {
            tariff = 4.30;
        } else {
            tariff=0.0;
        }
        return tariff;

    }

    private void invalid() {
        Toast.makeText(getApplicationContext(), "Invalid Amount",
                Toast.LENGTH_LONG).show();
        amountEditText.setText(null);
    }

    public static boolean isBetween(double x, double lower, double upper) {
        return lower <= x && x <= upper;
    }

    public static boolean isNumeric(String amount) {
        try {
            BigDecimal n = new BigDecimal(amount);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}

