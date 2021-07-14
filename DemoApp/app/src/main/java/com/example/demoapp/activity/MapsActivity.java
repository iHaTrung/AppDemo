package com.example.demoapp.activity;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.demoapp.R;
import com.example.demoapp.adapter.PlacesAutoCompleteAdapter;
import com.example.demoapp.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;

import java.util.ArrayList;
import java.util.Objects;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, PlacesAutoCompleteAdapter.ClickListener {

    private GoogleMap googleMap;
    ActivityMapsBinding binding;
    CameraPosition cameraPosition;
    LatLng myLatLng;
    Place mPlace= null;
    private ArrayList<PlacesAutoCompleteAdapter.PlaceAutocomplete> mResultList = new ArrayList<>();
    PlacesAutoCompleteAdapter mAutoCompleteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.iconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainScreen = new Intent(getApplicationContext(), AddNotificationActivity.class);
                if (mPlace!=null){
                    com.example.demoapp.model.Place place=new com.example.demoapp.model.Place(mPlace.getAddress(),mPlace.getLatLng().longitude,mPlace.getLatLng().longitude);
                    mainScreen.putExtra("place", place);
                }

                startActivity(mainScreen);
                finish();
            }
        });

        //initialize
        Places.initialize(getApplicationContext(), getString(R.string.google_maps_key));
        PlacesClient client = Places.createClient(this);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        binding.addressSearch.addTextChangedListener(filterTextWatcher);

        mAutoCompleteAdapter = new PlacesAutoCompleteAdapter(this);
        binding.placeRecyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mAutoCompleteAdapter.setClickListener(this);
        binding.placeRecyclerview.setAdapter(mAutoCompleteAdapter);
        mAutoCompleteAdapter.notifyDataSetChanged();
    }

    private TextWatcher filterTextWatcher = new TextWatcher() {
        public void afterTextChanged(Editable s) {
            if (!s.toString().equals("")) {
                mAutoCompleteAdapter.getFilter().filter(s.toString());
                if (binding.placeRecyclerview.getVisibility() == View.GONE) {binding.placeRecyclerview.setVisibility(View.INVISIBLE);}
            } else {
                if (binding.placeRecyclerview.getVisibility() == View.INVISIBLE) {binding.placeRecyclerview.setVisibility(View.VISIBLE);}
            }
        }
        public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
        public void onTextChanged(CharSequence s, int start, int before, int count) { }
    };

    @Override
    public void click(Place place) {
        mPlace=place;
        binding.placeRecyclerview.setVisibility(View.GONE);
        binding.addressSearch.setText(place.getName());
        myLatLng = place.getLatLng();
        cameraPosition = new CameraPosition.Builder().target(
                myLatLng)
                .zoom(15)
                .bearing(0)
                .tilt(0)
                .build();
        googleMap.addMarker(new MarkerOptions().position(myLatLng).title("Marker in " + place.getName()));
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
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
        this.googleMap = googleMap;
        LatLng myLatLng = new LatLng(21, 105);
        cameraPosition = new CameraPosition.Builder().target(
                myLatLng)
                .zoom(15)
                .bearing(0)
                .tilt(0)
                .build();
        googleMap.addMarker(new MarkerOptions().position(myLatLng).title("My Place"));
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }
}
