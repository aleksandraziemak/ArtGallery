package com.artgallery.domain;

import com.artgallery.domain.model.Author;
import com.artgallery.domain.model.BankAccount;
import com.artgallery.domain.model.Client;
import com.artgallery.domain.model.CollectionEntry;
import com.artgallery.domain.model.Curator;
import com.artgallery.domain.model.Painting;
import com.artgallery.domain.model.Transaction;
import com.artgallery.infrastructure.PaintingRepositoryImpl;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ArtService {

    private final PaintingRepository paintingRepository;
    private final AuthorRepository authorRepository;
    private final CuratorRepository curatorRepository;
    private final CollectionEntryRepository collectionEntryRepository;
    private final ClientRepository clientRepository;
    private final BankAccountRepository bankAccountRepository;
    private final TransactionRepository transactionRepository;

    public ArtService(PaintingRepositoryImpl repository, AuthorRepository authorRepository,
                      CuratorRepository curatorRepository, CollectionEntryRepository collectionEntryRepository,
                      ClientRepository clientRepository, BankAccountRepository bankAccountRepository,
                      TransactionRepository transactionRepository) {
        this.paintingRepository = repository;
        this.authorRepository = authorRepository;
        this.curatorRepository = curatorRepository;
        this.collectionEntryRepository = collectionEntryRepository;
        this.clientRepository = clientRepository;
        this.bankAccountRepository = bankAccountRepository;
        this.transactionRepository = transactionRepository;
    }

    public List<Painting> getPaintings() {
        return paintingRepository.getPaintings();
    }

    public List<Author> getAuthors() {
        return authorRepository.getAuthors();
    }

    public List<Curator> getCurators() {
        return curatorRepository.getCurators();
    }

    public List<CollectionEntry> getCollectionEntries() {
        return collectionEntryRepository.getCollectionEntries();
    }

    public List<Client> getClients() {
        return clientRepository.getClients();
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccountRepository.getBankAccounts();
    }

    public List<Transaction> getTransactions() {
        return transactionRepository.getTransactions();
    }

    public void addPainting(Painting painting) {
        paintingRepository.addPainting(painting);
    }

    public void addAuthor(Author author) {
        authorRepository.addAuthor(author);
    }

    public void addCurator(Curator curator) {
        curatorRepository.addCurator(curator);
    }

    public void addCollectionEntry(CollectionEntry collectionEntry) {
        collectionEntryRepository.addCollectionEntry(collectionEntry);
    }

    public void addClient(Client client) {
        clientRepository.addClient(client);
    }

    public void addBankAccount(BankAccount bankAccount) {
        bankAccountRepository.addBankAccount(bankAccount);
    }

    public void addTransaction(Transaction transaction) {
        transactionRepository.addTransaction(transaction);
    }

    public void editPainting(Painting painting) {
        paintingRepository.updatePainting(painting);
    }

    public void editAuthor(Author author) {
        authorRepository.updateAuthor(author);
    }

    public void editCurator(Curator curator) {
        curatorRepository.updateCurator(curator);
    }

    public void editCollectionEntry(CollectionEntry collectionEntry) {
        collectionEntryRepository.updateCollectionEntry(collectionEntry);
    }

    public void editClient(Client client) {
        clientRepository.updateClient(client);
    }

    public void editBankAccount(BankAccount bankAccount) {
        bankAccountRepository.updateBankAccount(bankAccount);
    }

    public void editTransaction(Transaction transaction) {
        transactionRepository.updateTransaction(transaction);
    }

    public void deletePainting(Long id) {
        paintingRepository.deletePainting(id);
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteAuthor(id);
    }

    public void deleteCurator(Long id) {
        curatorRepository.deleteCurator(id);
    }

    public void deleteCollectionEntry(Long id) {
        collectionEntryRepository.deleteCollectionEntry(id);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteClient(id);
    }

    public void deleteBankAccount(Long id) {
        bankAccountRepository.deleteBankAccount(id);
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteTransaction(id);
    }
}