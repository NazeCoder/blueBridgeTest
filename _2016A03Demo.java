/*
搭积木

小明最近喜欢搭数字积木，
一共有10块积木，每个积木上有一个数字，0~9。

搭积木规则：
每个积木放到其它两个积木的上面，并且一定比下面的两个积木数字小。
最后搭成4层的金字塔形，必须用完所有的积木。

下面是两种合格的搭法：

   0
  1 2
 3 4 5
6 7 8 9

   0
  3 1
 7 5 2
9 8 6 4

请你计算这样的搭法一共有多少种？

请填表示总数目的数字。
注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。



  */
public class _03DemoTest {
	
	static int[] array = {0,1,2,3,4,5,6,7,8,9};
	private static int sum = 0;
	
	public static void main(String[] args) {
		
		f(array,0);
		System.out.println(sum);
		
	}
	static void f(int[] array , int k) {
		if(k == array.length) {
			if(check(array)) {
				sum++;
			}
		}
		for (int i = k; i < array.length; i++) {
			swap(array,i,k);
			
			f(array,k+1);
			
			swap(array,i,k);
			
		}
	}
	
	static boolean check(int[] array) {
		if(array[1] < array[0] || array[2] < array[0] 
			|| array[3] < array[1] || array[4] < array[1] || array[4] < array[2] ||
			array[5] < array[2] || array[6] < array[3] || array[7] < array[3] ||
			array[7] < array[4] || array[8] < array[4] || array[8] < array[5] ||
			array[9] < array[5] ) {
			return false;
		}
		return true;
	}
  
  
	static void swap(int[] array,int a,int b) {
		int t = array[a];
		array[a] = array[b];
		array[b] = t;
	}

}
