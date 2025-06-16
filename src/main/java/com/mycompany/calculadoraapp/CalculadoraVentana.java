/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculadoraapp;

/**
 *
 * @author porto
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculadoraVentana extends JFrame implements ActionListener {
    private JTextField mostradorDeNumeros;
    private String operador = "";
    private double primerNumero = 0;

    //Creacion de los elementos de la ventana
    public CalculadoraVentana() {
        setTitle("Calculadora");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        //Configuracion del Mostrador
        mostradorDeNumeros = new JTextField();
        mostradorDeNumeros.setEditable(false);
        mostradorDeNumeros.setFont(new Font("Arial", Font.BOLD, 50));
        add(mostradorDeNumeros, BorderLayout.NORTH);

        
        //Panel de Botones
        JPanel panelBotones = new JPanel(new GridLayout(4, 4, 5, 5));
        String[] botones = {
            "1", "2", "3", "/",
            "4", "5", "6", "*",
            "7", "8", "9", "-",
            "C", "0", "=", "+"
        };
        
        //Crear botones 
        for (String texto : botones) {
            JButton btn = new JButton(texto);
            btn.setFont(new Font("Arial", Font.BOLD, 20));
            btn.addActionListener(this);
            panelBotones.add(btn);
        }

        add(panelBotones, BorderLayout.CENTER);
        setVisible(true);
    }
    
    
    //Acciones de los botones
    @Override
    public void actionPerformed(ActionEvent e) {
        String entrada = e.getActionCommand();
        
        //Entrada de botones
        if (entrada.matches("[0-9]")) {
            mostradorDeNumeros.setText(mostradorDeNumeros.getText() + entrada);
        // Si se presiona el punto decimal y no hay uno ya, se agrega
        } else if (entrada.equals(".")) {
            if (!mostradorDeNumeros.getText().contains(".")) {
                mostradorDeNumeros.setText(mostradorDeNumeros.getText() + ".");
            }
        // Si se presiona C, se limpia todo
        } else if (entrada.equals("C")) {
            mostradorDeNumeros.setText("");
            operador = "";
            primerNumero = 0;
        // Con el = se realiza la operacion con el operador
        } else if (entrada.equals("=")) {
            try {
                // El operador, realiza la operación correspondiente
                double segundoNumero = Double.parseDouble(mostradorDeNumeros.getText());
                double resultado = switch (operador) {
                    case "+" -> primerNumero + segundoNumero;
                    case "-" -> primerNumero - segundoNumero;
                    case "*" -> primerNumero * segundoNumero;
                    case "/" -> segundoNumero != 0 ? primerNumero / segundoNumero : 0;
                    default -> segundoNumero; // Por si no hay operador, solo muestra el número
                };
                mostradorDeNumeros.setText(String.valueOf(resultado));
                operador = ""; // Se limpia el operador
            } catch (NumberFormatException ex) {
                mostradorDeNumeros.setText("Error");
            }
        } else {
            try {
                primerNumero = Double.parseDouble(mostradorDeNumeros.getText());
                operador = entrada;
                mostradorDeNumeros.setText("");
            } catch (NumberFormatException ex) {
                mostradorDeNumeros.setText("Error");
            }
        }
    }
}

