package com.obsqura.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.utilities.ExcelUtility;

public class RegressionTest {
  @Test
  public void ExcelRead_Test() throws IOException {
	  ExcelUtility e=new ExcelUtility();
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
