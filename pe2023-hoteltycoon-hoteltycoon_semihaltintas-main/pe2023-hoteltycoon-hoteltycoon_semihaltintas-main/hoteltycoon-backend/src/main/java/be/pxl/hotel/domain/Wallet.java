package be.pxl.hotel.domain;

import be.pxl.hotel.exception.UnsufficientMoneyException;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Wallet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "amount")
	@Value("${wallet.initial-amount}")
	private double amount;
	@OneToMany//(mappedBy = "wallet", cascade = CascadeType.ALL)
	private List<Transaction> transactions = new ArrayList<>();

	public Wallet(double initialAmount) {
		this.amount = initialAmount;
		transactions.add(new Transaction(initialAmount, TransactionType.RECEIPT, "Starting amount"));
	}
	public Wallet() {
		// JPA Only
	}


	public double getAmount() {
		return amount;
	}
	public void registerPayment(double price, String description) {
		// Zorg voor een implementatie om een correcte betaling te doen.
		// Er moet voldoende geld aanwezig zijn en enkel een positief bedrag (groter dan 0) is toegelaten.
		// Zorg voor een correcte foutafhandeling.
		// Vergeet de betaling niet te registreren in de transactions-lijst.
		if (price <= 0) {
			throw new UnsufficientMoneyException("Price must be greater than 0");
		}
		if (price > amount) {
			throw new UnsufficientMoneyException("Not enough money");
		}
		amount -= price;
		transactions.add(new Transaction(price, TransactionType.PAYMENT, description));
	}

	public void registerReceipt(double price, String description) {
		// Zorg voor een implementatie om een bedrag te ontvangen.
		// Een negatief bedrag of 0 is niet toegelaten.
		// Zorg voor een correcte foutafhandeling.
		// Vergeet de ontvangst van het bedrag niet te registreren in de transactions-lijst.
		if (price <= 0) {
			throw new UnsufficientMoneyException("Price must be greater than 0");
		}
		amount += price;
		transactions.add(new Transaction(price, TransactionType.RECEIPT, description));
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}
}
