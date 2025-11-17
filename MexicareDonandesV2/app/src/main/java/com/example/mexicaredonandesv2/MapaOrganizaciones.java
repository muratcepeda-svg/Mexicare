package com.example.mexicaredonandesv2;

import android.os.Bundle;
import android.widget.TextView;
import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

public class MapaOrganizaciones extends BaseActivity {

    private MapView map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Configuration.getInstance().setUserAgentValue(getPackageName());

        setContentView(R.layout.activity_mapa_organizaciones);
        setupBottomNavigation();

        TextView tvTitulo = findViewById(R.id.tv_titulo);
        tvTitulo.setText("Organizaciones Cercanas (4)");

        map = findViewById(R.id.map);
        map.setTileSource(TileSourceFactory.MAPNIK);
        map.setBuiltInZoomControls(true);
        map.setMultiTouchControls(true);

        IMapController mapController = map.getController();
        mapController.setZoom(12.0);
        GeoPoint startPoint = new GeoPoint(19.4326, -99.1332);
        mapController.setCenter(startPoint);

        // Agregar marcadores
        addMarker(19.4326, -99.1332, "Cruz Roja", "Av. Principal 123");
        addMarker(19.4286, -99.1276, "DIF Municipal", "Calle Centro 456");
        addMarker(19.4366, -99.1392, "Caritas", "Blvd. Norte 789");
        addMarker(19.4246, -99.1252, "Hospital Comunitario", "Col. Sur 321");
    }

    private void addMarker(double lat, double lon, String title, String description) {
        Marker marker = new Marker(map);
        marker.setPosition(new GeoPoint(lat, lon));
        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        marker.setTitle(title);
        marker.setSubDescription(description);
        map.getOverlays().add(marker);
    }

    @Override
    protected void onResume() {
        super.onResume();
        map.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        map.onPause();
    }

    @Override
    protected int getCurrentMenuItemId() {
        return R.id.nav_map;
    }
}