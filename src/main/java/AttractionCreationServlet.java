import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AttractionCreationServlet
 */
@WebServlet("/AttractionCreationServlet")
public class AttractionCreationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AttractionCreationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("attraction_Id"));
		String name = request.getParameter("attractionName");
		String description = request.getParameter("description");
		String image = request.getParameter("image");
		int price = Integer.parseInt(request.getParameter("price"));
		String hours = request.getParameter("openingHours");
		String address = request.getParameter("address");
	
		try {
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con = DriverManager.getConnection(
		 "jdbc:mysql://localhost:3306/attraction_booking", "root", "password");

		 PreparedStatement ps = con.prepareStatement("insert into attraction values(?,?,?,?,?,?,?)");

		 ps.setInt(1, id);
		 ps.setString(2, name);
		 ps.setString(3, description);
		 ps.setString(4, image);
		 ps.setInt(5, price);
		 ps.setString(6, hours);
		 ps.setString(7, address);
	
		 int i = ps.executeUpdate();
	
		 if (i > 0){
		PrintWriter writer = response.getWriter();
		writer.println("<h1>" + "You have successfully added an attraction!" +
		"</h1>");
		writer.close();
		}
		}
		//Step 8: catch and print out any exception
		catch (Exception exception) {
		 System.out.println(exception);
		 out.close();
		}
		doGet(request, response);

		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


