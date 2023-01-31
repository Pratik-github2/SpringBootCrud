package com.ty.springboot1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.springboot1.dao.UserDao;
import com.ty.springboot1.dto.ResponseStructure;
import com.ty.springboot1.dto.User;

@Service
public class UserService {
	@Autowired
	UserDao userDao;
	
	//save 
	public ResponseStructure<User> saveUser(User user){
		ResponseStructure<User> responseStructure=new ResponseStructure<User>();
		responseStructure.setData(userDao.saveUser(user));
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("User saved succesfully");
		return responseStructure;
}
	
	
	//get single
	public ResponseStructure<User> getUser(int id) {
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		User user = userDao.getById(id);
		if (user != null) {
			responseStructure.setData(user);
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Success");
		} else {
			System.out.println("Unsuccessfull");
		}
		return responseStructure;
	}
	
	
	//update name
	public ResponseStructure<User> updateNameUser(int id,User user) {
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		User user1 = userDao.getById(id);
		
		if (user1 != null) {
			user1.setName(user.getName());
			responseStructure.setData(userDao.updateUser(id, user1));
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Updated");
		} else {
			System.out.println("Unsuccessfull");
		}
		return responseStructure;
	}
	
	
	
	//update email
		public ResponseStructure<User> updateEmailUser(int id,User user) {
			ResponseStructure<User> responseStructure = new ResponseStructure<User>();
			User user1 = userDao.getById(id);
			if (user1 != null) {
				
				user1.setEmail(user.getEmail());
				responseStructure.setData(userDao.updateUser(id, user1));
				responseStructure.setStatusCode(HttpStatus.CREATED.value());
				responseStructure.setMessage("Updated");
			} else {
				System.out.println("Unsuccessfull");
			}
			return responseStructure;
		}
	
	
	//delete user
	public ResponseStructure<String> deleteUser(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		boolean flag = userDao.deleteUserByid(id);
		if (flag) {
			responseStructure.setData("Data deleted");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
		} else {
			System.out.println("User Not Exist");
		}
		return responseStructure;
	}

	//getall users
	public ResponseStructure<List<User>> getAllUser(){
		ResponseStructure<List<User>> responseStructure = new ResponseStructure<List<User>>();
		List<User> productes = userDao.getAllUser();
		if (productes.size()>0) {
			responseStructure.setData(productes);
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Success");
		} else {
			System.out.println("Unsuccessfull");
		}
		return responseStructure;
	}
	
	
}
