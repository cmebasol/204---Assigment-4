
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the test file for the CourseDBManager which is implemented from the
 * CourseDBManagerInterface
 * 
 */
public class CourseDBStructureTestSTUDENT {
	CourseDBStructure courseDataStructure, trialStructure;

	@Before
	public void setUp() throws Exception {
		courseDataStructure = new CourseDBStructure(20);
		trialStructure = new CourseDBStructure("Example", 20);
	}

	@After
	public void tearDown() throws Exception {
		courseDataStructure = trialStructure = null;
	}

	/**
	 * Test the tableSize for CourseDBStructures constructed with both constructors
	 */
	@Test
	public void testGetTableSize() {
		assertEquals(19, courseDataStructure.getTableSize());
		assertEquals(20, trialStructure.getTableSize());
	}

	@Test
	public void testHashTable() {

		//Create a course 
		CourseDBElement courseDataElementOne = new CourseDBElement("CMSC500", 39999, 4, "SC100", "Nobody InParticular");
		
		courseDataStructure.add(courseDataElementOne);  //add to data structure
		courseDataStructure.add(courseDataElementOne);  // add it again. add method  should  ignore it
	 
		ArrayList<String> courseList = courseDataStructure.showAll(); 
		assertTrue(courseList.size()==1);  
		
		//Create another course
		CourseDBElement courseDataElementTwo = new CourseDBElement("CMSC600", 4000, 4, "SC100", "Nobody InParticular");
	 
 		try {
			assertEquals(39999, courseDataStructure.get(courseDataElementOne.getCRN()).getCRN());  
			courseDataStructure.get(courseDataElementTwo.getCRN()).getCRN(); // should throw exception
		} catch (IOException e) {

			assertTrue("threw Exception successfuly for the course not found", true);
		}
		
 		courseDataStructure.add(courseDataElementTwo);
 		courseList = courseDataStructure.showAll(); 
		assertTrue(courseList.size()==2);  
		
		try {
			assertEquals(4000, courseDataStructure.get(courseDataElementTwo.getCRN()).getCRN());
		} catch (IOException e) {
			 
			fail("Should not throw exception");
		}  
		CourseDBElement cde1Update = new CourseDBElement("CMSC500-updated", 39999, 4, "SC100", "updated");
		courseDataStructure.add(cde1Update);  //Same CRN updated information
 		courseList = courseDataStructure.showAll(); 
		assertTrue(courseList.size()==2);  
		
		try {
			assertEquals(39999, courseDataStructure.get(cde1Update.getCRN()).getCRN());
			assertEquals("CMSC500-updated", courseDataStructure.get(cde1Update.getCRN()).getID());
		} catch (IOException e) {
			 
			fail("Should not throw exception");
		}  
		trialStructure.add(courseDataElementOne); 
		courseList = trialStructure.showAll(); 
		assertTrue(courseList.size()==1); 
	}
}
