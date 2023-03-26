package com.kyunggwan.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kyunggwan.board.dto.ResponseDto;
import com.kyunggwan.board.dto.SignInResponseDto;
import com.kyunggwan.board.dto.SignUpDto;
import com.kyunggwan.board.service.AuthService;
import com.kyunggwan.board.dto.SignInDto;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	AuthService authService;

	@PostMapping("/signUp")
	public ResponseDto<?> signUp(@RequestBody SignUpDto requestBody) {
		ResponseDto<?> result = authService.signUp(requestBody);
		return result;
	}

	@PostMapping("/signIn")
	public ResponseDto<SignInResponseDto> sigin(@RequestBody SignInDto requesetBody) {
		ResponseDto<SignInResponseDto> result = authService.signIn(requesetBody);
		return result;
	}

}
