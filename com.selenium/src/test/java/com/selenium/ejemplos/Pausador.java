package com.selenium.ejemplos;

public class Pausador {
	public static void pausa(int x) {
		try {
			Thread.sleep(x * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
