package crm.controleur;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import crm.entity.UtilisateurClass;
import crm.service.ServiceInformatique;

@Configuration
@Controller
@RequestMapping("/Utilisateurs")
public class ControleurUtilisateurs {

	// Créer un lien automatiquement grace à cette annotation
	@Autowired
	private ServiceInformatique serviceInformatique;
	
	@RequestMapping("/liste")
	public String listeUtilisateurs(Model model) {

		// Obenir la liste des utilisateurs 
		List<UtilisateurClass> listeUtilisateurs = serviceInformatique.GetListeUtilisateurs();

		// listeUtilisateurjsp est utilisé dans un
		// foreach sur la page liste-utilisateurs
		model.addAttribute("listeUtilisateursJSP", listeUtilisateurs);

		for (UtilisateurClass utilisateurClass : listeUtilisateurs) {
			System.out.println(utilisateurClass.getNom());
		}
		
		
		// retourne la liste des utilisateurs sur la page jsp suivante
		return "liste-utilisateurs";
	}

	@GetMapping("/formulaireAjoutUtilisateur")
	public String ajouterUtilisateur(Model model) {

		// Creer un attribut Model lier au formulaire ajouter-client.jp
		UtilisateurClass utilisateurClass = new UtilisateurClass();
		model.addAttribute("ajoutUtilisateurJSP", utilisateurClass);

		return "ajouter-utilisateur";
	}

	@PostMapping("/processAjoutUtilisateur")
	public String processAjoutUtilisateur(@ModelAttribute("utilisateurClassJSP") UtilisateurClass utilisateurClass) {

		serviceInformatique.ajoutUtilisateur(utilisateurClass);
		return "redirect:/utilisateurs/liste/";
	}

	
	@GetMapping("/formulaireMAJUtitilisateur")
	public String miseAJourClient(@RequestParam("idUtilisateurJSP") String idUtilisateur, Model model) {

		// Obtenir le client depuis la class service
		UtilisateurClass utilisateurClass = serviceInformatique.getUtilisateur(idUtilisateur);

		// Auto complete le formulaire
		model.addAttribute("idUtilisateurJSP", utilisateurClass);
		// et envoyé sur la page
		return "miseAJour-utilisateur";
	}

	
	@PostMapping("/processMAJUtilisateur")
	public String processMAJUtilisateur(@ModelAttribute("utilisateurClassJSP") UtilisateurClass utilisateurClass) {

		serviceInformatique.updateUtilisateur(utilisateurClass);
		return "redirect:/utilisateurs/liste/";
	}

	@GetMapping("/suppressionUtilisateur")
	public String suppressionUtilisateur(@RequestParam("idUtilisateurJSP") String idUtilisateur) {

		// Obtenir le client depuis la class service
		UtilisateurClass utilisateurClass = serviceInformatique.getUtilisateur(idUtilisateur);

		// Obtenir les client depuis la class service-
		serviceInformatique.suppressionUtilisateur(utilisateurClass);

		// et envoyé sur la page
		return "redirect:/utilisateurs/liste/";
	}

	@GetMapping("/formRechercheUtilisateur")
	public String rechercherClient(Model model) {

		// Creer un attribut Model lier au formulaire ajouter-utilisateur.jp
		UtilisateurClass utilisateurClass = new UtilisateurClass();
		model.addAttribute("utilisateurClassJSP", utilisateurClass);

		return "rechercher-utilisateur";
	}

	@PostMapping("/process-recherche-utilisateur")
	public String processRechercheUtilisateur(@ModelAttribute("utilisateurClassJSP") UtilisateurClass nom, Model model) {

		List<UtilisateurClass> ListeUtilisateurClass = serviceInformatique.GetListeUtilisateurs();
		List<UtilisateurClass> ListeUtilisateurClassTrouvé = new ArrayList<>();

		boolean utilisateurTrouvé = false;

		for (UtilisateurClass utilisateurClass : ListeUtilisateurClass) {

			if (utilisateurClass.getNom().equalsIgnoreCase(nom.getNom())) {

				UtilisateurClass unUtilisateurClass = serviceInformatique.getUtilisateur(utilisateurClass.getNomUtilisateur());
				ListeUtilisateurClassTrouvé.add(unUtilisateurClass);
				utilisateurTrouvé = true;
			}

		}
		if (utilisateurTrouvé) {
			model.addAttribute("ListeUtilisateurClassTrouvéJSP", ListeUtilisateurClassTrouvé);
			return "liste-utilisateur-trouvé";
		} else {
			return "liste-utilisateur-nonTrouvé";
		}
	}
	

	
	
}
