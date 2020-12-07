package practicefilehandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

public class FileManipulator {

	static String f = "student.txt";
	Set<Student> studentList = new LinkedHashSet<Student>();
	File file;

	public void readData(String f) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(f));
		String line;
		while ((line = reader.readLine()) != null) {
			parseText(line);
		}
		reader.close();

	}

	public void appendData(String f, Student student) throws IOException {
		if (studentList.contains(student))
			return;
		BufferedWriter writer = new BufferedWriter(new FileWriter(f, true));
		writer.newLine();
		writer.append(student.toString());
		studentList.add(student);
		writer.close();
	}

	public void parseText(String line) {
		String[] student = line.split(",");
		Student s = new Student(Integer.parseInt(student[0]), student[1], student[2]);
		studentList.add(s);
	}

	public void display() {
		studentList.forEach(s -> System.out.println(s));
	}

	public static void main(String[] args) throws IOException {
		FileManipulator myfile = new FileManipulator();
		myfile.readData(f);
		myfile.appendData(f, new Student(6, "John Lee", "Arts"));
		myfile.display();

	}

}
