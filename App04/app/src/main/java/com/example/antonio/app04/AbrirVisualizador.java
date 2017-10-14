package com.example.antonio.app04;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

/**
 * Created by Antonio on 12/10/2017.
 */

public class AbrirVisualizador {

    public static void visualizadorDeImagens(View v, int comando, Activity context){

        Intent intent = new Intent();
        intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        //Informa a intent que vai ter o resultado da foto selecionada
        Log.i("AVISO","Deu certo");
        context.startActivityForResult(intent, comando);
    }
}
