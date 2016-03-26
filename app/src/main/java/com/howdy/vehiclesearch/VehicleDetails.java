package com.howdy.vehiclesearch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jiteshdugar on 14/02/16.
 */
public class VehicleDetails extends AppCompatActivity{
    private static VehicleDetails ins;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vehicle_details);
        ButterKnife.bind(this);
        ins=this;

    }
    public static VehicleDetails  getInstace(){
        return ins;
    }
    public void updateTheTextView(final String t) {
        VehicleDetails.this.runOnUiThread(new Runnable() {
            public void run() {
                TextView textV1 = (TextView) findViewById(R.id.text_vehicledetails);
                textV1.setText(t);
            }
        });
    }

}
