package com.acme.rbac.jdbi;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.acme.rbac.api.User;

public class UserMapper implements ResultSetMapper<User> {
    @Override
    public final User map(final int index, final ResultSet r,
            final StatementContext ctx) throws SQLException {
        return new User(r.getString("username"), r.getString("first_name"),
                r.getString("family_name"), r.getString("email"));
    }
}