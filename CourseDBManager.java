import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface{
	CourseDBStructure structure;
	/**
	 * no argument constructor
	 */
	public CourseDBManager() {
		structure = new CourseDBStructure(35);
	}
	
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		// TODO Auto-generated method stub
		structure.add(new CourseDBElement(id, crn, credits, roomNum, instructor));
//		System.out.println(structure.showAll() +"\n \n");
		
	}

	@Override
	public CourseDBElement get(int crn) {
		try {
			return structure.get(crn);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * Reads the information of courses from a test file and adds them
	 * to the CourseDBStructure data structure
	 * @param input input file 
	 * @throws FileNotFoundException if file does not exists
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {
		if (input == null ) {
			throw new FileNotFoundException();
		}
		Scanner read = new Scanner(input);
		while(read.hasNextLine()) {
			String [] temp = read.nextLine().split(" ");
			add(temp[0], Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), temp[3], temp[4]);
		}
	}
	/**
	 * @return an array list of string representation of each course in 
	 * the data structure separated by a new line. 
	 * Refer to the following example:
	 * Course:CMSC500 CRN:39999 Credits:4 Instructor:Nobody InParticular Room:SC100
	 * Course:CMSC600 CRN:4000 Credits:4 Instructor:Somebody Room:SC200
	 */
	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> ret = new ArrayList();
		for (int i = 0; i < structure.showAll().size(); i++) {
			ret.add("\n" + structure.showAll().get(i));
		}
		return ret;
	}

}
