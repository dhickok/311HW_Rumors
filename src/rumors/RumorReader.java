package rumors;
import java.io.*;
import java.util.*;
public class RumorReader {

		private static String fName = "U:\\workspace\\David_Hickok_HW2_331\\rumorsTest";
		
		public static void main(String[] args) throws FileNotFoundException{
			
			File f = new File(fName);
			Scanner fIn = new Scanner(f);
			int numBrokers = 0;
			int count = 0;
			
			while (fIn.hasNextLine()){
				count++;
				if (count == 1){
					numBrokers = fIn.nextInt();
					int[][] brokerArray = new int[numBrokers][numBrokers];
					System.out.println("The number of Brokers is: " + numBrokers);
				}
				else{
					int numContacts = fIn.nextInt();
					for (int i = 0; i < numContacts; i++){
						for (int j = 0; j < 2; j++){
							
						}
					}
					
				}
			}
		}
}