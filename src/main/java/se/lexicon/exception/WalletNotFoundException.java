package se.lexicon.exception;

public class WalletNotFoundException extends RuntimeException {
    public WalletNotFoundException(String walletId) {
        super("Wallet not found with ID: " + walletId);
    }
}
