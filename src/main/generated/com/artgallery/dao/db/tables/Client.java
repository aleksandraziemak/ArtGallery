/*
 * This file is generated by jOOQ.
 */
package com.artgallery.dao.db.tables;


import com.artgallery.dao.db.DefaultSchema;
import com.artgallery.dao.db.Keys;
import com.artgallery.dao.db.tables.records.ClientRecord;

import java.util.function.Function;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function3;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row3;
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
public class Client extends TableImpl<ClientRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>CLIENT</code>
     */
    public static final Client CLIENT = new Client();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ClientRecord> getRecordType() {
        return ClientRecord.class;
    }

    /**
     * The column <code>CLIENT.ID</code>.
     */
    public final TableField<ClientRecord, Long> ID = createField(DSL.name("ID"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>CLIENT.FIRST_NAME</code>.
     */
    public final TableField<ClientRecord, String> FIRST_NAME = createField(DSL.name("FIRST_NAME"), SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>CLIENT.LAST_NAME</code>.
     */
    public final TableField<ClientRecord, String> LAST_NAME = createField(DSL.name("LAST_NAME"), SQLDataType.CLOB.nullable(false), this, "");

    private Client(Name alias, Table<ClientRecord> aliased) {
        this(alias, aliased, null);
    }

    private Client(Name alias, Table<ClientRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>CLIENT</code> table reference
     */
    public Client(String alias) {
        this(DSL.name(alias), CLIENT);
    }

    /**
     * Create an aliased <code>CLIENT</code> table reference
     */
    public Client(Name alias) {
        this(alias, CLIENT);
    }

    /**
     * Create a <code>CLIENT</code> table reference
     */
    public Client() {
        this(DSL.name("CLIENT"), null);
    }

    public <O extends Record> Client(Table<O> child, ForeignKey<O, ClientRecord> key) {
        super(child, key, CLIENT);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public Identity<ClientRecord, Long> getIdentity() {
        return (Identity<ClientRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<ClientRecord> getPrimaryKey() {
        return Keys.PK_CLIENT;
    }

    @Override
    public Client as(String alias) {
        return new Client(DSL.name(alias), this);
    }

    @Override
    public Client as(Name alias) {
        return new Client(alias, this);
    }

    @Override
    public Client as(Table<?> alias) {
        return new Client(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Client rename(String name) {
        return new Client(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Client rename(Name name) {
        return new Client(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Client rename(Table<?> name) {
        return new Client(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Long, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function3<? super Long, ? super String, ? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function3<? super Long, ? super String, ? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
