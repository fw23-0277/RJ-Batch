package com.example.model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Id;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String password;
	
	private String mobileNumber;
	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createdAt;

	@UpdateTimestamp
	@Column(insertable = false)
	private LocalDateTime lastModifiedDate;
	
	
	@OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
	private List<Post> posts;
	
	
	

}
