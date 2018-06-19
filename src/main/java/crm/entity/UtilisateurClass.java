package crm.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Column;
import javax.persistence.Table;

@Table(name="users")
public class UtilisateurClass {
	
	@NotNull(message="Nom obligatoire")
	@Size(min=1, message="est obligatoire")
	private String nomUtilisateur;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prénom;
	
	@Column(name="email")
	private String email;
	
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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrénom() {
		return prénom;
	}

	public void setPrénom(String prénom) {
		this.prénom = prénom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	


	
}
