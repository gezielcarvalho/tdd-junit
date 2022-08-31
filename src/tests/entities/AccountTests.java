package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import tests.factory.AccountFactory;

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
		Account account = AccountFactory.createEmptyAccount();
		double depositFee = Account.getDepositFeePercentage();
		double expectedValue = amount * (1 - depositFee);
		// Act
		account.deposit(amount);
		// Assert
		Assertions.assertEquals(expectedValue, account.getBalance());
	}
	
	@Test
	public void depositShouldDoNothingWhenNegativeAmount() {
		// Arrange
		double amount = -200.0;
		double expectedValue = 100.0;
		Account account = AccountFactory.createAccount(expectedValue);
		// Act
		account.deposit(amount);
		// Assert
		Assertions.assertEquals(expectedValue, account.getBalance());		
	}
}
