package com.example.ava.converter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String dec, hex, bin;

    EditText decInput, hexInput, binInput;
    Button convertButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        decInput = (EditText) findViewById(R.id.decInput);
        hexInput = (EditText) findViewById(R.id.hexInput);
        binInput = (EditText) findViewById(R.id.binInput);

        convertButton = (Button) findViewById(R.id.submit);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                dec = decInput.getText().toString();
                hex = hexInput.getText().toString();
                bin = binInput.getText().toString();

                try {
                    if(!dec.matches("") && !hex.matches("") &&!bin.matches("") ||
                    (dec.matches("") && hex.matches("") && bin.matches("")))
                        throw new Exception("Entered wrong");
                    else if (!dec.matches("")) {
                        //convert other two
                        bin = Integer.toString(Integer.valueOf(dec), 2);
                        hex = Integer.toString(Integer.valueOf(dec), 16);
                        binInput.setText(bin);
                        hexInput.setText(hex);
                    } else if (!hex.matches("")) {
                        dec = "" + Integer.parseInt(hex, 16);
                        bin = Integer.toString(Integer.valueOf(dec), 2);
                        binInput.setText(bin);
                        decInput.setText(dec);
                    } else if (!bin.matches("")) {
                        dec = "" + Integer.parseInt(bin, 2);
                        hex = Integer.toString(Integer.valueOf(dec), 16);
                        decInput.setText(dec);
                        hexInput.setText(hex);
                    }
                }catch(NumberFormatException e){
                    Toast toast= Toast.makeText(MainActivity.this,"Enter numbers correctly",Toast.LENGTH_LONG);
                    toast.show();


                } catch (Exception e) {
                    Toast toast= Toast.makeText(MainActivity.this,"Enter One Field",Toast.LENGTH_LONG);
                    toast.show();

                }
            }

        });
        decInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                binInput.setText("");
                hexInput.setText("");
                decInput.setText("");
                hexInput.setFocusable(false);
                binInput.setFocusable(false);
                decInput.setFocusableInTouchMode(true);
                decInput.setInputType(2);
            }
        });
        hexInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                binInput.setText("");
                hexInput.setText("");
                decInput.setText("");
                hexInput.setFocusableInTouchMode(true);
                binInput.setFocusable(false);
                decInput.setFocusable(false);
                hexInput.setInputType(1);
            }
        });
        binInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                binInput.setText("");
                hexInput.setText("");
                decInput.setText("");
                hexInput.setFocusable(false);
                binInput.setFocusableInTouchMode(true);
                decInput.setFocusable(false);
                binInput.setInputType(2);
            }
        });
    }
}
