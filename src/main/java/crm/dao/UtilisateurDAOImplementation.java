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
import org.springframework.stereotype.Repository;

import crm.entity.UtilisateurClass;

@Repository
public class UtilisateurDAOImplementation implements UtilisateurDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session;
	
	@Override
	public List<UtilisateurClass> getUtilisateurs() {
		
		session = sessionFactory.openSession();
		
		//Création du critère de recherche
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<UtilisateurClass> criteriaQuery = builder.createQuery(UtilisateurClass.class);
		Root<UtilisateurClass> utilisateurs = criteriaQuery.from(UtilisateurClass.class);
		criteriaQuery.select(utilisateurs);
		Query<UtilisateurClass> query = session.createQuery(criteriaQuery);
		List<UtilisateurClass> listUtilisateur = query.getResultList();
		session.close();
		return listUtilisateur;
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
		Root<UtilisateurClass> clients = criteriaQuery.from(UtilisateurClass.class);
		//Un select sur la table clients
		criteriaQuery.select(clients);
		//
		criteriaQuery.where(criteriaBuilder.equal(clients.get("user"), idUtilisateur));
		Query<UtilisateurClass> maQuery = session.createQuery(criteriaQuery);
		UtilisateurClass utilisateurClass = maQuery.getSingleResult();
		session.close();
		return utilisateurClass;
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
