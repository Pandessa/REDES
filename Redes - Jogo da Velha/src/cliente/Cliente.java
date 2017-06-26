package cliente;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import jogo.*;


public class Cliente {
	
	public static JogoVelha game = new JogoVelha();
	
		public static void main(String[] args) throws UnknownHostException, IOException
		{
			 
			 
			 InetAddress ip    = InetAddress.getLocalHost(); 
			 Socket cliente    = new Socket(ip, 3000);
		     System.out.println("O cliente se conectou ao servidor!");
	    	 System.out.println("Faça sua jogada! Você é O");
	    	 JogoVelha.imprimirTabuleiro();
		     
		     Scanner teclado   = new Scanner(System.in);
		     PrintStream saida = new PrintStream(cliente.getOutputStream());
		     Thread t = new Thread(new Leitor(cliente,game));
		     t.start();
		     
		     while (teclado.hasNext())
		     {
		    	 String jogada = teclado.next();
				 game.fazerJogada(jogada, "O");
				 game.imprimirTabuleiro();
		    	 saida.println(jogada);
		     }
		     
		     cliente.close();
		     saida.close();
		     teclado.close();
		}

}
