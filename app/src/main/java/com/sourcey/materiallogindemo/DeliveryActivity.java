package com.sourcey.materiallogindemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by juan on 24/01/17.
 */

public class DeliveryActivity extends AppCompatActivity{


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        Bundle b = getIntent().getExtras();
        int value = -1; // or other values
        if(b != null)
            value = b.getInt("id");

        TextView entregado = (TextView) findViewById(R.id.delivery);
        if (value == 0){
            entregado.setText("CERO");
        }
        if (value == 1){
            entregado.setText("UNO");
        }
        if (value == 2){
            entregado.setText("DOS");
        }
        if (value == 3){
            entregado.setText("TRES");
        }



    }
}
