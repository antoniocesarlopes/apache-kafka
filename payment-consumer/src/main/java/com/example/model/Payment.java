package com.example.model;

import java.io.Serializable;

public class Payment implements Serializable {

	private static final long serialVersionUID = 6091402445140402965L;
	
	private Long id;
    private Long idUser;
    private Long idProduct;
    private String cardNumber;
    
	public Long getId() {
		return id;
	}
	public Long getIdUser() {
		return idUser;
	}
	public Long getIdProduct() {
		return idProduct;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
    
}
