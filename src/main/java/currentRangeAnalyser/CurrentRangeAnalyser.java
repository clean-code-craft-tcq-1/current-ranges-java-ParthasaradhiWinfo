package currentRangeAnalyser;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurrentRangeAnalyser {

	public Map<String, Integer> findRangeInList(List<Integer> currentRangeSeries) {
		Map<String, Integer> countOfNumbersInDifferentRanges = new HashMap<>();
		if (currentRangeSeries == null || currentRangeSeries.isEmpty()) {
			throw new NullPointerException("Series Should Not Be Empty or NULL");
		}
		if (currentRangeSeries.contains(null)) {
			throw new NullPointerException("Series Should Not Contian NULL Values");
		}

		Collections.sort(currentRangeSeries);

		int rangeStartValue = currentRangeSeries.get(0);
		int rangeEndValue = currentRangeSeries.get(0);
		int numbersInGivenRange = 1;

		int index = 0;
		for (Integer currentRange : currentRangeSeries) {

			if (index < currentRangeSeries.size() - 1) {
				if (currentRangeSeries.get(index + 1) - currentRange <= 1) {
					numbersInGivenRange++;
					rangeEndValue = currentRangeSeries.get(index + 1);
				} else {
					buildMap(countOfNumbersInDifferentRanges, rangeStartValue, rangeEndValue, numbersInGivenRange);
					numbersInGivenRange = 1;
					rangeStartValue = currentRangeSeries.get(index + 1);
				}
				if (index == (currentRangeSeries.size() - 2)) {
					buildMap(countOfNumbersInDifferentRanges, rangeStartValue, rangeEndValue, numbersInGivenRange);
				}
			}
			index++;
		}

		printRanges(countOfNumbersInDifferentRanges);
		return countOfNumbersInDifferentRanges;
	}

	private void printRanges(Map<String, Integer> countOfNumbersInDifferentRanges) {
		for (String keys : countOfNumbersInDifferentRanges.keySet()) {
			System.out.println(keys + ", " + countOfNumbersInDifferentRanges.get(keys));
		}

	}

	private void buildMap(Map<String, Integer> countOfNumbersInDifferentRanges, int rangeStartValue, int rangeEndValue,
			int numbersInGivenRange) {
		StringBuilder rangeString = new StringBuilder();
		rangeString.append(rangeStartValue);
		rangeString.append('-');
		rangeString.append(rangeEndValue);
		countOfNumbersInDifferentRanges.put(rangeString.toString(), numbersInGivenRange);
	}
}
