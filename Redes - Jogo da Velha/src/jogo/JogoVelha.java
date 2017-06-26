package jogo;

public class JogoVelha {
	
	public static String[][] tabuleiro = {{"1","2","3"},
			  							 {"4","5","6"},
			  							 {"7","8","9"}};
	
	public void copia(String[][] t)
	{
		for(int i = 0; i<3; i++)
		{
			for(int j = 0; j<3; j++)
			{
				tabuleiro[i][j] = t[i][j];
			}
		}
		
	}
	
	public boolean jogadaValida(String posicao)
	{	
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(tabuleiro[i][j].equals(posicao))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public void fazerJogada(String posicao, String caracterJogador)
	{
		{
			for(int i=0;i<3;i++)
			{
				for(int j=0;j<3;j++)
				{
					if(tabuleiro[i][j].equals(posicao))
					{
						tabuleiro[i][j] = caracterJogador;
					}
				}
			}
		}		
	}
	public static void imprimirTabuleiro(){
		
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				System.out.print("|"+tabuleiro[i][j]);
				System.out.print("|");
			}
			System.out.println();
			
		}
		System.out.println();
	}
	
}
