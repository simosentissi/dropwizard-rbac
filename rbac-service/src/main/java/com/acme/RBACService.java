/**
 * 
 */
package com.acme;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

/**
 * The Class RBACService.
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
	public static void main(String[] args) throws Exception {
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
	public void initialize(Bootstrap<RBACConfiguration> bootstrap) {
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
	public void run(RBACConfiguration configuration, Environment environment)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
