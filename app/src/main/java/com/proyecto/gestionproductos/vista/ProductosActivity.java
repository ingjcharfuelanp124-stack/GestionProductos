package com.proyecto.gestionproductos.vista;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.proyecto.gestionproductos.R;
import com.proyecto.gestionproductos.controlador.ProductoControlador;

public class ProductosActivity extends AppCompatActivity {

    private EditText etNombre;
    private EditText etPrecio;
    private RecyclerView rvProductos;
    private ProductoControlador controlador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        controlador = new ProductoControlador(this);
        etNombre = findViewById(R.id.etNombre);
        etPrecio = findViewById(R.id.etPrecio);
        rvProductos = findViewById(R.id.rvProductos);
        Button btnGuardar = findViewById(R.id.btnGuardar);

        rvProductos.setLayoutManager(new LinearLayoutManager(this));
        btnGuardar.setOnClickListener(v -> guardarProducto());

        cargarLista();
    }

    private void guardarProducto() {
        String nombre = etNombre.getText().toString();
        String precio = etPrecio.getText().toString();

        if (controlador.guardar(nombre, precio)) {
            etNombre.setText("");
            etPrecio.setText("");
            cargarLista();
            Toast.makeText(this, "Producto guardado", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Escribe un nombre y un precio válido", Toast.LENGTH_SHORT).show();
        }
    }

    private void cargarLista() {
        rvProductos.setAdapter(new ProductoAdapter(controlador.listar(), producto -> {
            controlador.eliminar(producto);
            cargarLista();
            Toast.makeText(this, "Producto eliminado", Toast.LENGTH_SHORT).show();
        }));
    }
}