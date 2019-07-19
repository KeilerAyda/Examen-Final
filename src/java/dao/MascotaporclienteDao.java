
package dao;

import entidades.Clientepormascota;
import interfaces.IMascotaporcliente;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilitarios.HibernateUtil;

/**
 *
 * @author USUARIO
 */
public class MascotaporclienteDao implements IMascotaporcliente{

    @Override
    public boolean guardarMascotaPorCliente(Clientepormascota mascotaporcliente) {
         System.out.println("masc"+mascotaporcliente);
        //Construir una nueva session y una nueva transaccion
        boolean respuesta = true;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = sesion.beginTransaction();
        //Rgistrar en la base de datos la mascotaporcliente

        try {
            sesion.save(mascotaporcliente);
            transaccion.commit();
        } catch (Exception e) {
            System.out.println("ERROR DE GUARFDAR::" + e);
            respuesta = false;
        }

        sesion.close();
        return respuesta;
    }

    @Override
    public ArrayList<Clientepormascota> listarMascotaPorCliente() {
         Session sesion = HibernateUtil.getSessionFactory().openSession();
        ArrayList<Clientepormascota> milista = new ArrayList<>();
        //Create la consulta hacia la base de datos
        Query query = sesion.createQuery("from MascotaPorCliente");
        //Ejecutar la consulta y obtener la lista
        milista = (ArrayList<Clientepormascota>) query.list();
          sesion.close();
        return milista;
    }

    @Override
    public boolean ActualizarMascotaPorCliente(Clientepormascota mascotaporcliente) {
         //   System.out.println("error"+ mascotaporcliente.getNombreCliente());
        boolean resp= true;
        Session sesion= null;
        try {
            sesion=HibernateUtil.getSessionFactory().openSession();
            Transaction transaction=sesion.beginTransaction();
            sesion.update(mascotaporcliente);
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
    public boolean eliminarMascotaPorCliente(Clientepormascota mascotaporcliente) {
          Session sesion = null;
        boolean resp = true;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.delete(mascotaporcliente);
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
