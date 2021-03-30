package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight,
            btnNine, btnDot, btnSign, btnEqual, btnClear, btnSum, btnSub, btnMul, btnDiv;
    private TextView tUp, tDown;
    boolean isDot = true;

    String sign, content;
    double op1, op2, result;

    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnZero = (Button) findViewById(R.id.btnZero);
        btnOne = (Button) findViewById(R.id.btnOne);
        btnTwo = (Button) findViewById(R.id.btnTwo);
        btnThree = (Button) findViewById(R.id.btnThree);
        btnFour = (Button) findViewById(R.id.btnFour);
        btnFive = (Button) findViewById(R.id.btnFive);
        btnSix = (Button) findViewById(R.id.btnSix);
        btnSeven = (Button) findViewById(R.id.btnSeven);
        btnEight = (Button) findViewById(R.id.btnEight);
        btnNine = (Button) findViewById(R.id.btnNine);

        btnEqual = (Button) findViewById(R.id.btnEqual);
        btnSum = (Button) findViewById(R.id.btnSum);
        btnSub = (Button) findViewById(R.id.btnSubtract);
        btnMul = (Button) findViewById(R.id.btnMultiplication);
        btnDiv = (Button) findViewById(R.id.btnDivide);

        btnSign = (Button) findViewById(R.id.btnSign);
        btnDot  = (Button) findViewById(R.id.btnDot);
        btnClear = (Button) findViewById(R.id.btnClear);
        //btn = (Button) findViewById(R.id.);

        tDown = (TextView) findViewById(R.id.tvOut);
        tUp = (TextView) findViewById(R.id.tvtInp);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tUp.setText("");
                tDown.setText("");
                sign="";
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                content = tDown.getText().toString();

                if (content.length() <= 0){
                    tUp.setText("0.");
                }else {
                    if (content.contains(".")){

                    }else {
                        tDown.setText(content+".");
                        isDot = false;
                    }
                }

            }
        });
        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cont = tDown.getText().toString();
                if (!cont.equals("")){
                    double res = Double.parseDouble(cont);
                    res = res * -1;
                    tDown.setText(String.valueOf(res));
                }


            }
        });

        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sign = "+";
                content = tDown.getText().toString();

                if (content.isEmpty()){
                    op1 = 0;
                    tUp.setText("0+");
                }else {

                    op1 = Double.parseDouble(content);
                    tUp.setText(content+"+");
                    tDown.setText("");

                }
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sign = "-";
                content = tDown.getText().toString();
                if (content.isEmpty()){
                    op1 = 0;
                    tUp.setText("0-");
                }else {
                    op1 = Double.parseDouble(content);
                    tUp.setText(content+"-");
                    tDown.setText("");
                }
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sign = "*";
                content = tDown.getText().toString();
                if (content.isEmpty()){
                    op1 = 0;
                    tUp.setText("0*");
                }else {
                    op1 = Double.parseDouble(content);
                    tUp.setText(content+"*");
                    tDown.setText("");
                }
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sign = "/";
                content = tDown.getText().toString();
                if (content.isEmpty()){
                    op1 = 0;
                    tUp.setText("0/");
                }else {
                    op1 = Double.parseDouble(content);
                    tUp.setText(content+"/");
                    tDown.setText("");
                }
            }
        });


        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                content = tDown.getText().toString();
                boolean isShowResult = true;

                if (content.equals("")) {

                    tDown.setText("");
                }else if (!content.equals("") && sign.equals("")){
                    tDown.setText(content);

                }else {



                    op2 = Double.parseDouble(content);

                    switch (sign){
                        case "+":
                            result = op1+op2;
                            break;
                        case "-":
                            result = op1-op2;
                            break;
                        case "*":
                            result = op1*op2;
                            break;
                        case "/":
                            result = op1/op2;
                            break;

                    }
                    if(isShowResult){
                        tUp.setText(tUp.getText().toString() + content);
                        tDown.setText(String.valueOf(result));
                        op1 = result;

                        isShowResult = false;
                    }

                }

            }
        });



        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tDown.setText(tDown.getText().toString()+ "0");

            }
        });

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tDown.setText(tDown.getText().toString()+ "1");
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tDown.setText(tDown.getText().toString()+ "2");
            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tDown.setText(tDown.getText().toString()+ "3");
            }
        });

        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tDown.setText(tDown.getText().toString()+ "4");
            }
        });

        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tDown.setText(tDown.getText().toString()+ "5");
            }
        });

        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tDown.setText(tDown.getText().toString()+ "6");
            }
        });

        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tDown.setText(tDown.getText().toString()+ "7");
            }
        });

        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tDown.setText(tDown.getText().toString()+ "8");
            }
        });

        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tDown.setText(tDown.getText().toString()+ "9");
            }
        });

    }


}