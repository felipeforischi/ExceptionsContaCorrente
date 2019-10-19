package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.ContaCorrente;
import model.exceptions.DomainException;

public class Programa {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		try {
		System.out.println("Digite os dados da conta.");
		System.out.print("Numero: ");
		int numero = sc.nextInt();
		System.out.print("Titular: ");
		sc.nextLine();
		String titular = sc.nextLine();
		System.out.print("Saldo Inicial: ");
		double saldo = sc.nextDouble();
		System.out.print("Limite de Saque: ");
		double limiteSaque = sc.nextDouble();
		
		ContaCorrente cc = new ContaCorrente(numero, titular, saldo, limiteSaque);
		
		System.out.print("Digite o valor do saque: ");
		double valor = sc.nextDouble();
		
			cc.saque(valor);
			System.out.println("Saldo Atual: " + String.format("%.2f", cc.getSaldo()));
		}
		catch (DomainException e) {
			System.out.println("Erro no Saque: "+ e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro de digitação");
		}
		
		System.out.println("Operação finalizada. Até a próxima");
		sc.close();
		
		
	}

}
