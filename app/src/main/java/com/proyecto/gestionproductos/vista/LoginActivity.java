package com.proyecto.gestionproductos.vista;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.proyecto.gestionproductos.R;
import com.proyecto.gestionproductos.util.Validador;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsuario;
    private EditText etContrasena;
    private Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsuario = findViewById(R.id.etUsuario);
        etContrasena = findViewById(R.id.etContrasena);
        btnIngresar = findViewById(R.id.btnIngresar);

        btnIngresar.setOnClickListener(v -> iniciarSesion());
    }

    private void iniciarSesion() {
        String usuario = etUsuario.getText().toString().trim();
        String contrasena = etContrasena.getText().toString().trim();

        if (!Validador.credencialesValidas(usuario, contrasena)) {
            Toast.makeText(this, "Completa los campos (contraseña mínimo 4 caracteres)",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        if (usuario.equals("admin") && contrasena.equals("1234")) {
            startActivity(new Intent(this, ProductosActivity.class));
            finish();
        } else {
            Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
        }
    }
}