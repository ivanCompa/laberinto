/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comandos;

/**
 *
 * @author Diurno
 */
public class Comando {
    private String comando, segundaPalabra;
    
    public Comando (String comando, String segundaPalabra){
        this.comando = comando;
        this.segundaPalabra = segundaPalabra;
    }

    public String getComando() {
        return comando;
    }

    public String getSegundaPalabra() {
        return this.segundaPalabra;
    }

    public boolean hayComando(){
        if(comando != null && new PalabrasComando().esComando(comando)){
            return true;
        }else{
            return false;
        }
    }

    public boolean haySegundaPalabra(){
        if(this.segundaPalabra != null ){
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public String toString() {
        return "Comando{" + "comando=" + comando + ", segundaPalabra=" + segundaPalabra + '}';
    }
}

