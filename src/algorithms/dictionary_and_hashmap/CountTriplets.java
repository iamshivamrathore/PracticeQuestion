package algorithms.dictionary_and_hashmap;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class CountTriplets {

	static long countTriplets(List<Long> arr, long r) {

		long ans = 0;
		// System.out.println(arr);

		Map<Long, Long> countMap = new HashMap<>();

		for (int i = 0; i < arr.size(); i++) {
			Long l = arr.get(i);
			if (!countMap.containsKey(l)) {
				countMap.put(l, 1l);
			} else {
				countMap.put(l, countMap.get(l) + 1);
				arr.remove(l);
				i--;
			}
		}
		// System.out.println(arr);
		// System.out.println(countMap);
		Iterator<Long> it = arr.iterator();
		long num1 = it.next();
		long count1 = countMap.get(num1);
		
		if(countMap.size() == 1) {
			
		}
		long num2 = it.next();
		long count2 = countMap.get(num2);
		while (it.hasNext()) {
			long num3 = it.next();
			long count3 = countMap.get(num3);
			if (num2 / num1 == num3 / num2) {
				// System.out.print("Num1 : " + num1 + " Count1 : " + count1);
				// System.out.print("\tNum2 : " + num2 + " Count2 : " + count2);
				// System.out.println("\tNum3 : " + num3 + " Count3 : " + count3);
				ans += count1 * count2 * count3;

			}

			num1 = num2;
			count1 = count2;
			num2 = num3;
			count2 = count3;
		}
	//	System.out.println(countMap);
		return ans;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(nr[0]);
		
		long r = Long.parseLong(nr[1]);

		List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Long::parseLong)
				.collect(toList());

		long ans = countTriplets(arr, r);

		System.out.println("Ans : " + ans);
		// bufferedWriter.write(String.valueOf(ans));
		// bufferedWriter.newLine();

		bufferedReader.close();
		// bufferedWriter.close();

	}

}
