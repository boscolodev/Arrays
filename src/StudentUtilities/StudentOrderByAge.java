package StudentUtilities;

import java.util.Comparator;

import Entities.Student;

public class StudentOrderByAge implements Comparator<Student> {

	public int compare(Student pos1, Student pos2) {
		if (pos1.getIdade() < pos2.getIdade()) {
			return -1;
		}
		if (pos1.getIdade() > pos2.getIdade()) {
			return 1;
		} else {
			return 0;
		}
	}

}