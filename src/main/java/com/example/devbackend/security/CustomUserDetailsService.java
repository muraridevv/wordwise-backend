package com.example.devbackend.security;

import com.example.devbackend.exception.ResourceNotFoundException;
import com.example.devbackend.model.User;
import com.example.devbackend.repository.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepo userRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user=userRepository.findByEmail(email)
				.orElseThrow(()-> new UsernameNotFoundException("User not found with email "+email));
		
		return UserPrincipal.create(user);
	}
	
	public UserDetails loadUserById(String id) {
		User user=userRepository.findById(id)
				.orElseThrow(
						()-> new ResourceNotFoundException("User","id",id)
		);
		return UserPrincipal.create(user);
	}

}
