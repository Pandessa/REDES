package jogo;

public class JogoVelha {
	public String[][] tabuleiro =
		{
				{ "1", "2", "3" },
				{ "4", "5", "6" },
				{ "7", "8", "9" } };
		
		private String caracterJogador1 = "X";
		private String caracterJogador2 = "O";


		public boolean verificarJogada(String posicao)
		{
			for (int i = 0; i < 3; i++)
			{
				for (int j = 0; j < 3; j++)
				{
					if (this.tabuleiro[i][j].equals(posicao))
					{
						return true;
					}
				}
			}
			return false;
		}

		/*public void receberJogada(String posicao, String caracterJogador)
		{
			{
				for (int i = 0; i < 3; i++)
				{
					for (int j = 0; j < 3; j++)
					{
						if (tabuleiro[i][j].equals(posicao))
						{
							tabuleiro[i][j] = caracterJogador;
						}
					}
				}
			}
		}
	*/
		public void imprimir()
		{

			for (int i = 0; i < 3; i++)
			{
				for (int j = 0; j < 3; j++)
				{
					System.out.print("|" + tabuleiro[i][j]);
					System.out.print("|");
				}
				System.out.println();

			}
			System.out.println();
		}

		public boolean verificarGanhador()
		{

			// jogador1 ganhou na linha 1ou2ou3
			if ((tabuleiro[0][0].equals(this.caracterJogador1) && tabuleiro[0][1].equals(this.caracterJogador1)
					&& tabuleiro[0][2].equals(this.caracterJogador1))
					|| (tabuleiro[1][0].equals(this.caracterJogador1) && tabuleiro[1][1].equals(this.caracterJogador1)
							&& tabuleiro[1][2].equals(this.caracterJogador1))
					|| (tabuleiro[2][0].equals(this.caracterJogador1) && tabuleiro[2][1].equals(this.caracterJogador1)
							&& tabuleiro[2][2].equals(this.caracterJogador1)))
			{
				System.out.println("Jogador 192.168.1.4 ganhou!");
				return true;

				// jogador2 ganhou na linha 1ou2ou3
			} else if ((tabuleiro[0][0].equals(this.caracterJogador2) && tabuleiro[0][1].equals(this.caracterJogador2)
					&& tabuleiro[0][2].equals(this.caracterJogador2))
					|| (tabuleiro[1][0].equals(this.caracterJogador2) && tabuleiro[1][1].equals(this.caracterJogador2)
							&& tabuleiro[1][2].equals(this.caracterJogador2))
					|| (tabuleiro[2][0].equals(this.caracterJogador2) && tabuleiro[2][1].equals(this.caracterJogador2)
							&& tabuleiro[2][2].equals(this.caracterJogador2)))
			{
				System.out.println("Jogador 127.0.0.1 ganhou!");
				return true;

				// jogador1 ganhou na coluna 1ou2ou3
			} else if ((tabuleiro[0][0].equals(this.caracterJogador1) && tabuleiro[1][0].equals(this.caracterJogador1)
					&& tabuleiro[2][0].equals(this.caracterJogador1))
					|| (tabuleiro[0][1].equals(this.caracterJogador1) && tabuleiro[1][1].equals(this.caracterJogador1)
							&& tabuleiro[2][1].equals(this.caracterJogador1))
					|| (tabuleiro[0][2].equals(this.caracterJogador1) && tabuleiro[1][2].equals(this.caracterJogador1)
							&& tabuleiro[2][2].equals(this.caracterJogador1)))
			{
				System.out.println("Jogador 192.168.1.4 ganhou!");
				return true;

				// jogador2 ganhou na coluna 1ou2ou3
			} else if ((tabuleiro[0][0].equals(this.caracterJogador2) && tabuleiro[1][0].equals(this.caracterJogador2)
					&& tabuleiro[2][0].equals(this.caracterJogador2))
					|| (tabuleiro[0][1].equals(this.caracterJogador2) && tabuleiro[1][1].equals(this.caracterJogador2)
							&& tabuleiro[2][1].equals(this.caracterJogador2))
					|| (tabuleiro[0][2].equals(this.caracterJogador2) && tabuleiro[1][2].equals(this.caracterJogador2)
							&& tabuleiro[2][2].equals(this.caracterJogador2)))
			{
				System.out.println("Jogador 127.0.0.1 ganhou!");
				return true;

				// jogador1 ganhou na dp e ds
			} else if (((tabuleiro[0][0].equals(this.caracterJogador1) && tabuleiro[1][1].equals(this.caracterJogador1)
					&& tabuleiro[2][2].equals(this.caracterJogador1)))
					|| (tabuleiro[0][2].equals(this.caracterJogador1) && tabuleiro[1][1].equals(this.caracterJogador1)
							&& tabuleiro[2][0].equals(this.caracterJogador1)))
			{
				System.out.println("Jogador 192.168.1.4 ganhou!");
				return true;

				// jogador2 ganhou na dp e ds
			} else if (((tabuleiro[0][0].equals(this.caracterJogador2) && tabuleiro[1][1].equals(this.caracterJogador2)
					&& tabuleiro[2][2].equals(this.caracterJogador2)))
					|| (tabuleiro[0][2].equals(this.caracterJogador2) && tabuleiro[1][1].equals(this.caracterJogador2)
							&& tabuleiro[2][0].equals(this.caracterJogador2)))
			{
				System.out.println("Jogador 127.0.0.1 ganhou!");
				return true;
			} else
				return false;

		}

}
