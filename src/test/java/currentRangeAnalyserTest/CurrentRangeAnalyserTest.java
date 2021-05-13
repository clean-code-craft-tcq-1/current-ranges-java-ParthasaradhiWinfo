package currentRangeAnalyserTest;

import org.junit.Test;

import currentRangeAnalyser.CurrentRangeAnalyser;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CurrentRangeAnalyserTest {

	@Test(expected = NullPointerException.class)
	public void nullCheck() {

		new CurrentRangeAnalyser().findRangeInList(null);

	}

	@Test(expected = NullPointerException.class)
	public void nullWithIsEmpty() {

		new CurrentRangeAnalyser().findRangeInList(new ArrayList<Integer>());

	}

	@Test(expected = NullPointerException.class)
	public void nullCheckBypassingNullInList() {
		List<Integer> numberSeries = new ArrayList<Integer>();
		numberSeries.add(10);
		numberSeries.add(null);
		new CurrentRangeAnalyser().findRangeInList(new ArrayList<Integer>());
	}

	@Test
	public void findTheCountOfNumbersInEachRange() {
		Map<String, Integer> countOfNumbersInDifferentRanges = new CurrentRangeAnalyser()
				.findRangeInList(Arrays.asList(3, 3, 5, 4, 10, 11, 12));
		assertTrue(countOfNumbersInDifferentRanges.get("3-5") == 4);
		assertTrue(countOfNumbersInDifferentRanges.get("10-12") == 3);
	}

	
}
