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

public class CargaDeliveryActivity extends AppCompatActivity {
    private static final int CAMERA_REQUEST = 1888;
    @Bind(R.id.imageView1)
    ImageView _imagenFoto;
    @Bind(R.id.button)
    Button _botonGuardarYCargarMas;
    @Bind(R.id.button2)
    Button _botonGuardar;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_carga);
        ButterKnife.bind(this);

        _botonGuardarYCargarMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the Signup activity
                tomarFoto();
            }
        });

        _botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        tomarFoto();
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