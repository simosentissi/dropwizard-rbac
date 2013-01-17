package com.acme.rbac.jdbi;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.acme.rbac.api.User;

public class UserMapper implements ResultSetMapper<User> {

    public static final String USERNAME = "username";
    public static final String FIRST_NAME = "first_name";
    public static final String FAMILY_NAME = "family_name";
    public static final String EMAIL = "email";
    public static final String USER_ID = "user_id";

    @Override
    public final User map(final int index, final ResultSet r,
            final StatementContext ctx) throws SQLException {
        User user = new User(r.getString(USERNAME),
                r.getString(FIRST_NAME), r.getString(FAMILY_NAME),
                r.getString(EMAIL));
        user.setId(r.getInt(USER_ID));
        return user;
    }
}