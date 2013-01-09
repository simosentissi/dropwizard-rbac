package com.acme.rbac;

import org.skife.jdbi.v2.DBI;

import com.acme.rbac.auth.SQLAuthenticator;
import com.acme.rbac.core.User;
import com.acme.rbac.jdbi.UsersDAO;
import com.acme.rbac.resources.UsersResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.auth.basic.BasicAuthProvider;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.db.DatabaseConfiguration;
import com.yammer.dropwizard.jdbi.DBIFactory;
import com.yammer.dropwizard.jdbi.bundles.DBIExceptionsBundle;
import com.yammer.dropwizard.migrations.MigrationsBundle;

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
        // handler for jdbi runtime exceptions with the db
        bootstrap.addBundle(new DBIExceptionsBundle());
        // liquidbase support, reads a file called migrations.xml from
        // src/main/resources
        bootstrap.addBundle(new MigrationsBundle<RBACConfiguration>() {
            @Override
            public DatabaseConfiguration getDatabaseConfiguration(
                    RBACConfiguration configuration) {
                return configuration.getDatabaseConfiguration();
            }
        });

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

        environment.addProvider(new BasicAuthProvider<User>(
                new SQLAuthenticator(usersDao), "SUPER SECRET STUFF"));

        environment.addResource(new UsersResource(usersDao));
    }

}
