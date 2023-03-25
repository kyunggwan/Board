package com.kyunggwan.board.entity;

import com.kyunggwan.board.dto.SignUpDto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "User") // 해당 클래스를 Entity클래스로 사용
@Table(name = "User") // DB에 있는 테이블과 현재 클래스를 매핑 시
public class UserEntity {
	@Id
	private String userEmail;
	private String userPassword;
	private String userNickname;
	private String userPhoneNumber;
	private String userAddress;
	private String userProfile;

	public UserEntity(SignUpDto dto) {
		this.userEmail = dto.getUserEmail();
		this.userPassword = dto.getUserPassword();
		this.userNickname = dto.getUserNickname();
		this.userPhoneNumber = dto.getUserPhoneNumber();
		this.userAddress = dto.getUserAddress()+" " + dto.getUserAddressDetail() ;
	}
}
