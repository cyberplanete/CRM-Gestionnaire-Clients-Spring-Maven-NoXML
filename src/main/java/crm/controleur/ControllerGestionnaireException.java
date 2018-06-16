package crm.controleur;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import crm.erreurs.ClientNonTrouveException;
import crm.erreurs.ReponseErreurClient;

@EnableWebMvc
@ControllerAdvice
public class ControllerGestionnaireException {
	
	//Gestion de erreur client non trouvé
	@ExceptionHandler
	public ResponseEntity<ReponseErreurClient> gestionnaireDesErreurs(ClientNonTrouveException exec){
		
		ReponseErreurClient erreur = new ReponseErreurClient();
		
		erreur.setStatus(HttpStatus.NOT_FOUND.value());
		erreur.setMessage(exec.getMessage());
		erreur.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(erreur, HttpStatus.NOT_FOUND);
				}
	
	//Gestion des erreurs générique
	@ExceptionHandler
	public ResponseEntity<ReponseErreurClient> gestionnaireDesErreurs(Exception exec){
		
		ReponseErreurClient erreur = new ReponseErreurClient();
		
		erreur.setStatus(HttpStatus.BAD_REQUEST.value());
		erreur.setMessage(exec.getMessage());
		erreur.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(erreur, HttpStatus.BAD_REQUEST);
				}

}
