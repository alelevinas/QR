package com.sourcey.materiallogindemo;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

    private void entregadoApretado() {
        finish();
    }

    private void noEntregadoApretado() {
        CharSequence opciones[] = new CharSequence[] {"No atienden en el domicilio", "Cliente no quiso aceptarlo",
                "No se pudo llegar a horario al domicilio", "Otro"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("¿Por qué no pudo ser entregado?");
        builder.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 3)
                    otroApretado();
                else
                    finish();
            }
        });
        builder.show();
    }

    private void otroApretado() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        final EditText edittext = new EditText(this.getBaseContext());
        alert.setTitle("Delivery no entregado");
        alert.setMessage("Describa por qué no puedo realizar la entrega");


        alert.setView(edittext);

        alert.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //What ever you want to do with the value
                //Editable YouEditTextValue = edittext.getText();
                //OR
                String YouEditTextValue = edittext.getText().toString();
                finish();
            }
        });

        alert.setNegativeButton("Descartar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                finish();
            }
        });

        alert.show();
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