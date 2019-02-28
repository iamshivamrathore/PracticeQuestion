package dynamicProgramming.geeks;

public class ChoiceOfArea {

	static int calculate(int a, int b, char c) {
		int count = 0;

		if (a <= 0 || b <= 0) {
			return 0;
		} else {
			if (c == 'x') {
				System.out.print("x ");

				int y = calculate(a -5, b -10, 'y');
				int z = calculate(a +20, b -5, 'z');
				if (y > z) {
					System.out.print("Ans : y");
				} else {
					System.out.print("Ans : z");
				}
				count = 1 + Math.max(y, z);
//				if (calculate(a + 3, b + 2, 'y') > calculate(a + 3, b + 2, 'z')) {
//					count = 1 + Math.max(calculate(a + 3, b + 2, 'y'), calculate(a + 3, b + 2, 'z'));
//				}
			} else if (c == 'y') {
				System.out.print("y ");
				
				int x = calculate(a+3, b+2, 'x');
				int z = calculate(a +20, b -5, 'z');
				if(x>z) {
					System.out.print("Ans : x ");
				}else {
					System.out.print("Ans : z ");
				}
				
				count = 1 + Math.max(x, z);
				//count = 1 + Math.max(calculate(a - 5, b - 10, 'x'), calculate(a - 5, b - 10, 'z'));
			} else if (c == 'z') {
				System.out.print("z ");
				
				int x = calculate(a+3, b+2, 'x');
				int y = calculate(a -5, b -10, 'y');
				if(x>y) {
					System.out.print("Ans : x ");
				}else {
					System.out.print("Ans : y ");
				}
				
				count = 1+ Math.max(x, y);
			//	count = 1 + Math.max(calculate(a - 20, b + 5, 'y'), calculate(a - 20, b + 5, 'x'));
			}
		}
		System.out.print(count+"   ");
		return count;
	}

	public static void main(String[] args) {
		int a = 20;
		int b = 8;

		// System.out.println(Math.max(calculate(a, b, 'x'), Math.max(calculate(a, b,
		// 'y'), calculate(a, b, 'z'))));

		System.out.println(calculate(a+3, b+2	, 'x'));
	}

}
