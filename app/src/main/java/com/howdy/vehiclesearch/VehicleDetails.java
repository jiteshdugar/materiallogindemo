package com.howdy.vehiclesearch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.w3c.dom.Text;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jiteshdugar on 14/02/16.
 */
public class VehicleDetails extends AppCompatActivity{

    @Bind(R.id.text_vehicledetails)
    Text _vehicleDetails;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchvehicle);
        ButterKnife.bind(this);

    }


}
