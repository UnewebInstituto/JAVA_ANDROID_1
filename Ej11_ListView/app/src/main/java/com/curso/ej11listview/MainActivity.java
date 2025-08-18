package com.curso.ej11listview;

import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // 1. Declara el ListView
    ListView simpleListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // 2. Inicializa el ListView
        simpleListView = findViewById(R.id.simpleListView);

        // 3. Prepara los datos
        ArrayList<String> fruitList = new ArrayList<>();
        fruitList.add("Manzana");
        fruitList.add("Banana");
        fruitList.add("Naranja");
        fruitList.add("Fresa");
        fruitList.add("Uva");
        fruitList.add("Piña");

        // 4. Crea el Adaptador
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                fruitList
        );

        // 5. Establece el Adaptador
        simpleListView.setAdapter(arrayAdapter);

        // Opcional: Maneja el clic en los elementos de la lista
        simpleListView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedFruit = (String) parent.getItemAtPosition(position);
            Toast.makeText(getApplicationContext(), "Has seleccionado: " + selectedFruit, Toast.LENGTH_SHORT).show();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}