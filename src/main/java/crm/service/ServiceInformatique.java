package crm.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import crm.entity.UtilisateurClass;

public interface ServiceInformatique {
	
	public List<UtilisateurClass> GetListeUtilisateur();

	public void ajoutUtilisateur(UtilisateurClass utilisateurClass);

	public UtilisateurClass getUtilisateur(String idUtilisateur);

	public void updateUtilisateur(UtilisateurClass utilisateurClass);

	public void suppressionUtilisateur(UtilisateurClass utilisateurClass);

	public void validateUser(Map utilisateur, HttpServletRequest request);
	

	
}
