package crm.controleur;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import crm.entity.UtilisateurClass;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;

@Controller
@RequestMapping("/ajouter")
public class ControleurEnregistrementUtilisateur {

	@Autowired
	private UserDetailsManager UserDetailsManager;
	
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);}
	
	
	
	@GetMapping("/formulaireUtilisateur")
	public String formulaireUtilisateur(Model leModel) {
		
		leModel.addAttribute("utilisateurFormVersControleur", new UtilisateurClass());
		
		return "ajouter-utilisateur";
	}
	
	
	@PostMapping("/processformulaireUtilisateur")
	public String processFormulaireUtilisateur(@Valid @ModelAttribute("utilisateurFormVersControleur") UtilisateurClass utilisateurClass, 
												BindingResult theBindingResult, 
												Model theModel) {
		
		String nomUtilisateur = utilisateurClass.getNomUtilisateur();
		
		logger.info("Process formulaire enregistrment utilisateur");
		
		//Validation du formulaire.  Verifier les champs du formulaire
		if (theBindingResult.hasErrors()) {
			
			theModel.addAttribute("utilisateurFormVersControleur", new UtilisateurClass());
			theModel.addAttribute("ErreurEnregistrement", "Champ utilisateur/Mot de passe ne peut être vide");
			
			logger.warning("Champ utilisateur/Mot de Passe ne pet être vide");
			
			return "ajouter-utilisateur";
		}
		
		//Vérifer si l'utilisateur est present dans la base
		boolean utilisateurExiste = verificationSiUtilisateurExiste(nomUtilisateur);
		
		if (utilisateurExiste) {
			theModel.addAttribute("utilisateurFormVersControleur", new UtilisateurClass());
			theModel.addAttribute("ErreurEnregistrement", "Utilisateur déjà présent dans la base");
			
			logger.warning("Utilisateur déjà présent dans la base");
			return "ajouter-utilisateur";
		}
		
		//Encrypte le mot de passe
		String motDePasseEncoded = passwordEncoder.encode(utilisateurClass.getMotDePasse());
		
		//prèpare l'ajout du mot de passe dans la base de donnée
		motDePasseEncoded = "{bcrypt}" + motDePasseEncoded;
		
		//Donner un role employé à l'utilisateur
		List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_EMPLOYE");
		
		//Créer un objet utilisateur (Spring Security Framework)
		User tempUser = new User(nomUtilisateur,motDePasseEncoded, authorities);
		
		//Sauvegarde dans la base de donnée
		UserDetailsManager.createUser(tempUser);
				
		logger.info("Utilisateur enregistré correctement dans la base" + nomUtilisateur);
		
		return "confirmation-ajout-utlisateur";
		
	}


	private boolean verificationSiUtilisateurExiste(String nomUtilisateur) {
		logger.info("Vérification si utilisateur dans la base");
		
		boolean existeTrueOrFalse = UserDetailsManager.userExists(nomUtilisateur);
		
		logger.info("Utilisateur" + nomUtilisateur + ",  exite: " + existeTrueOrFalse);
		
		return existeTrueOrFalse;
	}

}
