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
	private String jdbcPassword = "password";

	public GetBookingServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Step 2: Prepare list of SQL prepared statements to perform CRUD to our
	// database
	private static final String INSERT_BOOKINGS_SQL = "INSERT INTO booking"
			+ " (bookingid, attractionid, attractionname, userid, date, numberoftickets, totalprice) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?);";
	private static final String SELECT_BOOKING_BY_ID = "select bookingid, attractionid, attractionname, userid, date, numberoftickets, totalprice from booking where bookingid =?";
	private static final String SELECT_ALL_BOOKINGS = "select * from booking ";
	private static final String DELETE_BOOKINGS_SQL = "delete from booking where bookingid = ?;";
	private static final String UPDATE_BOOKINGS_SQL = "update booking set bookingid = ?,attractionid= ?, attractionname =?, userid =?, date =?, numberoftickets =?, totalprice =? where bookingid =?;";

	// Step 3: Implement the getConnection method which facilitates connection to
	// the database via JDBC
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
			case "/GetBookingServlet/delete":
				deleteBooking(request, response);
				break;
			case "/GetBookingServlet/edit":
				showEditForm(request, response);
				break;
			case "/GetBookingServlet/update":
				updateBooking(request, response);
				break;
			case "/GetBookingServlet/dashboard":
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
				bookings.add(new Booking(bookingid, attractionid, attractionname, userid, date, numberoftickets,
						totalprice));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5.4: Set the users list into the listUsers attribute to be pass to the bookingManagement.jsp
		request.setAttribute("listBookings", bookings);
		request.getRequestDispatcher("/bookingManagement.jsp").forward(request, response);
	}

	// method to get parameter, query database for existing user data and redirect to booking edit page
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// get parameter passed in the URL
		String bookingid = request.getParameter("bookingid");
		Booking existingBooking = new Booking("", "", "", "", "", "", "");
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOKING_BY_ID);) {
			preparedStatement.setString(1, bookingid);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object
			while (rs.next()) {
				bookingid = rs.getString("bookingid");
				String attractionid = rs.getString("attractionid");
				String attractionname = rs.getString("attractionname");
				String userid = rs.getString("userid");
				String date = rs.getString("date");
				String numberoftickets = rs.getString("numberoftickets");
				String totalprice = rs.getString("totalprice");
				existingBooking = new Booking(bookingid, attractionid, attractionname, userid, date, numberoftickets,
						totalprice);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5: Set existingUser to request and serve up the userEdit form
		request.setAttribute("booking", existingBooking);
		request.getRequestDispatcher("/bookingEdit.jsp").forward(request, response);
	}

	// method to update the user table base on the form data
	private void updateBooking(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// Step 1: Retrieve value from the request
		String oribookingid = request.getParameter("oribookingid");
		String bookingid = request.getParameter("bookingid");
		String attractionid = request.getParameter("attractionid");
		String attractionname = request.getParameter("attractionname");
		String userid = request.getParameter("userid");
		String date = request.getParameter("date");
		String numberoftickets = request.getParameter("numberoftickets");
		String totalprice = request.getParameter("totalprice");

		// Step 2: Attempt connection with database and execute update user SQL query
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_BOOKINGS_SQL);) {
			statement.setString(1, bookingid);
			statement.setString(2, attractionid);
			statement.setString(3, attractionname);
			statement.setString(4, userid);
			statement.setString(5, date);
			statement.setString(6, numberoftickets);
			statement.setString(7, totalprice);
			statement.setString(8, oribookingid);
			int i = statement.executeUpdate();
			System.out.println(bookingid);
		}
		// Step 3: redirect back to UserServlet (note: remember to change the url to your project name)
		response.sendRedirect("http://localhost:8090/BookingAttraction/GetBookingServlet/dashboard");
	}

	// method to delete user
	private void deleteBooking(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// Step 1: Retrieve value from the request
		String bookingid = request.getParameter("bookingid");
		System.out.println(bookingid);
		// Step 2: Attempt connection with database and execute delete user SQL query
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_BOOKINGS_SQL);) {
			statement.setString(1, bookingid);
			int i = statement.executeUpdate();
		}
		// Step 3: redirect back to UserServlet dashboard (note: remember to change the
		// url to your project name)
		response.sendRedirect("http://localhost:8090/BookingAttraction/GetBookingServlet/dashboard");
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
