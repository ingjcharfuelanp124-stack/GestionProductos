package com.proyecto.gestionproductos.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.proyecto.gestionproductos.modelo.Producto;

/**
 * Base de datos Room de la aplicación (patrón Singleton).
 */
@Database(entities = {Producto.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instancia;

    public abstract ProductoDao productoDao();

    public static synchronized AppDatabase getInstancia(Context context) {
        if (instancia == null) {
            instancia = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class,
                            "productos_db")
                    .allowMainThreadQueries()
                    .build();
        }
        return instancia;
    }
}