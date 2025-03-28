package se.lexicon.model;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Represents a user's wallet that can store balance and transaction history.
 */
public class Wallet {

    private String walletId;

    private String owner;

    private BigDecimal balance;

    /**
     * Constructor to create a wallet with an owner and initial balance.
     * Generates a unique ID automatically.
     */
    public Wallet(String owner, BigDecimal initialBalance) {
        this.owner = owner;
        this.balance = initialBalance;
    }

    public void deposit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        this.balance = this.balance.subtract(amount);
    }

    public String getWalletId() {
        return walletId;
    }

    public String getOwner() {
        return owner;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    @Override
    public String toString() {
        return "Wallet ID: " + walletId + ", " + owner + "'s Balance: SEK " + balance;
    }
}
