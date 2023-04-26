import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyCalc implements ActionListener{
	private JFrame myFrame;
	private JButton one, two, three, four, five, six, seven, eight, nine, zero, add, sub, mul, div;
	private JTextField result;
	private int n1=-1, n2=-1, res=0;

	public static void main(String[] args) {
		MyCalc mc = new MyCalc();

	}
	
	public MyCalc() {
		myFrame = new JFrame("My Calculator");
		myFrame.setSize(500, 500);
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		myFrame.setLayout(gbl);
		
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridwidth=4;
		result = new JTextField(30);
		myFrame.add(result,gbc);
		
		gbc.gridwidth=1;
		gbc.gridx=0;
		gbc.gridy=1;
		one = new JButton("1");
		myFrame.add(one, gbc);
		one.addActionListener(this);
		
		gbc.gridwidth=1;
		gbc.gridx=1;
		gbc.gridy=1;
		two = new JButton("2");
		myFrame.add(two, gbc);
		two.addActionListener(this);
		
		gbc.gridwidth=1;
		gbc.gridx=2;
		gbc.gridy=1;
		three = new JButton("3");
		myFrame.add(three, gbc);
		three.addActionListener(this);
		
		gbc.gridwidth=1;
		gbc.gridx=3;
		gbc.gridy=1;
		add = new JButton("+");
		myFrame.add(add, gbc);
		add.addActionListener(this);
		
		gbc.gridwidth=1;
		gbc.gridx=0;
		gbc.gridy=2;
		four = new JButton("4");
		myFrame.add(four, gbc);
		four.addActionListener(this);
		
		gbc.gridwidth=1;
		gbc.gridx=1;
		gbc.gridy=2;
		five = new JButton("5");
		myFrame.add(five, gbc);
		five.addActionListener(this);
		
		gbc.gridwidth=1;
		gbc.gridx=2;
		gbc.gridy=2;
		six = new JButton("6");
		myFrame.add(six, gbc);
		six.addActionListener(this);
		
		gbc.gridwidth=1;
		gbc.gridx=3;
		gbc.gridy=2;
		sub = new JButton("-");
		myFrame.add(sub, gbc);
		sub.addActionListener(this);
		
		gbc.gridwidth=1;
		gbc.gridx=0;
		gbc.gridy=3;
		seven = new JButton("7");
		myFrame.add(seven, gbc);
		seven.addActionListener(this);
		
		gbc.gridwidth=1;
		gbc.gridx=1;
		gbc.gridy=3;
		eight = new JButton("8");
		myFrame.add(eight, gbc);
		eight.addActionListener(this);
		
		gbc.gridwidth=1;
		gbc.gridx=2;
		gbc.gridy=3;
		nine = new JButton("9");
		myFrame.add(nine, gbc);
		nine.addActionListener(this);
		
		gbc.gridwidth=1;
		gbc.gridx=3;
		gbc.gridy=3;
		mul = new JButton("*");
		myFrame.add(mul, gbc);
		mul.addActionListener(this);
		
		gbc.gridwidth=1;
		gbc.gridx=2;
		gbc.gridy=4;
		zero = new JButton("0");
		myFrame.add(zero, gbc);
		zero.addActionListener(this);
		
		gbc.gridwidth=1;
		gbc.gridx=3;
		gbc.gridy=4;
		div = new JButton("/");
		myFrame.add(div, gbc);
		div.addActionListener(this);
		
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}