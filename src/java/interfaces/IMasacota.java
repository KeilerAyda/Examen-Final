/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Mascota;
import java.util.ArrayList;
import org.hibernate.Session;

/**
 *
 * @author USUARIO
 */
public interface IMasacota {
     public abstract boolean guardarMascota(Mascota mascota);

    public abstract ArrayList<Mascota> listarMascotas();

    public abstract boolean ActualizarMascota(Mascota mascota);
    
    public abstract boolean eliminarMascota(Mascota mascota);
    
}
