package org.alfa.comex.data.daos;

import java.util.stream.Stream;

import org.alfa.comex.data.model.Transaccion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManagerFactory;
import jakarta.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TransaccionDaoImpl implements TransaccionDao{
	
    @Autowired
    private EntityManagerFactory entityManagerFactory;

	@Override
	public void registrarTransaccion(Transaccion transaccion) {
        Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
        try {
            session.beginTransaction();
            session.save(transaccion);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
           
        } finally {
            session.close();
        }
		
	}

	@Override
	public Boolean modificarTransaccion(Transaccion transaccion) {
        Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
        try {
            session.beginTransaction();
            session.update(transaccion);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            return Boolean.FALSE;
        } finally {
            session.close();
        }
		return Boolean.TRUE;
	}

	@Override
	public Stream<Transaccion> listaTransaccion() {
		
        Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
        List<Transaccion> lista = null;
        try {
            session.beginTransaction();
            lista = session.createQuery("FROM Transaccion").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
        return lista.stream();
		
	}

}
