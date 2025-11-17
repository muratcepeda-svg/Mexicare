package com.example.mexicaredonandesv2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupBottomNavigation();

        Button btnDonar = findViewById(R.id.btn_donar);
        Button btnBuscar = findViewById(R.id.btn_buscar_medicina);
        Button btnMapa = findViewById(R.id.btn_ver_mapa);
        Button btnLista = findViewById(R.id.btn_lista_espera);

        btnDonar.setOnClickListener(v ->
                startActivity(new Intent(this, MapaOrganizaciones.class)));
        btnBuscar.setOnClickListener(v ->
                startActivity(new Intent(this, BuscadorMedicinas.class)));
        btnMapa.setOnClickListener(v ->
                startActivity(new Intent(this, MapaOrganizaciones.class)));
        btnLista.setOnClickListener(v ->
                startActivity(new Intent(this, ListaEspera.class)));
    }

    @Override
    protected int getCurrentMenuItemId() {
        return R.id.nav_home;
    }
}