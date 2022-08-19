package sdbms;

import java.util.Comparator;

class SortStudentByMarks implements Comparator<Student>{
	@Override
	public int compare(Student x,Student y){
		return x.getMarks().compareTo(y.getMarks());
	}

}
