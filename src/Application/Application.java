package Application;

import java.util.ArrayList;
import java.util.List;

import Entities.Aluno;

public class Application {

	public static void main(String[] args) {

		List<Aluno> listAluno = new ArrayList<Aluno>();

		Aluno a = new Aluno();
		
		//Criando uma lista a partir do CSV
		listAluno = a.parseList();
		
		// Ordenando por Altura
		//a.orderByHeigh(listAluno);

		// Ordenando por Nome
		a.orderByName(listAluno);

	}

}
