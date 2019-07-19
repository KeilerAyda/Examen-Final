
package interfaces;

import entidades.Usuario;
import java.util.ArrayList;

public interface IUsuario {
    public abstract boolean guardarUsuario(Usuario usuario);

    public abstract ArrayList<Usuario> listarUsuario();

    public abstract boolean ActualizarUsuario(Usuario usuario);

    public abstract boolean eliminarUsuario(Usuario usuario);

    
}
