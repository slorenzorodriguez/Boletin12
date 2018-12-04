/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin12;

import javax.swing.JOptionPane;

/**
 *
 * @author slorenzorodriguez
 */
public class Garaje {
   
    public Garaje() {
    }

    
    private int numCoches, numPlazas = 5;
    private long horaEntrada, horaSalida, horas;
    private String matricula;
    private double precio, cantidadIntroducida, cambio;

    
    public void aparcar() {
        if (numPlazas == 0) {
            JOptionPane.showMessageDialog(null, "COMPLETO");
        } else {
            JOptionPane.showMessageDialog(null, "PLAZAS DISPONIBLES");
            matricula = JOptionPane.showInputDialog(null, "INTRODUZCA MATRICULA");
            numPlazas--;
            numCoches++;
            horaEntrada = System.nanoTime() / 1000 / 60 / 60;
        }
    }

    public void retirar() {
        if (numPlazas == 5) {
            JOptionPane.showMessageDialog(null, "NO HAY COCHES A RETIRAR");
        } else {
            horaSalida = System.nanoTime() / 1000 / 60 / 60;
            if (horaSalida - horaEntrada < 3) {
                precio = 1.5;
            } else {
                horas = (horaSalida - horaEntrada) - 3;
                Math.floor(horas);
                precio = 1.5 + (0.2 * horas);
            }
            cantidadIntroducida = Double.parseDouble(JOptionPane.showInputDialog(null, "INTRODUZCA PAGO"));
            while (cantidadIntroducida < precio) {
                JOptionPane.showMessageDialog(null, "PAGO INSUFICIENTE");
                cantidadIntroducida = cantidadIntroducida + Double.parseDouble(JOptionPane.showInputDialog(null, "INTRODUZCA PAGO"));
            }
            cambio = cantidadIntroducida - precio;
            JOptionPane.showMessageDialog(null, "FACTURA\nMATRICULA COCHE: " + matricula + "\nTIEMPO: " + (horaSalida - horaEntrada) + "\nPRECIO: " + precio + "\nDINERO RECIBIDO: " + cantidadIntroducida + "\nDINERO DEVUELTO: " + cambio);
            numPlazas++;
            numCoches--;
        }
    }

    public void menú() {
        int eleccion;
        String[] opciones = {"APARCAR ", "RETIRAR COCHE", "SALIR"};
        eleccion = JOptionPane.showOptionDialog(null, "¿En qué puedo ayudarle?", null, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, null);
        while (eleccion <= 1) {
            if (eleccion <= 1) {
                switch (eleccion) {
                    case 0:
                        aparcar();
                        eleccion = JOptionPane.showOptionDialog(null, "¿En qué puedo ayudarle?", null, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, null);
                        break;
                    case 1:
                        retirar();
                        eleccion = JOptionPane.showOptionDialog(null, "¿En qué puedo ayudarle?", null, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, null);
                        break;
                }
            }
        }
    }

}
