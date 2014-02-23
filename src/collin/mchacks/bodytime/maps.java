package collin.mchacks.bodytime;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.SyncStateContract.Constants;

public class maps extends Activity {
	GoogleMap googleMap;
	LatLng myLocation;
	Location location;
	Marker naut;
	Marker mans;
	Marker leri;
	Marker ville;
	Marker vie;
	Marker mont;
	Marker v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maps);
        googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        centerMapOnMyLocation();
        
        LatLng nautilus = new LatLng(45.502286, -73.572889);
		naut = googleMap.addMarker(new MarkerOptions().
				position(nautilus).title("Nautilus Plus Inc."));

		LatLng mansf = new LatLng(45.500843, -73.571283);
		mans = googleMap.addMarker(new MarkerOptions().
				position(mansf).title("Mansfield Club Athlétique"));
		
		LatLng lerik = new LatLng(45.502798, -73.570035);
		leri = googleMap.addMarker(new MarkerOptions().
				position(lerik).title("Leriken Premiere Functional Fitness"));
   
		LatLng ville = new LatLng(45.499692, -73.574636);
		leri = googleMap.addMarker(new MarkerOptions().
				position(ville).title("Ville-Marie"));
   
		LatLng vie = new LatLng(45.505708, -73.567309);
		leri = googleMap.addMarker(new MarkerOptions().
				position(vie).title("Vie En Forme"));
		LatLng mont = new LatLng(45.502793, -73.570035);
		leri = googleMap.addMarker(new MarkerOptions().
				position(mont).title("Gym Montréal"));
		LatLng v = new LatLng(45.502286, -73.563448);
		leri = googleMap.addMarker(new MarkerOptions().
				position(v).title("V Square Fitness"));
		
    }
    private void centerMapOnMyLocation() {

    	   LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
           Criteria criteria = new Criteria();

           Location location = locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, false));
           if (location != null)
           {
               googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                       new LatLng(location.getLatitude(), location.getLongitude()), 13));

               CameraPosition cameraPosition = new CameraPosition.Builder()
               .target(new LatLng(location.getLatitude(), location.getLongitude()))      // Sets the center of the map to location user
               .zoom(17)                   // Sets the zoom
               .bearing(90)                // Sets the orientation of the camera to east
               .tilt(40)                   // Sets the tilt of the camera to 30 degrees
               .build();                   // Creates a CameraPosition from the builder
           googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

    }
}
}
