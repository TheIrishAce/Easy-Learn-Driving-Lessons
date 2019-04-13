package com.example.easylearndrivinglessons;

import android.location.Location;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.Manifest;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import android.widget.Toast;
import android.content.pm.PackageManager;

import android.graphics.Color;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.location.LocationListener;
import java.util.ArrayList;

import static com.google.maps.android.SphericalUtil.computeDistanceBetween;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, LocationListener {

    private GoogleMap mMap;

    private static final int LOCATION_REQUEST = 500;
    ArrayList<LatLng> listPoints;



    private GoogleApiClient googleApiClient;


    private FusedLocationProviderClient fusedLocationClient;
    Location myloc;

    LocationRequest locationrequest;
    Location lastLoc;
    LatLng userLoc;
    Marker m;
    private static final int request=99;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            checkP();
        }
        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.current_location);
        mapFragment.getMapAsync(this);
        listPoints = new ArrayList<>();

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            // Logic to handle location object
                            myloc = location;

                        }
                    }
                });


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
        mMap = googleMap;

        mMap.getUiSettings().setZoomControlsEnabled(true);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_REQUEST);
            return;
        }
        buildGoogleApliClient();
        mMap.setMyLocationEnabled(true);





    }

    public boolean checkP(){
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.ACCESS_FINE_LOCATION)){
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},request);
            }
            else {
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},request);
            }
            return false;
        }
        else{
            return true;
        }
    }




    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case request: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED){
                        if(googleApiClient==null){
                            buildGoogleApliClient();
                        }
                        mMap.setMyLocationEnabled(true);
                    }
                }
                else{
                    Toast.makeText(this,"Permission Denied",Toast.LENGTH_SHORT).show();
                }return;
            }

        }
    }


    protected synchronized void buildGoogleApliClient() {
        googleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        googleApiClient.connect();
    }

    public void Distance() {
        double result = 999999999 ;
        int index = 0;
        int i = 0;
        ArrayList<MarkerOptions> moa=new ArrayList<>();



        LatLng Blanchardstown = new LatLng(53.389039, -6.381835);
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(Blanchardstown);
        listPoints.add(Blanchardstown);

        LatLng OmniPark = new LatLng(53.392187, -6.246457);
        MarkerOptions markerOptions1 = new MarkerOptions();
        markerOptions1.position(OmniPark);
        listPoints.add(OmniPark);

        LatLng Graiguecullen= new LatLng(52.838504, -6.943162);
        MarkerOptions markerOptions2 = new MarkerOptions();
        markerOptions2.position(Graiguecullen);
        listPoints.add(Graiguecullen);

        LatLng Cavan = new LatLng(53.962144, -7.357901);
        MarkerOptions markerOptions3 = new MarkerOptions();
        markerOptions3.position(Cavan);
        listPoints.add(Cavan);

        LatLng Kilrush= new LatLng(52.836541, -8.989820);
        MarkerOptions markerOptions4 = new MarkerOptions();
        markerOptions4.position(Kilrush);
        listPoints.add(Kilrush);

        LatLng Charleville = new LatLng(52.355164, -8.683481);
        MarkerOptions markerOptions5 = new MarkerOptions();
        markerOptions5.position(Charleville);
        listPoints.add(Charleville);

        LatLng Montenotte = new LatLng(51.901193, -8.463078);
        MarkerOptions markerOptions6 = new MarkerOptions();
        markerOptions6 .position(Montenotte);
        listPoints.add(Montenotte);

        LatLng Macroom  = new LatLng(51.922626, -8.992098);
        MarkerOptions markerOptions7 = new MarkerOptions();
        markerOptions7.position(Macroom );
        listPoints.add(Macroom );

        LatLng Lurriga = new LatLng(51.557718, -9.263095);
        MarkerOptions markerOptions8 = new MarkerOptions();
        markerOptions8.position(Lurriga);
        listPoints.add(Lurriga);

        LatLng Foxhole = new LatLng(51.971662, -7.863633);
        MarkerOptions markerOptions9 = new MarkerOptions();
        markerOptions9.position(Foxhole);
        listPoints.add(Foxhole);

        LatLng Derrybeg = new LatLng(55.069286, -8.298281);
        MarkerOptions markerOptions10 = new MarkerOptions();
        markerOptions10.position(Derrybeg);
        listPoints.add(Derrybeg);

        LatLng Doonan = new LatLng(54.658758, -8.129656);
        MarkerOptions markerOptions11 = new MarkerOptions();
        markerOptions11.position(Doonan);
        listPoints.add(Doonan);

        LatLng DonegalTown = new LatLng(54.653756, -8.108390);
        MarkerOptions markerOptions12 = new MarkerOptions();
        markerOptions.position(DonegalTown);
        listPoints.add(DonegalTown);

        LatLng Letterkenny  = new LatLng(54.949807, -7.737523);
        MarkerOptions markerOptions13 = new MarkerOptions();
        markerOptions13.position(Letterkenny);
        listPoints.add(Letterkenny);

        LatLng Dock = new LatLng(53.349608, -6.250260);
        MarkerOptions markerOptions14 = new MarkerOptions();
        markerOptions14.position(Dock);
        listPoints.add(Dock);

        LatLng Laoghaire = new LatLng(53.292481, -6.135061);
        MarkerOptions markerOptions15 = new MarkerOptions();
        markerOptions15.position(Laoghaire);
        listPoints.add(Laoghaire);

        moa.add(markerOptions);
        moa.add(markerOptions1);
        moa.add(markerOptions2);
        moa.add(markerOptions3);
        moa.add(markerOptions4);
        moa.add(markerOptions5);
        moa.add(markerOptions6);
        moa.add(markerOptions7);
        moa.add(markerOptions8);
        moa.add(markerOptions9);
        moa.add(markerOptions10);
        moa.add(markerOptions11);
        moa.add(markerOptions12);
        moa.add(markerOptions13);
        moa.add(markerOptions14);
        moa.add(markerOptions15);


        while (i < listPoints.size()) {

            if (result > computeDistanceBetween(listPoints.get(i), userLoc)) {
                result = computeDistanceBetween(listPoints.get(i), userLoc);
                index = i;
            }

            i++;
        }
        mMap.addMarker(moa.get(index));
        float zoomLevel = 16.0f; //This goes up to 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLoc, zoomLevel));

    }






    private void showDefaultLocation() {
        Toast.makeText(this, "Location permission not granted, " +
                        "showing default location",
                Toast.LENGTH_SHORT).show();
        LatLng redmond = new LatLng(47.6739881, -122.121512);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(redmond));
    }


    private GoogleMap.OnMyLocationButtonClickListener onMyLocationButtonClickListener =
            new GoogleMap.OnMyLocationButtonClickListener() {
                @Override
                public boolean onMyLocationButtonClick() {
                    mMap.setMinZoomPreference(15);
                    return false;
                }
            };

    private GoogleMap.OnMyLocationClickListener onMyLocationClickListener =
            new GoogleMap.OnMyLocationClickListener() {
                @Override
                public void onMyLocationClick(@NonNull Location location) {

                    mMap.setMinZoomPreference(12);

                    CircleOptions circleOptions = new CircleOptions();
                    circleOptions.center(new LatLng(location.getLatitude(),
                            location.getLongitude()));

                    circleOptions.radius(200);
                    circleOptions.fillColor(Color.RED);
                    circleOptions.strokeWidth(6);

                    mMap.addCircle(circleOptions);
                }
            };


    @Override
    public void onLocationChanged(Location location) {
        lastLoc=location;

        if(m!=null){
            m.remove();
        }



        userLoc=new LatLng(location.getLatitude(),location.getLongitude());


        if(googleApiClient!=null){
            LocationServices.FusedLocationApi.removeLocationUpdates(googleApiClient, (com.google.android.gms.location.LocationListener) this);
        }
        Distance();

    }



    @Override
    public void onConnected(@Nullable Bundle bundle) {
        locationrequest = new LocationRequest();
        locationrequest.setInterval(1100);
        locationrequest.setFastestInterval(1100);
        locationrequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationrequest, (com.google.android.gms.location.LocationListener) this);

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }


}
