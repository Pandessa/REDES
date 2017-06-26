package cliente;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import jogo.JogoVelha;

public class Cliente2 {
	
	public static JogoVelha game = new JogoVelha();
	
	public static void main(String[] args) throws UnknownHostException, IOException
	{
		String ip2 = "192.168.1.4";
		Socket cliente    = new Socket(ip2, 3000);
	    System.out.println("O cliente se conectou ao servidor!");
	    System.out.println("Faça sua jogada! Você é X");
	    game.imprimirTabuleiro();
	    
	    Scanner teclado   = new Scanner(System.in);
	    PrintStream saida = new PrintStream(cliente.getOutputStream());
	    Thread t = new Thread(new Leitor(cliente,game));
	    t.start();
	     
	     while (teclado.hasNext())
	     {
	    	 String jogada = teclado.next();
			 game.fazerJogada(jogada, "X");
			 game.imprimirTabuleiro();
			 game.quemGanhou();
	    	 saida.println(jogada);
	     }
	     
	     cliente.close();
	     saida.close();
	     teclado.close();
	}

}
