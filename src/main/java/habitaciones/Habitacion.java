
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package habitaciones;

/**
 *
 * @author Diurno
 */
public class Habitacion {
    private String descripcion, salida;
    private Habitacion sNorte, sSur, sEste, sOeste;

    public Habitacion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setSalida (String direccion, Habitacion hab){
        switch (direccion) {
            case "norte":
                this.sNorte = hab;
                break;
            case "sur":
                this.sSur = hab;
                break;
            case "este":
                this.sEste = hab;
                break;
            case "oeste":
                this.sOeste = hab;
                break;
            default:
                System.out.println("La habitación no existe");
                break;
        }
    }

    public String getDescripcion (){
        return this.descripcion;
    }

    public String getDescripcionLarga(){
        return "Estás en " + this.getDescripcion() + " y las salidas posibles son: " + getStringSalidas();
    }
    
    
    
    public String getStringSalidas(){
        String salidas = "";
        if(sNorte != null) salidas += "norte ";
        if(sSur != null) salidas += "sur ";
        if(sEste != null) salidas += "este ";
        if(sOeste != null) salidas += "oeste ";

        return salidas.trim();
    }

    public Habitacion getSalida(String direccion){
        switch (direccion) {
            case "norte":
                return this.sNorte;
            case "sur":
                return this.sSur;
            case "este":
                return this.sEste;
            case "oeste":
                return this.sOeste;
            default:
                return null;
        }
    }

}
