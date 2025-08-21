package com.example.ej21menusubmenu;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
        setContentView(R.layout.activity_main);



        /*
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        */
    }
    /**
     * Este método es llamado por Android para crear el menú en la barra de acción.
     * Aquí se infla el archivo XML del menú.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    /**
     * Este método se llama cada vez que el usuario selecciona un elemento del menú.
     * Aquí se manejan los eventos de clic para cada ítem.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        // Usa una sentencia if-else para manejar cada opción del menú
        if (id == R.id.action_save) {
            Toast.makeText(this, "Opción 'Guardar' seleccionada", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_profile) {
            Toast.makeText(this, "Submenú 'Perfil' seleccionado", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_privacy) {
            Toast.makeText(this, "Submenú 'Privacidad' seleccionado", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_exit) {
            Toast.makeText(this, "Opción 'Salir' seleccionada", Toast.LENGTH_SHORT).show();
            finish(); // Cierra la actividad
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}