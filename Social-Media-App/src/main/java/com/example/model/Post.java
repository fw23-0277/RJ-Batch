package com.example.model;

import java.util.List;


import jakarta.persistence.Id;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_post")
@Entity
public class Post {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	private byte[] imageUrl;
	
	private String description;
	
	@ManyToOne
	private User user;
	
	@OneToOne(mappedBy = "post" , cascade = CascadeType.ALL)
	private Like like;
	
	@OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
	private List<Comment> comments;
	
	
	

}
