package com.luv2code.bookrental.dao;

import java.util.List;

import com.luv2code.bookrental.entity.Book;
import com.luv2code.bookrental.entity.Client;

public interface ClientDAO {
	
	public List<Client> getClients();
	
	public void saveClient(Client theClient);
	
	public Client getClient(int theId);

	void deleteClient(int theId);

}
