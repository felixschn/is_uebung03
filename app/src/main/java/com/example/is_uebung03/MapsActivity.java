package com.example.is_uebung03;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static final int PERMISSION_REQUEST_CODE = 200;
    private String key;
    boolean[] markerArray = new boolean[5];
    int[] markerIntArray = new int[5];
    MarkerOptions markerOptionInfoFak = (new MarkerOptions()
            .position(new LatLng(51.025664, 13.723250))
            .title("Informatik Fakultät"));

    MarkerOptions markerOptionAlteMensaMarker = (new MarkerOptions()
            .position(new LatLng(51.027096, 13.726451))
            .title("Alte Mensa"));

    MarkerOptions markerOptionNeueMensaMarker = (new MarkerOptions()
            .position(new LatLng(51.028881, 13.731928))
            .title("Neue Mensa"));

    MarkerOptions markerOptionNürnberger = (new MarkerOptions()
            .position(new LatLng(51.032321, 13.727343))
            .title("Nürnberger Platz"));

    MarkerOptions markerOptionMünchner = (new MarkerOptions()
            .position(new LatLng(51.030032, 13.721243))
            .title("Münchner Platz"));



    Marker markerInfFak;
    Marker markerAlteMensa;
    Marker markerNeueMensa;
    Marker markerNürnberger;
    Marker markerMünchener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Button button = new Button(this);
        button.setText("Click me");
        addContentView(button, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(v.getContext(), markerList.class);

                Bundle b = new Bundle();
                b.putBooleanArray("zustand", markerArray);
                i.putExtras(b);
                int counter = 0;
                MapsActivity.super.startActivityForResult(i, counter);
            }

        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        MapsActivity.super.onActivityResult(requestCode, resultCode, data);

        //Retrieve data in the intent
        markerArray = data.getBooleanArrayExtra("auswertung");
        for (int i = 0; i < markerArray.length; i++) {
            System.out.println("Array Position: " + i + "   " + markerArray[i]);
        }


        if (markerArray[0]) {
            if(markerInfFak == null) {
                markerInfFak = mMap.addMarker(markerOptionInfoFak);
                System.out.println("Info Marker erstellt");
            }
            markerInfFak.setVisible(true);

        } else if (markerInfFak != null) {
            markerInfFak.setVisible(false);
            System.out.println("Info müsste verschwinden, da false");
        }

        if (markerArray[1]) {
            if(markerAlteMensa == null) {
                markerAlteMensa = mMap.addMarker(markerOptionAlteMensaMarker);
                System.out.println("Alte Mensa Marker erstellt");
            }
            markerAlteMensa.setVisible(true);
        } else if (markerAlteMensa != null) {
            markerAlteMensa.setVisible(false);
            System.out.println("Alte Mensa müsste verschwinden, da false");
        }

        if (markerArray[2]) {
            if(markerNeueMensa == null) {
                markerNeueMensa = mMap.addMarker(markerOptionNeueMensaMarker);
                System.out.println("Neue Mensa Marker erstellt");
            }
            markerNeueMensa.setVisible(true);

        } else if (markerNeueMensa != null) {
            markerNeueMensa.setVisible(false);
            System.out.println("Neue Mensa müsste verschwinden, da false");
        }

        if (markerArray[3]) {
            if(markerNürnberger == null) {
                markerNürnberger = mMap.addMarker(markerOptionNürnberger);
                System.out.println("Nürnberger Marker erstellt");
            }
            markerNürnberger.setVisible(true);
        } else if (markerNürnberger != null) {
            markerNürnberger.setVisible(false);
            System.out.println("Nürnberger müsste verschwinden, da false");
        }

        if (markerArray[4]) {
            if(markerMünchener == null) {
                markerMünchener = mMap.addMarker(markerOptionMünchner);
                System.out.println("Münchner Marker erstellt");
            }
            markerMünchener.setVisible(true);
        } else if (markerMünchener != null) {
            markerMünchener.setVisible(false);
            System.out.println("Münchner müsste verschwinden, da false");
        }


    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        //requestPermissions(new String[]{ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_CODE);

        mMap = googleMap;
        setUpMap();
    }

    public void setUpMap() {

        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
    }


    @Override
    protected void onResume() {
        super.onResume();
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /*private boolean checkPermission(){
        int result = ContextCompat.checkSelfPermission(getApplicationContext(), ACCESS_FINE_LOCATION);
        return result == PackageManager.PERMISSION_GRANTED;
    }

    public void requestPermission(){
        requestPermissions(this,new String[]{ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_CODE);
    }

    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(MapsActivity.this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }
    @Override
    public void onRequestPermissionResult(int requestCode, String[] permissions[], int[] grantResults){
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if(grantResults.length > 0){
                    boolean locationAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;

                    if (locationAccepted){}
                        //Snackbar.make(view,"Permission Granted", Snackbar.LENGTH_LONG).show();

                    else{
                        //Snackbar.make(view, "Permission Denied", Snackbar.LENGTH_LONG).show();

                        if(shouldShowRequestPermissionRationale(ACCESS_FINE_LOCATION)){
                            showMessageOKCancel("You need to allow access to the location permission to proceed",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                                                requestPermissions(new String[]{ACCESS_FINE_LOCATION},PERMISSION_REQUEST_CODE);
                                            }
                                        }
                                    });
                        }
                    }
                }
        }
    }*/

/*    public void locationManager() {
        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                //TODO makeUseOfNewLocation(location);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    Activity#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for Activity#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        String locationProvider = LocationManager.GPS_PROVIDER;
        Location lastKnownLocation = locationManager.getLastKnownLocation(locationProvider);
    }

    public void transferArray(boolean[] array) {
        for (int i = 0; i <= array.length; i++) {
            markerIntArray[i] = array[i] ? 1 : 0;
        }
    }


    public class MapLocation {
        public MapLocation(double lt, double ln, String t) {
            lat = lt;
            lon = ln;
            title = t;
        }

        public double lat;
        public double lon;
        public String title;

    }*/
}
