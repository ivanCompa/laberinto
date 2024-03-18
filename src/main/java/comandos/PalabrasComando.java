/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comandos;

/**
 *
 * @author Diurno
 */
public class PalabrasComando {

    public boolean esComando(String comando){
        if(TipoComando.getTipoComando(comando) != null){
            return true;
        }else{
            return false;
        }
    }



    public String mostrarTodos() {
        return "Comandos\n" + TipoComando.AYUDA + ": Da una ayuda al usuario\n" + TipoComando.IR + ":Para indicar a donde moverse\n" + TipoComando.ATACAR + ":Dañar al monstruo\n" + TipoComando.FIN + ":Finalizar partida";
    }
}