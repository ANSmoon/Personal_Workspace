package com.ssafy.di4_의존성주입;

import java.util.Scanner;

public class test2 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		programmer p = new programmer();
		
		Computer computer = ComputerFactory.getComputer(scanner.next());
		p.setComputer(computer);
		
		p.coding();
		
		while(true) {
			p.setComputer(ComputerFactory.getComputer(scanner.next()));
			p.coding();
		}
	}
}