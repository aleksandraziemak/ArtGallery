/*
 * This file is generated by jOOQ.
 */
package com.artgallery.dao.db;


import com.artgallery.dao.db.tables.Author;
import com.artgallery.dao.db.tables.BankAccount;
import com.artgallery.dao.db.tables.Client;
import com.artgallery.dao.db.tables.CollectionEntry;
import com.artgallery.dao.db.tables.Curator;
import com.artgallery.dao.db.tables.Painting;
import com.artgallery.dao.db.tables.Transaction;
import com.artgallery.dao.db.tables.records.AuthorRecord;
import com.artgallery.dao.db.tables.records.BankAccountRecord;
import com.artgallery.dao.db.tables.records.ClientRecord;
import com.artgallery.dao.db.tables.records.CollectionEntryRecord;
import com.artgallery.dao.db.tables.records.CuratorRecord;
import com.artgallery.dao.db.tables.records.PaintingRecord;
import com.artgallery.dao.db.tables.records.TransactionRecord;

import javax.annotation.processing.Generated;

import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in the
 * default schema.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.17.8"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AuthorRecord> PK_AUTHOR = Internal.createUniqueKey(Author.AUTHOR, DSL.name("PK_AUTHOR"), new TableField[] { Author.AUTHOR.ID }, true);
    public static final UniqueKey<BankAccountRecord> PK_BANK_ACCOUNT = Internal.createUniqueKey(BankAccount.BANK_ACCOUNT, DSL.name("PK_BANK_ACCOUNT"), new TableField[] { BankAccount.BANK_ACCOUNT.ID }, true);
    public static final UniqueKey<ClientRecord> PK_CLIENT = Internal.createUniqueKey(Client.CLIENT, DSL.name("PK_CLIENT"), new TableField[] { Client.CLIENT.ID }, true);
    public static final UniqueKey<CollectionEntryRecord> PK_COLLECTION_ENTRY = Internal.createUniqueKey(CollectionEntry.COLLECTION_ENTRY, DSL.name("PK_COLLECTION_ENTRY"), new TableField[] { CollectionEntry.COLLECTION_ENTRY.ID }, true);
    public static final UniqueKey<CuratorRecord> PK_CURATOR = Internal.createUniqueKey(Curator.CURATOR, DSL.name("PK_CURATOR"), new TableField[] { Curator.CURATOR.ID }, true);
    public static final UniqueKey<PaintingRecord> PK_PAINTING = Internal.createUniqueKey(Painting.PAINTING, DSL.name("PK_PAINTING"), new TableField[] { Painting.PAINTING.ID }, true);
    public static final UniqueKey<TransactionRecord> PK_TRANSACTION = Internal.createUniqueKey(Transaction.TRANSACTION, DSL.name("PK_TRANSACTION"), new TableField[] { Transaction.TRANSACTION.ID }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<CollectionEntryRecord, AuthorRecord> FK_COLLECTION_AUTHOR = Internal.createForeignKey(CollectionEntry.COLLECTION_ENTRY, DSL.name("FK_COLLECTION_AUTHOR"), new TableField[] { CollectionEntry.COLLECTION_ENTRY.AUTHOR_ID }, Keys.PK_AUTHOR, new TableField[] { Author.AUTHOR.ID }, true);
    public static final ForeignKey<CollectionEntryRecord, CuratorRecord> FK_COLLECTION_CURATOR = Internal.createForeignKey(CollectionEntry.COLLECTION_ENTRY, DSL.name("FK_COLLECTION_CURATOR"), new TableField[] { CollectionEntry.COLLECTION_ENTRY.CURATOR_ID }, Keys.PK_CURATOR, new TableField[] { Curator.CURATOR.ID }, true);
    public static final ForeignKey<CollectionEntryRecord, PaintingRecord> FK_COLLECTION_PAINTING = Internal.createForeignKey(CollectionEntry.COLLECTION_ENTRY, DSL.name("FK_COLLECTION_PAINTING"), new TableField[] { CollectionEntry.COLLECTION_ENTRY.PAINTING_ID }, Keys.PK_PAINTING, new TableField[] { Painting.PAINTING.ID }, true);
    public static final ForeignKey<TransactionRecord, BankAccountRecord> FK_TRANSACTION_BANK_ACCOUNT = Internal.createForeignKey(Transaction.TRANSACTION, DSL.name("FK_TRANSACTION_BANK_ACCOUNT"), new TableField[] { Transaction.TRANSACTION.BANK_ACCOUNT_ID }, Keys.PK_BANK_ACCOUNT, new TableField[] { BankAccount.BANK_ACCOUNT.ID }, true);
    public static final ForeignKey<TransactionRecord, ClientRecord> FK_TRANSACTION_CLIENT = Internal.createForeignKey(Transaction.TRANSACTION, DSL.name("FK_TRANSACTION_CLIENT"), new TableField[] { Transaction.TRANSACTION.CLIENT_ID }, Keys.PK_CLIENT, new TableField[] { Client.CLIENT.ID }, true);
    public static final ForeignKey<TransactionRecord, CuratorRecord> FK_TRANSACTION_CURATOR = Internal.createForeignKey(Transaction.TRANSACTION, DSL.name("FK_TRANSACTION_CURATOR"), new TableField[] { Transaction.TRANSACTION.CURATOR_ID }, Keys.PK_CURATOR, new TableField[] { Curator.CURATOR.ID }, true);
    public static final ForeignKey<TransactionRecord, PaintingRecord> FK_TRANSACTION_PAINTING = Internal.createForeignKey(Transaction.TRANSACTION, DSL.name("FK_TRANSACTION_PAINTING"), new TableField[] { Transaction.TRANSACTION.PAINTING_ID }, Keys.PK_PAINTING, new TableField[] { Painting.PAINTING.ID }, true);
}
