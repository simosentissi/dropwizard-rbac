package com.acme;

import org.skife.jdbi.v2.DBI;

import com.acme.jdbi.UsersDAO;
import com.acme.resources.UsersResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.jdbi.DBIFactory;

/**
 * The main entry point into a RBAC Dropwizard based service.
 */
public class RBACService extends Service<RBACConfiguration> {

    /**
     * The main method.
     * 
     * @param args
     *            the arguments
     * @throws Exception
     *             the exception
     */
    public static void main(final String[] args) throws Exception {
        new RBACService().run(args);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.yammer.dropwizard.Service#initialize(com.yammer.dropwizard.config
     * .Bootstrap)
     */
    @Override
    public final void initialize(final Bootstrap<RBACConfiguration> bootstrap) {
        bootstrap.setName("Roles Based Access Control");
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.yammer.dropwizard.Service#run(com.yammer.dropwizard.config.Configuration
     * , com.yammer.dropwizard.config.Environment)
     */
    @Override
    public final void run(final RBACConfiguration configuration,
            final Environment environment) throws Exception {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment,
                configuration.getDatabaseConfiguration(), "mysql");
        final UsersDAO usersDao = jdbi.onDemand(UsersDAO.class);
        environment.addResource(new UsersResource(usersDao));

    }

}
