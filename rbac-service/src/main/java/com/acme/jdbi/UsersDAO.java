package com.acme.jdbi;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;

public interface UsersDAO {

    @SqlQuery("select username from users where user_id = :id")
    String findUserameById(@Bind("id") int id);

}
