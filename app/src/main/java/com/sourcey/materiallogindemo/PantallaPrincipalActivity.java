package com.sourcey.materiallogindemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by horacio on 1/8/17.
 */

public class PantallaPrincipalActivity extends AppCompatActivity {

    @Bind(R.id.nombreUsuarioTextView) TextView _nombreUsuario;
    @Bind(R.id.verDeliverysButton)
    Button _verButton;
    @Bind(R.id.notificarDeliveryButton)
    Button _notificarButton;
    @Bind(R.id.cargaDeliveryButton)
    Button _cargarButton;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        ButterKnife.bind(this);
        String username = getIntent().getStringExtra("USERNAME");
        _nombreUsuario.setText(username);

        _verButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), VerDeliverysActivity.class);
                startActivity(intent);
            }
        });

        _notificarButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), NotificarDeliveryActivity.class);
                startActivity(intent);
            }
        });

        _cargarButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), CargaDeliveryActivity.class);
                startActivity(intent);
            }
        });
    }

}