package se.lexicon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import se.lexicon.dao.TransactionDao;
import se.lexicon.dao.WalletDao;
import se.lexicon.dao.impl.InMemoryTransactionDao;
import se.lexicon.dao.impl.InMemoryWalletDao;
import se.lexicon.service.WalletService;
import se.lexicon.service.WalletServiceImpl;

@Configuration
@ComponentScan(basePackages = "se.lexicon")
public class AppConfig {

    /*@Bean
    public WalletDao walletDao() {
        return new InMemoryWalletDao();
    }

    @Bean
    public TransactionDao transactionDao() {
        return new InMemoryTransactionDao();
    }

    @Bean
    public WalletService walletService(WalletDao walletDao, TransactionDao transactionDao) {
        return new WalletServiceImpl(walletDao, transactionDao);
    }*/
}
