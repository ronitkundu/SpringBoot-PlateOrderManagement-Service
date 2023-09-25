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
@Table(name = "user")
@Data
@AllArgsConstructor
@ToString		
@NoArgsConstructor
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 103441329488155432L;
	@Id
	@Column
	@Getter @Setter
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	@Getter @Setter
	private String userName;

	@Column
	@Getter @Setter
	private String adress;

	@Column
	@Getter @Setter
	private String passcode;

	/*public String getUserName() {
		return userName;
	}

	public String getAdress() {
		return adress;
	}

	public String getPasscode() {
		return passcode;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", adress=" + adress + ", passcode=" + passcode + "]";
	}

	public User(String userName, String adress, String passcode) {
		super();
		this.userName = userName;
		this.adress = adress;
		this.passcode = passcode;
	}

	public User() {
		super();
	}*/
}
