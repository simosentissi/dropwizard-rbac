package com.acme.rbac.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.acme.rbac.api.User;
import com.acme.rbac.jdbi.UsersDAO;
import com.google.common.collect.ImmutableList;
import com.yammer.dropwizard.jersey.params.IntParam;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsersResource {

    private final UsersDAO usersDao;

    public UsersResource(UsersDAO aUsersDao) {
        this.usersDao = aUsersDao;
    }

    @GET
    public ImmutableList<User> fetch() {
        return usersDao.findAllUsers();
    }

    @GET
    @Path("/{userId}")
    public User fetch(@PathParam("userId") IntParam userId) {
        return usersDao.findUserameById(userId.get());
    }
}
