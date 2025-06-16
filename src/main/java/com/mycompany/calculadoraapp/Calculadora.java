/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calculadoraapp;

/**
 *
 * @author porto
 */
public class Calculadora {
    public static void main(String[] args) {
        // Ejecuta la calculadora en el hilo de la GUI
        javax.swing.SwingUtilities.invokeLater(() -> {
            new CalculadoraVentana();
        });
    }
}

