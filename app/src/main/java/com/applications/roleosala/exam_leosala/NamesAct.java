package com.applications.roleosala.exam_leosala;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class NamesAct extends Activity {
    EditText txtNames;
    String names[], cNames[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_names);
        __init__();
    }

    private void __init__() {
        names = getResources().getStringArray(R.array.names);
        cNames = new String[names.length];
        for(int i = names.length; i > 0; i--){
            if(i < 10){
                cNames[i - 1] = "00" + i + " : " + names[i];
            }else if(i < 100 && i >= 10){
                cNames[i - 1] = "0" + i + " : " + names[i];
            }else{
                cNames[i - 1 ] = i + " : " + names[i];
            }
        }

        txtNames  = findViewById(R.id.txtNames);
        Log.d("Num", String.valueOf(cNames.length));
        for(int i = 0; i < names.length; i++){
            txtNames.append(cNames[i]);
            txtNames.append("\n");
        }
    }

}
