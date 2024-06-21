package LooakTechStudentsRegistrationController;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import LooakTechStudentsRegistrationDao.StudentsDao;
import LooakTechStudentsRegistrationModel.Students;

/**
 * Servlet implementation class StudentsServlet
 */
@WebServlet("/register")
public class StudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentsDao studentDao=new StudentsDao();

    /**
     * Default constructor. 
     */
    public StudentsServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/studentregister.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String StudentName=request.getParameter("StudentName");
		String Course=request.getParameter("Course");
		String Fees=request.getParameter("Fees");
		
		Students students=new Students();
		students.setStudentName(StudentName);
		students.setCourse(Course);
		students.setFees(Fees);
		
			try {
				StudentsDao.register(students);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/studentdetails.jsp");
			dispatcher.forward(request, response);
	
		
	}

}
