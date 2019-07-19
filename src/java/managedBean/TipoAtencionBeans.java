/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;
import dao.TipoAtencionDao;
import entidades.Tipoatencion;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Lenovo
 */
@ManagedBean
@ViewScoped
public class TipoAtencionBeans {
    
    private Tipoatencion tipoatenciones;
    private boolean banderaSelect = false;
    
    public TipoAtencionBeans(){
        this.tipoatenciones = new Tipoatencion();
        
    }
       public String guardarTipoAtencion() {
        TipoAtencionDao dao = new TipoAtencionDao();
        boolean respuesta = dao.guardarTipoatencion(tipoatenciones);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se guardo correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo registrar"));
        }
        return "/RegistroTipoAtencion";

    }
       
        public String actualizarTipoAtencion() {
        try {
            TipoAtencionDao mascotadao = new TipoAtencionDao();
            boolean resp = mascotadao.ActualizarTipoatencion(tipoatenciones);
            if (resp) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se Pudo Actualizar"));

            }
            mascotadao.ActualizarTipoatencion(tipoatenciones);
        } catch (Exception e) {
            System.out.println("Error::" + e);
        }
        return "/RegistroTipoAtencion";
    }
         public ArrayList<Tipoatencion> listarTipoAtencion() {
        ArrayList<Tipoatencion> milista = new ArrayList<>();
        TipoAtencionDao dao = new TipoAtencionDao();
        milista = dao.listarTipoatencion();
        return milista;

    }
       
    public String eliminar(Tipoatencion data) {
        TipoAtencionDao tadao = new TipoAtencionDao();
        boolean respuesta = tadao.eliminarTipoatencion(data);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se elimino correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo eliminar"));
        }

        return "/RegistroTipoAtencion.xhtml";
    }
    
     public String limpiar() {
        banderaSelect=false;
        return "/RegistroTipoAtencion.xhtml";
    }
     
     
    public void selectBandera() {
        banderaSelect = true;
    }

    public boolean isBanderaSelect() {
        return banderaSelect;
    }

    public void setBanderaSelect(boolean banderaSelect) {
        this.banderaSelect = banderaSelect;
    }
    
    public Tipoatencion getTipoatenciones() {
        return tipoatenciones;
    }

    public void setTipoatenciones(Tipoatencion tipoatenciones) {
        this.tipoatenciones = tipoatenciones;
    }
    
    
    
    
    
    

   
    
    
    
}
