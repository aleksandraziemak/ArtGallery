/*
 * This file is generated by jOOQ.
 */
package com.artgallery.dao.db.tables;


import com.artgallery.dao.db.DefaultSchema;
import com.artgallery.dao.db.Keys;
import com.artgallery.dao.db.tables.records.AuthorRecord;

import java.util.function.Function;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function5;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row5;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


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
public class Author extends TableImpl<AuthorRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>AUTHOR</code>
     */
    public static final Author AUTHOR = new Author();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AuthorRecord> getRecordType() {
        return AuthorRecord.class;
    }

    /**
     * The column <code>AUTHOR.ID</code>.
     */
    public final TableField<AuthorRecord, Long> ID = createField(DSL.name("ID"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>AUTHOR.FIRST_NAME</code>.
     */
    public final TableField<AuthorRecord, String> FIRST_NAME = createField(DSL.name("FIRST_NAME"), SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>AUTHOR.SECOND_NAME</code>.
     */
    public final TableField<AuthorRecord, String> SECOND_NAME = createField(DSL.name("SECOND_NAME"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>AUTHOR.LAST_NAME</code>.
     */
    public final TableField<AuthorRecord, String> LAST_NAME = createField(DSL.name("LAST_NAME"), SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>AUTHOR.COUNTRY</code>.
     */
    public final TableField<AuthorRecord, String> COUNTRY = createField(DSL.name("COUNTRY"), SQLDataType.CLOB.nullable(false), this, "");

    private Author(Name alias, Table<AuthorRecord> aliased) {
        this(alias, aliased, null);
    }

    private Author(Name alias, Table<AuthorRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>AUTHOR</code> table reference
     */
    public Author(String alias) {
        this(DSL.name(alias), AUTHOR);
    }

    /**
     * Create an aliased <code>AUTHOR</code> table reference
     */
    public Author(Name alias) {
        this(alias, AUTHOR);
    }

    /**
     * Create a <code>AUTHOR</code> table reference
     */
    public Author() {
        this(DSL.name("AUTHOR"), null);
    }

    public <O extends Record> Author(Table<O> child, ForeignKey<O, AuthorRecord> key) {
        super(child, key, AUTHOR);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public Identity<AuthorRecord, Long> getIdentity() {
        return (Identity<AuthorRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<AuthorRecord> getPrimaryKey() {
        return Keys.PK_AUTHOR;
    }

    @Override
    public Author as(String alias) {
        return new Author(DSL.name(alias), this);
    }

    @Override
    public Author as(Name alias) {
        return new Author(alias, this);
    }

    @Override
    public Author as(Table<?> alias) {
        return new Author(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Author rename(String name) {
        return new Author(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Author rename(Name name) {
        return new Author(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Author rename(Table<?> name) {
        return new Author(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Long, String, String, String, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function5<? super Long, ? super String, ? super String, ? super String, ? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function5<? super Long, ? super String, ? super String, ? super String, ? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
