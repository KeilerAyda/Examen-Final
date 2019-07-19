/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Mascota;
import interfaces.IMasacota;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilitarios.HibernateUtil;

/**
 *
 * @author USUARIO
 */
public class MascotaDao implements IMasacota{

    @Override
    public boolean guardarMascota(Mascota mascota) {
         //Construir una nueva session y una nueva transaccion
        boolean respuesta = true;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = sesion.beginTransaction();
        //Rgistrar en la base de datos la mascota

        try {
            sesion.save(mascota);
            transaccion.commit();
        } catch (Exception e) {
            System.out.println("ERROR DE GUARFDAR::" + e);
            respuesta = false;
        }

        sesion.close();
        return respuesta;
    }

    @Override
    public ArrayList<Mascota> listarMascotas() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Mascota> milista = new ArrayList<>();
        //Create la consulta hacia la base de datos
        Query query = sesion.createQuery("from Mascota");
        //Ejecutar la consulta y obtener la lista
        milista = (ArrayList<Mascota>) query.list();
          sesion.close();
        return milista;
    }

    @Override
    public boolean ActualizarMascota(Mascota mascota) {
        System.out.println("error"+ mascota.getNombreMascota());
        boolean resp= true;
        Session sesion= null;
        try {
            sesion=HibernateUtil.getSessionFactory().openSession();
            Transaction transaction=sesion.beginTransaction();
            sesion.update(mascota);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error en actualizar::"+e);
        }finally{
            if(sesion != null){
                sesion.close();
            }
            
        }
       return resp;
    }

    @Override
    public boolean eliminarMascota(Mascota mascota) {
       
         Session sesion = null;
        boolean resp = true;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.delete(mascota);
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
