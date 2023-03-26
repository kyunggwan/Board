package com.kyunggwan.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyunggwan.board.dto.PatchUserDto;
import com.kyunggwan.board.dto.PatchUserResponseDto;
import com.kyunggwan.board.dto.ResponseDto;
import com.kyunggwan.board.entity.UserEntity;
import com.kyunggwan.board.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public ResponseDto<PatchUserResponseDto> patchUser(PatchUserDto dto, String userEmail) {
		UserEntity userEntity = null;
		String userNickname = dto.getUserNickname();
		String userProfile = dto.getUserProfile();
		try {
			userEntity = userRepository.findByUserEmail(userEmail);
			if (userEntity == null)
				return ResponseDto.setFailed("Does Not Exist User");

			userEntity.setUserNickname(userNickname);
			userEntity.setUserProfile(userProfile);

			userRepository.save(userEntity);
		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.setFailed("Database Error");
		}

		userEntity.setUserPassword("");
		PatchUserResponseDto patchUserResponseDto = new PatchUserResponseDto(userEntity);

		return ResponseDto.setSuccess("Success", patchUserResponseDto);
	}
}
