package entities;

public class Account {

	private static final double DEPOSIT_FEE_PERCENTAGE = 0.02; 
	
	private Long id;
	private Double balance;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(Long id, Double balance) {
		super();
		this.id = id;
		this.balance = balance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount * (1 - DEPOSIT_FEE_PERCENTAGE);
		}
	}

	public void withdraw(double amount) {
		if (amount>balance) {
			throw new IllegalArgumentException("Not enough funds");
		}
		balance -= amount;
	}
	
	public double fullWithdraw() {
		double lastBalance = balance;
		balance = 0.0;
		return lastBalance;
	}
	
	public static double getDepositFeePercentage() {
		return DEPOSIT_FEE_PERCENTAGE;
	}
	
}
