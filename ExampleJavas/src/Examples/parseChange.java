package Examples;

public class parseChange {
	public static void main(String[] args) {
		int i = 10;
		String binaryString = Integer.toBinaryString(i);
		System.out.println(binaryString);
		
		String octalString = Integer.toOctalString(i);
		System.out.println(octalString);
		
		i = 0xf;
		String hexString = Integer.toHexString(i);
		System.out.println(hexString);
	}
}
