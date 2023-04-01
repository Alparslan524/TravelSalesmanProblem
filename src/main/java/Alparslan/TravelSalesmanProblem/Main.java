package Alparslan.TravelSalesmanProblem;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {

		String path = "C:\\\\\\\\campspring\\\\\\\\TravelSalesmanProblem\\\\\\\\src\\\\\\\\main\\\\\\\\java\\\\\\\\Alparslan\\\\\\\\TravelSalesmanProblem\\\\\\\\"
				+ "tsp_85900_1";
		ReadFromFile readFromFile = new ReadFromFile();

		ArrayList<Double> coordinatesXWithCityCount = readFromFile.getXCoordinates(path);// Şehir sayısı ile birliktye
																							// aldık
		ArrayList<Double> coordinatesY = readFromFile.getYCoordinates(path);
		ArrayList<Double> coordinatesX = new ArrayList<>(
				coordinatesXWithCityCount.subList(1, coordinatesXWithCityCount.size()));// şehir sayısını aldık ve
																						// sadece koordinatları tuttuk.
																						// Şehir Sayısı =
																						// coordinatesXWithCityCount.get(0)

		System.out.println("Reading Finished. Starting Calculate" + "\n");

		SolveTSP solveTSP = new SolveTSP(coordinatesX, coordinatesY);
		ArrayList<Integer> results = solveTSP.solveTSP(coordinatesXWithCityCount.get(0));
		for (Integer result : results) {
			System.out.println(result);
		}

	}
}
