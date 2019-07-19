
package managedBean;
import dao.ClientesDao;
import dao.UsuarioDao;
import dao.ReservaCitaDao;
import dao.TipoReservaDao;
import entidades.Cliente;
import entidades.Usuario;
import entidades.Reservacita;
import entidades.Tiporeserva;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;


@ManagedBean
@ViewScoped
public class ReservacitaBean implements Serializable{
    
    private Reservacita reservacita;
    private Usuario usuario;
    private Cliente cliente;
    private Tiporeserva tiporeserva;
    
    private ArrayList listaCliente;
    private ArrayList listarUsuario;
    private ArrayList listarTiporeserva;
    private boolean banderaSelect = false;

    private int idUsuario;
    private int idCliente;
    private int idTipoReserva;
    private int idReservacita;
    
    public void ListarCombos(){
        UsuarioDao usuariodao= new UsuarioDao();
        ClientesDao clientedao= new ClientesDao();
        TipoReservaDao tiporeservaDao=new TipoReservaDao();
        listarTiporeserva=tiporeservaDao.listarTiporeserva();
        listarUsuario= usuariodao.listarUsuario();
        listaCliente= clientedao.listarCliente();
    }
    
    public ReservacitaBean() {
        this.reservacita = new Reservacita();
        listaCliente=new ArrayList();
        listarUsuario = new ArrayList();
        listarTiporeserva=new ArrayList();
        usuario = new Usuario();
        cliente = new Cliente();
        tiporeserva =new Tiporeserva();
        
        ListarCombos();
    }

  
    public String guardarReservacita() {
        try {

            ReservaCitaDao reservacitaDao = new ReservaCitaDao();
            cliente.setIdCliente(idCliente);
            usuario.setIdUsuario(idUsuario);
            tiporeserva.setIdTipoReserva(idTipoReserva);
            reservacita.setUsuario(usuario);
            reservacita.setCliente(cliente);
            reservacita.setTiporeserva(tiporeserva);
            
            boolean respuesta = reservacitaDao.guardarReservacita(reservacita);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se registro correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo registrar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/RegistroReservaCita";
    }

    public String actualizarReservacita() {
        try {
            ReservaCitaDao reservacitaDao = new ReservaCitaDao();
            boolean respuesta = reservacitaDao.ActualizarReservacita(reservacita);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo actualizar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/RegistroReservaCita";

    }

    public ArrayList<Reservacita> listarReservacitas() {
        ArrayList<Reservacita> lista = new ArrayList<>();
        ReservaCitaDao reservacitaDao = new ReservaCitaDao();
        lista = reservacitaDao.listarReservacita();
        return lista;
    }

    public String eliminar() {
        ReservaCitaDao reservacitaDao = new ReservaCitaDao();
        boolean respuesta = reservacitaDao.eliminarReservacita(reservacita);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se elimino correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo eliminar"));
        }
        return "/RegistroReservaCita";
    }
    
    public String limpiar() {
        return "/RegistroReservaCita";
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

    public Reservacita getReservacita() {
        return reservacita;
    }

    public void setReservacita(Reservacita reservacita) {
        this.reservacita = reservacita;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Tiporeserva getTiporeserva() {
        return tiporeserva;
    }

    public void setTiporeserva(Tiporeserva tiporeserva) {
        this.tiporeserva = tiporeserva;
    }

    public ArrayList getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(ArrayList listaCliente) {
        this.listaCliente = listaCliente;
    }

    public ArrayList getListarUsuario() {
        return listarUsuario;
    }

    public void setListarUsuario(ArrayList listarUsuario) {
        this.listarUsuario = listarUsuario;
    }

    public ArrayList getListarTiporeserva() {
        return listarTiporeserva;
    }

    public void setListarTiporeserva(ArrayList listarTiporeserva) {
        this.listarTiporeserva = listarTiporeserva;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdTipoReserva() {
        return idTipoReserva;
    }

    public void setIdTipoReserva(int idTipoReserva) {
        this.idTipoReserva = idTipoReserva;
    }

    public int getIdReservacita() {
        return idReservacita;
    }

    public void setIdReservacita(int idReservacita) {
        this.idReservacita = idReservacita;
    }

  
    
}
