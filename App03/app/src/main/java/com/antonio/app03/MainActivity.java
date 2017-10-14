package com.antonio.app03;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.io.IOException;

public class MainActivity extends AppCompatActivity{

    String PegaVisor;
    //private TextView Visor;
    private EditText Visor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Visor = (TextView) findViewById(R.id.text_visor);
        Visor = (EditText) findViewById(R.id.text_visor);
    }

    public void func9(View view) {
        PegaVisor = Visor.getText().toString();
        this.Visor.setText(PegaVisor + "9");
    }

    public void func8(View v) {

        PegaVisor = Visor.getText().toString();
        this.Visor.setText(PegaVisor + "8");


    }

    public void func7(View v) {

        PegaVisor = Visor.getText().toString();
        this.Visor.setText(PegaVisor + "7");


    }

    public void func6(View v) {

        PegaVisor = Visor.getText().toString();
        this.Visor.setText(PegaVisor + "6");


    }

    public void func5(View v) {

        PegaVisor = Visor.getText().toString();
        this.Visor.setText(PegaVisor + "5");


    }

    public void func4(View v) {

        PegaVisor = Visor.getText().toString();
        this.Visor.setText(PegaVisor + "4");


    }

    public void func3(View v) {

        PegaVisor = Visor.getText().toString();
        this.Visor.setText(PegaVisor + "3");


    }


    public void func2(View v) {

        PegaVisor = Visor.getText().toString();
        this.Visor.setText(PegaVisor + "2");


    }

    public void func1(View v) {

        PegaVisor = Visor.getText().toString();
        this.Visor.setText(PegaVisor + "1");


    }

    public void func0(View v) {

        PegaVisor = Visor.getText().toString();
        this.Visor.setText(PegaVisor + "0");


    }


    public void funcAdicao(View v) {

        PegaVisor = Visor.getText().toString();
        this.Visor.setText(PegaVisor + "+");


    }

    public void funcSubtracao(View v) {

        PegaVisor = Visor.getText().toString();
        this.Visor.setText(PegaVisor + "-");


    }

    public void funcDivisao(View v) {

        PegaVisor = Visor.getText().toString();
        this.Visor.setText(PegaVisor + "/");


    }

    public void funcMultiplicacao(View v) {

        PegaVisor = Visor.getText().toString();
        this.Visor.setText(PegaVisor + "*");


    }


    public void funcCE(View v) {

        this.Visor.setText("");

    }

    public void funcIgual(View v) {

        PegaVisor = Visor.getText().toString();

        try {
            Expression e = new ExpressionBuilder(PegaVisor).build();
            double result = e.evaluate();
            String exibeResult = String.valueOf(result);
            this.Visor.setText(exibeResult);
        }catch (Exception ex) {

            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setNeutralButton("OK", null);
            alertDialog.setTitle("Erro!");
            alertDialog.setMessage("Verifique a expressão matemática utilizada!!");
            alertDialog.show();
        }

    }
}
