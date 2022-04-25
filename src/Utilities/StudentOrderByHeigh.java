package Utilities;

import java.util.Comparator;

import Entities.Aluno;

public class StudentOrderByHeigh implements Comparator<Aluno> {

	public int compare(Aluno pos1, Aluno pos2) {
		if (pos1.getAltura() < pos2.getAltura()) {
			return -1;
		}
		if (pos1.getAltura() > pos2.getAltura()) {
			return 1;
		} else {
			return 0;
		}
	}
	
}
