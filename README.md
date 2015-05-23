

**Inter JVM/Processes communication between Servers**
-----------------------------------------------------

This application need to coordinate among the nodes and make sure that one and only one of them does a System.out.println("We are started!")
Different process of this application on different nodes/machines will check the message status from the
distributed shared cache and accordingly print the message to the console. 
Distributed caches, although deployed on a cluster of multiple nodes, offer a single logical view (and state) of the cache. By means of a hashing algorithm, the cache engine can always determine on which node a particular key-value resides.

**Files details:**
 1. HazelCastServer:  This class start the server and update the status with "We are started!" in the
     distributed shared cache.
 2. HazelCastClient: This class is an example of a client application which connects to the distributed cache
    and check the status,if it already started,it will print following message.
    "I'm not started,Master node 'Node1' with Node ID-'1' is already started.."

***To run this tool:***

The source code can be imported into your IDE or local folder using git clone command and build the maven module using Maven command as below

> mvn clean install

=> Then run "HazelCastServer" first then start "HazelCastClient"