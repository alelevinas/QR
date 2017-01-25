package com.sourcey.materiallogindemo;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

import com.sourcey.materiallogindemo.MobileArrayAdapter;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import android.view.View;
import com.sourcey.materiallogindemo.DeliveryActivity;



public class VerDeliverysActivity extends ListActivity {

    static final String[] MOBILE_OS =
            new String[] { "Android", "iOS", "WindowsMobile", "Blackberry"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new MobileArrayAdapter(this, MOBILE_OS));

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        //get selected items
        String selectedValue = (String) getListAdapter().getItem(position);
        Toast.makeText(this, selectedValue, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(VerDeliverysActivity.this, DeliveryActivity.class);
        Bundle b = new Bundle();
        b.putInt("id", position); //Your id
        intent.putExtras(b); //Put your id to your next Intent
        startActivity(intent);

    }

}