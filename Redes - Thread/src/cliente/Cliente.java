package cliente;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Cliente {


		public static void main(String[] args) throws UnknownHostException, IOException
		{
			
			 //"192.168.1.4"
			 InetAddress ip    = InetAddress.getLocalHost(); 
			 Socket cliente    = new Socket(ip, 3000);
		     System.out.println("O cliente se conectou ao servidor!");
		     
		     Scanner teclado   = new Scanner(System.in);
		     PrintStream saida = new PrintStream(cliente.getOutputStream());
		     
		     Thread thread  = new Thread(new Leitor(cliente));
	    	 thread.start();
		     
		     while (teclado.hasNextLine())
		     {
		       saida.println(teclado.nextLine());
		       
		     }
		     
		     cliente.close();
		     saida.close();
		     teclado.close();
		}

}
