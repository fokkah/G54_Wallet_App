package se.lexicon;

import se.lexicon.dao.WalletDao;
import se.lexicon.dao.impl.InMemoryWalletDao;
import se.lexicon.model.Wallet;
import se.lexicon.service.WalletService;
import se.lexicon.service.WalletServiceImpl;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        WalletDao walletDao = new InMemoryWalletDao();

        WalletService service = new WalletServiceImpl(walletDao);

        Wallet wallet = new Wallet("Elnaz", new BigDecimal(500));

        Wallet createdWallet = service.create(wallet);

        service.deposit(createdWallet.getWalletId(), new BigDecimal(100));

    }
}
