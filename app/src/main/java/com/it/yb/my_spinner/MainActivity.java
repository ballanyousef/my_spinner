package com.it.yb.my_spinner;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {
    Spinner spinner1;
    TextView textView1;

    String[] days = {"Sunday", "Monday", "Tuesday",
            "Wednesday", "Thursday", "Friday", "Saturday"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        spinner1 = findViewById(R.id.spinner1);
        textView1 = findViewById(R.id.textView1);

        ArrayAdapter<String> aa = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, days);

        spinner1.setAdapter(aa);
        spinner1.setOnItemSelectedListener(spinner1Listener);

    }

    private AdapterView.OnItemSelectedListener spinner1Listener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            textView1.setText(days[position]);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {


        }
    };
    //-------------------------------------------------


    public class Point2d{

    }

    //-------------------------------------------
}
