package org.learn.config;


import org.hibernate.dialect.MySQL5Dialect;

public class MysqlDBSetting extends MySQL5Dialect {
    @Override
    public String getTableTypeString() {
        return "ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci";
    }
}
