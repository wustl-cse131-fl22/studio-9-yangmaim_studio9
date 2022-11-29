package studio9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import support.cse131.NotYetImplementedException;

public class NameToHeight {
	/**
	 * Construct and fill a map with your studio group members' names, each
	 * associated with his or her height.
	 * 
	 * Construct an ArgsProcessor and loop asking the args processor for a name to
	 * lookup the height. When the user cancels (that is: when args processor
	 * returns null), break from the loop. Otherwise, loop up the name in the map
	 * and output the results. Be sure to handle the case where the map does not
	 * contain a specified name.
	 */

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		Map<String, Double> a = new HashMap();
		a.put("Yang", 180.0);
		a.put("Ma", 180.0);
		a.put("Im", 178.0);
		a.put("Yang1", 173.0);
		
		while (true) {
			System.out.print("Name? :");
			String name = in.next();
			Double height = a.get(name);
			
			if (height != null) {
				System.out.println("name: " + name + "     height: " + height);
			} else {
				break;
			}	
		}
	}
}
