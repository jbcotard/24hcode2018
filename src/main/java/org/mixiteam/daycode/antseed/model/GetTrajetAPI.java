package org.mixiteam.daycode.antseed.model;

import io.vertx.core.http.HttpClient;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;

import java.io.*;
import java.net.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.mixiteam.daycode.antseed.Position;

public class GetTrajetAPI {

	/**
	 * recuperation trajet le plus rapide
	 *
	 * @param token
	 * @return
	 * @throws IOException
	 */
	public static String getTrajetLePlusCourt(Position depart, Position arrivee) throws IOException {

		String position = depart.getLon() + "," + depart.getLon() + ";" + arrivee.getLon() + "," + arrivee.getLat();
		position="0.2416894,47.9843764;0.2475570,47.9878235";
	    
		URL urlClient = new URL("http://router.project-osrm.org/route/v1/driving/" + position
				+ "?overview=full&steps=true&annotations=nodes");

		HttpURLConnection conn = (HttpURLConnection) urlClient.openConnection();
		conn.setRequestMethod("GET");
		conn.setDoOutput(true);

		System.out.println("response : " + conn.getResponseCode());

		Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

		StringBuilder tokenBuilder = new StringBuilder();
		for (int c; (c = in.read()) >= 0;)
			tokenBuilder.append((char) c);

		return tokenBuilder.toString();
	}

}
