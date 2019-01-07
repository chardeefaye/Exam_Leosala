package com.applications.roleosala.exam_leosala;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class NamesAct extends Activity {
    EditText txtNames;
    String names[], cNames[], rNames[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_names);
        __init__();
    }

    private void __init__() {
        names = getResources().getStringArray(R.array.names);
        cNames = new String[names.length];
        int c = names.length;
        for(int i = 0; i < names.length; i++){
            c--;
            if(i < 10){
                cNames[c] = "00" + i + ":" +  names[i];
            }else if (i < 100 && i > 9){
                cNames[c] = "0" + i + ":" +  names[i];
            }else{
                cNames[c] = i + ":" +  names[i];
            }
        }
        txtNames  = findViewById(R.id.txtNames);
        txtNames.setKeyListener( null );
        txtNames.setFocusable( false );
        txtNames.setCursorVisible(false);
        Log.d("Num", String.valueOf(cNames.length));
        for(int i = 0; i < names.length; i++){
            txtNames.append(cNames[i]);
            txtNames.append("\n");
        }
    }

}
