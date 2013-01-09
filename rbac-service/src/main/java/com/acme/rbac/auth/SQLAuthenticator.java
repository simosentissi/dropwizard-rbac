package com.acme.rbac.auth;

import com.acme.rbac.core.User;
import com.acme.rbac.jdbi.UsersDAO;
import com.google.common.base.Optional;
import com.yammer.dropwizard.auth.AuthenticationException;
import com.yammer.dropwizard.auth.Authenticator;
import com.yammer.dropwizard.auth.basic.BasicCredentials;

public class SQLAuthenticator implements Authenticator<BasicCredentials, User> {
    private final UsersDAO usersDao;

    public SQLAuthenticator(UsersDAO aUsersDao) {
        this.usersDao = aUsersDao;
    }

    @Override
    public Optional<User> authenticate(BasicCredentials credentials)
            throws AuthenticationException {
        String password = usersDao.authenticateUser(credentials.getUsername());
        if (password != null && password.equals(credentials.getPassword())) {
            return Optional.of(new User(credentials.getUsername()));
        }
        return Optional.absent();
    }
}