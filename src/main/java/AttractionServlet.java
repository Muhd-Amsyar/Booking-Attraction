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
			  private static final String UPDATE_ATTRACTION_SQL = "update attraction set attraction_Id=?,attractionName=?,description=?,image=?,price=?,openingHours=?,address=? where attraction_Id=?;";
			  
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
			 case "/AttractionServlet/delete":
			 deleteAttraction(request, response);
			 break;
			 case "/AttractionServlet/edit":
			 showUpdateForm(request, response);
			 break;
			 case "/AttractionServlet/update":
			 updateAttraction(request, response);
			 break;
			 case "/AttractionServlet/dashboard":
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
			  String attraction_Id = rs.getString("attraction_Id");
			  String attractionName = rs.getString("attractionName");
			  String description = rs.getString("description");
			  String image = rs.getString("image");
			  String price = rs.getString("price");
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
	 
	 private void showUpdateForm(HttpServletRequest request, HttpServletResponse response)
			 throws SQLException, ServletException, IOException {

			 String attraction_Id = request.getParameter("attraction_Id");
			 Attraction existingAttraction = new Attraction("","", "", "","", "", "");
			 // Step 1: Establishing a Connection
			 try (Connection connection = getConnection();
			 // Step 2:Create a statement using connection object
			 PreparedStatement preparedStatement =
			 connection.prepareStatement(SELECT_ATTRACTION_BY_ID);) {
			 preparedStatement.setString(1, attraction_Id);
			 // Step 3: Execute the query or update query
			 ResultSet rs = preparedStatement.executeQuery();
			 // Step 4: Process the ResultSet object
			 while (rs.next()) {
			 attraction_Id = rs.getString("attraction_Id");
			 String attractionName = rs.getString("attractionName");
			 String description = rs.getString("description");
			 String image = rs.getString("image");
			 String price = rs.getString("price");
			 String openingHours = rs.getString("openingHours");
			 String address = rs.getString("address");
			 existingAttraction = new Attraction(attraction_Id,attractionName,description,image,price,openingHours,address);
			 }
			 } catch (SQLException e) {
			 System.out.println(e.getMessage());
			 }
			 //Step 5: Set existingAttraction to request and serve up the userEdit form
			 request.setAttribute("attraction", existingAttraction);
			 request.getRequestDispatcher("/attractionEdit.jsp").forward(request, response);
			 }
	 
	//method to update the user table base on the form data
	 private void updateAttraction(HttpServletRequest request, HttpServletResponse response)
	 throws SQLException, IOException {
	 //Step 1: Retrieve value from the request
	 String oriAttraction_Id = request.getParameter("oriAttraction_Id");
	 String attraction_Id = request.getParameter("attraction_Id");
	  String attractionName = request.getParameter("attractionName");
	  String description = request.getParameter("description");
	  String image = request.getParameter("image");
	  String price = request.getParameter("price");
	  String openingHours = request.getParameter("openingHours");
	  String address = request.getParameter("address");

	  //Step 2: Attempt connection with database and execute update user SQL query
	  try (Connection connection = getConnection(); PreparedStatement statement =
	 connection.prepareStatement(UPDATE_ATTRACTION_SQL);) {
	  statement.setString(1, attraction_Id);
	  statement.setString(2, attractionName);
	  statement.setString(3, description);
	  statement.setString(4, image);
	  statement.setString(5, price);
	  statement.setString(6, openingHours);
	  statement.setString(7, address);
	  statement.setString(8, oriAttraction_Id);
	  int i = statement.executeUpdate();
	  
	  }
	  response.sendRedirect("http://localhost:8090/BookingAttraction/AttractionServlet/dashboard");
	 }
	 
	 private void deleteAttraction(HttpServletRequest request, HttpServletResponse response)
			 throws SQLException, IOException {
			 
			  String attraction_Id = request.getParameter("attraction_Id");
			
			  try (Connection connection = getConnection(); PreparedStatement statement =
			 connection.prepareStatement( DELETE_ATTRACTION_SQL);) {
			  statement.setString(1, attraction_Id);
			  int i = statement.executeUpdate();
			  }
		
			  response.sendRedirect("http://localhost:8090/BookingAttraction/AttractionServlet/dashboard");
			 }

}