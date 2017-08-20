package com.example.android.retake1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class DisplayMessageActivity extends AppCompatActivity {

    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        final String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        final String message1 = getIntent().getStringExtra("EXTRA_MESSAGE1");




        // Capture the layout's TextView and set the string as its text
        final TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(message);

        final TextView textView1 = (TextView) findViewById(R.id.textView2);
        textView1.setText(message1);



        // spinner code
        spinner = (Spinner)findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this,R.array.measurement_labels, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getBaseContext(),parent.getItemAtPosition(position) + " is selected", Toast.LENGTH_LONG).show();

                if(position > 0)
                {
                    Double fvalue =Double.parseDouble(textView1.getText().toString());
                    Double Fvalue = Double.parseDouble(textView.getText().toString());

                    Double fvalue1 = (fvalue * 1.8) + 32;
                    Double Fvalue1 = (Fvalue * 1.8) + 32;

                    String fvalue2 = Double.toString(fvalue1);
                    String Fvalue2 = Double.toString(Fvalue1);


                    textView1.setText(fvalue2);
                    textView.setText(Fvalue2);


                }
                else
                {
                    textView.setText(message);
                    textView1.setText(message1);
                }



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}
