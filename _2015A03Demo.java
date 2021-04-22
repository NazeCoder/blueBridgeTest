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
		
		ArraysList<Integer> list = list(9);
		returnABC(list);
		//A:192 219 273 327
		
		int[] temp = {1,2,3,4,5,6,7,8,9};
		f(temp,0);

	}
	
	static void returnABC(ArraysList<Integer> list){
		
		for (int a = 0; a < list.size(); a++) {
			for (int b = 0; b < list.size(); b++) {
				if(list.get(b) == 2 * list.get(a) && check(list.get(b), list.get(a))) {
					for (int c = 0; c < list.size(); c++) {
						if(list.get(c) == 3 * list.get(a) && check(list.get(b), list.get(c))&& check(list.get(c), list.get(a))) {
							System.out.println("a: " + list.get(a) + " b: " + list.get(b) + " c: " + list.get(c));
						}
					}
				}
			}
		}
	}
	static ArrayList<Integer> list(int a){
		ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 1; i <= a; i++) {
				for (int j = 1; j <= a; j++) {
					for (int k = 1; k <= a; k++) {
						if(i != j && i != k && j != k) {
						list.add(i*100 + j*10 + k);	
						}
					}
				}	
			}
		return list;
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
	
	static void f(int[] array,int k){
		if( k == 9) {
			int a = array[0] * 100 + array[1] * 10 + array[2];
			int b = array[3] * 100 + array[4] * 10 + array[5];
			int c = array[6] * 100 + array[7] * 10 + array[8];
			if(b == 2 * a && c == 3 * a) {
				System.out.println(a);
			}
		}
		for (int i = k; i < array.length; i++) {
			int t = array[i];
			array[i] = array[k];
			array[k] = t;
			
			f(array,k+1);
			
			t = array[i];
			array[i] = array[k];
			array[k] = t;
			 
		}
	}
}
