package com.kyunggwan.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpDto {

	private String userEmail;
	private String userPassword;
	private String userPasswordCheck;
	private String userNickname;
	private String userPhoneNumber;
	private String userAddress;
	private String userAddressDetail;

}
