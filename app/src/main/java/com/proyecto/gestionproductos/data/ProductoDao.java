package com.proyecto.gestionproductos.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.proyecto.gestionproductos.modelo.Producto;

import java.util.List;

/**
 * Operaciones de acceso a datos para la tabla productos.
 */
@Dao
public interface ProductoDao {

    @Insert
    void insertar(Producto producto);

    @Update
    void actualizar(Producto producto);

    @Delete
    void eliminar(Producto producto);

    @Query("SELECT * FROM productos ORDER BY nombre ASC")
    List<Producto> obtenerTodos();

    @Query("SELECT * FROM productos WHERE id = :id")
    Producto obtenerPorId(int id);
}