package com.curso.ej12linearlayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.text.InputType;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 1. Crear el LinearLayout principal
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setGravity(Gravity.CENTER);
        mainLayout.setPadding(64, 64, 64, 64); // Un padding para centrar mejor el contenido

        // 2. Crear los LayoutParams para los elementos hijos (con márgenes)
        LinearLayout.LayoutParams childParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        childParams.setMargins(0, 16, 0, 16); // Márgenes para separar los elementos

        // 3. Crear y configurar el TextView del título
        TextView titleTextView = new TextView(this);
        titleTextView.setText("Iniciar Sesión");
        titleTextView.setTextSize(24);
        titleTextView.setGravity(Gravity.CENTER);
        titleTextView.setLayoutParams(childParams);

        // 4. Crear y configurar el EditText para el nombre de usuario
        EditText usernameEditText = new EditText(this);
        usernameEditText.setHint("Nombre de usuario");
        usernameEditText.setLayoutParams(childParams);

        // 5. Crear y configurar el EditText para la contraseña
        EditText passwordEditText = new EditText(this);
        passwordEditText.setHint("Contraseña");
        passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        passwordEditText.setLayoutParams(childParams);

        // 6. Crear y configurar el Button de inicio de sesión
        Button loginButton = new Button(this);
        loginButton.setText("Acceder");
        loginButton.setLayoutParams(childParams);

        // 7. Añadir todas las vistas al LinearLayout principal
        mainLayout.addView(titleTextView);
        mainLayout.addView(usernameEditText);
        mainLayout.addView(passwordEditText);
        mainLayout.addView(loginButton);

        // 8. Establecer el LinearLayout como la vista principal de la actividad
        setContentView(mainLayout);

        //EdgeToEdge.enable(this);
        //setContentView(R.layout.activity_main);
        //ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
        //    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        //    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
        //    return insets;
        // });
    }
}