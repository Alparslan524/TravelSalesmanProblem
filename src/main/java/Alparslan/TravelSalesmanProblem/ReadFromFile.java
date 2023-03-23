package Alparslan.TravelSalesmanProblem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFromFile {

	public ArrayList<Double> getXCoordinates(String path) {

		ArrayList<Double> xCoords = new ArrayList<Double>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while ((line = br.readLine()) != null) {
				String[] coordinates = line.split(" "); // koordinatları boşluk karakterine göre ayrırdık
				double x = Double.parseDouble(coordinates[0]);
				xCoords.add(x);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return xCoords;
	}

	public ArrayList<Double> getYCoordinates(String path) {

		ArrayList<Double> xCoords = new ArrayList<Double>();
		ArrayList<Double> yCoords = new ArrayList<Double>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while ((line = br.readLine()) != null) {
				String[] coordinates = line.split(" ");
				double x = Double.parseDouble(coordinates[0]);
				double y = Double.parseDouble(coordinates[1]);
				xCoords.add(x);
				yCoords.add(y);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return yCoords;
	}
}
