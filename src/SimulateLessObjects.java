import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class SimulateLessObjects {
	static Map<String, HashMap<Integer, List<Object>>> rateMap = new HashMap<String, HashMap<Integer, List<Object>>>();
	static String rateMapKey = null;

	static HashMap<Integer, List<Object>> hMap = new HashMap<Integer, List<Object>>();
	static List<Object> value = new ArrayList<Object>();
	static Double rate = 0.0;
	static String effectiveFrom = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
	static String effectiveTo = "yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy";

	static HashMap<String, String> hMap2 = new HashMap<>();

	// create a sample column value
	public static Double colValue() {
		Double sampleRate = ThreadLocalRandom.current().nextDouble(0, 20000);
		sampleRate = round(sampleRate, 2);
		// System.out.println(sampleRate);

		return sampleRate;
	}

	public static String fullString() {

		// create a 99 column long string, delimited by comma;
		String fullString = "";

		for (int i = 0; i < 100; i++) {
			fullString = fullString + Double.toString(colValue()) + ",";
		}

		// remove the last comma
		fullString = fullString.substring(0, fullString.length() - 1);

		return fullString;

	}

	public static void main(String[] args) {

		// System.out.println(fullString);

		// simulate one sheet - 5000 lines and 99 columns

		// key = payment term + policy year + Sex, Smoker, Unique Identifier,
		// Effective From, Effective To
		// key - value, key = 10_5_M_N_(UI)_198764556544_177990980809

		String key = null;
		String simFullString = "";
		for (int i = 0; i < 500000000; i++) {

			key = "10_5_M_N_";

			key = key + String.valueOf(i) + "_198764556544_177990980809";
			simFullString = fullString();

			// System.out.println("key is " + key + ", index = " +
			// String.valueOf(i));
			// System.out.println("value is " + simFullString);

			hMap2.put(key, simFullString);

			if (i % 50000 == 0) {
				System.out.println("10 pages mate, well done!");
			}
		}

	}

	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	public static void main2(String[] args) {

		for (int i = 0; i < 1000000000; i++) {

			// what does the HashMap<Integer, List<Object>>> consists of?
			// Integer is the PolicyYear
			// List of Object is 1. Rate, 2. Effective From, 3. Effective To
			rate = ThreadLocalRandom.current().nextDouble(0, 10000);
			value.add(rate);
			value.add(effectiveFrom);
			value.add(effectiveTo);

			hMap.put(i, value);

			// rateMapKey =
			// Double.toString(ThreadLocalRandom.current().nextDouble(0,
			// 20000));
			rateMapKey = Integer.toString(1000000000 + 1);
			rateMap.put(rateMapKey, hMap);

			if (i % 100000 == 0) {
				System.out.println(i);

				// Get current size of heap in bytes
				long heapSize = Runtime.getRuntime().totalMemory();
				System.out.println("heapSize = " + heapSize);

				// Get maximum size of heap in bytes. The heap cannot grow
				// beyond this size.// Any attempt will result in an
				// OutOfMemoryException.
				long heapMaxSize = Runtime.getRuntime().maxMemory();
				System.out.println("heapMaxSize = " + heapMaxSize);

				// Get amount of free memory within the heap in bytes. This size
				// will increase // after garbage collection and decrease as new
				// objects are created.
				long heapFreeSize = Runtime.getRuntime().freeMemory();
				System.out.println("heapFreeSize = " + heapFreeSize);
			}
		}

	}

}
