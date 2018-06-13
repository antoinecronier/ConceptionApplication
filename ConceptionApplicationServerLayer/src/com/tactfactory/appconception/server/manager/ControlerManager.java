package com.tactfactory.appconception.server.manager;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.text.DateFormat;
import java.util.Date;

import com.tactfactory.appconception.server.controler.UserControler;

public class ControlerManager implements Runnable {
	private Socket sock;
	private PrintWriter writer = null;
	private BufferedInputStream reader = null;
	boolean closeConnexion = false;

	public ControlerManager(Socket pSock) {
		sock = pSock;
	}

	// Le traitement lancé dans un thread séparé
	public void run() {
		System.err.println("Lancement du traitement de la connexion cliente");

		// tant que la connexion est active, on traite les demandes
		while (!sock.isClosed()) {

			try {

				// Ici, nous n'utilisons pas les mêmes objets que précédemment
				// Je vous expliquerai pourquoi ensuite
				writer = new PrintWriter(sock.getOutputStream());
				reader = new BufferedInputStream(sock.getInputStream());

				// On attend la demande du client
				String response = read();
				
				if (closeConnexion) {
					System.err.println("COMMANDE CLOSE DETECTEE ! ");
					writer = null;
					reader = null;
					sock.close();
					break;
				}
				
				InetSocketAddress remote = (InetSocketAddress) sock.getRemoteSocketAddress();

				// On affiche quelques infos, pour le débuggage
				String debug = "";
				debug = "Thread : " + Thread.currentThread().getName() + ". ";
				debug += "Demande de l'adresse : " + remote.getAddress().getHostAddress() + ".";
				debug += " Sur le port : " + remote.getPort() + ".\n";
				debug += "\t -> Commande reçue : " + response + "\n";
				System.err.println("\n" + debug);

				// On traite la demande du client en fonction de la commande
				// envoyée
				String toSend = "";

				switch (response.split("/")[0]) {
				case "user":
					toSend = new UserControler().Action(response.split("/")[1]);
					break;
				default:
					toSend = "Commande inconnu !";
					break;
				}

				// On envoie la réponse au client
				writer.write(toSend);
				// Il FAUT IMPERATIVEMENT UTILISER flush()
				// Sinon les données ne seront pas transmises au client
				// et il attendra indéfiniment
				writer.flush();
			} catch (SocketException e) {
				System.err.println("LA CONNEXION A ETE INTERROMPUE ! ");
				break;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// La méthode que nous utilisons pour lire les réponses
	private String read() throws IOException {
		String response = "";
		int stream;
		byte[] b = new byte[4096];
		stream = reader.read(b);
		if (stream != -1) {
			response = new String(b, 0, stream);
		}else{
			closeConnexion = true;
		}
		return response;
	}

}
