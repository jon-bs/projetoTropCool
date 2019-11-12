package com.webiv.ifpr.tropcool.model.entity;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public class AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull 
	private LocalDateTime created;
	
	private LocalDateTime updated;

	@PrePersist
	protected void refreshCreated() {
		if (this.getCreated() == null) {
			this.setCreated(LocalDateTime.now());
		}
	}

	@PreUpdate
	protected void refreshUpdated() {
		this.refreshCreated();
		this.setUpdated(LocalDateTime.now());
	}
}
