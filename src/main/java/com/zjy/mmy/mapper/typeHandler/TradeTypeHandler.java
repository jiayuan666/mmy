package com.zjy.mmy.mapper.typeHandler;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class TradeTypeHandler extends BaseTypeHandler<List<String>> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i
            , List<String> strings, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, StringUtils.join(strings, ","));
    }

    @Override
    public List<String> getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return Arrays.asList(resultSet.getString(s).split(","));
    }

    @Override
    public List<String> getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return Arrays.asList(resultSet.getString(i).split(","));
    }

    @Override
    public List<String> getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return Arrays.asList(callableStatement.getString(i).split(","));
    }
}
