package com.curso.ej16scrollviewenloslinearlayout;

import android.os.Bundle;

import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        // 1. Cargar el diseño XML que contiene el ScrollView y el LinearLayout
        setContentView(R.layout.activity_main);

        // 2. Obtener una referencia al LinearLayout dentro del ScrollView
        LinearLayout linearLayoutContent = findViewById(R.id.main_layout_content);

        // 3. Simular un contenido largo añadiendo 30 TextViews programáticamente
        for (int i = 1; i <= 30; i++) {
            TextView textView = new TextView(this);
            textView.setText("Elemento de lista #" + i);
            textView.setTextSize(18);
            textView.setPadding(0, 16, 0, 16);

            // 4. Añadir el TextView al LinearLayout
            linearLayoutContent.addView(textView);
        }

        //ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
        //    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        //    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
        //    return insets;
        //});
    }
}