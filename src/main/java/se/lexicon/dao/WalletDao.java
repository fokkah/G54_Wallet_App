package se.lexicon.dao;

import se.lexicon.model.Wallet;

import java.util.Optional;

public interface WalletDao {
    Wallet save(Wallet wallet);
    Optional<Wallet> findById(String id);
    Wallet update(Wallet wallet); // ✅ Added method

}
