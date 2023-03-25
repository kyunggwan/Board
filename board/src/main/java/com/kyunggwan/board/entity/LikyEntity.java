package com.kyunggwan.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Liky")
@Table(name="liky")
public class LikyEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int likeId;
	private int boardNumber;
	private String userEmail;
	private String likeUserProfile;
	private String likeUserNickname;
}
