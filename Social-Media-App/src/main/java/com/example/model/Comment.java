package com.example.model;

import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comments")
@Entity
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	private String comment;
	
	
	@ManyToOne
	private Post post;
	
	@OneToMany(mappedBy = "comment" , cascade = CascadeType.ALL)
	private List<Recomment> recomments;
}
