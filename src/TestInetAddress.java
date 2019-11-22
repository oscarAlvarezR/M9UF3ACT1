import java.net.*;
import java.util.Scanner;

public class TestInetAddress {
	
	public static void main (String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introdueix la ip:");
		String ipTeclado = teclado.nextLine();
		InetAddress dir = null;
		System.out.println("=====================================================");
		System.out.println("SORTIDA PER A LOCALHOST");
		
		try {
			//LOCALHOST
			dir = InetAddress.getByName(ipTeclado);
			provaTots(dir);
			
			//URL www.google.com
			System.out.println("=====================================================");
			System.out.println("SORTIDA PER A URL");
			dir = InetAddress.getByName("www.google.com");
			provaTots(dir);
			
			//Array tipus InetAddress amb totes les adreces IP de google.com
			System.out.println("\tAdreces IP per a: "+dir.getHostName());
			InetAddress[] adreces = InetAddress.getAllByName(dir.getHostName());
			for (int i=0; i<adreces.length; i++) 
				System.out.println("\t\t"+adreces[i].toString());
			System.out.println("=====================================================");
			
		} catch (UnknownHostException e1) {e1.printStackTrace();}
		
	}
	
	private static void provaTots(InetAddress dir) {
		
		InetAddress dir2;
		
		System.out.println("\tM�tode getByName(): "+dir);
		
		try {
			dir2 = InetAddress.getLocalHost();
			System.out.println("\tM�tode getLocalHost(): "+dir2);
		} catch (UnknownHostException e) {e.printStackTrace();}
		
		//FEM SERVIR M�TODES DE LA CLASSE
		System.out.println("\tM�tode getHostName(): "+dir.getHostName());
		System.out.println("\tM�tode getHostAddress(): "+dir.getHostAddress());
		System.out.println("\tM�tode toString(): "+dir.toString());
		System.out.println("\tM�tode getCanonicalHostName(): "+dir.getCanonicalHostName());
		
	}

}