package com.test.hazelcastexample.domian;

import java.io.Serializable;

public class Node implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1370355392731490984L;

	private String nodeName;
	private String status;

	public Node() {

	}

	public Node(String name,String status) {
		this.setNodeName(name);
		this.setStatus(status);
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

}
