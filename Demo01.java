package aDemoTest;

public class Demo01 {
//������ 1900 �� 2020 �У��ж��ٸ�������
	public static void main(String[] args) {
		method01(19000,200000);
		method02(19000,200000);
		method03(19000,200000);
		method04(19000,200000);
	}
	
	//һ���㷨
	public static void method01(int startNum,int endNum){
		long startTime = System.currentTimeMillis();
		int sum = 0;
		int temp=0;
		for(int i = startNum;i < endNum+1;i++) {
			for(int j = 2;j < i; j++) {
				if(i%j==0) {
					temp = j;
					break;	
				}
				temp=j;
			}
			if(temp==i-1) {
				sum++;
			}
		}
		
		System.out.println(sum);
		long endTime = System.currentTimeMillis();
		System.out.println("Time:" + (endTime-startTime));
	}
	
	//�����㷨
	public static void method02(int startNum,int endNum) {
		long startTime = System.currentTimeMillis();
		int sum1 = 0,sum2 = 0;
		for (int i = 2; i < startNum; i++) {
			if(i%2 == 0 && i != 2) continue;
		 	int temp = 0;
			for (int j =2 ; j < i/2; j++) {
				if(i%j == 0) {
					break;
				}else {
					temp++;
				}
			}
			if(temp == i/2-2) {
				sum1++;
			}
			
		}
		
		for (int i = 2; i < endNum; i++) {
			if(i%2 == 0 && i != 2) continue;
		 	int temp = 0;
			for (int j =2 ; j < i/2; j++) {
				if(i%j == 0) {
					break;
				}else {
					temp++;
				}
			}
			if(temp == i/2-2) {
				sum2++;
			}
		}
		System.out.println(sum2-sum1);
		long endTime = System.currentTimeMillis();
		System.out.println("Time:" + (endTime-startTime));
		
	}
	
	//�����㷨
	public static int method03(int num) {
		int sum = 0;
		for (int i = 2; i < num; i++) {
			if(i%2 == 0 && i != 2) continue;
			
		 	boolean temp = true;
			for (int j =2 ; j <=  Math.sqrt(i); j++) {
				if(i % j == 0) {
					temp = false;
					break;
				}
			}
			if(temp) {
				sum++;
			}
		}
		return sum;
	}
		public static void method03(int startNum,int endNum) {
			long startTime = System.currentTimeMillis();
			
			int sum1 = method03(startNum);
			int sum2 = method03(endNum);
			System.out.println(sum2-sum1);
			
			long endTime = System.currentTimeMillis();
			System.out.println("Time:" + (endTime-startTime));
			
		}
		
// ���ݰ���ɸ���Ľ��ۣ�Ҫ�õ���Ȼ��  N ���ڵ�ȫ������������Ѳ�����" ���θ���  N "�����������ı����޳���ʣ�µľ�������
		public static int method04(int num) {
			int sum = 0;
			
			int[] numType = new int[num];
			numType[0] = 1;
			double sqrtNum = Math.sqrt(num);
			for (int i = 2; i <= sqrtNum; i++) {
				for (int j = i*i; j < num; j+=i) {
					numType[j-1] = 1;
				}
			}
			for (int i = 0; i < numType.length; i++) {
				if(numType[i] == 0) sum++;
			}
			return sum;
		}
		
		public static void method04(int startNum,int endNum) {
			long startTime = System.currentTimeMillis();
			
			int sum1 = method04(startNum);
			int sum2 = method04(endNum);
			System.out.println(sum2-sum1);
			
			long endTime = System.currentTimeMillis();
			System.out.println("Time:" + (endTime-startTime));
		}
	
}


