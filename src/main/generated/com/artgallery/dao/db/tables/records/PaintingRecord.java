/*
 * This file is generated by jOOQ.
 */
package com.artgallery.dao.db.tables.records;


import com.artgallery.dao.db.tables.Painting;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
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
public class PaintingRecord extends UpdatableRecordImpl<PaintingRecord> implements Record5<Long, String, Long, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>PAINTING.ID</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>PAINTING.ID</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>PAINTING.TITLE</code>.
     */
    public void setTitle(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>PAINTING.TITLE</code>.
     */
    public String getTitle() {
        return (String) get(1);
    }

    /**
     * Setter for <code>PAINTING.year</code>.
     */
    public void setYear(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>PAINTING.year</code>.
     */
    public Long getYear() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>PAINTING.MOVEMENT</code>.
     */
    public void setMovement(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>PAINTING.MOVEMENT</code>.
     */
    public String getMovement() {
        return (String) get(3);
    }

    /**
     * Setter for <code>PAINTING.STATUS</code>.
     */
    public void setStatus(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>PAINTING.STATUS</code>.
     */
    public String getStatus() {
        return (String) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<Long, String, Long, String, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Long, String, Long, String, String> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Painting.PAINTING.ID;
    }

    @Override
    public Field<String> field2() {
        return Painting.PAINTING.TITLE;
    }

    @Override
    public Field<Long> field3() {
        return Painting.PAINTING.YEAR;
    }

    @Override
    public Field<String> field4() {
        return Painting.PAINTING.MOVEMENT;
    }

    @Override
    public Field<String> field5() {
        return Painting.PAINTING.STATUS;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getTitle();
    }

    @Override
    public Long component3() {
        return getYear();
    }

    @Override
    public String component4() {
        return getMovement();
    }

    @Override
    public String component5() {
        return getStatus();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getTitle();
    }

    @Override
    public Long value3() {
        return getYear();
    }

    @Override
    public String value4() {
        return getMovement();
    }

    @Override
    public String value5() {
        return getStatus();
    }

    @Override
    public PaintingRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public PaintingRecord value2(String value) {
        setTitle(value);
        return this;
    }

    @Override
    public PaintingRecord value3(Long value) {
        setYear(value);
        return this;
    }

    @Override
    public PaintingRecord value4(String value) {
        setMovement(value);
        return this;
    }

    @Override
    public PaintingRecord value5(String value) {
        setStatus(value);
        return this;
    }

    @Override
    public PaintingRecord values(Long value1, String value2, Long value3, String value4, String value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PaintingRecord
     */
    public PaintingRecord() {
        super(Painting.PAINTING);
    }

    /**
     * Create a detached, initialised PaintingRecord
     */
    public PaintingRecord(Long id, String title, Long year, String movement, String status) {
        super(Painting.PAINTING);

        setId(id);
        setTitle(title);
        setYear(year);
        setMovement(movement);
        setStatus(status);
    }
}
