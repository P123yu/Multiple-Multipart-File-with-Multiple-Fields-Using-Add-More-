package com.info.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
public class InfoModel {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate toDate;
	private String purpose;
	private String expenseType;
	private String mode;
	private Long amount;
	private String currency;
	private LocalDate created;
	private String fileName;
	private String filePath;

}
