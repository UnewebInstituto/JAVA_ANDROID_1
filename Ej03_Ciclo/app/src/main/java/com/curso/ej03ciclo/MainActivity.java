package com.curso.ej03ciclo;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.util.Log; // Importar la clase Log

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityLifeCycle"; // Constante para el Logcat

    // Declarar las variables para los elementos de la UI
    private TextView textViewContador;
    private Button buttonClickMe;
    private int contador = 0; // Variable para el contador

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main); // Asocia esta actividad con su layout XML

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Obtener referencias a los elementos de la UI usando sus IDs
        textViewContador = findViewById(R.id.textViewContador);
        buttonClickMe = findViewById(R.id.buttonClickMe);

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
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() llamado.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() llamado.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() llamado.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() llamado.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() llamado.");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart() llamado.");
    }

}