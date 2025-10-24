package jp.ac.meijou.android.hannama.maps;


import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.util.Log;

import androidx.core.app.ActivityCompat;

public class location {

    Activity activity;

    public double latitude, longitude;
    LocationManager mlocationManager;

    public location(Activity activity, LocationManager locationManager) {
        this.activity = activity;
        this.mlocationManager = locationManager;
        init(mlocationManager);
        locationStart();
    }

    public void init(LocationManager locationManager) {
        locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    private void pm() {//位置情報の許可を得る
        if(ActivityCompat.checkSelfPermission(activity, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(activity, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }
    }

    private void locationStart(){
        pm();
        if (ActivityCompat.checkSelfPermission(activity, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(activity, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mlocationManager.requestLocationUpdates(mlocationManager.GPS_PROVIDER, 30, 30, location -> {
            latitude = location.getLatitude();
            longitude = location.getLongitude();
            Log.d("Location", "Latitude: " + latitude + ", Longitude: " + longitude);
        });
    }

}
