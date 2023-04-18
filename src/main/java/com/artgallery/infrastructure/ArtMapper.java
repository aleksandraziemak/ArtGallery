package com.artgallery.infrastructure;

import com.artgallery.dao.db.tables.records.AuthorRecord;
import com.artgallery.dao.db.tables.records.BankAccountRecord;
import com.artgallery.dao.db.tables.records.ClientRecord;
import com.artgallery.dao.db.tables.records.CuratorRecord;
import com.artgallery.dao.db.tables.records.PaintingRecord;
import com.artgallery.dao.db.tables.records.TransactionRecord;
import com.artgallery.domain.model.Author;
import com.artgallery.domain.model.BankAccount;
import com.artgallery.domain.model.Client;
import com.artgallery.domain.model.CollectionEntry;
import com.artgallery.domain.model.Curator;
import com.artgallery.domain.model.Movement;
import com.artgallery.domain.model.Painting;
import com.artgallery.domain.model.Status;
import com.artgallery.domain.model.Transaction;

public class ArtMapper {

    public static Painting mapPainting(PaintingRecord record) {
        Painting painting = new Painting(record.getId());
        painting.setMovement(Movement.valueOf(record.getMovement()));
        painting.setYear(record.getYear());
        painting.setTitle(record.getTitle());
        painting.setStatus(Status.valueOf(record.getStatus()));
        return painting;
    }

    public static Author mapAuthor(AuthorRecord record) {
        Author author = new Author(record.getId());
        author.setFirstName(record.getFirstName());
        author.setSecondName(record.getSecondName());
        author.setLastName(record.getLastName());
        author.setCountry(record.getCountry());
        return author;
    }

    public static Curator mapCurator(CuratorRecord record) {
        Curator curator = new Curator(record.getId());
        curator.setFirstName(record.getFirstName());
        curator.setLastName(record.getLastName());
        curator.setSalary(record.getSalary());
        return curator;
    }

    public static CollectionEntry mapCollection(Long collectionEntryId,
                                                PaintingRecord paintingRecord,
                                                AuthorRecord authorRecord,
                                                CuratorRecord curatorRecord) {
        CollectionEntry collectionEntry = new CollectionEntry();
        collectionEntry.setId(collectionEntryId);
        collectionEntry.setPainting(mapPainting(paintingRecord));
        collectionEntry.setAuthor(mapAuthor(authorRecord));
        collectionEntry.setCurator(mapCurator(curatorRecord));
        return collectionEntry;
    }

    public static Client mapClient(ClientRecord record) {
        Client client = new Client(record.getId());
        client.setFirstName(record.getFirstName());
        client.setLastName(record.getLastName());
        return client;
    }

    public static BankAccount mapBankAccount(BankAccountRecord record) {
        BankAccount bankAccount = new BankAccount(record.getId());
        bankAccount.setName(record.getName());
        bankAccount.setAccountNumber(record.getAccountNumber());
        bankAccount.setBalance(record.getBalance());
        return bankAccount;
    }


    public static Transaction mapTransaction(TransactionRecord record) {
        Transaction transaction = new Transaction(record.getId());
        transaction.setPaintingId(record.getPaintingId());
        transaction.setCuratorId(record.getCuratorId());
        transaction.setClientId(record.getClientId());
        transaction.setBankAccountId(record.getBankAccountId());
        transaction.setValue(record.getValue());
        transaction.setDate(record.getDate());
        return transaction;
    }
}