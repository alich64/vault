package com.example.android.retake1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";  //  new

    @Override
    protected void onCreate(Bundle savedInstanceState) {
           Button Bsubmit;


super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bsubmit = (Button) (findViewById(R.id.Bsubmit));
        Bsubmit.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {


        EditText a1 = (EditText) findViewById(R.id.editText1);
        EditText a2 = (EditText) findViewById(R.id.editText2);
        EditText a3 = (EditText) findViewById(R.id.editText3);
        EditText a4 = (EditText) findViewById(R.id.editText4);
        EditText a5 = (EditText) findViewById(R.id.editText5);
        EditText a6 = (EditText) findViewById(R.id.editText6);
        EditText a7 = (EditText) findViewById(R.id.editText7);

        double num1,num2,num3,num4,num5,num6,num7;

        num1 = Double.parseDouble(a1.getText().toString());
        num2 = Double.parseDouble(a2.getText().toString());
        num3 = Double.parseDouble(a3.getText().toString());
        num4 = Double.parseDouble(a4.getText().toString());
        num5 = Double.parseDouble(a5.getText().toString());
        num6 = Double.parseDouble(a6.getText().toString());
        num7 = Double.parseDouble(a7.getText().toString());


        double array[] = {num1,num2,num3,num4,num5,num6,num7};

        double temp = array[0];

//		        to calculate the highest value
        for(int i=1; i <array.length;i++)
        {
        if(temp<array[i])
        {
        temp = array[i];
        }

        }
        System.out.println(temp);

        double total = 0;
        double avg = 0;
        // average
        for(int i=0; i <array.length;i++){

        total += array[i];

        avg = total/array.length;

        }


        System.out.println(avg);

        String final_avg = Double.toString(avg);
        String final_temp = Double.toString(temp);


        String message = " this page works";

    // dealing with the button press

    Intent intent = new Intent(MainActivity.this,DisplayMessageActivity.class);

    // dont forget to change this

    intent.putExtra(EXTRA_MESSAGE, final_avg); // string message variable was taken out
    intent.putExtra("EXTRA_MESSAGE1", final_temp); // new addition
    startActivity(intent);






//                double ans = num1 +num2;
//
//                TextView t = (TextView)findViewById(R.id.notyetcreated);
//                t.setText("" + ans);











        }
        });
        }




        }
