package crm.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UtilisateurClass {
	
	@NotNull(message="Nom obligatoire")
	@Size(min=1, message="est obligatoire")
	private String nomUtilisateur;
	
	@NotNull(message="Nom obligatoire")
	@Size(min=1, message="est obligatoire")
	private String motDePasse;

	public UtilisateurClass() {
		
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	
	


	
}
