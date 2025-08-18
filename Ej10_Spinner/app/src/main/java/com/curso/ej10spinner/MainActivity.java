package com.curso.ej10spinner;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerCities;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // 1. Encontrar los elementos de la UI por su ID
        spinnerCities = findViewById(R.id.spinnerCities);
        textViewResult = findViewById(R.id.textViewResult);

        // Opcional: Si no usas android:entries en el XML
        // Crear un ArrayAdapter para vincular el arreglo de datos al Spinner
        // ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.cities_array, android.R.layout.simple_spinner_item);
        // adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // spinnerCities.setAdapter(adapter);

        // 2. Establecer un listener para el Spinner
        spinnerCities.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // 3. Obtener el valor de la opción seleccionada
                String selectedCity = parent.getItemAtPosition(position).toString();

                // 4. Actualizar el TextView con el resultado
                textViewResult.setText("Ciudad seleccionada: " + selectedCity);

                // Opcional: Mostrar un Toast
                Toast.makeText(MainActivity.this, "Seleccionaste: " + selectedCity, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Se llama cuando no se selecciona ningún elemento (por ejemplo, si la selección se borra)
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}