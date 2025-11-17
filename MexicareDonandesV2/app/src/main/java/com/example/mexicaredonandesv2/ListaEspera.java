package com.example.mexicaredonandesv2;

import android.os.Bundle;
import android.widget.TextView;

public class ListaEspera extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_espera);
        setupBottomNavigation();

        TextView tvEstado = findViewById(R.id.tv_estado);
        tvEstado.setText("Tienes 3 medicinas en tu lista");
    }

    @Override
    protected int getCurrentMenuItemId() {
        return R.id.nav_list;
    }
}