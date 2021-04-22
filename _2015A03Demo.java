import java.util.ArrayList;

/*
九数分三组

1~9的数字可以组成3个3位数，设为：A,B,C,  现在要求满足如下关系：
B = 2 * A
C = 3 * A

请你写出A的所有可能答案，数字间用空格分开，数字按升序排列。

注意：只提交A的值，严格按照格式要求输出。*/
//全排列
public class _03DemoTest {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				for (int k = 1; k <= 9; k++) {
					if(i != j && i != k && j != k) {
					list.add(i*100 + j*10 + k);	
					}
				}
			}	
		}
		for (int a = 0; a < list.size(); a++) {
			for (int b = 0; b < list.size(); b++) {
				if(list.get(b) == 2 * list.get(a) && check(list.get(b), list.get(a))) {
					for (int c = 0; c < list.size(); c++) {
						if(list.get(c) == 3 * list.get(a) && check(list.get(b), list.get(c))&& check(list.get(c), list.get(a))) {
							System.out.println("a: " + list.get(a) + " b: " + list.get(b) + " c: " + list.get(c)
							);
						}
					}
				}
			}
		}
		//192 219 273 327

	}
	
	static boolean check(int a,int b) {
		String stra = Integer.toString(a);
		String strb = Integer.toString(b);
		for (int i = 0; i < stra.length(); i++) {
			for (int j = 0; j < strb.length(); j++) {
				if(stra.charAt(i) == strb.charAt(j)) {
					return false;
				}
			}	
		}
		return true;
	}
}
