package com.example.plate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "items")
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Items  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 103441329488155432L;
	@Id
	@Column
	@Getter @Setter
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	@Getter @Setter
	private String item_name;
	
	@Column
	@Getter @Setter
	private double price;
	
	@Column
	@Getter @Setter
	private int count;
	
	


}
