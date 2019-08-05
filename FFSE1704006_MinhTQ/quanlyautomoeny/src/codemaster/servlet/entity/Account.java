package codemaster.servlet.entity;

public abstract class Account {
	private String accountNo;
	private String ownerName;
	private double amount;
	private int accountType;

	public Account() {
		super();

	}

	public Account(String accountNo, String ownerName, double amount, int accountType) {
		super();
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.amount = amount;
		this.accountType = accountType;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getAccountType() {
		return accountType;
	}

	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}

	/**
	 * 
	 * tiền gửi
	 * 
	 * @param Amount
	 * @return 
	 */
	public abstract double deposit(double amount);

	/**
	 * 
	 * rút tiền
	 * 
	 * @param Amount
	 */
	public abstract double withdraw(double amount);

}
