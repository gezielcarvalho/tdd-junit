package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;

public class AccountTests {

	@Test
	public void getDepositFeePercentageShouldReturnExpectedValue() {
		double expectedValue = 0.02;
		Assertions.assertEquals(expectedValue, Account.getDepositFeePercentage());
	}
	
	@Test
	public void depositShouldIncreaseBalanceWhenPositiveAmount() {
		// Arrange
		double amount = 200.0;
		Account account = new Account(1L, 0.0);
		double depositFee = Account.getDepositFeePercentage();
		double expectedValue = amount * (1 - depositFee);
		// Act
		account.deposit(amount);
		// Assert
		Assertions.assertEquals(expectedValue, account.getBalance());
	}
}
