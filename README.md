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

Now that you’ve built a JAR file, it’s time to run it.

In your project directory, run this:

    $ java -jar target/xxx-0.0.1-SNAPSHOT.jar


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