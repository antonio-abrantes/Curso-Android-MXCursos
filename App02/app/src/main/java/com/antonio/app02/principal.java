package com.antonio.app02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class principal extends AppCompatActivity {

    private TextView usuario_logado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        usuario_logado = (TextView) findViewById(R.id.text_usuario_logado);

        String usuario = getIntent().getStringExtra("USUARIO");

        usuario_logado.setText(usuario);

    }
}
