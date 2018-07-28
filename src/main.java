import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class main {
	static Map<String, HashMap<Integer, List<Object>>> rateMap = new HashMap<String, HashMap<Integer, List<Object>>>();
	static String rateMapKey = null;

	static HashMap<Integer, List<Object>> hMap = new HashMap<Integer, List<Object>>();
	static List<Object> value = new ArrayList<Object>();
	static Double rate = 0.0;
	static String effectiveFrom = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
	static String effectiveTo = "yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
			}
		}

	}

}
