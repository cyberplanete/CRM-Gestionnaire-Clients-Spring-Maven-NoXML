package crm.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import crm.entity.ClientClass;

public interface ServiceClient {
	
	public List<ClientClass> GetListClient();

	public void ajoutClient(ClientClass clientClass);

	public ClientClass GetClient(int idClient);

	public void updateClient(ClientClass clientClass);

	public void suppressionClient(ClientClass clientClass);

	public void validateUser(Map utilisateur, HttpServletRequest request);
	

	
}
