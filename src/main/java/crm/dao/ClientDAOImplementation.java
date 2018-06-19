package crm.dao;

import java.util.List;
import org.hibernate.query.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import crm.entity.ClientClass;

@Component
@Repository
public class ClientDAOImplementation implements ClientDAO {

	@Autowired
	private SessionFactory sessionFactory;
	// Retourne la liste des clients au controllerCRM
	// @Transactional, il faut utiliser le tag <annotation-driven> de l'espace de
	// nommage tx pour préciser à Spring 
	// que les annotations sont utilisées pour la définition des transactions.
	// indique au conteneur les méthodes qui doivent s'exécuter dans un context
	// transactionnel.
	// @Transactional. Enlève l'obligation d'ajouter du code tel que
	// Begin transtation , commit transaction….

	// Avec projet_crm_spring_hibernate.xml

	private Session session;

	@Override
	public List<ClientClass> getClients() {

		// Obtenir la session en cours d'hibernate
		session = sessionFactory.openSession();

		// Contruction du Critère
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<ClientClass> criteriaQuery = builder.createQuery(ClientClass.class);
		Root<ClientClass> clients = criteriaQuery.from(ClientClass.class);
		criteriaQuery.select(clients);
//		session.close();
		return session.createQuery(criteriaQuery).getResultList();

		// version XML
		// //Obtenir la session en cours d'hibernate
		// Session sessionEnCours =generateurDeSession.getCurrentSession();
		// //Créer une requete sur la ClassClient pour obtenir la liste
		// Query<ClientClass> uneRequete = sessionEnCours.createQuery("from ClientClass
		// order by nom", ClientClass.class);
		// //Obtenir ke resultat final
		// List<ClientClass> listClients = uneRequete.getResultList();

	}

	@Override
	public void addClient(ClientClass clientClass) {

		// Obtenir la session en cours d'hibernate
				session = sessionFactory.openSession();
				Transaction tx = session.beginTransaction();

		// //Obtenir la session en cours d'hibernate
		// Session sessionEnCours =generateurDeSession.getCurrentSession();

		// Sauvegarde le client.
		session.saveOrUpdate(clientClass);
		tx.commit();
		session.close();

	}

	@Override
	public ClientClass getClient(int idClient) {

		// Obtenir la session en cours d'hibernate
		session = sessionFactory.openSession();

		//String idClientSQL = "from ClientClass c where c.id=" + idClient;

		// //Obtenir la session en cours d'hibernate
		// Session sessionEnCours =generateurDeSession.getCurrentSession();

		// Obtenir la session en cours d'hibernate

		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<ClientClass> criteriaQuery = criteriaBuilder.createQuery(ClientClass.class);
		Root<ClientClass> clients = criteriaQuery.from(ClientClass.class);
		criteriaQuery.select(clients);
		criteriaQuery.where(criteriaBuilder.equal(clients.get("id"), idClient));
		Query<ClientClass> maQuery = session.createQuery(criteriaQuery);
		ClientClass leClientClass = maQuery.getSingleResult();
		//
		// //Créer une requete sur la ClassClient pour obtenir la liste
		// Query<ClientClass> uneRequete = sessionEnCours.createQuery(idClientSQL,
		// ClientClass.class);
		//
		// //Obtenir ke resultat final
		// ClientClass leClientClass = uneRequete.getSingleResult();

		session.close();
		return leClientClass;
	}

	@Override
	public void updateClient(ClientClass clientClass) {
		// //Obtenir la session en cours d'hibernate
		// Session sessionEnCours =generateurDeSession.getCurrentSession();

		// Obtenir la session en cours d'hibernate
		session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		// Sauvegarde le client.
		session.update(clientClass);
		tx.commit();
		session.close();

		
		
		
		
	}

	@Override
	public void suppressionClient(ClientClass clientClass) {

		// Obtenir la session en cours d'hibernate
				session = sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
		// Suppresion du client.
		session.delete(clientClass);
		tx.commit();
		session.close();


	}

}
