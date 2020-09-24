package map;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class Map {

	private static int width;
	private static int height;
	private int[] indices; 							//Indices that match to certain tiles
	private boolean[] solids;						//Binary value of 0 or 1 - 0 means not solid, 1 means solid

//	array int indices
//	array boolean solids




	public Map(String path) {							
		
		
		
		File file = new File(path);
		try {
			Scanner readMap = new Scanner(file); 		//Allows for reading of the text file that contains map
			width = readMap.nextInt();
			height = readMap.nextInt();
			indices = new int[width * height];			//Sets the size of the two arrays
			solids = new boolean[width * height];
			int count = 0;
//			System.out.println(width);					//For testing purposes
//			System.out.println(height);
			while(readMap.hasNextInt()) {
				indices[count] = readMap.nextInt();
				int thanos = readMap.nextInt(); 		//thanos is temporary variable that converts binary 0 and 1 to false or true 
				if(thanos == 0) {
					solids[count] = false;
				}
				else {
					solids[count] = true;
				}
//				System.out.println(indices[count]);		//For testing purposes
//				System.out.println(solids[count]);
				count++;
			}
			readMap.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public int getIndex(int x, int y) {
		if(x >= 0 && x < width && y >= 0 && y < height) {
            return indices[y * width + x];
		}
		else {
			return 102970147; //If parameters aren't within the map, or there's an error of some sort
		}
	}

	public boolean getSolid(int x, int y) {
		if(x >= 0 && x < width && y >= 0 && y < height) {
            return solids[y * width + x];
		}
        return false;
	}


	public static int getW() {
		return width;
	}
	public static int getH() {
		return height;
	}
	
//	public static void main(String[] args) {
//        new Map("src/map/hometown.txt");		For testing purposes
//    }

}
