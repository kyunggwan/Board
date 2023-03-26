package com.kyunggwan.board.dto;

import com.kyunggwan.board.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignInResponseDto {

	private String token;
	private int exprTime;
	private UserEntity user;
}
