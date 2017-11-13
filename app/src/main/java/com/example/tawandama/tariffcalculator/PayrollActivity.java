package com.example.tawandama.tariffcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PayrollActivity extends AppCompatActivity {

    private TextView displayText;
    private EditText amountEditText;
    private Button calcPayroll;
    public double tariff = 0;
    public double amount;
    public String amtInTextFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payroll);

        amountEditText = (EditText)findViewById(R.id.amountEditText);
        calcPayroll = (Button)findViewById(R.id.calcPayroll);

        calcPayroll.setOnClickListener(new View.OnClickListener() {
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
        Toast.makeText(getApplicationContext(), "You want to do a Bulk/Payroll Payment of $"+amount + " . You will be charged $"+tariff,
                Toast.LENGTH_LONG).show();
        amountEditText.setText(null);
    }

    private double calculate(double amt) {

        if (isBetween(amt, 1, 150)) {
            tariff = 0.55;
        } else if (isBetween(amt, 150.01, 300)) {
            tariff = 0.45;
        } else if (isBetween(amt, 300.01, 450)) {
            tariff = 0.40;
        } else if (amt > 450) {
            tariff = 0.35;
        }else {
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
