package com.mycompany.calculation;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
    private TextView textCalc;
    private double value;
    private String currentText;

    enum Symbols {
        Unset, Plus, Minus, Multiply, Divide
    }
    private Symbols symbol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.textCalc = (TextView)this.findViewById(R.id.textView);
        currentText="";
        symbol=Symbols.Unset;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addNewNumber(String newNumber) {
        this.textCalc.setText(this.textCalc.getText().toString() + newNumber);
    }

    public void onOneButtonClick(View view) {
        this.addNewNumber("1");
    }

    public void onTwoButtonClick(View view) {
        this.addNewNumber("2");
    }

    public void onThirdButtonClick(View view) {
        this.addNewNumber("3");
    }

    public void onFourButtonClick(View view) {
        this.addNewNumber("4");
    }

    public void onFiveButtonClick(View view) {
        this.addNewNumber("5");
    }

    public void onSixButtonClick(View view) {
        this.addNewNumber("6");
    }

    public void onSevenButtonClick(View view) {
        this.addNewNumber("7");
    }

    public void onEightButtonClick(View view) {
        this.addNewNumber("8");
    }

    public void onNineButtonClick(View view) {
        this.addNewNumber("9");
    }

    public void onZeroButtonClick(View view) {
        this.addNewNumber("0");
    }

    public void chooseAction (String action){
        if(this.textCalc.getText().toString().equals(""))
        {
            this.textCalc.setText("");
            this.symbol = Symbols.Unset;
        }
        else
        {
            this.value = Double.parseDouble(this.textCalc.getText().toString());
            this.textCalc.setText(this.textCalc.getText().toString() + action);
            this.currentText = this.textCalc.getText().toString();
        }
    }
    public void onPlusButtonClick(View view) {
        this.symbol = Symbols.Plus;
        this.chooseAction("+");
    }
    public void onMinusButtonClick(View view) {
        this.symbol = Symbols.Minus;
        this.chooseAction("-");
    }
    public void onMultiplyButtonClick(View view) {
        this.symbol = Symbols.Multiply;
        this.chooseAction("*");
    }
    public void onDivideButtonClick(View view) {
        this.symbol = Symbols.Divide;
        this.chooseAction("/");
    }
    public void onClearButtonClick(View view) {
        this.textCalc.setText("");
        this.symbol = Symbols.Unset;
    }
    public void onEqualButtonClick(View view) {
        if (this.textCalc.getText().toString().equals(""))
            this.textCalc.setText("");
        else {
                switch (this.symbol) {
                    case Minus:
                        this.value -= Double.parseDouble(this.textCalc.getText().toString().replace(this.currentText, ""));
                        break;
                    case Plus:
                        this.value += Double.parseDouble(this.textCalc.getText().toString().replace(this.currentText, ""));
                        break;
                    case Multiply:
                        this.value *= Double.parseDouble(this.textCalc.getText().toString().replace(this.currentText, ""));
                        break;
                    case Divide:
                        this.value /= Double.parseDouble(this.textCalc.getText().toString().replace(this.currentText, ""));
                        break;
                    case Unset:
                        this.value = Double.parseDouble(this.textCalc.getText().toString());
                        this.textCalc.setText(String.valueOf(this.value));
                        break;
                }
                this.textCalc.setText(String.valueOf(this.value));
                this.symbol=Symbols.Unset;
            }
        }
}