package Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

	public static void Options() {

		// Criar um Arraylist aluno para alimentar os dados
		List<Student> listAluno = new ArrayList<Student>();
		// Criando Objeto para chamar os métodos
		Student student = new Student();
		// Criando uma lista a partir do CSV
		listAluno = student.parseList();
		// Definindo método de entrada de dados
		Scanner sc = new Scanner(System.in);

		int opt = -1;

		while (opt != 0) {
			System.out.println("MENU DE OPÇÔES ");
			System.out.println("1. Lista Alunos por Ordem Alfabética: ");
			System.out.println("2. Lista Alunos por Altura: ");
			System.out.println("3. Lista Alunos por Idade: ");
			System.out.println("4. Lista Alunos por Filas: ");
			System.out.println("0. Sair: ");
			System.out.println("Digite a opção desejada: ");
			opt = sc.nextInt();

			switch (opt) {
			case 1: {
				student.orderByName(listAluno);
				break;
			}
			case 2: {
				student.orderByHeigh(listAluno);
				break;
			}
			case 3: {
				student.orderByAge(listAluno);
				break;
			}
			case 4: {
				student.orderByStack(listAluno);
				break;
			}default:
				break;
			}

		}
		sc.close();
	}
}
