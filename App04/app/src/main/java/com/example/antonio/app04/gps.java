package com.example.antonio.app04;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class gps extends AppCompatActivity {

    private TextView Latitude, Longitude;
    Double latitude;
    Double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);

        Latitude = (TextView) findViewById(R.id.txt_latitude);
        Longitude = (TextView) findViewById(R.id.txt_longitude);

        LocationManager lManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        LocationListener lListener = new LocationListener() {
            public void onLocationChanged(Location locat) {
                updateView(locat);
            }

            public void onStatusChanged(String provider, int status, Bundle extras) {
            }

            public void onProviderEnabled(String provider) {
            }

            public void onProviderDisabled(String provider) {
            }
        };

        lManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, lListener);
//        lManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,0,0,lListener);

    }

    public void updateView(Location locat){
        latitude = locat.getLatitude();
        longitude = locat.getLongitude();

        Latitude.setText(latitude.toString());
        Longitude.setText(longitude.toString());

    }

    public void verMapa(View view) {
        Intent mapa = new Intent(this, MapsActivity.class);
        mapa.putExtra("latitude", latitude.toString());
        mapa.putExtra("longitude", longitude.toString());
        startActivity(mapa);
    }
}
