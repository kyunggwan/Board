package com.kyunggwan.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kyunggwan.board.dto.ResponseDto;
import com.kyunggwan.board.dto.SignInDto;
import com.kyunggwan.board.dto.SignInResponseDto;
import com.kyunggwan.board.dto.SignUpDto;
import com.kyunggwan.board.entity.UserEntity;
import com.kyunggwan.board.repository.UserRepository;
import com.kyunggwan.board.security.TokenProvider;

@Service
public class AuthService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	TokenProvider tokenProvider;

	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public ResponseDto<?> signUp(SignUpDto dto) {
		String userEmail = dto.getUserEmail();
		String userPassword = dto.getUserPassword();
		String userPasswordCheck = dto.getUserPasswordCheck();

		try {
			// email 중복 확인
			if (userRepository.existsById(userEmail))
				return ResponseDto.setFailed("Existed email");
		} catch (Exception error) {
			return ResponseDto.setFailed("Data Base Error!!!");
		}

		// 비밀번호, 비밀번호 체크가 서로 다르면 failed response
		if (!userPassword.equals(userPasswordCheck)) {
			return ResponseDto.setFailed("password does not matched!");
		}

		// UserEntity 생성
		UserEntity userEntity = new UserEntity(dto);

		// 비밀번호 암호화
		String encodedPassword = passwordEncoder.encode(userPassword);
		userEntity.setUserPassword(passwordEncoder.encode(userPassword));

		// UserRepository를 이용해서 데이터베이스 Entity 저장
		try {
			userRepository.save(userEntity);
		} catch (Exception error) {
			return ResponseDto.setFailed("Data Base Error!!!");
		}

		// 성공 시 success response 반환
		return ResponseDto.setSuccess("SignUp Success", dto);

	}

	public ResponseDto<SignInResponseDto> signIn(SignInDto dto) {
		String userEmail = dto.getUserEmail();
		String userPassword = dto.getUserPassword();

		UserEntity userEntity = null;
		try {
			userEntity = userRepository.findByUserEmail(userEmail);
			// 잘못된 이메일
			if (userEntity == null)
				return ResponseDto.setFailed("Sign In Failed");
			// 잘못된 비밀번호
			if (!passwordEncoder.matches(userPassword, userEntity.getUserPassword()))
				return ResponseDto.setFailed("Sign In Failed");
		} catch (Exception error) {
			return ResponseDto.setFailed("Database Error");
		}

		userEntity.setUserPassword("");
		// userEmail로 토큰 생성
		String token = tokenProvider.create(userEmail);
		int exprTime = 3600000;

		SignInResponseDto signInResponseDto = new SignInResponseDto(token, exprTime, userEntity);
		return ResponseDto.setSuccess("Sign In Success", signInResponseDto);

	}
}
