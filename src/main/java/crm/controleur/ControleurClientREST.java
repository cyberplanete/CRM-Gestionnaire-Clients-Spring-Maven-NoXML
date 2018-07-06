package crm.controleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import crm.entity.ClientClass;
import crm.erreurs.ClientNonTrouveException;
import crm.service.ServiceClient;

@RestController
@RequestMapping("/api")
public class ControleurClientREST {
	
	//Autowire serviceClient
	@Autowired
	private ServiceClient serviceClient;
	
	@GetMapping("/listClients")	
	public List<ClientClass> listClient (){
		
		return serviceClient.GetListClient();
		
	}
	
	@GetMapping("/getClient/{clientID}")
	public ClientClass getClient(@PathVariable int clientID){
		
		List<ClientClass> listClients = serviceClient.GetListClient();
		
		if (listClients == null) {
			throw new ClientNonTrouveException("Client non trouvé" + clientID);
		}
		
		//Verifier si etudiant est dans la base
		if (clientID >= listClients.size() || (clientID < 0)) {
			throw  new ClientNonTrouveException("Client id non trouvé - " + clientID);
		}
		
		return serviceClient.GetClient(clientID);
	}
	
	//Ajout mapping pour permettre l'ajout de client
	@PostMapping("/ajoutClient")//Obligation de désativer CSRF (CrossSiteForgery)
//	@RequestMapping(value= "/ajoutClient", method= RequestMethod.POST)
	public ClientClass ajoutClient(@RequestBody ClientClass unClientClass) {
		
		//Si ID passé dans JSON ... set id à 0... force a save of new item... instead of update
		unClientClass.setId(0);
		
		serviceClient.ajoutClient(unClientClass);
		
		return unClientClass;
		
	}
	
	//Ajout mapping pour permettre la mise à jour d'un client
	@PostMapping("/updateClient")//Obligation de désativer CSRF (CrossSiteForgery)
//	@RequestMapping(value= "/ajoutClient", method= RequestMethod.POST)
	public ClientClass updateClient(@RequestBody ClientClass unClientClass) {
		
		
		serviceClient.updateClient(unClientClass);
	
		return unClientClass;
		
	}
	
	//Ajout mapping pour permettre la mise à jour d'un client
	@PostMapping("/deleteClient/{IDClient}")//Obligation de désativer CSRF (CrossSiteForgery)
//	@RequestMapping(value= "/ajoutClient", method= RequestMethod.POST)
	public String deleteClient(@PathVariable int  IDClient) {
		
		ClientClass unClientClass = serviceClient.GetClient(IDClient);
		List<ClientClass> listClients = serviceClient.GetListClient();
		
		if (unClientClass == null) {
			throw new ClientNonTrouveException("Client non trouvé: " + IDClient);
		}
		
		//Verifier si client est dans la base
				if (IDClient >= listClients.size() || (IDClient < 0)) {
					throw  new ClientNonTrouveException("Client id non trouvé - " + IDClient);
				}
		
		serviceClient.suppressionClient(unClientClass);
		
				
		return "Client supprimé de la base" + unClientClass;
		
	}

}
