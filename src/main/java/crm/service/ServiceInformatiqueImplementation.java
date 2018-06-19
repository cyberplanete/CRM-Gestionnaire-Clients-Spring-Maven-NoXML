package crm.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crm.dao.ClientDAO;
import crm.dao.UtilisateurDAO;
import crm.entity.ClientClass;
import crm.entity.UtilisateurClass;

@Service
public class ServiceInformatiqueImplementation implements ServiceInformatique {

	@Autowired
	private UtilisateurDAO utilisateurDAO;
	
	
	@Override
	@Transactional
	public List<UtilisateurClass> GetListeUtilisateur() {
		
		List<UtilisateurClass> listUtilisateurs = utilisateurDAO.getUtilisateurs();
		
		return listUtilisateurs;
	}


	@Override
	@Transactional
	public void ajoutUtilisateur(UtilisateurClass utilisateurClass) {
		
		utilisateurDAO.addUtilisateur(utilisateurClass);
		
	}


	@Override
	@Transactional
	public UtilisateurClass getUtilisateur(String idUtilisateur) {
		
		UtilisateurClass utilisateurClass= utilisateurDAO.getUtilisateur(idUtilisateur);
		
		return utilisateurClass;
	}


	@Override
	@Transactional
	public void updateUtilisateur(UtilisateurClass utilisateurClass) {
		
		utilisateurDAO.updateUtilisateur(utilisateurClass);
		
	}


	@Override
	@Transactional
	public void suppressionUtilisateur(UtilisateurClass utilisateurClass) {
		
		utilisateurDAO.suppressionUtilisateur(utilisateurClass);
		
	}


	@Override
	public void validateUser(Map utilisateur, HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}




}
