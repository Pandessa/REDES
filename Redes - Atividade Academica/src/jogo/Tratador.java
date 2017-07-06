package jogo;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Tratador implements Runnable{

	private Socket novo;
	private static Map <String, PrintStream> clientes = new HashMap<String, PrintStream>();
	
	public Tratador (Socket cliente)
	{
		novo = cliente;
	}
	
	@Override
	public void run()
	{
		Scanner teclado = new Scanner(System.in);
		    
			try
			{
				System.out.println("Nova conexão com o cliente "+novo.getInetAddress().getHostAddress());
				Scanner entrada = new Scanner(novo.getInputStream());
				clientes.put(novo.getInetAddress().getHostName(), new PrintStream(novo.getOutputStream()));
					
			    while (entrada.hasNextLine())
			    {
			    	if(!novo.getInetAddress().getHostName().equalsIgnoreCase("179.34.114.31"))
			    	{
			    		enviarTodos(entrada.nextLine(), novo.getInetAddress().getHostName());
			    	}
			    }
			    
			    entrada.close();
			} 
			catch (IOException e)
			{
				System.out.println("Não foi possível enviar as mensagens!");
			}
			
			teclado.close();
		   
		}
		
		public static void enviarTodos(String msg, String hostname) throws IOException
		{
			Set <String> chaves = clientes.keySet();
			/* Recupero as chaves para iterar sobre os elementos e
			 * enviar a mensagem para todos os outros clientes, exceto
			 * para o mesmo que está enviando a msg atual.
			 */
			
			for(String c : chaves)
			{
				if(!c.equalsIgnoreCase(hostname))
				{
					clientes.get(c).println(msg);
				}
			}
		}
}
