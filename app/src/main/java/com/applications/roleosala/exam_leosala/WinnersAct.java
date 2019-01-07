package com.applications.roleosala.exam_leosala;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class WinnersAct extends Activity {
    TextView txtCurWin, txtPrevWin;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winners);
        __init__();
    }

    private void __init__() {
        txtCurWin = findViewById(R.id.txtCurWin);
        txtPrevWin = findViewById(R.id.txtPrevWin);
        getShared();
    }

    public void getShared(){
        sharedPreferences = getSharedPreferences("Leosala_data", MODE_PRIVATE);
        String data_1 = sharedPreferences.getString("Current", "");
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("thewin", "this winner");
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String value = preferences.getString("Current","Ambot kinsa ni daog diri BAHAHAHAHAHA");
        txtCurWin.setText(value);
        txtPrevWin.setText("Love you Sir");
    }
}
