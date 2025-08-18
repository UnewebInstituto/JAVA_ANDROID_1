package com.curso.ej07radiogroupyradiobutton;

import android.os.Bundle;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // 1. Encontrar los elementos de la UI por su ID
        radioGroup = findViewById(R.id.radioGroup);
        textViewResult = findViewById(R.id.textViewResult);

        // 2. Establecer un listener para el RadioGroup
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // 3. Determinar qué RadioButton fue seleccionado
                RadioButton checkedRadioButton = findViewById(checkedId);
                String selectedText = checkedRadioButton.getText().toString();

                // 4. Actualizar el TextView con el resultado
                textViewResult.setText("Has seleccionado: " + selectedText);

                // Opcional: También puedes mostrar un Toast
                Toast.makeText(MainActivity.this, "Has seleccionado: " + selectedText, Toast.LENGTH_SHORT).show();
            }
        });

        // Opcional: Mostrar el valor inicial
        int initialCheckedId = radioGroup.getCheckedRadioButtonId();
        if (initialCheckedId != -1) {
            RadioButton initialRadioButton = findViewById(initialCheckedId);
            String initialText = initialRadioButton.getText().toString();
            textViewResult.setText("Has seleccionado: " + initialText);
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}