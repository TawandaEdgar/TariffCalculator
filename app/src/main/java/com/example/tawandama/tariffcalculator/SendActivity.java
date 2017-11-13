package com.example.tawandama.tariffcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class SendActivity extends AppCompatActivity {

    private TextView displayText;
    private EditText amountEditText;
    private Button calcSendButton;
    public double tariff = 0;
    public double amount;
    public Boolean booleanData ;
    public String amtInTextFormat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);

        amountEditText = (EditText)findViewById(R.id.amountEditText);
        calcSendButton = (Button)findViewById(R.id.calcSend);


      calcSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                amtInTextFormat = amountEditText.getText().toString();
                try {
                    amount = Double.valueOf(amtInTextFormat);
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
        Toast.makeText(getApplicationContext(), "You want to send to a registered customer an amount of $"+amount+" . You will be charged $"+tariff,
                Toast.LENGTH_LONG).show();
        amountEditText.setText(null);
    }

    private double calculate(double amt) {

        if (isBetween(amt, 1, 1.99)) {
            tariff = 0.11;
        } else if (isBetween(amt, 2, 5)) {
            tariff = 0.12;
        } else if (isBetween(amt, 5.01, 10)) {
            tariff = 0.21;
        } else if (isBetween(amt, 10.01, 20)) {
            tariff = 0.37;
        } else if (isBetween(amt, 20.01, 30)) {
            tariff = 0.53;
        } else if (isBetween(amt, 30.01, 40)) {
            tariff = 0.69;
        } else if (isBetween(amt, 40.01, 50)) {
            tariff = 0.87;
        } else if (isBetween(amt, 50.01, 60)) {
            tariff = 1.22;
        } else if (isBetween(amt, 60.01, 75)) {
            tariff = 1.28;
        } else if (isBetween(amt, 75.01, 100)) {
            tariff = 1.69;
        } else if (isBetween(amt, 100.01, 150)) {
            tariff = 2.12;
        } else if (isBetween(amt, 150.01, 200)) {
            tariff = 2.47;
        } else if (isBetween(amt, 200.01, 300)) {
            tariff = 2.54;
        } else if (isBetween(amt, 300.01, 400)) {
            tariff = 2.58;
        } else if (isBetween(amt, 400.01, 500)) {
            tariff = 2.62;
        }
        else {
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