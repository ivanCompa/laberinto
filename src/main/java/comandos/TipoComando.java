/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comandos;

/**
 *
 * @author Diurno
 */
public enum TipoComando {
    IR("ir: Moverse en una dirección"), FIN("fin: Terminar"), AYUDA("ayuda: Proporcionar información o ayuda"), ATACAR("atacar: dañar al monstruo"), ABRIR("abre un cofre");

    private final String descripcion;

    TipoComando(String descripcion) {
        this.descripcion = descripcion;
    }

    // Convetir una cadena a un tipocomando (objeto)
    public static TipoComando getTipoComando(String palabra) {
        try {
            return TipoComando.valueOf(palabra.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public String getDescripcion() {
        return this.descripcion;
    }

}
