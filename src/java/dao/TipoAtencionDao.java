/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Tipoatencion;
import interfaces.ITipoAtención;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilitarios.HibernateUtil;


/**
 *
 * @author USUARIO
 */
public class TipoAtencionDao implements ITipoAtención{

    @Override
    public boolean guardarTipoatencion(Tipoatencion atencion) {
        boolean respuesta = true;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = sesion.beginTransaction();
        //Rgistrar en la base de datos la cliente
        try {
            sesion.save(atencion);
            transaccion.commit();
        } catch (Exception e) {
            System.out.println("ERROR DE GUARDAR::" + e);
            respuesta = false;
        }
        sesion.close();
        return respuesta;
    }

    @Override
    public ArrayList<Tipoatencion> listarTipoatencion() {
         Session sesion = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Tipoatencion> milista = new ArrayList<>();
        //Create la consulta hacia la base de datos
        Query query = sesion.createQuery("from Tipoatencion");
        //Ejecutar la consulta y obtener la lista
        milista = (ArrayList<Tipoatencion>) query.list();
        sesion.close();
        return milista;
    }

    @Override
    public boolean ActualizarTipoatencion(Tipoatencion atencion) {
          boolean resp = true;
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = sesion.beginTransaction();
            sesion.update(atencion);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error en actualizar::" + e);
        } finally {
            if (sesion != null) {
                sesion.close();
            }

        }
        return resp;
    }

    @Override
    public boolean eliminarTipoatencion(Tipoatencion atencion) {
         Session sesion = null;
        boolean resp = true;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.delete(atencion);
            sesion.getTransaction().commit();

        } catch (Exception e) {
            resp = false;
            System.out.println("ERROR EN ELIMINAR::" + e);
            sesion.getTransaction().rollback();
        } finally {
            if (sesion != null) {
                sesion.close();

            }

        }
        return resp;
    }
    
    
    
}
