package DAO;

import java.util.List;

import Domain.CustomerDomain;

public interface ICustomerDAO {
	List<CustomerDomain> getCustomers() ;
}
