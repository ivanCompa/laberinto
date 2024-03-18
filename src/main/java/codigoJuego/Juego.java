/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigoJuego;

import comandos.Comando;
import comandos.Transformar;
import habitaciones.Habitacion;
import habitaciones.HabitacionConMonstruo;
import habitaciones.HabitacionConCofre;
import java.util.Scanner;

/**
 *
 * @author Diurno
 */
public class Juego {

    private Transformar transformar;
    private Habitacion habitacionActual;
    private Habitacion fin;
    Scanner sc;

    public Juego() {
        crearHabitaciones();

        
        this.transformar = new Transformar();
        sc = new Scanner(System.in);

    }

    public void crearHabitaciones() {

        // Crear las habitaciones
        Habitacion habitacion1 = new Habitacion("habitación 1");
        HabitacionConMonstruo habitacion2ConMonstruo = new HabitacionConMonstruo("habitación 2 con monstruo", "Ciclope");
        HabitacionConCofre habitacion3ConCofre = new HabitacionConCofre("habitación 3 con cofre", "espada");
        Habitacion habitacion4 = new Habitacion("habitación 4");
        HabitacionConMonstruo habitacion5ConMonstruo = new HabitacionConMonstruo("habitación 5 con monstruo", "Ciempies gigante");
        Habitacion habitacion6 = new Habitacion("habitación 6");
        Habitacion habitacion7 = new Habitacion("habitación 7");
        HabitacionConCofre habitacion8ConCofre = new HabitacionConCofre("habitación 8 con cofre", "toneladas de oro");
        Habitacion habitacion9 = new Habitacion("habitación 9");
        Habitacion habitacion10 = new Habitacion("habitación 10");

        //Crear las habitaciones alternativas
        Habitacion habitacionALT1 = new Habitacion("habitación ALT1");
        HabitacionConMonstruo habitacionALT2ConMonstruo = new HabitacionConMonstruo("habitación ALT2 con monstruo", "Araña");
        Habitacion habitacionALT3 = new Habitacion("habitación ALT3");

        //Crear las salidas
        habitacion1.setSalida("norte", habitacion2ConMonstruo);
        habitacion2ConMonstruo.setSalida("este", habitacion3ConCofre);
        habitacion3ConCofre.setSalida("sur", habitacion4);
        habitacion4.setSalida("norte", habitacion5ConMonstruo);
        habitacion5ConMonstruo.setSalida("oeste", habitacion6);
        habitacion6.setSalida("este", habitacion7);
        habitacion7.setSalida("sur", habitacion8ConCofre);
        habitacion8ConCofre.setSalida("sur", habitacion9);
        habitacion9.setSalida("oeste", habitacion10);

        // Crear las salidas de las habitaciones alternativas
        habitacion6.setSalida("sur", habitacionALT1);
        habitacionALT1.setSalida("este", habitacionALT2ConMonstruo);
        habitacionALT2ConMonstruo.setSalida("norte", habitacionALT3);

        this.habitacionActual = habitacion1;

    }

    public void juego() {
        bienvenido();
        
        boolean terminar = false;
        while (!terminar) {
            // Pedir comando
            Comando comando = transformar.getCommand();
            // Pasar el comando a la habitación actual
            terminar = procesarComando(comando);

        }
        System.out.println("Gracias por jugar");
    }

    //bienvenido
    private void bienvenido() {
        System.out.println();
        System.out.println("Bienvenido al Laberinto!");
        System.out.println("Escribe 'ayuda' si necesitas ayuda.");
        System.out.println();
        System.out.println(habitacionActual.getDescripcionLarga());
    }

    //procesar comando
    private boolean procesarComando(Comando comando) {
        boolean quiereSalir = false;

        if (comando.hayComando()) {
            String palabraComando = comando.getComando();
            switch (palabraComando) {
                case "ayuda":
                    ayuda();
                    break;
                case "ir":
                    irA(comando);
                    break;
                case "atacar":
                    atacar();
                    break;
                case "fin":
                    quiereSalir = fin(comando);
                case "abrir":
                    abrirCofre();
                    break;
                
                default:
                    System.out.println("No entiendo ese comando...");
                    break;
            }
        } else {
            System.out.println("No has introducido un comando...");
        }
        return quiereSalir;
    }

    //ayuda
    private void ayuda() {
        System.out.println("Estás perdido. Estás solo. Caminas por el laberinto.");
        System.out.println();
        System.out.println("Tus comandos son:");
        System.out.println("   ir <dirección>");
        System.out.println("   atacar");
        System.out.println("   ayuda");
        System.out.println("   fin");
    }

    //irA
    private void irA(Comando comando) {
        if (!comando.haySegundaPalabra()) {
            // si no hay segunda palabra, no sabemos a dónde ir...
            System.out.println("Ir ¿dónde?");
            return;
        }

        String direccion = comando.getSegundaPalabra();
        Habitacion siguienteHabitacion = habitacionActual.getSalida(direccion);

        if (siguienteHabitacion == null) {
            System.out.println("No hay puerta en esa dirección!");
        } else {
            habitacionActual = siguienteHabitacion;
            System.out.println(habitacionActual.getDescripcionLarga());
            
            
            if (habitacionActual.getDescripcion().equals("habitación 10")) {
                System.out.println("FIN 1");
                System.exit(0);
                
            }
            if (habitacionActual.getDescripcion().equals("habitación ALT3")) {
                System.out.println("FIN 2");
                System.exit(0);
                
            }

        }
    }

    public void atacar() {
        if (!(habitacionActual instanceof HabitacionConMonstruo)) {
            System.out.println("No hay monstruo en esta habitación");
            return;
        }
        HabitacionConMonstruo habitacionConMonstruo = (HabitacionConMonstruo) habitacionActual;
        habitacionConMonstruo.ataqueAlMonstruo();
    }

    private void abrirCofre() {
        if (!(habitacionActual instanceof HabitacionConCofre)) {
            System.out.println("No hay cofres en esta habitación");
            return;
        }
        HabitacionConCofre habitacionConCofre = (HabitacionConCofre) habitacionActual;
        System.out.println(habitacionConCofre.abrirCofre());
    }

    //fin
    private boolean fin(Comando comando) {
        if (comando.getComando().equalsIgnoreCase("fin")) {
            System.out.println("Si quieres salir del juego, introduce el comando 'fin' sin más palabras.");
            String salir = sc.nextLine();
            if (salir.equalsIgnoreCase("fin")) {
                return true;

            } else {
                return false;
            }
        }

        return false; // Salir
    }
}
