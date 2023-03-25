package com.kyunggwan.board.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kyunggwan.board.dto.ResponseDto;
import com.kyunggwan.board.dto.SignUpDto;
import com.kyunggwan.board.dto.SignUpResponseDto;

@CrossOrigin(originPatterns="http://localhost:3000")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@PostMapping("/signUp")
	public ResponseDto<SignUpResponseDto> signUp(@RequestBody SignUpDto requestBody){
		System.out.print(requestBody.toString());
		return null;
		
	}
}
