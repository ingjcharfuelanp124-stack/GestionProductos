package com.proyecto.gestionproductos;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.proyecto.gestionproductos.util.Validador;

import org.junit.Test;

public class ValidadorTest {

    @Test
    public void textoVacio_devuelveTrue() {
        assertTrue(Validador.esTextoVacio(""));
        assertTrue(Validador.esTextoVacio("   "));
        assertTrue(Validador.esTextoVacio(null));
    }

    @Test
    public void textoConContenido_devuelveFalse() {
        assertFalse(Validador.esTextoVacio("Camisa"));
    }

    @Test
    public void credencialesCorrectas_sonValidas() {
        assertTrue(Validador.credencialesValidas("admin", "1234"));
    }

    @Test
    public void credencialesIncorrectas_noSonValidas() {
        assertFalse(Validador.credencialesValidas("", "1234"));
        assertFalse(Validador.credencialesValidas("admin", ""));
        assertFalse(Validador.credencialesValidas("admin", "12"));
    }

    @Test
    public void precioValido_devuelveTrue() {
        assertTrue(Validador.esPrecioValido("2500"));
        assertTrue(Validador.esPrecioValido("19.99"));
    }

    @Test
    public void precioInvalido_devuelveFalse() {
        assertFalse(Validador.esPrecioValido(""));
        assertFalse(Validador.esPrecioValido("abc"));
        assertFalse(Validador.esPrecioValido("0"));
        assertFalse(Validador.esPrecioValido("-5"));
    }
}