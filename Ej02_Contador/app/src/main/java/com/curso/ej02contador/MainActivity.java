package com.curso.ej02contador;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    // Declarar las variables para los elementos de la UI
    private TextView textViewContador;
    private Button buttonClickMe;
    private int contador = 0; // Variable para el contador

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main); // Asocia esta actividad con su layout XML

        // Obtener referencias a los elementos de la UI usando sus IDs
        textViewContador = findViewById(R.id.textViewContador);
        buttonClickMe = findViewById(R.id.buttonClickMe);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Configurar el Listener para el click del botón
        buttonClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando el botón es clickeado:
                contador++; // Incrementar el contador
                // Actualizar el texto del TextView
                textViewContador.setText("Contador: " + contador);
            }
        });


    }
}