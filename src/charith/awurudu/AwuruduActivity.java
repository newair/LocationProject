package charith.awurudu;

import android.app.Activity;
import android.os.Bundle;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class AwuruduActivity extends Activity implements LocationListener {   
    /** Called when the activity is first created. */
   
private TextView tvLongitudeValue;
private TextView tvLatitudeValue;

@Override
protected void onCreate(Bundle savedInstanceState) {
	
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    
    initializeService();

}



private void initializeService() {
	// TODO Auto-generated method stub
	
	   tvLongitudeValue = (TextView) findViewById(R.id.txtVal1);
	    tvLatitudeValue = (TextView) findViewById(R.id.txtVal2);
	    LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
	    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
	    Double lastLatitude = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER).getLatitude();
	    Double lastLongitude = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER).getLongitude();
	   
	  //  LocationClient mLocationClient = new LocationClient(this, this, this);
	    tvLatitudeValue.setText(String.valueOf(lastLatitude));
	    tvLongitudeValue.setText(String.valueOf(lastLongitude));
	
}



@Override
public void onLocationChanged(Location location) {
    // TODO Auto-generated method stub

    double latitude = (double) (location.getLatitude());
    double longitude = (double) (location.getLongitude());

    Log.i("Geo_Location", "Latitude: " + latitude + ", Longitude: " + longitude);
    //Toast.makeText(this, "Latitude: " + latitude + ", Longitude: " + longitude, 1000).show();
    
    String latString = String.valueOf(latitude);
    String longiString = String.valueOf(longitude);
    
    tvLatitudeValue.setText(latString);
    tvLongitudeValue.setText(longiString);
    
    
}

@Override
public void onProviderDisabled(String provider) {
    // TODO Auto-generated method stub
	

}

@Override
public void onProviderEnabled(String provider) {
    // TODO Auto-generated method stub

}

@Override
public void onStatusChanged(String provider, int status, Bundle extras) {
    // TODO Auto-generated method stub

}

}