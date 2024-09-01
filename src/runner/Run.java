package runner;

import java.io.FileNotFoundException;

import controller.Control;

public class Run {

	public static void main(String[] args) {
		try {
			new Control();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
