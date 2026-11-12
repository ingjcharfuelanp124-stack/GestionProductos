package com.proyecto.gestionproductos.util;

public class Validador {

    public static boolean esTextoVacio(String texto) {
        return texto == null || texto.trim().isEmpty();
    }

    public static boolean credencialesValidas(String usuario, String contrasena) {
        return !esTextoVacio(usuario)
                && !esTextoVacio(contrasena)
                && contrasena.length() >= 4;
    }

    public static boolean esPrecioValido(String texto) {
        if (esTextoVacio(texto)) {
            return false;
        }
        try {
            return Double.parseDouble(texto.trim()) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}