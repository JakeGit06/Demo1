package MyPack;

import java.io.IOException;
public class ReadExcel {
	public static void main(String[] args) throws IOException {
		Excel e=new Excel();
		System.out.println("The Excel Sheet Data are:");
		for(int i=0;i<=2;i++) {
			for(int j=0;j<=1;j++) {
				System.out.print(e.readData(i, j)+"\t");
			}
			System.out.print("\n");
		}
		System.out.println("Ending of the pgm");
	}

}

