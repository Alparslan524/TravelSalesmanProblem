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

		ArrayList<Double> yCoords = new ArrayList<Double>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			int count = 0; // koordinat sayısını tutmak için değişken oluşturduk
			while ((line = br.readLine()) != null) {
				String[] coordinates = line.split(" ");
				if (count != 0) {
					// Count sıfırken ilk satırı okuyor sonra countun sayısını değiştiriyor ve 
					// döngü bitiyor bir sonraki while döngüsüne giriyor yani alt satıra geçmiş oluyor
					// Böylelikle İlk satırdaki verinin tek veri olması etkilemiyor. yCoords'a aktarmaya 2.satırdan itibaren başlıyor
					double y = Double.parseDouble(coordinates[1]);
					yCoords.add(y);
				} else {
					count = Integer.parseInt(coordinates[0]);
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return yCoords;
	}
}
