package model.entities;

import model.exceptions.DomainException;

public class ContaCorrente {
	
	private Integer numero;
	private String titular;
	private Double saldo;
	private Double limiteSaque;
			
	public ContaCorrente() {
		
}

	public ContaCorrente(Integer numero, String titular, Double saldo, Double limiteSaque) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
		this.limiteSaque = limiteSaque;
	}

	public Integer getNumero() {
		return numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}


	public Double getLimiteSaque() {
		return limiteSaque;
	}

	public void setLimiteSaque(Double limiteSaque) {
		this.limiteSaque = limiteSaque;
	}
	
	public void deposito (double valor) {
		saldo += valor;
	}
	public void saque (double valor) {
		
		if(valor > limiteSaque) {
			throw new DomainException("Limite de saque excedido");
		}
		if(valor > saldo) {
			throw new DomainException("Não há saldo o suficiente"); 
		}
		saldo -= valor;
	}
	
}
