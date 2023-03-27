package Alparslan.TravelSalesmanProblem;

import java.util.ArrayList;

public class SolveTSP {

	private ArrayList<Double> XCoordinates;
	private ArrayList<Double> YCoordinates;

	public SolveTSP(ArrayList<Double> X, ArrayList<Double> Y) {
		this.XCoordinates = X;
		this.YCoordinates = Y;
		// Constructor injection
	}

	private double getDistance(int city1, int city2) {
		double x1 = XCoordinates.get(city1);
		double y1 = YCoordinates.get(city1);
		double x2 = XCoordinates.get(city2);
		double y2 = YCoordinates.get(city2);
		double dx = x2 - x1;
		double dy = y2 - y1;
		return Math.sqrt(dx * dx + dy * dy);
		// 2 Nokta arası uzaklık Hesaplama(Math.sqrt => Kök)
	}

	public ArrayList<Integer> solveTSP() {

		double cityNumber = XCoordinates.get(0);
		int numberOfCities = (int) Math.floor(cityNumber);
		XCoordinates = new ArrayList<>(XCoordinates.subList(1, XCoordinates.size()));
		YCoordinates = new ArrayList<>(YCoordinates.subList(1, YCoordinates.size()));
		// burada şehir sayısını aldık ve geri kalan koordinatları
		// tekrardan XCoordinates-YCoordinates'e aktardık

		boolean[] visited = new boolean[numberOfCities];
		visited[0] = true;// İlk şehir ziyaret edildi
		ArrayList<Integer> visitedCities = new ArrayList<>();
		visitedCities.add(0);

		double totalDistance = 0;
		int remainingCities = numberOfCities - 1;

		// Şehir kalmayana kadar git
		while (remainingCities > 0) {

			// En son ziyaret edilen şehir
			int lastIndex = visitedCities.get(visitedCities.size() - 1);

			// En yakın şehri ve mesafeyi bul
			int nearestCity = -1;
			double nearestDistance = Double.MAX_VALUE;
			for (int i = 0; i < numberOfCities; i++) {
				if (!visited[i]) {
					double distance = getDistance(lastIndex, i);
					if (distance < nearestDistance) {
						nearestCity = i;
						nearestDistance = distance;
					}
				}
			}

			// En yakın şehri ziyaret edildi olarak işaretle ve ziyaret edilen şehirler
			// listesine ekle
			visited[nearestCity] = true;
			visitedCities.add(nearestCity);

			totalDistance += nearestDistance;
			remainingCities--;
			// Mesafe toplam mesafeye ekleniyor
		}

		// Başlangıç Noktasına dönülüyor
		int lastCity = visitedCities.get(visitedCities.size() - 1);
		int startCity = visitedCities.get(0);
		double lastDistance = getDistance(lastCity, startCity);
		totalDistance += lastDistance;

		ArrayList<Integer> result = new ArrayList<>();
		result.add((int) totalDistance);
		for (int i = 0; i < visitedCities.size(); i++) {
			result.add(visitedCities.get(i));
		}
		return result;
	}
}
