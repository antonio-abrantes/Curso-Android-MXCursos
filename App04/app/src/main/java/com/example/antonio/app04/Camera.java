package com.example.antonio.app04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.File;

public class Camera extends AppCompatActivity {

    private static final int CAPTURAR_IMAGEM = 1;
    private static final int CAPTURAR_VIDEO = 2;
    private Uri uri;
    //private Button btn_camera;
    private ImageButton btn_camera;
    private ImageButton btn_video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera02);

        this.btn_camera = (ImageButton)findViewById(R.id.imageButton);
        this.btn_video = (ImageButton)findViewById(R.id.btn_video);

    }

    public void capturarImagem(View v) {

        boolean temCamera = getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA);

        if (temCamera) {

            File diretorio = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

            String nomeImagem = diretorio.getPath() + "/" + System.currentTimeMillis() + ".jpg";

            uri = Uri.fromFile(new File(nomeImagem));
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);

            startActivityForResult(intent, CAPTURAR_IMAGEM);
        }
    }

    public void capturarVideo(View v){

        boolean temCamera = getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA);

        if(temCamera){

            File diretorio = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

            String nomeVideo = diretorio.getPath() + "/" + System.currentTimeMillis() + ".mp4";

            uri = Uri.fromFile(new File(nomeVideo));

            Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
            intent.putExtra(MediaStore.EXTRA_DURATION_LIMIT, 5);
            startActivityForResult(intent, CAPTURAR_VIDEO);
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAPTURAR_IMAGEM) {
            if (resultCode == RESULT_OK) {
                mostrarMensagem("Imagem capturada!");
                adicionarNaGaleria();
            } else {
                mostrarMensagem("Imagem não capturada!"); } }

        else if(requestCode == CAPTURAR_VIDEO) {
            if (resultCode == RESULT_OK) {
                mostrarMensagem("Vídeo gravado com sucesso!");
                adicionarNaGaleria();
            }
            else { mostrarMensagem("Vídeo não gravado!"); }
        }
    }

    private void mostrarMensagem(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    private void adicionarNaGaleria() {
        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        intent.setData(uri);
        this.sendBroadcast(intent);
    }

}
