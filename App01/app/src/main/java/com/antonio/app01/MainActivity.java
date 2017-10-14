package com.antonio.app01;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Antonio on 08/10/2017.
 */

public class MainActivity extends Activity {

    private EditText Nome;
    private TextView Mensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.Nome = (EditText) findViewById(R.id.text_nome);
        this.Mensagem = (TextView) findViewById(R.id.mensagemText);

    }

    public void exibeMensagem(View view) {

        String texto = "Seja bem vindo " + this.Nome.getText().toString();

        this.Mensagem.setText(texto);
    }
}
