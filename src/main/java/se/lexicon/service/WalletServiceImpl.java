package se.lexicon.service;

import se.lexicon.dao.WalletDao;
import se.lexicon.model.Wallet;

import java.math.BigDecimal;

public class WalletServiceImpl implements WalletService {

    private WalletDao walletDao;

    public WalletServiceImpl(WalletDao walletDao) {
        this.walletDao = walletDao;
    }

    @Override
    public Wallet create(Wallet wallet) {
        if (wallet == null) {
            throw new IllegalArgumentException("Wallet object cannot be null");
        }
        Wallet createdWallet = walletDao.save(wallet);
        return createdWallet;
    }

    @Override
    public Wallet deposit(String walletId, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero.");
        }
        if (walletId == null) {
            throw new IllegalArgumentException("Wallet id cannot be null");
        }
        Wallet foundWallet = walletDao.findById(walletId).orElseThrow(() -> new IllegalArgumentException("Wallet not found"));
        foundWallet.deposit(amount);
        Wallet updatedWallet = walletDao.update(foundWallet);

        return updatedWallet;
    }

    @Override
    public Wallet withdraw(String walletId, BigDecimal amount) {
        return null;
    }

    @Override
    public Wallet getWalletById(String walletId) {
        return null;
    }
}
