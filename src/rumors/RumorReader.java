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
			
			while (fIn.hasNextLine()){
				numBrokers = fIn.nextInt();
				if (numBrokers == 0){
					break;
				}
				brokerArray = new int[numBrokers][numBrokers];
				//System.out.println("The number of Brokers is: " + numBrokers);
				for (int i = 0; i < numBrokers; i++){
					for (int j = 0; j< numBrokers; j++){
						if (i == j){
							brokerArray[i][j] = 0;
						}
						else{
							brokerArray[i][j] = 99;
						}
					}
				}
					for (int x = 0; x < numBrokers; x++){
						int numContacts = fIn.nextInt();
						for (int y = 0; y < numContacts; y++){
								int broker = fIn.nextInt();
								int timeTo = fIn.nextInt();
								//System.out.println("The time to broker " + broker + " is: " + timeTo);
								brokerArray[x][broker-1] = timeTo;
						}
					}
					
					for (int i = 0; i < brokerArray.length; i++){
						System.out.println("");
						for(int j = 0; j < brokerArray.length; j++){
							System.out.print(brokerArray[i][j] + " ");
						}
					}
					System.out.println("");
					floydWarshall(brokerArray);
					findPath(brokerArray);
			}
		}
		public static void floydWarshall(int bArray[][]){
			int brokerArray[][] = bArray;
			int i;
			int j;
			int k;
			int towardsV = 0;
			for (i = 0; i < brokerArray.length; i++){
				for (j = 0; j < brokerArray.length; j++){
					for (k = 0; k < brokerArray.length; k++){
						towardsV = brokerArray[j][i] + brokerArray[i][k];
						if (towardsV < brokerArray[j][k]){
							brokerArray[j][k] = towardsV;
						}
					}
				}
			}
		}
		public static void findPath(int bArray[][]){
			int min = 99;
			int max = 0;
			int row = 0;
			int brokerArray[][] = bArray;
			for (int i = 0; i < brokerArray.length; i++){
				for (int j = 0; j < brokerArray.length; j++){
					if (brokerArray[i][j] > max){
						max = brokerArray[i][j];
					}
					if (min < max){
						min = max;
						row = i + 1;
					}
				}
			}
			System.out.println(row + " " + min);
			
		}
}