package net.madvirus.spring4.chop08.common;

public class Money {
	
	private int amount;
	private String currency;
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	@Override
	public String toString() {
		return "Money [amount=" + amount + ", currency=" + currency + "]";
	}
	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}
	

}
