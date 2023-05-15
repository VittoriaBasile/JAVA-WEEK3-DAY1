package Application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Application {
	static Connection connection = null;

	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/java-week3-day1?useSSL=false";
		String username = "postgres";
		String password = "9296";
		String data1 = "1990, 4, 16";
		String data2 = "1990, 6, 20";
		String data3 = "1990, 10, 6";
		String data4 = "1990, 11, 17";

		Student student1 = new Student("Mario", "Rossi", 'm', data1, 5.5, 9.0);
		Student student2 = new Student("Maria", "Rossi", 'f', data2, 7.5, 8.0);
		Student student3 = new Student("Mario", "Rossi", 'm', data3, 6, 7);
		Student student4 = new Student("Mario", "Rossi", 'm', data4, 6.5, 9.5);

		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		insertStudent(student1);
	}

	public static void insertStudent(Student s) {

		String sqlInsert = "INSERT INTO school_students(name,last_name,gender,birthdate,min_vote,max_vote)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sqlInsert);
			stmt.setString(1, s.getName());
			stmt.setString(2, s.getLastName());
			stmt.setLong(3, s.getGender());
			stmt.setString(4, s.getBirthDate());
			stmt.setDouble(5, s.getMinVote());
			stmt.setDouble(6, s.getMaxVote());
			System.out.println("STUDENTE AGGIUNTO");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
