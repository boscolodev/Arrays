package Utilities;

import java.util.Comparator;

import Entities.Aluno;

public class StudentOrderByName implements Comparator<Aluno> {

	@Override
	public int compare(Aluno a1, Aluno a2) {
		return a1.getNome().compareTo(a2.getNome());
	}

}
