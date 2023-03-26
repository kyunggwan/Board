package com.kyunggwan.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kyunggwan.board.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
	public boolean existsByuserEmailAndUserPassword(String userEmail, String userPassword);
	
	public UserEntity findByUserEmail(String userEmail);
}
