package com.curso.ej15framelayout;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


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

        // Cargar el diseño desde el archivo XML
        setContentView(R.layout.activity_main);

        // Opcional: Obtener una referencia al TextView para interactuar con él
        TextView overlayTextView = findViewById(R.id.overlay_text_view);

        // Opcional: Configurar un clic en el texto superpuesto
        overlayTextView.setOnClickListener(v -> {
            Toast.makeText(this, "¡Has hecho clic en el texto superpuesto!", Toast.LENGTH_SHORT).show();
            // Puedes cambiar el texto o la imagen aquí
            overlayTextView.setText("¡Texto cambiado!");
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}