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
    private String currentText="";
    private String prevText="";

    enum Symbols {
        Unset, Plus, Minus, Multiply, Divide
    }
    private Symbols symbol = Symbols.Unset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.textCalc = (TextView) findViewById(R.id.textView);
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

    public void AddNewNumber(String newNumber) {
        this.textCalc.setText(currentText + newNumber);
        this.currentText = this.textCalc.getText().toString();
    }

    public void onClickOneButton(View view) {
        AddNewNumber("1");
    }

    public void onClickTwoButton(View view) {
        AddNewNumber("2");
    }

    public void onClickThirdButton(View view) {
        AddNewNumber("3");
    }

    public void onClickFourButton(View view) {
        AddNewNumber("4");
    }

    public void onClickFiveButton(View view) {
        AddNewNumber("5");
    }

    public void onClickSixButton(View view) {
        AddNewNumber("6");
    }

    public void onClickSevenButton(View view) {
        AddNewNumber("7");
    }

    public void onClickEightButton(View view) {
        AddNewNumber("8");
    }

    public void onClickNineButton(View view) {
        AddNewNumber("9");
    }

    public void onClickZeroButton(View view) {
        AddNewNumber("0");
    }
    public void onClickPlus(View view) {
        if(currentText.isEmpty())
            this.textCalc.setText("");
        else {
            this.value = Double.parseDouble(this.currentText);
            this.textCalc.setText(currentText + "+");
            this.currentText = textCalc.getText().toString();
            this.prevText = textCalc.getText().toString();
            this.symbol = Symbols.Plus;
        }
    }
    public void onClickMinus(View view) {
        if(currentText.isEmpty())
            this.textCalc.setText("");
        else {
            this.value = Double.parseDouble(this.currentText);
            this.textCalc.setText(currentText + "-");
            this.currentText = textCalc.getText().toString();
            this.prevText = textCalc.getText().toString();
            this.symbol = Symbols.Minus;
        }
    }
    public void onClickMultiplyButton(View view) {
        if(currentText.isEmpty())
            this.textCalc.setText("");
        else {
            this.value = Double.parseDouble(this.currentText);
            this.textCalc.setText(currentText + "*");
            this.currentText = textCalc.getText().toString();
            this.prevText = textCalc.getText().toString();
            this.symbol = Symbols.Multiply;
        }
    }
    public void onClickDivideButton(View view) {
        if(currentText.isEmpty())
            this.textCalc.setText("");
        else {
            this.value = Double.parseDouble(this.currentText);
            this.textCalc.setText(currentText + "/");
            this.currentText = textCalc.getText().toString();
            this.prevText = textCalc.getText().toString();
            this.symbol = Symbols.Divide;
        }
    }
    public void onClickClearButton(View view) {
            this.textCalc.setText("");
            this.currentText = "";
            this.value = 0;
            this.symbol = Symbols.Unset;
    }
    public void onClickEqualButton(View view) {
        switch (this.symbol) {
            case Minus:
                this.value -= Double.parseDouble(this.currentText.replace(this.prevText, ""));
                this.textCalc.setText(String.valueOf(value));
                this.currentText = this.textCalc.getText().toString();
                break;
            case Plus:
                this.value += Double.parseDouble(this.currentText.replace(this.prevText, ""));
                this.textCalc.setText(String.valueOf(value));
                this.currentText = this.textCalc.getText().toString();
                break;
            case Multiply:
                this.value *= Double.parseDouble(this.currentText.replace(this.prevText, ""));
                this.textCalc.setText(String.valueOf(value));
                this.currentText = this.textCalc.getText().toString();
                break;
            case Divide:
                this.value /= Double.parseDouble(this.currentText.replace(this.prevText, ""));
                this.textCalc.setText(String.valueOf(value));
                this.currentText = this.textCalc.getText().toString();
                break;
            case Unset:
                if(currentText.isEmpty())
                    this.textCalc.setText("");
                else {
                    this.value = Double.parseDouble(this.currentText);
                    this.textCalc.setText(String.valueOf(value));
                }
        }
    }
}