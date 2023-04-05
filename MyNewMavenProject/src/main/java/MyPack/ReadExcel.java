package MyPack;

import java.io.IOException;
public class ReadExcel {
	public static void main(String[] args) throws IOException {
		Excel e=new Excel();
		String a=e.readData(0, 0);
		System.out.println(a);
		String b=e.readData(0, 1);
		System.out.println(b);
		String c=e.readData(1, 0);
		System.out.println(c);
		String d=e.readData(1, 1);
		System.out.println(d);
	}

}

