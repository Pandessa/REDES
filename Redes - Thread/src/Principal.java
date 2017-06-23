import java.io.IOException;
import cliente.Cliente;
import servidor.Servidor;

public class Principal {

	public static void main(String[] args) {
		
		Servidor server = new Servidor();
		
		try
		{
			server.conectar();
		}
		catch(IOException e)
		{
			System.out.println("Deu ruim no servidor hein?!");
		}

	}

}
