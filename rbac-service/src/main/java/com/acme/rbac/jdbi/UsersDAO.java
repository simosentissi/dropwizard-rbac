package com.acme.rbac.jdbi;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import com.acme.rbac.api.User;
import com.google.common.collect.ImmutableList;

@RegisterMapper(UserMapper.class)
public interface UsersDAO {

    String ID = "id";
    String UNAME = "uname";

    @SqlQuery("select user_id, username, first_name, family_name, email from users where user_id = :id")
    User findUserameById(@Bind(ID) int id);

    @SqlQuery("select user_id, username, first_name, family_name, email from users ORDER BY family_name ASC")
    ImmutableList<User> findAllUsers();

    @SqlQuery("select password from users where username = :uname")
    String authenticateUser(@Bind(UNAME) String uname);
}
