
package managedBean;

import dao.ClientesDao;
import dao.PersonalDao;
import dao.UsuarioDao;
import entidades.Cliente;
import entidades.Personal;
import entidades.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;


@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable{
    
    private Usuario usuario;
    private Personal personal;
    private Cliente cliente;
    
    private ArrayList listaCliente;
    private ArrayList listarPersonal;
    private boolean banderaSelect = false;

    private int idPersonal;
    private int idCliente;
    
    public void ListarCombos(){
        PersonalDao personaldao= new PersonalDao();
        ClientesDao clientedao= new ClientesDao();
        listarPersonal= personaldao.listarPersonal();
        listaCliente= clientedao.listarCliente();
    }
    
    public UsuarioBean() {
        this.usuario = new Usuario();
        listaCliente=new ArrayList();
        listarPersonal = new ArrayList();
        personal = new Personal();
        cliente = new Cliente();
        
        ListarCombos();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String guardarUsuario() {
        try {

            UsuarioDao usuarioDao = new UsuarioDao();
            cliente.setIdCliente(idCliente);
            personal.setIdPersonal(idPersonal);
            usuario.setPersonal(personal);
            usuario.setCliente(cliente);
            
            boolean respuesta = usuarioDao.guardarUsuario(usuario);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se registro correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo registrar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/RegistroUsuario";
    }

    public String actualizarUsuario() {
        try {
            UsuarioDao usuarioDao = new UsuarioDao();
            boolean respuesta = usuarioDao.ActualizarUsuario(usuario);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo actualizar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/RegistroUsuario";

    }

    public ArrayList<Usuario> listarUsuarios() {
        ArrayList<Usuario> lista = new ArrayList<>();
        UsuarioDao usuarioDao = new UsuarioDao();
        lista = usuarioDao.listarUsuario();
        return lista;
    }

    public String eliminar() {
        UsuarioDao usuarioDao = new UsuarioDao();
        boolean respuesta = usuarioDao.eliminarUsuario(usuario);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se elimino correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo eliminar"));
        }
        return "/RegistroUsuario";
    }
    
    public String limpiar() {
        return "/RegistroUsuario";
    }
    
    public void selectBandera(){
        banderaSelect = true;
    }

    public boolean isBanderaSelect() {
        return banderaSelect;
    }

    public void setBanderaSelect(boolean banderaSelect) {
        this.banderaSelect = banderaSelect;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(ArrayList listaCliente) {
        this.listaCliente = listaCliente;
    }

    public ArrayList getListarPersonal() {
        return listarPersonal;
    }

    public void setListarPersonal(ArrayList listaPersonal) {
        this.listarPersonal = listaPersonal;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
}
