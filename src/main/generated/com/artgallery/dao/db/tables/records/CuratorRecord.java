/*
 * This file is generated by jOOQ.
 */
package com.artgallery.dao.db.tables.records;


import com.artgallery.dao.db.tables.Curator;

import java.math.BigDecimal;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
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
public class CuratorRecord extends UpdatableRecordImpl<CuratorRecord> implements Record4<Long, String, String, BigDecimal> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>CURATOR.ID</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>CURATOR.ID</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>CURATOR.FIRST_NAME</code>.
     */
    public void setFirstName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>CURATOR.FIRST_NAME</code>.
     */
    public String getFirstName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>CURATOR.LAST_NAME</code>.
     */
    public void setLastName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>CURATOR.LAST_NAME</code>.
     */
    public String getLastName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>CURATOR.SALARY</code>.
     */
    public void setSalary(BigDecimal value) {
        set(3, value);
    }

    /**
     * Getter for <code>CURATOR.SALARY</code>.
     */
    public BigDecimal getSalary() {
        return (BigDecimal) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<Long, String, String, BigDecimal> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Long, String, String, BigDecimal> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Curator.CURATOR.ID;
    }

    @Override
    public Field<String> field2() {
        return Curator.CURATOR.FIRST_NAME;
    }

    @Override
    public Field<String> field3() {
        return Curator.CURATOR.LAST_NAME;
    }

    @Override
    public Field<BigDecimal> field4() {
        return Curator.CURATOR.SALARY;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getFirstName();
    }

    @Override
    public String component3() {
        return getLastName();
    }

    @Override
    public BigDecimal component4() {
        return getSalary();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getFirstName();
    }

    @Override
    public String value3() {
        return getLastName();
    }

    @Override
    public BigDecimal value4() {
        return getSalary();
    }

    @Override
    public CuratorRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public CuratorRecord value2(String value) {
        setFirstName(value);
        return this;
    }

    @Override
    public CuratorRecord value3(String value) {
        setLastName(value);
        return this;
    }

    @Override
    public CuratorRecord value4(BigDecimal value) {
        setSalary(value);
        return this;
    }

    @Override
    public CuratorRecord values(Long value1, String value2, String value3, BigDecimal value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CuratorRecord
     */
    public CuratorRecord() {
        super(Curator.CURATOR);
    }

    /**
     * Create a detached, initialised CuratorRecord
     */
    public CuratorRecord(Long id, String firstName, String lastName, BigDecimal salary) {
        super(Curator.CURATOR);

        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setSalary(salary);
    }
}
