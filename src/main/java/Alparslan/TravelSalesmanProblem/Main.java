package Alparslan.TravelSalesmanProblem;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {

		String path = "C:\\\\\\\\campspring\\\\\\\\TravelSalesmanProblem\\\\\\\\src\\\\\\\\main\\\\\\\\java\\\\\\\\Alparslan\\\\\\\\TravelSalesmanProblem\\\\\\\\"
				+ "tsp_5915_1";
		ReadFromFile readFromFile = new ReadFromFile();
		ArrayList<Double> coordinatesX = readFromFile.getXCoordinates(path);
		ArrayList<Double> coordinatesY = readFromFile.getYCoordinates(path);

		System.out.println("Reading Finished. Starting Calculate" + "\n");

		SolveTSP solveTSP = new SolveTSP(coordinatesX, coordinatesY);
		ArrayList<Integer> results = solveTSP.solveTSP();
		for (Integer result : results) {
			System.out.println(result);
		}

	}
}
