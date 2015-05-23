package com.test.hazelcastexample;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.test.hazelcastexample.domian.Node;

/**
 * This class start the server and update the status with "We are started!" in 
 * the distributed shared cache.
 * 
 * @author anand prakash
 *
 */
public class HazelCastServer {

	public static void main(String[] args) {
		HazelCastServer  server = new HazelCastServer();
		server.startServer();
	}
	
	private void startServer(){
		Config cfg = new Config();
		HazelcastInstance instance = Hazelcast.newHazelcastInstance(cfg);
		
		IMap<Object, Object> nodesMap = instance.getMap("nodes");
		
		if(nodesMap.size() == 0)
			nodesMap.put(1, new Node("Node1","We are started!"));

		System.out.println("Map Size:" + nodesMap.size());
		Set<Entry<Object, Object>> nodes = nodesMap.entrySet();

		for (Iterator<Entry<Object, Object>> iterator = nodes.iterator(); iterator
				.hasNext();) {
			Entry<Object, Object> entry = (Entry<Object, Object>) iterator
					.next();
			String nodeName = ((Node) entry.getValue()).getNodeName();
			
			System.out.println("Node status:"+ ((Node) entry.getValue()).getStatus());
			System.out.println("Node Id:" + entry.getKey()+ "\nNode name: " + nodeName );
			
		}
		
	}
}
