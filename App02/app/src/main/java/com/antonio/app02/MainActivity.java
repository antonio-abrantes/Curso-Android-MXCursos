package com.antonio.app02;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText Usuario;
    private EditText Senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.Usuario = (EditText) findViewById(R.id.edit_usuario);
        this.Senha = (EditText) findViewById(R.id.edit_senha);
    }

    public void efetuarLogon(View view) {

        String PegaUsuario = Usuario.getText().toString();
        String PegaSenha = Senha.getText().toString();


        if (PegaUsuario.equals("antonio@teste.com") && PegaSenha.equals("123")) {
            Intent intent = new Intent (this, principal.class);
            intent.putExtra("USUARIO", Usuario.getText().toString());
            startActivity(intent);
        }

        else {

//            Toast msg = Toast.makeText(this, "Dados incorretos!", Toast.LENGTH_SHORT);
//            msg.show();

            AlertDialog.Builder msg = new AlertDialog.Builder(this);
            msg.setTitle("Dados invalido");
            msg.setMessage("Usuário ou senha invalidos!");
            msg.setNeutralButton("OK", null);
            msg.show();

        }

    }
}
