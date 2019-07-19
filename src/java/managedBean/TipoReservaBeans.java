/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import dao.TipoReservaDao;
import entidades.Tiporeserva;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;

/**
 *
 * @author USUARIO
 */
@ManagedBean
@ViewScoped
public class TipoReservaBeans implements Serializable{ 
    private Tiporeserva tiporeserva;
    

    public TipoReservaBeans() {
        this.tiporeserva = new Tiporeserva();
    }

    public Tiporeserva getTiporeserva() {
        return tiporeserva;
    }

    public void setTiporeserva(Tiporeserva tiporeserva) {
        this.tiporeserva = tiporeserva;
    }
    
    public String guardarTipoReserva() {
        try {

            TipoReservaDao tiporeservaDao = new TipoReservaDao();
            boolean respuesta = tiporeservaDao.guardarTiporeserva(tiporeserva);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se regidtro correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo registrar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/RegistroTipoReserva";
    }
    
    public String actualizarTipoReserva() {
        try {
            TipoReservaDao tiporeservaDao = new TipoReservaDao();
            boolean respuesta = tiporeservaDao.ActualizarTiporeserva(tiporeserva);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo actualizar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/RegistroTipoReserva";

    }
    
    public ArrayList<Tiporeserva> listarTipoReserva() {
        ArrayList<Tiporeserva> lista = new ArrayList<>();
        TipoReservaDao tiporeservaDao = new TipoReservaDao();
        lista = tiporeservaDao.listarTiporeserva();
        return lista;
    }

    public String eliminarTipoReserva() {
        TipoReservaDao tiporeservaDao = new TipoReservaDao();
        boolean respuesta = tiporeservaDao.eliminarTiporeserva(tiporeserva);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se elimino correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo eliminar"));
        }
        return "/RegistroTipoReserva";
    }
}
