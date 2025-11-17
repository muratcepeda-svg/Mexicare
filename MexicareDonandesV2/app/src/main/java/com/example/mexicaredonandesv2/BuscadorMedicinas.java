package com.example.mexicaredonandesv2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BuscadorMedicinas extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscador_medicinas);
        setupBottomNavigation();

        EditText etBuscar = findViewById(R.id.et_buscar);
        Button btnBuscar = findViewById(R.id.btn_buscar);
        Button btnLista = findViewById(R.id.btn_agregar_lista_espera);

        btnBuscar.setOnClickListener(v ->
                Toast.makeText(this, "Buscando: " + etBuscar.getText(), Toast.LENGTH_SHORT).show());

        btnLista.setOnClickListener(v ->
                Toast.makeText(this, "Agregado a lista de espera", Toast.LENGTH_SHORT).show());
    }

    @Override
    protected int getCurrentMenuItemId() {
        return R.id.nav_search;
    }
}