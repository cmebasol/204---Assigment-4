
public class CourseDBElement implements Comparable {

	private String ID;
	private int CRN;
	private int nCredits;
	private  String roomNumber;
	private String instructor;
	
	/**
	 * constructs course db element
	 * @param iD identification number
	 * @param cRN class room number
	 * @param nCredits number of credits
	 * @param roomNumber room number
	 * @param instructor instructor of the course
	 */
	public CourseDBElement(String iD, int cRN, int nCredits, String roomNumber, String instructor) {
		super();
		ID = iD;
		CRN = cRN;
		this.nCredits = nCredits;
		this.roomNumber = roomNumber;
		this.instructor = instructor;
	}
	/**
	 * gets the id number
	 * @return id number
	 */

	public String getID() {
		return ID;
	}
	/**
	 * sets the id number
	 * @param iD ID number
	 */

	public void setID(String iD) {
		ID = iD;
	}

	/**
	 * gets the class room number
	 * @return class room number
	 */
	public int getCRN() {
		return CRN;
	}

	/**
	 * sets the class room number
	 * @param cRN class room number
	 */
	public void setCRN(int cRN) {
		CRN = cRN;
	}

	/**
	 * gets the number of credits
	 * @return number of credits
	 */
	public int getnCredits() {
		return nCredits;
	}
	
	/**
	 * sets the number of credits
	 * @param nCredits number of credits
	 */
	public void setnCredits(int nCredits) {
		this.nCredits = nCredits;
	}

	/**
	 * gets the room number
	 * @return the room number
	 */
	public String getRoomNum() {
		return roomNumber;
	}

	/**
	 * sets the room number
	 * @param roomNumber the room number
	 */
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	/**
	 * gets the instructor name
	 * @return the instructor name
	 */
	public String getInstructor() {
		return instructor;
	}

	/**
	 * sets the instructor name
	 * @param instructor instructor name
	 */
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	/**
	 * it will compare based on the CRN
	 */
	@Override
	public int compareTo(Object o) {
		CourseDBElement other = (CourseDBElement) o;
		if (this.CRN == other.CRN)
			return 0;
		else if (this.CRN > other.CRN)
			return 1;
		else 
			return -1;
	
		
	}
	
	 //* Course:CMSC500 CRN:39999 Credits:4 Instructor:Nobody InParticular Room:SC100

	/**
	 * prints the courser db element's information
	 */
	@Override
	public String toString() {
		return "Course:" + this.ID + " CRN:" + this.CRN  + " Credits:" + this.nCredits + " Instructor:" + this.instructor + " Room:" + this.roomNumber;
	}

}
