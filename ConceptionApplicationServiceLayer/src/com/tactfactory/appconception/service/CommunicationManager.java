package com.tactfactory.appconception.service;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class CommunicationManager {

	private Socket connexion = null;
	private PrintWriter writer = null;
	private BufferedInputStream reader = null;

	public CommunicationManager(String host, int port) {
		try {
			connexion = new Socket(InetAddress.getByName(host), port);
			writer = new PrintWriter(connexion.getOutputStream(), true);
			reader = new BufferedInputStream(connexion.getInputStream());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public CommunicationManager(Socket socket){
		try {
			connexion = socket;
			writer = new PrintWriter(connexion.getOutputStream(), true);
			reader = new BufferedInputStream(connexion.getInputStream());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendData(String data){
		writer.write(data);
		writer.flush();
	}
	
	public String listenStringResponse() throws IOException{
		return new SocketReader(reader).readToString();
	}
	
	public Object listenObjectResponse() throws IOException{
		return new SocketReader(reader).readToObject();
	}
}
