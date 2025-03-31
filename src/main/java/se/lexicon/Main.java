package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.AppConfig;
import se.lexicon.dao.TransactionDao;
import se.lexicon.dao.WalletDao;
import se.lexicon.dao.impl.InMemoryTransactionDao;
import se.lexicon.dao.impl.InMemoryWalletDao;
import se.lexicon.model.Wallet;
import se.lexicon.service.WalletService;
import se.lexicon.service.WalletServiceImpl;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        /*
        WalletDao walletDao = new InMemoryWalletDao();
        TransactionDao transactionDao = new InMemoryTransactionDao();
        WalletService service = new WalletServiceImpl(walletDao, transactionDao);
        Wallet wallet = new Wallet("Elnaz", new BigDecimal(500));
        Wallet createdWallet = service.create(wallet);
        service.deposit(createdWallet.getWalletId(), new BigDecimal(100));
         */

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        WalletService service = context.getBean(WalletService.class);

        Wallet wallet = new Wallet("Elnaz", new BigDecimal(500));
        Wallet createdWallet = service.create(wallet);
        System.out.println("createdWallet = " + createdWallet);
        service.deposit(createdWallet.getWalletId(), new BigDecimal(100));
        System.out.println(service.getWalletById(createdWallet.getWalletId()));

    }
}
