package cliente;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Leitor implements Runnable{

	private Socket cliente;
	
	public Leitor(Socket cliente)
	{
		this.cliente = cliente;
	}
	
	@Override
	public void run()
	{
		try
		{
			Scanner servidor  = new Scanner(cliente.getInputStream());
			
			while(servidor.hasNextLine())
		     {
		    	 System.out.println(servidor.nextLine());
		     }
			
			servidor.close();
		}
		catch (IOException e)
		{
			System.out.println("Deu ruim no leitor hein?!");
		}
		
	}

}
