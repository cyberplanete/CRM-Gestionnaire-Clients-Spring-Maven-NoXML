package crm.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import crm.entity.UtilisateurClass;

@Component
@Repository
public class UtilisateurDAOImplementation implements UtilisateurDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session;
	
	@Override
	public List<UtilisateurClass> getListeUtilisateurs() {
		
		session = sessionFactory.openSession();
		
		//Création du critère de recherche
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<UtilisateurClass> criteriaQuery = builder.createQuery(UtilisateurClass.class);
		Root<UtilisateurClass> utilisateurs = criteriaQuery.from(UtilisateurClass.class);
		criteriaQuery.select(utilisateurs);
		
		return session.createQuery(criteriaQuery).getResultList();
		
	}

	@Override
	public void addUtilisateur(UtilisateurClass utilisateurClass) {
		session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.saveOrUpdate(utilisateurClass);
		tx.commit();
		session.close();
	}

	@Override
	public UtilisateurClass getUtilisateur(String idUtilisateur) {
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<UtilisateurClass> criteriaQuery = criteriaBuilder.createQuery(UtilisateurClass.class);
		Root<UtilisateurClass> utilisateurs = criteriaQuery.from(UtilisateurClass.class);
		//Un select sur la table clients
		criteriaQuery.select(utilisateurs);
		//
		criteriaQuery.where(criteriaBuilder.equal(utilisateurs.get("nomUtilisateur"), idUtilisateur));
		
		return session.createQuery(criteriaQuery).getSingleResult();
	}

	@Override
	public void updateUtilisateur(UtilisateurClass utilisateurClass) {
		session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.saveOrUpdate(utilisateurClass);
		tx.commit();
		session.close();

	}

	@Override
	public void suppressionUtilisateur(UtilisateurClass utilisateurClass) {
		session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.delete(utilisateurClass);
		tx.commit();
		session.close();

	}

}
