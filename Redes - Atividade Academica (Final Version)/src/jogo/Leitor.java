package jogo;
import java.io.IOException;
import java.util.Scanner;

public class Leitor implements Runnable{
	
	private Jogador jogador;
	private Observador observador;
	private Scanner server;
	

	public Leitor(Jogador player)
	{
		jogador = player;
	}
	
	public Leitor(Observador obv)
	{
		observador = obv;
		try
		{
			server = new Scanner(observador.cliente.getInputStream());
		}
		catch (IOException e)
		{
			System.out.println("Erro no server.");
		}
	}

	@Override
	public void run()
	{		
		try
		{
			if(jogador != null)
			{
				
			
			Scanner servidor  = new Scanner(jogador.cliente.getInputStream());
			String aux = "-";
			
			while(servidor.hasNext())
			{
				String [] entrada = servidor.next().split("-");
				
				if(jogador.cliente.getInetAddress().getHostName().equalsIgnoreCase("192.168.1.8"))
				{
					aux = jogador.getCaracter();
					jogador.setCaracter("O");
					jogador.jogar(entrada[0]);
					jogador.setCaracter("X");
				}
				
				else
				{
					aux = jogador.getCaracter();
					jogador.setCaracter("X");
					jogador.jogar(entrada[0]);
					jogador.setCaracter("O");
				}
				
				jogador.getJogo().imprimir();
				jogador.getJogo().verificarGanhador();
				
				//servidor.next();
			}
			
			servidor.close();
			}
			
			if(observador != null)
			{
				while(server.hasNext())
				{
					String entrada = server.next();
					String [] aux  = entrada.split("-");
					observador.visualizarJogadas(aux[0], aux[1]);
				}
			}
		}
		catch(IOException e)
		{
			System.out.println("Ocorreu um erro ao receber mensagem do servidor.");
		}
	}
}
