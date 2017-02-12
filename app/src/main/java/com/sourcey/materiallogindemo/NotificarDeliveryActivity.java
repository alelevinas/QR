package com.sourcey.materiallogindemo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by horacio on 1/8/17.
 */

public class NotificarDeliveryActivity extends AppCompatActivity {
    private static final int CAMERA_REQUEST = 1888;
    @Bind(R.id.imageView1)
    ImageView _imagenFoto;
    @Bind(R.id.buttonEntregado)
    Button botonEntregado;
    @Bind(R.id.buttonNoEntregado)
    Button _botonNoEntregado;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_notificar);
        ButterKnife.bind(this);

        botonEntregado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entregadoApretado();
            }


        });

        _botonNoEntregado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noEntregadoApretado();
            }

        });
        tomarFoto();
    }

    private void noEntregadoApretado() {

    }

    private void entregadoApretado() {

    }

    private void tomarFoto(){
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            _imagenFoto.setImageBitmap(photo);
        }
    }

}