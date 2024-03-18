/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package habitaciones;

/**
 *
 * @author Diurno
 */
public class HabitacionConCofre extends Habitacion{
 
    private boolean cofreAbierto;
    private String contenidoCofre;
    
    public HabitacionConCofre(String descripcion, String contenidoCofre) {
        super(descripcion);
        this.cofreAbierto = false;
        this.contenidoCofre = contenidoCofre;
    }

    public String abrirCofre(){
        if(cofreAbierto){
            return "El cofre ya estaba abierto y está vacio";
        }else{
            cofreAbierto = true;
            return "Has abierto el cofre que contiene " + contenidoCofre;
        }
    }


    public String getDescripcionLarga(){
        if(cofreAbierto){
            return super.getDescripcionLarga() + " - El cofre está abierto ";
        }else{
            return super.getDescripcionLarga() + " - El cofre se encuentra cerrado";
        }
    }
}

