package com.atm;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Bank server, which will deal with database
 * @author Oleh Kurpiak
 *
 */
public class BankServer {
		public static void startServer(int port) throws IOException{
			ServerSocket s = new ServerSocket(Integer.valueOf(port));
			BankService.createDatastore();
			try{
				while (true){
					Socket socket = s.accept();
					try{
						new ServeOneClient(socket);
					}catch (IOException e){
						socket.close();
					}
				}
			}finally{
				s.close();
			}
		}

	}

