package com.example.tawandama.tariffcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button sendRegBtn;
    private Button sendUnregBtn;
    private Button balEnqBtn;
    private Button bankBtn;
    private Button historyBtn;
    private Button cashOutBtn;
    private Button merchBtn;
    private Button payrollBtn;
    private Button billerBtn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendRegBtn = (Button)findViewById(R.id.btnSendReg);
        sendUnregBtn = (Button)findViewById(R.id.btnSendUnreg);
        balEnqBtn = (Button)findViewById(R.id.btbBalEnq);
        bankBtn = (Button)findViewById(R.id.btnBank);
        historyBtn = (Button)findViewById(R.id.btnHistory);
        cashOutBtn = (Button)findViewById(R.id.btnCashOut);
        merchBtn = (Button)findViewById(R.id.btnMerchant);
        payrollBtn = (Button)findViewById(R.id.btnPayroll);
        billerBtn = (Button)findViewById(R.id.btnBiller);


        sendRegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcSendReg();
            }
        });
        sendUnregBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcSendUnreg();
            }
        });
        balEnqBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                balEnq();
            }
        });
        bankBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bank();
            }
        });
        historyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history();
            }
        });
        cashOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cashOut();
            }
        });
        merchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                merchant();
            }
        });
        payrollBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                payroll();
            }
        });
        billerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                biller();
            }
        });
    }

    private void biller() {
        Intent intent = new Intent(getApplicationContext(), BillerActivity.class);
        startActivity(intent);
    }

    private void payroll() {
        Intent intent = new Intent(getApplicationContext(), PayrollActivity.class);
        startActivity(intent);
    }

    private void merchant() {
        Intent intent = new Intent(getApplicationContext(), MerchantActivity.class);
        startActivity(intent);
    }

    private void cashOut() {
        Intent intent = new Intent(getApplicationContext(), CashOutActivity.class);
        startActivity(intent);
    }

    private void history() {
        Intent intent = new Intent(getApplicationContext(), HistoryActivity.class);
        startActivity(intent);
    }

    private void bank() {
        Intent intent = new Intent(getApplicationContext(), BankActivity.class);
        startActivity(intent);
    }

    private void balEnq() {
        Intent intent = new Intent(getApplicationContext(), BalEnqActivity.class);
        startActivity(intent);
    }

    private void calcSendUnreg() {
        Intent intent = new Intent(getApplicationContext(), SendUnregActivity.class);
        startActivity(intent);
    }

    public void calcSendReg() {
        Intent in = new Intent(getApplicationContext(), SendActivity.class);
        startActivity(in);
    }
}
