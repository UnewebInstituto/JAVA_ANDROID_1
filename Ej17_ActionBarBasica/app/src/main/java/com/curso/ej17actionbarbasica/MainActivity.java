package com.curso.ej17actionbarbasica;

import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;

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
        setContentView(R.layout.activity_main);      // Carga el diseño

        // 1. Obtener una referencia al Action Bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // 2. Establecer un nuevo título en el Action Bar
            actionBar.setTitle("Mi Aplicación de Prueba");
        }
    }

    // 3. Crear el menú para el Action Bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    // 4. Manejar los clics en los elementos del menú del Action Bar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Verifica si el ID de la acción es el que creamos
        if (item.getItemId() == R.id.action_settings) {
            Toast.makeText(this, "Has seleccionado 'Configuración'", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

      //  ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
      //      Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
      //      v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
      //      return insets;
      //  });
    //}
}