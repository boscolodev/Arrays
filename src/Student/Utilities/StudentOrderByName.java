package Student.Utilities;

import java.util.Comparator;

import Entities.Student;

public class StudentOrderByName implements Comparator<Student> {

	@Override
	public int compare(Student a1, Student a2) {
		return a1.getNome().compareTo(a2.getNome());
	}

}
