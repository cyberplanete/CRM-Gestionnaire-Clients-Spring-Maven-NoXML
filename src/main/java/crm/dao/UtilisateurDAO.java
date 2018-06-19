package crm.dao;

import java.util.List;

import crm.entity.ClientClass;
import crm.entity.UtilisateurClass;


public interface UtilisateurDAO {
	
	public List<UtilisateurClass> getListeUtilisateurs();

	public void addUtilisateur(UtilisateurClass utilisateurClass);

	public UtilisateurClass getUtilisateur(String idUtilisateur);

	public void updateUtilisateur(UtilisateurClass utilisateurClass);

	public void suppressionUtilisateur(UtilisateurClass utilisateurClass);

	

}
