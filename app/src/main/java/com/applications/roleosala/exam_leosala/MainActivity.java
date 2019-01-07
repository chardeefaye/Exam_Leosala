package com.applications.roleosala.exam_leosala;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends Activity {

    String names[], cNames[];
    TextView txtFNum, txtSNum, txtTNum, txtWinner;
    Button btnDraw, btnClaim, btnWin, btnNames;

    @Override
    protected void onStart() {
        super.onStart();
        drawLots();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        drawLots();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        __init__();
        exqListener();
    }

    public void sharedMaoNani(View v){
        SharedPreferences sharedPreferences;
        sharedPreferences = getSharedPreferences("Leosala_data", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Current",txtWinner.getText().toString());
        editor.commit();
        Toast.makeText(this, "Claimed!", Toast.LENGTH_SHORT).show();
    }

    private void exqListener() {
        btnNames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NamesAct.class);
                startActivity(intent);
            }
        });
        btnWin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WinnersAct.class);
                startActivity(intent);
            }
        });
        btnDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawLots();
            }
        });
    }

    public void drawLots(){
        txtTNum.setText("0");
        txtSNum.setText("0");
        txtFNum.setText("0");
        txtWinner.setText("");
        btnDraw.setEnabled(false);
        btnClaim.setEnabled(false);
        CountDownTimer countDownTimer = new CountDownTimer(4000, 10) {
            int c = 0;
            @Override
            public void onTick(long millisUntilFinished) {
                c += 1;
                Random random = new Random();
                int r = random.nextInt(9);
                if(c <= 80){
                    txtFNum.setText(String.valueOf(r));
                }
                if (c <= 160){
                    txtSNum.setText(String.valueOf(r));
                }
                if (c <= 400){
                    txtTNum.setText(String.valueOf(r));
                }
            }

            @Override
            public void onFinish() {
                String fnum, snum, tnum, finNum;
                fnum = txtFNum.getText().toString();
                snum = txtSNum.getText().toString();
                tnum = txtTNum.getText().toString();
                finNum = fnum+snum+tnum;
                for(int i =0; i < names.length; i++){
                    if(cNames[i].contains(finNum)){
                        txtWinner.setText(names[i]);
                        Log.d(String.valueOf(i), cNames[i]);
                    }
                }
                btnDraw.setEnabled(true);
                btnClaim.setEnabled(true);
            }
        };
        countDownTimer.start();
    }

    private void __init__() {
        txtFNum = findViewById(R.id.txtFNum);
        txtSNum = findViewById(R.id.txtSNum);
        txtTNum = findViewById(R.id.txtTNum);
        txtWinner = findViewById(R.id.txtWinner);
        btnClaim = findViewById(R.id.btnClaim);
        btnDraw = findViewById(R.id.btnDraw);
        btnNames = findViewById(R.id.btnName);
        btnWin = findViewById(R.id.btnWin);
        names = getResources().getStringArray(R.array.names);
        cNames = new String[names.length];
        for(int i = 0; i < names.length; i++){
            if(i < 10){
                cNames[i] = "00" + i + " : " + names[i];
            }else if(i < 100 && i >= 10){
                cNames[i] = "0" + i + " : " + names[i];
            }else{
                cNames[i] = i + " : " + names[i];
            }
        }
    }
}
