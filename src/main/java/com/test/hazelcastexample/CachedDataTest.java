package com.test.hazelcastexample;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.test.hazelcastexample.domian.Node;

public class CachedDataTest {

	@SuppressWarnings({ "deprecation" })
	public static void main(String[] args) {
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.addAddress("127.0.0.1");
		HazelcastInstance client = HazelcastClient
				.newHazelcastClient(clientConfig);
		IMap<Object, Object> map = client.getMap("nodes");
		printMap(map);

	}

	@SuppressWarnings("unchecked")
	private static void printMap(@SuppressWarnings("rawtypes") Map map) {
		System.out.println("Map Size:" + map.size());
		Set<Entry<Object, Object>> customers = map.entrySet();
		for (Iterator<Entry<Object, Object>> iterator = customers.iterator(); iterator
				.hasNext();) {
			Entry<Object, Object> entry = (Entry<Object, Object>) iterator
					.next();
			System.out.println("Node Id : " + entry.getKey()
					+ "\nNode Name : " + ((Node)entry.getValue()).getNodeName()+"\nNode status:"+ ((Node)entry.getValue()).getStatus());
		}
	}

}
