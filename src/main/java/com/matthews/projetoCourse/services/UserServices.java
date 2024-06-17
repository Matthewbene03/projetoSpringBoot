package com.matthews.projetoCourse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matthews.projetoCourse.Repository.UserRepository;
import com.matthews.projetoCourse.entidades.User;

@Service
public class UserServices {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		List<User> listUser = userRepository.findAll();
		return listUser;
	}
	
	public User findById(Long id){
		Optional<User> user = userRepository.findById(id);
		return user.get();
	}
}
