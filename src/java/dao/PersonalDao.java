
package dao;

import entidades.Personal;
import interfaces.IPersonal;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilitarios.HibernateUtil;

public class PersonalDao implements IPersonal{

    @Override
    public boolean guardarPersonal(Personal personal) {
        //Construir una nueva session y una nueva transaccion
        boolean respuesta = true;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = sesion.beginTransaction();
        //Rgistrar en la base de datos la personal

        try {
            sesion.save(personal);
            transaccion.commit();
        } catch (Exception e) {
            System.out.println("ERROR DE GUARFDAR::" + e);
            respuesta = false;
        }

        sesion.close();
        return respuesta;
    }

    @Override
    public ArrayList<Personal> listarPersonal() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Personal> milista = new ArrayList<>();
        //Create la consulta hacia la base de datos
        Query query = sesion.createQuery("from Personal");
        //Ejecutar la consulta y obtener la lista
        milista = (ArrayList<Personal>) query.list();
        sesion.close();
        return milista;
    }

    @Override
    public boolean ActualizarPersonal(Personal personal) {
         //System.out.println("error"+ personal.getNombre());
        boolean resp= true;
        Session sesion= null;
        try {
            sesion=HibernateUtil.getSessionFactory().openSession();
            Transaction transaction=sesion.beginTransaction();
            sesion.update(personal);
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
    public boolean eliminarPersonal(Personal personal) {
         Session sesion = null;
        boolean resp = true;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.delete(personal);
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
