/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package habitaciones;

/**
 *
 * @author Diurno
 */
public class HabitacionConMonstruo extends Habitacion{
    private boolean monstruoVivo;
    private String nombre;

    public HabitacionConMonstruo(String descripcion, String nombre) {
        super(descripcion);
        this.monstruoVivo = true;
        this.nombre = nombre;
    }

    //simula un ataque al monstruo
    public String ataqueAlMonstruo(){
        if(monstruoVivo){
            monstruoVivo = false;
            return "Has atacado al monstruo y ha muerto";
        }else{
            return "El monstruo ya ha muerto";
        }
    }
    
    

    //añadir funcionalidad del padre
    @Override
    public String getDescripcionLarga(){
        if(monstruoVivo){
            return super.getDescripcionLarga() + " - El monstruo "+nombre+" aún sigue vivo";
        }else{
            return super.getDescripcionLarga() + " - Aquí murió el monstruo " + nombre;
        }
        
    }

    public String getNombre(){
        return this.nombre;
    }
}

