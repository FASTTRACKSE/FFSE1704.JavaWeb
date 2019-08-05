package codemaster.servlet.entity;

public class TransactionAccount extends Account {

	public TransactionAccount() {
		super();
	}

	public TransactionAccount(String accountNo, String ownerName, double amount, int accountType) {
		super(accountNo, ownerName, amount, accountType);
	}

	@Override
	public double deposit(double amount) {
		double sotienmoi = 0;

		double tienHienTai = this.getAmount();
		// setAmount(tienHienTai + amount);
		sotienmoi = tienHienTai - amount;
		return sotienmoi;
	}

	@Override
	public double withdraw(double amount) {

		double sotienmoi = 0;

		sotienmoi = getAmount() - amount;
		return sotienmoi;

	}

}
