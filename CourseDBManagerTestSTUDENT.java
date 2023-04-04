

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the test file for the CourseDBManager
 * which is implemented from the CourseDBManagerInterface
 * 
 */
public class CourseDBManagerTestSTUDENT {
	private CourseDBManagerInterface dataManagerOne = new CourseDBManager();

	/**
	 * Create an instance of CourseDBManager
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		dataManagerOne = new CourseDBManager();
	}

	/**
	 * Set dataManagerOne reference to null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		dataManagerOne = null;
	}

	/**
	 * Test for the add method
	 */
	@Test
	public void testAddToDB() {
		try {
			dataManagerOne.add("MATH207",30504,4,"SW483","Monshi Kayed");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	/**
	 * Test for the showAll method
	 */
	@Test
	public void testShowAll() {
		dataManagerOne.add("MATH207",30504,4,"SW483","Monshi Kayed");
//		System.out.println(dataManagerOne.showAll());
		dataManagerOne.add("MATH207",30503,4,"SW483","Jill B. Who-Dunit");
		dataManagerOne.add("CMSC204",30559,4,"SW483","BillyBob Jones");

		ArrayList<String> listHolder = dataManagerOne.showAll();
		assertEquals("\nCourse:MATH207 CRN:30503 Credits:4 Instructor:Jill B. Who-Dunit Room:SW483",listHolder.get(0));
	 	assertEquals("\nCourse:CMSC204 CRN:30559 Credits:4 Instructor:BillyBob Jones Room:SW483",listHolder.get(1));
//	 	assertEquals("got","expected");

		assertEquals("\nCourse:MATH207 CRN:30504 Credits:4 Instructor:Monshi Kayed Room:SW483",listHolder.get(2));
	}
	
	/**
	 * Test for the read method
	 */
	@Test
	public void testRead() {
		try {
			File inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("MATH207 30504 4 SW483 Monshi Kayed");
			inFile.print("CMSC204 30503 4 SW483 Jill B. Who-Dunit");
			
			inFile.close();
			dataManagerOne.readFile(inputFile);
			assertEquals("MATH207",dataManagerOne.get(30504).getID());
			assertEquals("CMSC204",dataManagerOne.get(30503).getID());
			assertEquals("SW483",dataManagerOne.get(30503).getRoomNum());
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
}
