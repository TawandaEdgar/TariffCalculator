package com.example.tawandama.tariffcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MerchantActivity extends AppCompatActivity {
    private TextView displayText;
    private EditText amountEditText;
    private Button calcMerchCharge;
    public double tariff = 0;
    public double amount;
    public String amtInTextFormat;
    public double oneToFifty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant);

        amountEditText = (EditText)findViewById(R.id.amountEditText);
        calcMerchCharge = (Button)findViewById(R.id.calcMerchCharge);

        calcMerchCharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                amtInTextFormat = amountEditText.getText().toString();
                try {
                    amount = Double.valueOf(amtInTextFormat);
                } catch (NumberFormatException e) {
                    amount = 0;
                }

                oneToFifty = ((0.02*amount)+0.05);
                calculate(amount);
                if (tariff > 0.0)
                    result();
                else if (isBetween(amount, 1, 50)) {
                    Toast.makeText(getApplicationContext(), "You want to do a Merchant Transaction of $"+amount+" . You will be charged $"+ oneToFifty,
                            Toast.LENGTH_LONG).show();
                    amountEditText.setText(null);
                }
                else{
                    invalid();
                }



            }
        });
    }

    private void result() {
        Toast.makeText(getApplicationContext(), "You want to do a Merchant Transaction of $"+amount+" . You will be charged $"+tariff,
                Toast.LENGTH_LONG).show();
        amountEditText.setText(null);
    }

    private double calculate(double amt) {

        if (isBetween(amt, 50.01, 75)) {
            tariff = 1.25;
        } else if (isBetween(amt, 75.01, 100)) {
            tariff = 1.45;
        } else if (isBetween(amt, 100.01, 150)) {
            tariff = 1.50;
        } else if (isBetween(amt, 150.01, 500)) {
            tariff = 1.50;
        }  else {
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

}
