package com.acme.rbac;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;
import com.yammer.dropwizard.db.DatabaseConfiguration;

/**
 * The Class RBACConfiguration.
 */
public class RBACConfiguration extends Configuration {

    /** The database configuration. */
    @Valid
    @NotNull
    @JsonProperty("database")
    private DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration();

    /**
     * Gets the database configuration.
     * 
     * @return the database configuration
     */
    public final DatabaseConfiguration getDatabaseConfiguration() {
        return databaseConfiguration;
    }

    /**
     * Sets the database configuration.
     * 
     * @param aDatabaseConfiguration
     *            the new database configuration
     */
    public final void setDatabaseConfiguration(
            final DatabaseConfiguration aDatabaseConfiguration) {
        this.databaseConfiguration = aDatabaseConfiguration;
    }

}
