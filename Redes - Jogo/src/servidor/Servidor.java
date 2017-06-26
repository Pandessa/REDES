package servidor;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Servidor {

	
	public void conectar() throws UnknownHostException, IOException
	{
		 ServerSocket servidor = new ServerSocket(3000);
	     System.out.println("Porta 3000 aberta!");
	     boolean a = true;
	   
	     while(a)
	     {
	    	 Socket cliente = servidor.accept();
	    	 Thread thread  = new Tratamento(cliente);
	    	 thread.start();
	     }
	     
	     servidor.close();
	}
	

}
