package com.acme.jdbi;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import com.acme.rbac.api.User;

@RegisterMapper(UserMapper.class)
public interface UsersDAO {

    @SqlQuery("select username, first_name, family_name, email from users where user_id = :id")
    User findUserameById(@Bind("id") int id);

    @SqlQuery("select username, first_name, family_name, email from users")
    List<User> findAllUsers();

}
