package Examples;

import java.util.Scanner;

public class ex2_10 {
	public static void main(String[] args) {
		int a,b,p,s,m,d,x,i;
		Scanner sc = new Scanner(System.in);
	    System.out.println("연산 할 두 숫자를 입력하시오.");
		a = sc.nextInt();
		b = sc.nextInt();
		System.out.println("연산자를 선택하시오.\n1. +\n2. -\n3. *\n4. /\n5. %");
		i = sc.nextInt();
		p = a + b;
		s = a - b;
		m = a * b;
		d = a / b;
		x = a % b;
		if(i==1) {
			System.out.println("연산 결과= " + p + "\n프로그램을 종료합니다.");
			System.exit(0);
		}
		else if(i==2) {
			System.out.println("연산 결과= " + s + "\n프로그램을 종료합니다.");
			System.exit(0);
		}
		else if(i==3) {
			System.out.println("연산 결과= " + m + "\n프로그램을 종료합니다.");
			System.exit(0);
		}
		else if(i==4) {
			System.out.println("연산 결과= " + d + "\n프로그램을 종료합니다.");
			System.exit(0);
		}
		else if(i==5) {
			System.out.println("연산 결과= " + s + "\n프로그램을 종료합니다.");
			System.exit(0);
		}
		else {
		System.out.println("잘못 눌르셨습니다 프로그램을 종료합니다.");
		System.exit(0);
		}
	}
}
