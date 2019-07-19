/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Clientepormascota;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public interface IMascotaporcliente {
    public abstract boolean guardarMascotaPorCliente(Clientepormascota mascotaporcliente);
    public abstract ArrayList<Clientepormascota> listarMascotaPorCliente();
     public abstract boolean ActualizarMascotaPorCliente(Clientepormascota mascotaporcliente);
     public abstract boolean eliminarMascotaPorCliente(Clientepormascota mascotaporcliente);
    
}
