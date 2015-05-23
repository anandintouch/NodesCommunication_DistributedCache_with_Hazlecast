package com.test.hazelcastexample;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.test.hazelcastexample.domian.Node;

/**
 * This class is an example of a client application which connects to the distributed cache and check the status,if it already started,it will print following message.
 * "I'm not started,Master node 'Node1' with Node ID-'1' is already started.." 
 * 
 * @author anand prakash
 *
 */
public class HazelCastClient {
	private static final String STATUS = "We are started!";
	
	@SuppressWarnings({ "deprecation" })
	public static void main(String[] args) {
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.addAddress("127.0.0.1");
		HazelcastInstance client = HazelcastClient
				.newHazelcastClient(clientConfig);
		IMap<Object, Object> map = client.getMap("nodes");
		checkStatusAndPrint(map);

	}

	@SuppressWarnings("unchecked")
	private static void checkStatusAndPrint(@SuppressWarnings("rawtypes") Map map) {
		System.out.println("Map Size:" + map.size());
		Set<Entry<Object, Object>> nodes = map.entrySet();
		
		Entry<Object, Object> entry = null;
		for (Iterator<Entry<Object, Object>> iterator = nodes.iterator(); iterator
				.hasNext();) {
			entry = (Entry<Object, Object>) iterator.next();
			
			if(((Node)entry.getValue()).getStatus().equals(STATUS)) {
				System.out.println("I'm not started,Master node '"+((Node)entry.getValue()).getNodeName()+"' with Node ID-'"+entry.getKey()+"' is already started..");
				break;
			}else {
				map.put(1, new Node("Node1","We are started!")); 
			}
		
		}

	}
}
