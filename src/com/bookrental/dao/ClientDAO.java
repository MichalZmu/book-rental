package com.bookrental.dao;

import java.util.List;

import com.bookrental.entity.Book;
import com.bookrental.entity.Client;

public interface ClientDAO {
	
	List<Client> getClients();
	
	void saveClient(Client theClient);
	
	Client getClient(int theId);

	void deleteClient(int theId);

	boolean checkIfUserHasBook(int theId);

}
