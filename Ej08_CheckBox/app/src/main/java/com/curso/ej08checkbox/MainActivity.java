package com.curso.ej08checkbox;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    CheckBox checkBoxMovies, checkBoxMusic, checkBoxGames;
    Button buttonShow;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // 1. Encontrar los elementos de la UI por su ID
        checkBoxMovies = findViewById(R.id.checkBoxMovies);
        checkBoxMusic = findViewById(R.id.checkBoxMusic);
        checkBoxGames = findViewById(R.id.checkBoxGames);
        buttonShow = findViewById(R.id.buttonShow);
        textViewResult = findViewById(R.id.textViewResult);

        // 2. Establecer un listener para el botón
        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 3. Crear un StringBuilder para construir el mensaje
                StringBuilder result = new StringBuilder();
                result.append("Tus intereses seleccionados:\n");

                // 4. Verificar el estado de cada CheckBox
                if (checkBoxMovies.isChecked()) {
                    result.append("- Películas\n");
                }
                if (checkBoxMusic.isChecked()) {
                    result.append("- Música\n");
                }
                if (checkBoxGames.isChecked()) {
                    result.append("- Videojuegos\n");
                }

                // 5. Actualizar el TextView con el resultado
                if (result.toString().equals("Tus intereses seleccionados:\n")) {
                    textViewResult.setText("No has seleccionado ningún interés.");
                    Toast.makeText(MainActivity.this, "Por favor, elige al menos un interés.", Toast.LENGTH_SHORT).show();
                } else {
                    textViewResult.setText(result.toString());
                    Toast.makeText(MainActivity.this, "Selecciones actualizadas.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}