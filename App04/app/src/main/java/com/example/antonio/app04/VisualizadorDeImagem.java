package com.example.antonio.app04;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class VisualizadorDeImagem extends AppCompatActivity{

    private ImageView imagem;
    private Uri uri;
    private Activity contexto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizador_de_imagem);

        this.uri = getIntent().getData();
        //Bitmap img = BitmapFactory.decodeFile(String.valueOf(uri));

        this.imagem = (ImageView)findViewById(R.id.imagem);
        this.imagem.setImageURI(uri);
    }
}