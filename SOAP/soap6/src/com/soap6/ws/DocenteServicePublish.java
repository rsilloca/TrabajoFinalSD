package com.soap6.ws;

import javax.xml.ws.Endpoint;



public class DocenteServicePublish {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Endpoint.publish("http://localhost:1515/WS/DOCENTE", new ServiceDocenteImpl());
	}

}
