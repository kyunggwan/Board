package com.kyunggwan.board.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kyunggwan.board.dto.PatchUserDto;
import com.kyunggwan.board.dto.PatchUserResponseDto;
import com.kyunggwan.board.dto.ResponseDto;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@PatchMapping("/")
	public ResponseDto<PatchUserResponseDto> patchUser(@RequestBody PatchUserDto requestbody,
			@AuthenticationPrincipal String userEmail) {
		return null;
	}

}
