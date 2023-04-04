import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface {

	int size;
	int tableSize;
	LinkedList<CourseDBElement> [] arr;
	ArrayList<String> info;
	
	/**
	 * returns the first 4k+3 number greater than the given guess of the number of elements the data structure will hold
	 * @param n guess of the number of elements the data structure will hold
	 * @param loadfactor a number that holds how full the array is before rehashing
	 * @return the first 4k+3 number greater than the given guess
	 */
	public static int fourKPlus3(int n, double loadfactor)
	{  boolean fkp3 = false;
	   boolean aPrime = false;
	   int prime, highDivisor, d;
	  

	   prime = (int)(n/loadfactor);
	   if(prime % 2 == 0) // if even make odd
	      prime = prime +1;

	   while(fkp3 == false) // not a 4k+3 prime
	   {  while(aPrime == false) // not a prime
	      {  highDivisor = (int)(Math.sqrt(prime) + 0.5);
	         for(d = highDivisor; d > 1; d--)
	         {  if(prime % d == 0)
	               break; // not a prime
	         }
	         if(d != 1) // prime not found
	            prime = prime + 2;
	         else
	            aPrime = true;
	      } // end of the prime search loop
	      if((prime - 3) % 4 == 0)
	         fkp3 = true;
	      else
	      {  prime = prime + 2;
	         aPrime = false;
	      }
	   } // end of 4k+3 prime search loop
	   return prime;
	}

	/**
	 * constructs a course db structure( single parameter)
	 * @param guess of the number of elements the data structure will hold
	 */
	public CourseDBStructure (int n) {
		tableSize = fourKPlus3(n,1.5);
		arr = new LinkedList[tableSize];
		size = 0;
		info = new ArrayList<String>();
				//LinkedList<CourseDBElement>[size];
		
		
	}
	
	/**
	 * constructs course db structure
	 * @param str string for testing purposes
	 * @param n guess of the number of elements the data structure will hold
	 */
	public CourseDBStructure(String str, int n) {
		
		tableSize = 20;
		arr = new LinkedList[tableSize];
		size = 0;
		info = new ArrayList<String>();


	}


	
	@Override
	public void add(CourseDBElement element) {
		boolean exists = false;
		// first convert the element.crn to string
		String str  = "" + element.getCRN();

		// get the hash code of the string and the index of the hashcode
		int index = str.hashCode()% tableSize;
		// if there is nothing create an arraylist and add it to it

		if (arr[index] == null) {
			arr[index] = new LinkedList<CourseDBElement>();
			info.add(element.toString());

		}
		else {
			for (int i = 0; i < arr[index].size(); i++) {//CourseDBElement each: arr[index]
				// if an element with the same crn exist in the structure update the information
				if (arr[index].get(i).compareTo(element) == 0) {
					arr[index].set(i, element);
					exists = true;
					
				}
			}
		}
		if (! (exists)) {
			arr[index].add(element);
			size++;
		}
		// if there s arraylist add it to the existing list
		
		
		
	}
	
	@Override
	public CourseDBElement get(int crn) throws IOException {
		//convert to string
		String str = "" + crn;
		// get the index
		int index = str.hashCode() % tableSize;
		// if there is, go through the linked list and look for the element using the crn
		if (arr[index] != null ){
			for (int i = 0; i < arr[index].size(); i ++ ) {
				if (arr[index].get(i).getCRN() == crn)
					return arr[index].get(i);
			}
			
		}
		//  if there the object at the index is null or the object is not in the liked list at that index throw exception
			throw new IOException();
		
	}

	@Override
	public ArrayList<String> showAll() {
		
		ArrayList<String>  ret = new ArrayList<String>();
		for (int i = 0; i < arr.length; i++ ) {
			if (arr[i] != null) {
				 for (CourseDBElement each: arr[i]) {
					 ret.add(each.toString());
				 }
			}
		}
		return ret;
	}
	

	@Override
	public int getTableSize() {
		return this.tableSize;
	}

}
