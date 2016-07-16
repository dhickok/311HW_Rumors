package rumors;
import java.io.*;
import java.util.*;
public class RumorReader {

		private static String fName = "U:\\workspace\\David_Hickok_HW2_331\\rumorsTest";
		
		public static void main(String[] args) throws FileNotFoundException{
			
			File f = new File(fName);
			Scanner fIn = new Scanner(f);
			int[][] brokerArray = null;
			int numBrokers = 0;
			int count = 0;
			
			while (fIn.hasNextLine()){
				numBrokers = fIn.nextInt();
				brokerArray = new int[numBrokers][numBrokers];
				System.out.println("The number of Brokers is: " + numBrokers);
				int row = 0;
					for (int x = 0; x < numBrokers; x++){
						int numContacts = fIn.nextInt();
						for (int i = 0; i < numContacts; i++){
								int broker = fIn.nextInt();
								int timeTo = fIn.nextInt();
								//System.out.println("The broker # is: " + broker);
								System.out.println("The time to broker " + broker + " is: " + timeTo);
								brokerArray[x][broker-1] = timeTo;
						}
						//numContacts = 0;
						
					}
					for (int i = 0; i < brokerArray.length; i++){
						System.out.println("");
						for(int j = 0; j < brokerArray.length; j++){
							System.out.print(brokerArray[i][j]);
						}
					}
					System.out.println("");
			}
		}
}