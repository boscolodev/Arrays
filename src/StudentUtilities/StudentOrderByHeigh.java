package StudentUtilities;

import java.util.Comparator;

import Entities.Student;

public class StudentOrderByHeigh implements Comparator<Student> {

	public int compare(Student pos1, Student pos2) {
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
