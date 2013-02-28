dropwizard-rbac
===============

Roles Based Access Control for Dropwizard

overview
========

The NIST RBAC model is a standardized definition of role based access control. Although originally developed by the National Institute of Standards and Technology, the standard was adopted and is copyrighted and distributed as INCITS 359-2004 by the International Committee for Information Technology Standards (INCITS). It is managed by INCITS committee CS1.

The NIST RBAC Model uses a limited set of concepts to define an RBAC system. The system has (1) users, users have (2) sessions and sessions and users have (3) roles assigned to them. Each role consist of (4) permissions and permissions are based on (5) objects and (6) operations.


Dropwizard is a Java framework for developing ops-friendly, high-performance, RESTful web services.

dropwizard-rbac is a implementation of NIST RBAC model using Dropwizard.


installation and use
========

To start a project:

    $ git clone git://github.com/alrighttheresham/dropwizard-rbac.git 

go into your project directory and run 

    $ mvn package     

Before running the jar ensure that you have a working mysql installation (note any sql db could be used but it would require update to the liquidbase and yml file.  The location of the mysql db (connection string) is defined in  rbac-service/src/main/resources/example.yml 

Now that you’ve built a JAR file, it’s time to run it.

In your project directory, run this:

    $ java -jar rbac-service/target/rbac-service-0.0.1-SNAPSHOT.jar server rbac-service/src/main/resources/example.yml


You should see something like 

        INFO  [2013-02-28 12:55:50,407] com.yammer.dropwizard.cli.ServerCommand: Starting Roles Based Access Control

	 _____       _             ____                     _                                    _____            _             _ 
	|  __ \     | |           |  _ \                   | |     /\                           / ____|          | |           | |
	| |__) |___ | | ___  ___  | |_) | __ _ ___  ___  __| |    /  \   ___ ___ ___  ___ ___  | |     ___  _ __ | |_ _ __ ___ | |
	|  _  // _ \| |/ _ \/ __| |  _ < / _` / __|/ _ \/ _` |   / /\ \ / __/ __/ _ \/ __/ __| | |    / _ \| '_ \| __| '__/ _ \| |
	| | \ \ (_) | |  __/\__ \ | |_) | (_| \__ \  __/ (_| |  / ____ \ (_| (_|  __/\__ \__ \ | |___| (_) | | | | |_| | | (_) | |
	|_|  \_\___/|_|\___||___/ |____/ \__,_|___/\___|\__,_| /_/    \_\___\___\___||___/___/  \_____\___/|_| |_|\__|_|  \___/|_|




       INFO  [2013-02-28 12:55:50,409] org.eclipse.jetty.server.Server: jetty-8.y.z-SNAPSHOT
       INFO  [2013-02-28 12:55:50,536] com.sun.jersey.server.impl.application.WebApplicationImpl: Initiating Jersey application, version 'Jersey: 1.15 10/30/2012 02:40 PM'
       INFO  [2013-02-28 12:55:50,597] com.yammer.dropwizard.config.Environment: 

	   GET     /users (com.acme.rbac.resources.UsersResource)
	   GET     /users/{userId} (com.acme.rbac.resources.UsersResource)

       INFO  [2013-02-28 12:55:50,597] com.yammer.dropwizard.config.Environment: tasks = 

	   POST    /tasks/gc (com.yammer.dropwizard.tasks.GarbageCollectionTask)

       INFO  [2013-02-28 12:55:50,808] org.eclipse.jetty.server.AbstractConnector: Started InstrumentedBlockingChannelConnector@0.0.0.0:8080
       INFO  [2013-02-28 12:55:50,811] org.eclipse.jetty.server.AbstractConnector: Started SocketConnector@0.0.0.0:8081

credits
=======

        http://en.wikipedia.org/wiki/NIST_RBAC_model
        http://www.mind-it.info
        http://dropwizard.codahale.com/


license 
========

MIT License

Copyright (c) 2012 Damian ONeill

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.