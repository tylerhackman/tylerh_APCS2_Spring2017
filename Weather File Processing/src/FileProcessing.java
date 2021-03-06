import java.io.*;
import java.util.*;
public class FileProcessing {
	public static void main (String [] args) throws FileNotFoundException {
		Scanner input = new Scanner (new File("./resources/weather.txt"));
		double previous = input.nextDouble();
		double next = input.nextDouble();
		double change = previous - next;
		for(int i = 0; i < 7; i++){
			if (next < 0 || previous < 0 || previous < next || next < previous) {
				change*= -1;
			}
			change = (change*10.0)/10.0;
			System.out.print(previous + " to " + next + ", change = ");
			System.out.printf("%.1f\n", change);
			if(input.hasNextDouble()) {
				previous = next;
				next = input.nextDouble();
			}
	
			else {			
				if (input.hasNextLine()) {
					input.nextLine();
					previous = next;
					next = input.nextDouble();
				}
			}
			change = previous - next;
		}	
	}
}