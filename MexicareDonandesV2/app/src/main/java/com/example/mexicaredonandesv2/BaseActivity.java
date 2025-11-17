package com.example.mexicaredonandesv2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public abstract class BaseActivity extends AppCompatActivity {
    
    protected BottomNavigationView bottomNavigationView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    
    protected void setupBottomNavigation() {
        setupWatermark();
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                
                if (itemId == R.id.nav_home) {
                    navigateToActivity(MainActivity.class);
                    return true;
                } else if (itemId == R.id.nav_search) {
                    navigateToActivity(BuscadorMedicinas.class);
                    return true;
                } else if (itemId == R.id.nav_list) {
                    navigateToActivity(ListaEspera.class);
                    return true;
                } else if (itemId == R.id.nav_map) {
                    navigateToActivity(MapaOrganizaciones.class);
                    return true;
                }
                return false;
            }
        });
    }
    
    private void navigateToActivity(Class<?> activityClass) {
        if (!this.getClass().equals(activityClass)) {
            Intent intent = new Intent(this, activityClass);
            startActivity(intent);
        }
    }
    
    protected abstract int getCurrentMenuItemId();
    
    private void setupWatermark() {
        findViewById(R.id.watermark_container).setBackgroundResource(R.drawable.watermark_background);
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        if (bottomNavigationView != null) {
            bottomNavigationView.setSelectedItemId(getCurrentMenuItemId());
        }
    }
}