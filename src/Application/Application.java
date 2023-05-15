package Application;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Application {
	static Connection connection = null;

	public static void main(String[] args) {
		Date data1 = java.sql.Date.valueOf("1990-04-16");
		Date data2 = java.sql.Date.valueOf("1990-06-20");
		Date data3 = java.sql.Date.valueOf("1990-10-06");
		Date data4 = java.sql.Date.valueOf("1990-11-17");

		Student student1 = new Student(1, "Mario", "Rossi", 'm', data1, 5.5, 9.0);
		Student student2 = new Student(2, "Maria", "Rossi", 'f', data2, 7.5, 8.0);
		Student student3 = new Student(3, "Giovanni", "Bianchi", 'm', data3, 6, 7);
		Student student4 = new Student(4, "Giuseppe", "Verdi", 'm', data4, 6.5, 9.5);
		List<Student> studenti = new ArrayList<>(List.of(student1, student2, student3, student4));

		try {
			String url = "jdbc:postgresql://localhost:5433/java-week3-day1?useSSL=false";
			String username = "postgres";
			String password = "9296";
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		insertStudent(student1);
		insertStudent(student2);
		insertStudent(student3);
		insertStudent(student4);
		deleteStudent(student1.getId());

	}

	public static void insertStudent(Student s) {

		String sqlInsert = "INSERT INTO school_students(id,name,last_name,gender,birthdate,min_vote,max_vote) VALUES (?,?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sqlInsert);
			stmt.setInt(1, s.getId());
			stmt.setString(2, s.getName());
			stmt.setString(3, s.getLastName());
			stmt.setString(4, String.valueOf(s.getGender()));
			stmt.setDate(5, s.getBirthDate());
			stmt.setDouble(6, s.getMinVote());
			stmt.setDouble(7, s.getMaxVote());
			stmt.execute();
			System.out.println("STUDENTE AGGIUNTO");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void deleteStudent(int id) {
		String sqlDelete = "DELETE FROM school_students WHERE id = ?";
		try {
			PreparedStatement stmtDelete = connection.prepareStatement(sqlDelete);
			stmtDelete.setInt(1, id);
			stmtDelete.execute();
			System.out.println("STUDENTE ELIMINATO");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
