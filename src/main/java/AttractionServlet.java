import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AttractionServlet
 */
@WebServlet("/AttractionServlet")
public class AttractionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/attraction_booking";
	 private String jdbcUsername = "root";
	 private String jdbcPassword = "password";
	 
	 private static final String INSERT_ATTRACTION_SQL = "INSERT INTO attraction" + " (attraction_Id,attractionName,description,image,price,openingHours,address) VALUES " +
			  " (?, ?, ?, ?, ?, ?);";
			  private static final String SELECT_ATTRACTION_BY_ID = "select attraction_Id,attractionName,description,image,price,openingHours,address from attraction where attraction_Id =?";
			  private static final String SELECT_All_ATTRACTIONS = "select * from attraction ";
			  private static final String DELETE_ATTRACTION_SQL = "delete from attraction where attraction_Id = ?;";
			  private static final String UPDATE_ATTRACTION_SQL = "update UserDetails set attraction_Id=?,attractionName=?,description=?,image=?,price=?,openingHours=?,address=? where attraction_Id = ?;";
			  
			  protected Connection getConnection() {
				  Connection connection = null;
				  try {
				  Class.forName("com.mysql.jdbc.Driver");
				  connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
				  } catch (SQLException e) {
				  e.printStackTrace();
				  } catch (ClassNotFoundException e) {
				  e.printStackTrace();
				  }
				  return connection;
				  }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AttractionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		 try {
		 switch (action) {
		 case "/insert":
		 break;
		 case "/delete":
		 break;
		 case "/edit":
		 break;
		 case "/update":
		 break;
		 default:
		 listAttractions(request, response);
		 break;
		 }
		 } catch (SQLException ex) {
		 throw new ServletException(ex);
		 }
		 
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	 private void listAttractions(HttpServletRequest request, HttpServletResponse response)
			 throws SQLException, IOException, ServletException
			 {
			 List <Attraction> attractions = new ArrayList <>();
			  try (Connection connection = getConnection();
			
			  PreparedStatement preparedStatement =
			 connection.prepareStatement(SELECT_All_ATTRACTIONS);) {
			 
			  ResultSet rs = preparedStatement.executeQuery();
			
			  while (rs.next()) {
			  int attraction_Id = rs.getInt("attraction_Id");
			  String attractionName = rs.getString("attractionName");
			  String description = rs.getString("description");
			  String image = rs.getString("image");
			  int price = rs.getInt("price");
			  String openingHours = rs.getString("openingHours");
			  String address = rs.getString("address");
			  attractions.add(new Attraction(attraction_Id,attractionName,description,image,price,openingHours,address));
			  }
			  } catch (SQLException e) {
			  System.out.println(e.getMessage());
			  }
			 request.setAttribute("listAttractions", attractions);
			 request.getRequestDispatcher("/attractionManagement.jsp").forward(request, response);
			 }

}
