/*
 * This file is generated by jOOQ.
 */
package com.artgallery.dao.db.tables.records;


import com.artgallery.dao.db.tables.Transaction;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.17.8"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TransactionRecord extends UpdatableRecordImpl<TransactionRecord> implements Record9<Long, Long, Long, Long, Long, BigDecimal, LocalDate, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>TRANSACTION.ID</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>TRANSACTION.ID</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>TRANSACTION.PAINTING_ID</code>.
     */
    public void setPaintingId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>TRANSACTION.PAINTING_ID</code>.
     */
    public Long getPaintingId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>TRANSACTION.CLIENT_ID</code>.
     */
    public void setClientId(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>TRANSACTION.CLIENT_ID</code>.
     */
    public Long getClientId() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>TRANSACTION.CURATOR_ID</code>.
     */
    public void setCuratorId(Long value) {
        set(3, value);
    }

    /**
     * Getter for <code>TRANSACTION.CURATOR_ID</code>.
     */
    public Long getCuratorId() {
        return (Long) get(3);
    }

    /**
     * Setter for <code>TRANSACTION.BANK_ACCOUNT_ID</code>.
     */
    public void setBankAccountId(Long value) {
        set(4, value);
    }

    /**
     * Getter for <code>TRANSACTION.BANK_ACCOUNT_ID</code>.
     */
    public Long getBankAccountId() {
        return (Long) get(4);
    }

    /**
     * Setter for <code>TRANSACTION.value</code>.
     */
    public void setValue(BigDecimal value) {
        set(5, value);
    }

    /**
     * Getter for <code>TRANSACTION.value</code>.
     */
    public BigDecimal getValue() {
        return (BigDecimal) get(5);
    }

    /**
     * Setter for <code>TRANSACTION.DATE</code>.
     */
    public void setDate(LocalDate value) {
        set(6, value);
    }

    /**
     * Getter for <code>TRANSACTION.DATE</code>.
     */
    public LocalDate getDate() {
        return (LocalDate) get(6);
    }

    /**
     * Setter for <code>TRANSACTION.TYPE</code>.
     */
    public void setType(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>TRANSACTION.TYPE</code>.
     */
    public String getType() {
        return (String) get(7);
    }

    /**
     * Setter for <code>TRANSACTION.VALUE_CURRENCY</code>.
     */
    public void setValueCurrency(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>TRANSACTION.VALUE_CURRENCY</code>.
     */
    public String getValueCurrency() {
        return (String) get(8);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row9<Long, Long, Long, Long, Long, BigDecimal, LocalDate, String, String> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    @Override
    public Row9<Long, Long, Long, Long, Long, BigDecimal, LocalDate, String, String> valuesRow() {
        return (Row9) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Transaction.TRANSACTION.ID;
    }

    @Override
    public Field<Long> field2() {
        return Transaction.TRANSACTION.PAINTING_ID;
    }

    @Override
    public Field<Long> field3() {
        return Transaction.TRANSACTION.CLIENT_ID;
    }

    @Override
    public Field<Long> field4() {
        return Transaction.TRANSACTION.CURATOR_ID;
    }

    @Override
    public Field<Long> field5() {
        return Transaction.TRANSACTION.BANK_ACCOUNT_ID;
    }

    @Override
    public Field<BigDecimal> field6() {
        return Transaction.TRANSACTION.VALUE;
    }

    @Override
    public Field<LocalDate> field7() {
        return Transaction.TRANSACTION.DATE;
    }

    @Override
    public Field<String> field8() {
        return Transaction.TRANSACTION.TYPE;
    }

    @Override
    public Field<String> field9() {
        return Transaction.TRANSACTION.VALUE_CURRENCY;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public Long component2() {
        return getPaintingId();
    }

    @Override
    public Long component3() {
        return getClientId();
    }

    @Override
    public Long component4() {
        return getCuratorId();
    }

    @Override
    public Long component5() {
        return getBankAccountId();
    }

    @Override
    public BigDecimal component6() {
        return getValue();
    }

    @Override
    public LocalDate component7() {
        return getDate();
    }

    @Override
    public String component8() {
        return getType();
    }

    @Override
    public String component9() {
        return getValueCurrency();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public Long value2() {
        return getPaintingId();
    }

    @Override
    public Long value3() {
        return getClientId();
    }

    @Override
    public Long value4() {
        return getCuratorId();
    }

    @Override
    public Long value5() {
        return getBankAccountId();
    }

    @Override
    public BigDecimal value6() {
        return getValue();
    }

    @Override
    public LocalDate value7() {
        return getDate();
    }

    @Override
    public String value8() {
        return getType();
    }

    @Override
    public String value9() {
        return getValueCurrency();
    }

    @Override
    public TransactionRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public TransactionRecord value2(Long value) {
        setPaintingId(value);
        return this;
    }

    @Override
    public TransactionRecord value3(Long value) {
        setClientId(value);
        return this;
    }

    @Override
    public TransactionRecord value4(Long value) {
        setCuratorId(value);
        return this;
    }

    @Override
    public TransactionRecord value5(Long value) {
        setBankAccountId(value);
        return this;
    }

    @Override
    public TransactionRecord value6(BigDecimal value) {
        setValue(value);
        return this;
    }

    @Override
    public TransactionRecord value7(LocalDate value) {
        setDate(value);
        return this;
    }

    @Override
    public TransactionRecord value8(String value) {
        setType(value);
        return this;
    }

    @Override
    public TransactionRecord value9(String value) {
        setValueCurrency(value);
        return this;
    }

    @Override
    public TransactionRecord values(Long value1, Long value2, Long value3, Long value4, Long value5, BigDecimal value6, LocalDate value7, String value8, String value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TransactionRecord
     */
    public TransactionRecord() {
        super(Transaction.TRANSACTION);
    }

    /**
     * Create a detached, initialised TransactionRecord
     */
    public TransactionRecord(Long id, Long paintingId, Long clientId, Long curatorId, Long bankAccountId, BigDecimal value, LocalDate date, String type, String valueCurrency) {
        super(Transaction.TRANSACTION);

        setId(id);
        setPaintingId(paintingId);
        setClientId(clientId);
        setCuratorId(curatorId);
        setBankAccountId(bankAccountId);
        setValue(value);
        setDate(date);
        setType(type);
        setValueCurrency(valueCurrency);
    }
}
