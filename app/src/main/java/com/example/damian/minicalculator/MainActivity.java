package com.example.damian.minicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

import java.util.ArrayList;


//import org.apache.commons.jexl3.JexlBuilder;
//import org.apache.commons.jexl3.JexlEngine;
//import org.apache.commons.jexl3.JexlException;
//import org.apache.commons.jexl3.JexlExpression;
//import android.widget.Toast;
//import org.apache.commons.jexl3.JexlBuilder;
//import org.apache.commons.jexl3.JexlEngine;
//import org.apache.commons.jexl3.JexlException;
//import org.apache.commons.jexl3.JexlExpression;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public String zapis="";
    private Button buttonAdd,buttonSubstract,buttonMultiply,buttonDivision,buttonSave;
    private TextView textViewWynik;
    private EditText editTextL1, editTextL2;
    private static StringBuffer resultString;
    private static ArrayList<String> history;
    public static final String HISTORY = "ovh.damian.minicalculator.history";


 //funkcja pierwotna
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        if (history == null) {
            history = new ArrayList<>();
        }

        if (resultString == null) {
            resultString = new StringBuffer(((TextView) findViewById(R.id.textViewResult)).getText());
        } else {
            this.updateResultString();
        }

    }

    private void updateResultString() {
        ((TextView) findViewById(R.id.textViewResult)).setText(resultString);
    }

    private void init() {

        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSubstract = findViewById(R.id.buttonSubstract);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivision = findViewById(R.id.buttonDivision);
        buttonSave = findViewById(R.id.buttonSave);
        editTextL1 = findViewById(R.id.editTextL1);
        editTextL2= findViewById(R.id.editTextL2);
        textViewWynik = findViewById(R.id.textViewResult);


        buttonAdd.setOnClickListener(this);
        buttonSubstract.setOnClickListener(this);
        buttonDivision.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {


        String num1 = editTextL1.getText().toString();
        String num2 = editTextL2.getText().toString();

        switch(v.getId()){
            case R.id.buttonAdd: //Dodawanie
                int addition = Integer.parseInt(num1) + Integer.parseInt(num2);

                zapis=num1+"+"+num2+"=";
                zapis+=String.valueOf(addition);
                textViewWynik.setText(String.valueOf(addition));
                textViewWynik.setText(zapis);

                break;
            case R.id.buttonSubstract: //Odejmowanie
                int subtraction = Integer.parseInt(num1) - Integer.parseInt(num2);
                zapis=num1+"-"+num2+"=";
                zapis+=String.valueOf(subtraction);
                textViewWynik.setText(String.valueOf(subtraction));
                break;

            case R.id.buttonMultiply: //Mnożenie
                int multiply = Integer.parseInt(num1) * Integer.parseInt(num2);
                zapis=num1+"*"+num2+"=";
                zapis+=String.valueOf(multiply);
                textViewWynik.setText(String.valueOf(multiply));
                break;

            case R.id.buttonDivision: //Dzielenie
                try{
                    int division = Integer.parseInt(num1) / Integer.parseInt(num2);
                    zapis=num1+"/"+num2+"=";
                    zapis+=String.valueOf(division);
                    textViewWynik.setText(String.valueOf(division));
                }catch(Exception e){
                    textViewWynik.setText("Nie mozna podzielic przez 0!");
                }
                break;

            case R.id.buttonSave:

                Intent intent = new Intent(this,Zapisane.class);
                intent.putExtra("klucz", textViewWynik.getText());
                startActivity(intent);
                break;
        }
    }
}