package se.lexicon.service;

import se.lexicon.model.Wallet;

import java.math.BigDecimal;

public interface WalletService {

    Wallet create(Wallet wallet);

    Wallet deposit(String walletId, BigDecimal amount);

    Wallet withdraw(String walletId, BigDecimal amount);

    Wallet getWalletById(String walletId);
}
