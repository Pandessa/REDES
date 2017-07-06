package jogo;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Servidor {

	public static void main(String[] args) throws UnknownHostException, IOException
	{
		 ServerSocket servidor = new ServerSocket(3000);
	     System.out.println("Porta 3000 aberta!");
	     boolean a = true;
	   
	     while(a)
	     {
	    	 Socket cliente = servidor.accept();
	    	 Thread thread  = new Thread(new Tratador(cliente));
	    	 thread.start();
	     }
	     
	     servidor.close();
	}
	

}
