/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Tipoatencion;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public interface ITipoAtención {
      public abstract boolean guardarTipoatencion(Tipoatencion atencion);

    public abstract ArrayList<Tipoatencion> listarTipoatencion();

    public abstract boolean ActualizarTipoatencion(Tipoatencion atencion);

    public abstract boolean eliminarTipoatencion(Tipoatencion atencion);
    
}
