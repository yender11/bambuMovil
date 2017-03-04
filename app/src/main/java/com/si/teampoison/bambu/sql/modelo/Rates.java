package com.si.teampoison.bambu.sql.modelo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by yender on 03/03/17.
 */


@DatabaseTable(tableName = "tb_rate")
public class Rates {

    @DatabaseField(id = true)
    String code;
    @DatabaseField
    String name;
    @DatabaseField
    Double rate;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
