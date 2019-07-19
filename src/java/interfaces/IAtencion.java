/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Atencion;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public interface IAtencion {
    
     public abstract boolean guardarAtencion(Atencion atencion);

    public abstract ArrayList<Atencion> listarAtencion();

    public abstract boolean ActualizarAtencion(Atencion atencion);

    public abstract boolean eliminarAtencion(Atencion atencion);
    
}
