package com.bookrental.dao;

import java.util.List;

import com.bookrental.entity.Book;
import com.bookrental.entity.Client;

public interface ClientDAO {
	
	public List<Client> getClients();
	
	public void saveClient(Client theClient);
	
	public Client getClient(int theId);

	void deleteClient(int theId);

}
