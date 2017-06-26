package cliente;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import jogo.JogoVelha;

public class Leitor implements Runnable{

	private Socket cliente;
	private JogoVelha g;
	public Leitor(Socket cliente, JogoVelha j)
	{
		this.cliente = cliente;
		this.g		 = j;
	}
	
	@Override
	public void run()
	{
		try
		{
			Scanner servidor  = new Scanner(cliente.getInputStream());
			
			while(servidor.hasNext())
		     {
				String entrada = servidor.next();
				
				if(cliente.getInetAddress().getHostName().equalsIgnoreCase("192.168.1.4"))
				{
					g.fazerJogada(entrada, "O");
				}
		    	else
				{
		    		g.fazerJogada(entrada, "X");
				}
				
				g.imprimirTabuleiro();
				g.quemGanhou();
				
		     }
			
			servidor.close();
		}
		catch (IOException e)
		{
			System.out.println("Deu ruim no leitor hein?!");
		}
		
	}

}
