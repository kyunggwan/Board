package com.kyunggwan.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyunggwan.board.dto.ResponseDto;
import com.kyunggwan.board.dto.SignUpDto;
import com.kyunggwan.board.entity.UserEntity;
import com.kyunggwan.board.repository.UserRepository;

@Service
public class AuthService {

	@Autowired
	UserRepository userRepository;

	public ResponseDto<?> signUp(SignUpDto dto) {
		String userEmail = dto.getUserEmail();
		String userPassword = dto.getUserPassword();
		String userPasswordCheck = dto.getUserPasswordCheck();

		try {
			// email 중복 확인
			if(userRepository.existsById(userEmail))
				return ResponseDto.setFailed("Existed email");	
		}catch(Exception e) {
			return ResponseDto.setFailed("Data Base Error!!!");
		}
		
		// 비밀번호, 비밀번호 체크가 서로 다르면 failed response
		if (!userPassword.equals(userPasswordCheck)) {
			return ResponseDto.setFailed("password does not matched!");
		}

		// UserEntity 생성
		UserEntity userEntity = new UserEntity(dto);
		
		// UserRepository를 이용해서 데이터베이스 Entity 저장		
		try {
			userRepository.save(userEntity);
			System.out.println("저장 됐다!!!");
		} catch (Exception e) {
			return ResponseDto.setFailed("Data Base Error!!!");
		}
		
		//성공 시 
		return ResponseDto.setSuccess("SignUp Success", dto);

	}
}
