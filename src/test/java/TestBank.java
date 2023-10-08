import com.denys.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestBank {
    Bank bank;
    BankAccount bankAccount;
    BankAccount otherBankAccount;
    @BeforeEach
    void setUp() {
        bank = new Bank();
        bankAccount = bank.createAccount("Account1", 300);
        otherBankAccount = bank.createAccount("Account2", 300);
    }
    @Test
    void FindAccountShouldReturnAccount() {
        var accountNumber = bankAccount.getAccountNumber();
        var actual = bank.findAccount(accountNumber);
        assertTrue(actual.isPresent());
    }
    @Test
    void TransferMoneyShouldThrowNegativeAmountException() {
        var fromAccountNumber = bankAccount.getAccountNumber();
        var toAccountNumber = otherBankAccount.getAccountNumber();
        var amount = -100;
        assertThrows(NegativeAmountException.class, () ->
                bank.transferMoney(fromAccountNumber, toAccountNumber, amount));
    }
    @Test
    void TransferMoneyShouldThrowInsufficientFundsException() {
        var fromAccountNumber = bankAccount.getAccountNumber();
        var toAccountNumber = otherBankAccount.getAccountNumber();
        var amount = bankAccount.getBalance() + 100;
        assertThrows(InsufficientFundsException.class, () ->
                bank.transferMoney(fromAccountNumber, toAccountNumber, amount));
    }
    @Test
    void TransferMoneyShouldThrowAccountNotFoundException() {
        var notExistingAccountNumber1 = -56654;
        var notExistingAccountNumber2 = -25353;
        var amount = 1;
        assertThrows(AccountNotFoundException.class, () ->
                bank.transferMoney(notExistingAccountNumber1, notExistingAccountNumber2, amount));
    }
}