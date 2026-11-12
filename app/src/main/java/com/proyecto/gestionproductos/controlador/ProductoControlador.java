package com.proyecto.gestionproductos.controlador;

import android.content.Context;

import com.proyecto.gestionproductos.data.AppDatabase;
import com.proyecto.gestionproductos.data.ProductoDao;
import com.proyecto.gestionproductos.modelo.Producto;
import com.proyecto.gestionproductos.util.Validador;

import java.util.List;

public class ProductoControlador {

    private final ProductoDao dao;

    public ProductoControlador(Context context) {
        dao = AppDatabase.getInstancia(context).productoDao();
    }

    public boolean guardar(String nombre, String precioTexto) {
        if (Validador.esTextoVacio(nombre) || !Validador.esPrecioValido(precioTexto)) {
            return false;
        }
        dao.insertar(new Producto(nombre.trim(), "", Double.parseDouble(precioTexto.trim()), 1));
        return true;
    }

    public List<Producto> listar() {
        return dao.obtenerTodos();
    }

    public void eliminar(Producto producto) {
        dao.eliminar(producto);
    }
}