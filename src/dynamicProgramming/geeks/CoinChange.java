package dynamicProgramming.geeks;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {

	static long recursive(int coins[], int sum, int pos) {
		if (sum == 0) {
			return 1;
		}

		if (sum < 0) {
			return 0;
		}

		if (pos <= 0 && sum > 0) {
			return 0;
		}

		return recursive(coins, sum, pos - 1) + recursive(coins, sum - coins[pos - 1], pos);
	}

	static long withDP(int coins[], int sum, int pos, Map<String, Long> map) {

		if (map.containsKey(sum + ":" + pos)) {
			return map.get(sum + ":" + pos);
		} else {
			if (sum == 0) {

				return 1;
			}

			if (pos <= 0 && sum > 0) {
				return 0;
			}

			if (sum < 0) {
				return 0;
			}

			map.put(sum + ":" + pos,
					(withDP(coins, sum, pos - 1, map) + (withDP(coins, sum - coins[pos - 1], pos, map))));
			return map.get(sum + ":" + pos);
		}

	}

	public static void main(String[] args) {
		int arr[] = { 1, 2,3  };
		int sum = 4;
//		System.out.println(recursive(arr, sum, arr.length));

		Map<String, Long> map = new HashMap<String, Long>();
		System.out.println(withDP(arr, sum, arr.length, map));

	}

}
