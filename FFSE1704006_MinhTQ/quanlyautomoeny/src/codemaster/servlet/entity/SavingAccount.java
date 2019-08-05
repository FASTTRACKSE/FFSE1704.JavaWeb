package codemaster.servlet.entity;

public class SavingAccount extends Account {
	private double interest;
	private int term;

	public SavingAccount() {
		super();
	}

	public SavingAccount(String accountNo, String ownerName, double amount, int accountType, double interest,
			int term) {
		super(accountNo, ownerName, amount, accountType);
		this.interest = interest;
		this.term = term;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	@Override
	public double deposit(double amount) {
		double sotienmoi = 0;

		sotienmoi = calculateInterest(amount);
		// setAmount(sotienmoi);

		return sotienmoi;

	}

	@Override
	public double withdraw(double amount) {
		double sotienmoi = 0;

		double soTienCu = this.getAmount();
		// setAmount(soTienCu - amount);
		sotienmoi = soTienCu - amount;
		return sotienmoi;
	}

	/**
	 * 
	 */
	public double calculateInterest(double amount) {

		double amount1 = (getAmount() + amount) * (1 + interest * term);
		return amount1;
	}
}
