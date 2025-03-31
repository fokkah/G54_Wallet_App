package se.lexicon.service;

import org.springframework.stereotype.Service;
import se.lexicon.dao.TransactionDao;
import se.lexicon.dao.WalletDao;
import se.lexicon.model.Transaction;
import se.lexicon.model.TransactionType;
import se.lexicon.model.Wallet;

import java.math.BigDecimal;

@Service
public class WalletServiceImpl implements WalletService {

    private WalletDao walletDao;
    private TransactionDao transactionDao;

    public WalletServiceImpl(WalletDao walletDao, TransactionDao transactionDao) {
        this.walletDao = walletDao;
        this.transactionDao = transactionDao;
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
        transactionDao.save(new Transaction(walletId, TransactionType.DEPOSIT, amount));
        return updatedWallet;
    }

    @Override
    public Wallet withdraw(String walletId, BigDecimal amount) {
        // todo: implement

        return null;
    }

    @Override
    public Wallet getWalletById(String walletId) {
        if (walletId == null) {
            throw new IllegalArgumentException("Wallet id cannot be null");
        }
        return walletDao.findById(walletId).orElseThrow(() -> new IllegalArgumentException("Wallet not found"));
    }
}
