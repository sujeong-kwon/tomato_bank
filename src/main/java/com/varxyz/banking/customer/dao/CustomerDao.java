package com.varxyz.banking.customer.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.varxyz.banking.customer.domain.Customer;

@Component("customerDao")
public class CustomerDao {
private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public CustomerDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void addCustomer(Customer customer) {
		String sql = "INSERT INTO Customer (email, passwd, name, ssn, phone)"
				+ " VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, customer.getEmail(), customer.getPasswd(),
				customer.getName(), customer.getSsn(), customer.getPhone());		
	}
	
	public List<Customer> findCustomerByIdPw(String email, String passwd) {
		String sql = "SELECT * FROM Customer WHERE email = ? AND passwd = ?";
		List<Customer> customers = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Customer>(Customer.class){
		}, email, passwd);
		System.out.println(customers);
		return customers;		
//		System.out.println(result);
//		if(result.size() != 0) {
//			System.out.println("true"+ result);
//			return true;
//		}else {
//			System.out.println("false"+result);
//			return false;
//		}
		
	}

	public Customer findCustomerByEmail(String email) {
		System.out.println("다오 진입");
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate "
				+ " FROM Customer WHERE email=?";
		try {
			return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Customer>(Customer.class){
			}, email);
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
		
	}
}
