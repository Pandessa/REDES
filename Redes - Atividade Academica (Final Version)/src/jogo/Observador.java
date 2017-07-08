package jogo;

public class Observador extends Cliente{
	
	private String [][] tabuleiro = {
			{ "1", "2", "3" },
			{ "4", "5", "6" },
			{ "7", "8", "9" }};
	
	public void visualizarJogadas(String posicao, String aux)
	{
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (tabuleiro[i][j].equals(posicao))
				{
					tabuleiro[i][j] = aux;
				}
				
				System.out.print("|" + tabuleiro[i][j]);
				System.out.print("|");
			}
			
			System.out.println();
		}
		
		System.out.println();
	}
	
	public Observador(String meuIp)
	{
		super(meuIp);
	}
	
	public static void main(String[] args)
	{
		Observador obv = new Observador("PCdaPanda");
		Thread thread  = new Thread(new Leitor(obv));
		thread.start();
		
	}

}
