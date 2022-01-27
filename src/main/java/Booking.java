
public class Booking {
	protected String attractionid;
	 
	 public Booking(String bookingid, String attractionid, String attractionname, String userid, String date, String numberoftickets, String totalprice) {
		 super();
		 this.bookingid = bookingid;
		 this.attractionid = attractionid;
		 this.attractionname = attractionname;
		 this.userid = userid;
		 this.date = date;
		 this.numberoftickets = numberoftickets;
		 this.totalprice = totalprice;
	 }
	 
	 public String getbookingid() {
		 return bookingid;
	 }
	 
	 public void setbookingid(String bookingid) {
		 this.bookingid = bookingid;
	 }
	 
	 public String getattractionid() {
		 return attractionid;
	 }
	 
	 public void setattractionid(String attractionid) {
		 this.attractionid = attractionid;
	 }
	 
	 public String getattractionname() {
		 return attractionname;
	 }
	 
	 public void setattractionname(String attractionname) {
		 this.attractionname = attractionname;
	 }
	 
	 public String getuserid() {
		 return userid;
	 }
	 
	 public void setuserid(String userid) {
		 this.userid = userid;
	 }
	 
	 public String getdate() {
		 return date;
	 }
	 
	 public void setdate(String date) {
		 this.date = date;
	 }
	 
	 public String getnumberoftickets() {
		 return numberoftickets;
	 }
	 
	 public void setnumberoftickets(String numberoftickets) {
		 this.numberoftickets = numberoftickets;
	 }
	
	 public String gettotalprice() {
		 return totalprice;
	 }
	 
	 public void settotalprice(String totalprice) {
		 this.totalprice = totalprice;
	 }
	 protected String bookingid;
	 protected String attractionname;
	 protected String userid;
	 protected String date;
	 protected String numberoftickets;
	 protected String totalprice;
}
