package jogo;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Jogador extends Cliente{

	private String caracter;
	private JogoVelha game = new JogoVelha();
	
	public JogoVelha getJogo()
	{
		return game;
	}
	
	public void setCaracter(String novoChar)
	{
		caracter = novoChar;
	}
	
	public String getCaracter()
	{
		return caracter;
	}
	
	public Jogador(String meuIp, String caracter)
	{
		super(meuIp);
		this.caracter = caracter;
	}
	
	public void jogar(String posicao)
	{
		
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (game.tabuleiro[i][j].equals(posicao))
				{
					game.tabuleiro[i][j] = caracter;
				}
			}
		}
	}
	
	public static void main(String [] args)
	{
		//Jogador jogador = new Jogador("192.168.1.8", "X");
		//System.out.println("Você é X");
		
		Jogador jogador = new Jogador("127.0.1.1", "O");
		System.out.println("Você é O");
		
		jogador.getJogo().imprimir();
		
		try
	    {
			Scanner teclado   = new Scanner(System.in);
		    PrintStream saida = new PrintStream(jogador.cliente.getOutputStream());
		    Thread thread 	  = new Thread(new Leitor(jogador));
		    thread.start();
		    
		    while(teclado.hasNext())
		    {
		    	String posicao = teclado.next();
		    	jogador.jogar(posicao);
		    	jogador.getJogo().imprimir();
		    	jogador.getJogo().verificarGanhador();
		    	saida.println(posicao+" "+jogador.caracter);
		    }
		    
		    teclado.close();
		    saida.close();
		}
	    catch (IOException e)
	    {
			System.out.println("Não foi possível realizar a jogada.");
		}
	}
}
