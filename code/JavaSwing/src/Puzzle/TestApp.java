package Puzzle;

import java.awt.EventQueue;

public class TestApp {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				Puzzle puzzle = new Puzzle();
				puzzle.setVisible(true);
			}
		});
	}
}
