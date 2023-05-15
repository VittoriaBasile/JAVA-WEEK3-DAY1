package Application;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Application {
	static Connection connection = null;

	public static void main(String[] args) {
		Date data1 = java.sql.Date.valueOf("1990-04-16");
		Date data2 = java.sql.Date.valueOf("1990-06-20");
		Date data3 = java.sql.Date.valueOf("1990-10-06");
		Date data4 = java.sql.Date.valueOf("1990-11-17");

		Student student1 = new Student("Mario", "Rossi", 'm', data1, 5.5, 9.0);
		Student student2 = new Student("Maria", "Rossi", 'f', data2, 7.5, 8.0);
		Student student3 = new Student("Giovanni", "Bianchi", 'm', data3, 6, 7);
		Student student4 = new Student("Giuseppe", "Verdi", 'm', data4, 6.5, 9.5);

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

	}

	public static void insertStudent(Student s) {

		String sqlInsert = "INSERT INTO school_students(name,last_name,gender,birthdate,min_vote,max_vote) VALUES (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sqlInsert);
			stmt.setString(1, s.getName());
			stmt.setString(2, s.getLastName());
			stmt.setString(3, String.valueOf(s.getGender()));
			stmt.setDate(4, s.getBirthDate());
			stmt.setDouble(5, s.getMinVote());
			stmt.setDouble(6, s.getMaxVote());
			stmt.execute();
			System.out.println("STUDENTE AGGIUNTO");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
