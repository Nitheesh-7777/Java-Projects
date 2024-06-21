package LooakTechStudentsRegistrationDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import LooakTechStudentsRegistrationModel.Students;

public class StudentsDao {

	public static int register(Students StudentRegistration)throws Exception
	{
		String Query="INSERT INTO StudentRegistration" + "(StudentName, Course, Fees) VALUES" + "(?, ?, ?);";
		int result=1;
		Class.forName("com.mysql.cj.jdbc.Driver");
		try(Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/LOOAKTech","root","Tester@2024");
				PreparedStatement preparedstatement=connection.prepareStatement(Query))	
		{
			//preparedstatement.setInt(1,1);
			preparedstatement.setString(1, StudentRegistration.getStudentName());
			preparedstatement.setString(2, StudentRegistration.getCourse());
			preparedstatement.setString(3, StudentRegistration.getFees());
			System.out.println(preparedstatement);
			
			result=preparedstatement.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		result++;
		return 0;
	}
	public static void main(String[] args) 
	{

	}

}
