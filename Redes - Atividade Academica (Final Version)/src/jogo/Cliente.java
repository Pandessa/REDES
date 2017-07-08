package jogo;
import java.io.IOException;
import java.net.Socket;

public class Cliente {

	protected String ip;
	protected Socket cliente;
	
	public Cliente(String meuIp)
	{
		try
		{
			this.cliente = new Socket(meuIp,3000);
			System.out.println("O cliente se conectou ao servidor!");
		}
		
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			System.out.println("Erro ao se conectar ao servidor.");
		}
	}
}
