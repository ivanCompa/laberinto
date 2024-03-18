/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comandos;

import java.util.Scanner;

/**
 *
 * @author Diurno
 */
public class Transformar {

    PalabrasComando palabras;

    public Transformar() {
        this.palabras = new PalabrasComando();
    }

    public Comando getCommand() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un comando y una dirección separados por espacios (norte, sur, este u oeste)");
        String linea = sc.nextLine();
        String[] lineas = linea.split(" ");
        String[] lugares = {"norte", "sur", "este", "oeste"};
        String comando = "";
        String lugar = "";
        if (lineas.length > 0 && (palabras.esComando(lineas[0]) || lineas[0].equalsIgnoreCase("ayuda") || lineas[0].equalsIgnoreCase("fin"))) { //comprueba que se le ha pasado el comando
            comando = lineas[0];
        }
        if (lineas.length > 1) {
            for (int i = 0; i < lugares.length; i++) {
                if (lineas[1].toLowerCase().equals(lugares[i])) { //comprueba que el lugar es igual que las posibilidades de lugares
                    lugar = lineas[1];
                    break;
                }
            }
        }

        return new Comando(comando, lugar);

    }
}
