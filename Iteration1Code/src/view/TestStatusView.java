package view;

import java.awt.*;

import javax.swing.*;

import model.*;

import java.awt.Toolkit;

public class TestStatusView extends JFrame{
	
	private StatusView statusView;
	
	public TestStatusView() {
		statusView = new StatusView(new Avatar(new Alchemist()));
		System.out.println("whee");
		add(statusView);
	}
	
	public static void main(String[] args) {
		TestStatusView tsv = new TestStatusView();
		tsv.setSize(1000,230);
		tsv.setVisible(true);
		tsv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
