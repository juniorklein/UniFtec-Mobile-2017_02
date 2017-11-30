package br.com.uniftec.fteclistview.ui;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;

/**
 * Created by marioklein on 30/11/17.
 */

public class IntinerarioMapFragment extends MapFragment implements OnMapReadyCallback{

    @Override
    public void onResume() {
        super.onResume();

        getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }
}
