package Implementation;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 *	Algorithms -> Implementations -> Happy Ladybugs
 *	Easy
 */
public class HappyLadybugs {

	public static boolean isSame(String str) {
		boolean isSame = true;

		for (int i = 1; i < str.length() - 1; i++) {
			if (str.charAt(i) != str.charAt(i - 1)) {
				isSame = false;
				break;
			}
		}
		return isSame;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int t = scan.nextInt();

		for (int i = 0; i < t; i++) {

			int n = scan.nextInt();
			scan.nextLine();
			String str = scan.nextLine();

			// only one underscore
			if (str.length() == 1 && str.charAt(0) == '_') {
				System.out.println("YES");
			}
			// all same
			else if (isSame(str)) {
				System.out.println("YES");
			} else {

				// construct map

				HashMap<String, Integer> map = new HashMap();
				for (int j = 0; j < n; j++) {
					String s = String.valueOf(str.charAt(j));
					if (map.containsKey(s)) {
						int val = map.get(s);
						val++;
						map.remove(s);
						map.put(String.valueOf(s), val);
					} else {
						map.put(String.valueOf(s), 1);
					}

				}

				// System.out.println(map);

				int flag = 0;
				for (Entry<String, Integer> string : map.entrySet()) {

					if (flag == 1)
						break;
					String key = string.getKey();
					int value = string.getValue();

					// underscore is there but any char is only one

					if (value == 1
							&& !string.getKey().equals(String.valueOf('_'))) {
						System.out.println("NO");
						flag = 1;
						break;
					} else {
						for (int g = 1; g < n - 1; g++) {
							if (str.charAt(g) == str.charAt(g - 1)
									|| str.charAt(g) == str.charAt(g + 1)) {
							} else {
								if (str.contains(String.valueOf('_'))) {

								} else {
									if (map.size() == 1) {
									} else {
										System.out.println("NO");
										flag = 1;
										break;
									}

								}
							}
						}
					}

				}
				if (flag == 0)
					System.out.println("YES");

			}

		} // for closes

	}

}
