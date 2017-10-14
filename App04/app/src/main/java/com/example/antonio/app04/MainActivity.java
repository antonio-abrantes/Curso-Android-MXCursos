package com.example.antonio.app04;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {


    private static final int VISUALIZAR_IMAGEM = 1;
    private static final int VISUALIZAR_VIDEO = 2;
    private Uri uri;
    private ImageButton camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.camera = (ImageButton) findViewById(R.id.btn_camera);

    }

    //Metodo que abre as opções para utilização da camera com as opções de video e foto
    public void executaFoto(View view) {

        Intent i = new Intent(this, Camera.class);
        startActivity(i);

    }

    //Metodo acionado pelo botão para abrir a galeria de fotos
    public void visualizarImagem(View v) {

        Intent intent = new Intent();
        intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*,video/*");
        //Informa a intent que vai ter o resultado da foto selecionada
        this.startActivityForResult(intent, VISUALIZAR_IMAGEM);

        //Minha implementação chamando classe externa
//        AbrirVisualizador.visualizadorDeImagens(v, VISUALIZAR_IMAGEM, this);

    }

    public void visualizarVideo(View v) {

        Intent intent = new Intent();
        intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("video/*");
        startActivityForResult(intent, VISUALIZAR_VIDEO);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        //Recebe e executa a visualização da imagem caso alguma tenha sido selecionada...
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                uri = data.getData();
                mostrarImagem();
            }
        }
        if (requestCode == 2) {
            if (resultCode == RESULT_OK) {
                uri = data.getData();
                mostrarVideo();
            }
        }
    }

    public void mostrarImagem() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        //intent.setDataAndType(uri, "image/jpg");
        intent.setDataAndType(uri, "image/*,video/*");

        //Minha implementacao
//        Intent intent = new Intent(this, VisualizadorDeImagem.class);
//        intent.setData(uri);
        startActivity(intent);
    }

    public void mostrarVideo() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(uri, "video/*");
        startActivity(intent);
    }

    public void visualizarGPS(View v) {

        Intent intent = new Intent(this, gps.class);
        //Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);

    }
}