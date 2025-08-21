package com.example.ej20popup;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
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

        Button popupMenuButton = findViewById(R.id.popupMenuButton);

        popupMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1. Crea una instancia de PopupMenu y la ancla a la vista
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, v);
                // 2. Infla el archivo de menú en la instancia
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

                // 3. Asigna un oyente para manejar los clics
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.popup_copy) {
                            Toast.makeText(MainActivity.this, "Opción 'Copiar' seleccionada", Toast.LENGTH_SHORT).show();
                            return true;
                        } else if (item.getItemId() == R.id.popup_paste) {
                            Toast.makeText(MainActivity.this, "Opción 'Pegar' seleccionada", Toast.LENGTH_SHORT).show();
                            return true;
                        }
                        return false;
                    }
                });
                // 4. Muestra el menú
                popupMenu.show();
            }
        });

        /*
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        */
    }
}