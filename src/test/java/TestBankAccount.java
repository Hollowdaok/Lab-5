import com.denys.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestBankAccount {
    BankAccount bankAccount;
    @BeforeEach
    void setUp() {
        bankAccount = new BankAccount(1, "Account1", 300);
    }

    @Test
    void DepositShouldIncreaseAccountBalance() {
        var depositAmount = 100;
        var balanceBeforeDeposit = bankAccount.getBalance();
        bankAccount.deposit(depositAmount);
        assertEquals(depositAmount, bankAccount.getBalance() - balanceBeforeDeposit);
    }

    @Test
    void DepositShouldThrowNegativeAmountException() {
        var negativeAmount = -100;
        assertThrows(NegativeAmountException.class, () -> bankAccount.deposit(negativeAmount));
    }

    @Test
    void WithdrawShouldDecreaseAccountBalance() {
        var withdrawAmount = 100;
        var balanceBeforeWithdraw = bankAccount.getBalance();
        bankAccount.withdraw(withdrawAmount);
        assertEquals(balanceBeforeWithdraw - withdrawAmount, bankAccount.getBalance());
    }

    @Test
    void WithdrawShouldThrowNegativeAmountException() {
        var negativeAmount = -100;
        assertThrows(NegativeAmountException.class, () -> bankAccount.withdraw(negativeAmount));
    }

    @Test
    void Withdraw_AmountBiggerThanBalance_ShouldThrowInsufficientFundsException() {
        var bigAmount = 99999999;
        assertThrows(InsufficientFundsException.class, () -> bankAccount.withdraw(bigAmount));
    }
}
