/*
 * This file is generated by jOOQ.
 */
package ge.tsu.weather.classes.tables;


import ge.tsu.weather.classes.Keys;
import ge.tsu.weather.classes.Public;
import ge.tsu.weather.classes.tables.records.WeatherRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row6;
import org.jooq.Schema;
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
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Weather extends TableImpl<WeatherRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.weather</code>
     */
    public static final Weather WEATHER = new Weather();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<WeatherRecord> getRecordType() {
        return WeatherRecord.class;
    }

    /**
     * The column <code>public.weather.id</code>.
     */
    public final TableField<WeatherRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.weather.city</code>.
     */
    public final TableField<WeatherRecord, String> CITY = createField(DSL.name("city"), SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.weather.region</code>.
     */
    public final TableField<WeatherRecord, String> REGION = createField(DSL.name("region"), SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.weather.temp</code>.
     */
    public final TableField<WeatherRecord, String> TEMP = createField(DSL.name("temp"), SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.weather.humidity</code>.
     */
    public final TableField<WeatherRecord, String> HUMIDITY = createField(DSL.name("humidity"), SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.weather.wind</code>.
     */
    public final TableField<WeatherRecord, String> WIND = createField(DSL.name("wind"), SQLDataType.VARCHAR, this, "");

    private Weather(Name alias, Table<WeatherRecord> aliased) {
        this(alias, aliased, null);
    }

    private Weather(Name alias, Table<WeatherRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.weather</code> table reference
     */
    public Weather(String alias) {
        this(DSL.name(alias), WEATHER);
    }

    /**
     * Create an aliased <code>public.weather</code> table reference
     */
    public Weather(Name alias) {
        this(alias, WEATHER);
    }

    /**
     * Create a <code>public.weather</code> table reference
     */
    public Weather() {
        this(DSL.name("weather"), null);
    }

    public <O extends Record> Weather(Table<O> child, ForeignKey<O, WeatherRecord> key) {
        super(child, key, WEATHER);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public Identity<WeatherRecord, Integer> getIdentity() {
        return (Identity<WeatherRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<WeatherRecord> getPrimaryKey() {
        return Keys.STATUS_PK;
    }

    @Override
    public List<UniqueKey<WeatherRecord>> getKeys() {
        return Arrays.<UniqueKey<WeatherRecord>>asList(Keys.STATUS_PK);
    }

    @Override
    public Weather as(String alias) {
        return new Weather(DSL.name(alias), this);
    }

    @Override
    public Weather as(Name alias) {
        return new Weather(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Weather rename(String name) {
        return new Weather(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Weather rename(Name name) {
        return new Weather(name, null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<Integer, String, String, String, String, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }
}
