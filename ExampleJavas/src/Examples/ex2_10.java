package Examples;

import java.util.Scanner;

public class ex2_10 {
	public static void main(String[] args) {
		int a,b,p,s,m,d,x,i;
		Scanner sc = new Scanner(System.in);
	    System.out.println("���� �� �� ���ڸ� �Է��Ͻÿ�.");
		a = sc.nextInt();
		b = sc.nextInt();
		System.out.println("�����ڸ� �����Ͻÿ�.\n1. +\n2. -\n3. *\n4. /\n5. %");
		i = sc.nextInt();
		p = a + b;
		s = a - b;
		m = a * b;
		d = a / b;
		x = a % b;
		if(i==1) {
			System.out.println("���� ���= " + p + "\n���α׷��� �����մϴ�.");
			System.exit(0);
		}
		else if(i==2) {
			System.out.println("���� ���= " + s + "\n���α׷��� �����մϴ�.");
			System.exit(0);
		}
		else if(i==3) {
			System.out.println("���� ���= " + m + "\n���α׷��� �����մϴ�.");
			System.exit(0);
		}
		else if(i==4) {
			System.out.println("���� ���= " + d + "\n���α׷��� �����մϴ�.");
			System.exit(0);
		}
		else if(i==5) {
			System.out.println("���� ���= " + s + "\n���α׷��� �����մϴ�.");
			System.exit(0);
		}
		else {
		System.out.println("�߸� �����̽��ϴ� ���α׷��� �����մϴ�.");
		System.exit(0);
		}
	}
}
