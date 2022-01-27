import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetBookingServlet
 */
@WebServlet("/GetBookingServlet")
public class GetBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	private String jdbcURL = "jdbc:mysql://localhost:3306/bookingproject";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";

	public GetBookingServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
		// Step 2: Prepare list of SQL prepared statements to perform CRUD to our database
		private static final String INSERT_BOOKINGS_SQL = "INSERT INTO booking" + " (bookingid, attractionid, attractionname, userid, date, numberoftickets, totalprice) VALUES " + " (?, ?, ?, ?, ?, ?, ?);";
		private static final String SELECT_BOOKING_BY_ID = "select bookingid, attractionid, attractionname, userid, date, numberoftickets, totalprice from booking where bookingid =?";
		private static final String SELECT_ALL_BOOKINGS = "select * from booking ";
		private static final String DELETE_BOOKINGS_SQL = "delete from booking where bookingid = ?;";
		private static final String UPDATE_BOOKINGS_SQL = "update booking set bookingid = ?,attractionid= ?, attractionname =?, userid =?, date =?, numberoftickets =?, totalprice =?, where bookingid = ?;";

		// Step 3: Implement the getConnection method which facilitates connection to the database via JDBC
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		// Step 4: Depending on the request servlet path, determine the function to
		// invoke using the follow switch statement.
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
				 listBookings(request, response);
			 break;
		
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	// Step 5: listUsers function to connect to the database and retrieve all users
	// records
	private void listBookings(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Booking> bookings = new ArrayList<>();
		try (Connection connection = getConnection();
				// Step 5.1: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKINGS);) {
			// Step 5.2: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 5.3: Process the ResultSet object.
			while (rs.next()) {
				String bookingid = rs.getString("bookingid");
				String attractionid = rs.getString("attractionid");
				String attractionname = rs.getString("attractionname");
				String userid = rs.getString("userid");
				String date = rs.getString("date");
				String numberoftickets = rs.getString("numberoftickets");
				String totalprice = rs.getString("totalprice");
				bookings.add(new Booking(bookingid, attractionid, attractionname, userid, date, numberoftickets, totalprice));
			
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5.4: Set the users list into the listUsers attribute to be pass to the
		// userManagement.jsp
		request.setAttribute("listBookings", bookings);
		request.getRequestDispatcher("/bookingManagement.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
