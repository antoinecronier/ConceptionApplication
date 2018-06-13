package com.tactfactory.appconception.client;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	private static Socket connexion = null;
	private static PrintWriter writer = null;
	private static BufferedInputStream reader = null;

	public static void main(String[] args) throws InterruptedException {
		try {
			connexion = new Socket(InetAddress.getByName("localhost"), 2345);
			writer = new PrintWriter(connexion.getOutputStream(), true);
			reader = new BufferedInputStream(connexion.getInputStream());

			writer.write("user/command1");
			writer.flush();

			while (!connexion.isClosed()) {
				String response = read();
				System.out.println("Réponse reçue :" + response);

				writer.write("game/1");
				writer.flush();
				
				Thread.sleep(1000);
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Méthode pour lire les réponses du serveur
	private static String read() throws IOException {
		String response = "";
		int stream;
		byte[] b = new byte[4096];
		stream = reader.read(b);
		if (stream != -1) {
			response = new String(b, 0, stream);
		}

		return response;
	}
}
