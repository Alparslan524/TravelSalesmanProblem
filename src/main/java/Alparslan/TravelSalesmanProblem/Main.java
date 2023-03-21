package Alparslan.TravelSalesmanProblem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		double[][] dizi = new double[5][2];
		int row = 0; // satır sayacı
		try {
			BufferedReader br = new BufferedReader(new FileReader(
					"C:\\\\\\\\campspring\\\\\\\\TravelSalesmanProblem\\\\\\\\src\\\\\\\\main\\\\\\\\java\\\\\\\\Alparslan\\\\\\\\TravelSalesmanProblem\\\\\\\\coordinates.txt")); // dosyayı
																																													// okuyoruz
			String line;
			while ((line = br.readLine()) != null) { // dosyanın sonuna kadar satır satır okuyoruz
				String[] coordinates = line.split(" "); // her satırdaki koordinatları boşluk karakterine göre
														// ayırıyoruz
				for (int i = 0; i < coordinates.length; i++) {
					double value = Double.parseDouble(coordinates[i]); // koordinat değerlerini double türüne
																		// çeviriyoruz
					dizi[row][i] = value; // koordinatları dizinin ilgili satır ve sütunlarına atıyoruz
				}
				row++; // bir sonraki satıra geçiyoruz
			}
			br.close(); // dosyayı kapatıyoruz
		} catch (IOException e) {
			e.printStackTrace();
		}
		// dizi elemanlarını ekrana yazdırıyoruz
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < 1; j++) {
				System.out.println(dizi[i][0] + "    " + dizi[i][1]);
			}
		}

	}
}