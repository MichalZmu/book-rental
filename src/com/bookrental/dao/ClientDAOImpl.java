package com.bookrental.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookrental.entity.Book;
import com.bookrental.entity.Client;

@Repository
public class ClientDAOImpl implements ClientDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Client> getClients() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		List<Client> clients = (List<Client>) currentSession.createQuery("from Client").list();
		
		return clients;
	}
	
	@Override
	public void saveClient(Client theClient) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theClient);
			
	}

	@Override
	public Client getClient(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();

		Client theClient = currentSession.get(Client.class, theId);
		
		return theClient;		
	}
	
	@Override
	public void deleteClient(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
				
		Query myQuery = currentSession.createQuery("delete from Client where idClient= :clientId");
		
		myQuery.setParameter("clientId", theId);
		
		myQuery.executeUpdate();
		
	}

}
