package crm.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="users")
public class UtilisateurClass {
	
	@Id
	@NotNull(message="Nom obligatoire")
	@Size(min=1, message="est obligatoire")
	@Column(name="username")
	private String nomUtilisateur;
	
	@Column(name="nom")
	@NotNull(message="nom obligatoire")
	private String nom;
	
	@Column(name="prenom")
	@NotNull(message="prenom obligatoire")
	private String prenom;
	
	@Column(name="email")
	@NotNull(message="email obligatoire")
	@Pattern(regexp="[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}",message="Adresse email non valide")
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	


	
}
