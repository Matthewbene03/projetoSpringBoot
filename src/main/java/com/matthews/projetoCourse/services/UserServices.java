package com.matthews.projetoCourse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.matthews.projetoCourse.Repository.UserRepository;
import com.matthews.projetoCourse.entidades.User;
import com.matthews.projetoCourse.services.exception.DatabaseException;
import com.matthews.projetoCourse.services.exception.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserServices {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		List<User> listUser = userRepository.findAll();
		return listUser;
	}

	public User findById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insertUser(User user) {
		return userRepository.save(user);
	}

	public User atualizeUser(Long id, User user) {
		try {
		User auxUser = userRepository.getReferenceById(id);
		atualize(auxUser, user);
		return userRepository.save(auxUser);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void atualize(User auxUser, User user) {
		auxUser.setNomeUser(user.getNomeUser());
		auxUser.setEmailUser(user.getEmailUser());
		auxUser.setTelefoneUser(user.getTelefoneUser());
	}

	public void deleteUser(Long id) {
		try {
		userRepository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
}
