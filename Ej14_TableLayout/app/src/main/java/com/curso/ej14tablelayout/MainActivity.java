package com.curso.ej14tablelayout;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

        // Obtener referencias a las vistas por su ID
        EditText nombreEditText = findViewById(R.id.nombre_edit_text);
        EditText correoEditText = findViewById(R.id.correo_edit_text);
        Button enviarButton = findViewById(R.id.enviar_button);

        // Configurar el OnClickListener para el botón
        enviarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el texto de los campos
                String nombre = nombreEditText.getText().toString();
                String correo = correoEditText.getText().toString();

                // Crear el mensaje a mostrar en el Toast
                String mensaje = "Formulario enviado:\nNombre: " + nombre + "\nCorreo: " + correo;

                // Mostrar el Toast
                Toast.makeText(MainActivity.this, mensaje, Toast.LENGTH_LONG).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}