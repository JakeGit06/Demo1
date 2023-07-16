package com.obsqura.testscripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.obsqura.listeners.reportListners;

@Listeners(reportListners.class)
public class RegressionTest extends TestHelper {
	@Test
	public void f() {

	}
}
