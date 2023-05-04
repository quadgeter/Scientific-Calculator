import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.InputMismatchException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class CalculatorGUI extends JFrame implements ActionListener, FocusListener, KeyListener{
	private JPanel basicPanel, advanced;
	private JTextArea opField, ansField;
	private JButton one, two, three, four, five, six, seven, eight, nine, zero, dot, plusMinus, percent, mod, clear, plus, minus;
	private JButton multiply, divide, squareRoot, square, cube, equals, sin, tan, cos, asin, atan, acos, sinh, tanh, cosh;
	private JButton oneOverN, log, ln, tenRoot, exit;
	private double num1, num2 = 0;
	private String opString = "";
	private Evaluator calc;
	

		public CalculatorGUI() {
			setTitle("Calculator");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLayout(new GridLayout(2, 1));
			getContentPane().setBackground(Color.BLACK);
			
			calc = new Evaluator();
			basicPanel = new JPanel();
			basicPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			basicPanel.setBackground(Color.BLACK);
			basicPanel.setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			gbc.fill = GridBagConstraints.BOTH;
			add(basicPanel);
			
			opField = new JTextArea();
			Border border = BorderFactory.createLineBorder(Color.BLACK);
			opField.setBorder(border);
			gbc.gridy = 0;
			gbc.gridwidth = 4;
			basicPanel.add(opField, gbc);
			opField.addFocusListener(this);
			opField.addKeyListener(this);

			
			ansField = new JTextArea();
			ansField.setBorder(border);
			gbc.gridy = 1;
			gbc.gridheight = 2;
			gbc.gridwidth = 4;
			basicPanel.add(ansField, gbc);
			
			gbc.gridheight = 1;
			gbc.gridwidth = 1;
			
			one = new JButton("1");
			one.setBackground(Color.darkGray);
			one.setForeground(Color.white);
			gbc.gridx = 0;
			gbc.gridy = 3;
			basicPanel.add(one, gbc);
			one.addActionListener(this);
			
			two = new JButton("2");
			gbc.gridx = 1;
			gbc.gridy = 3;
			two.setBackground(Color.darkGray);
			two.setForeground(Color.white);
			basicPanel.add(two, gbc);
			two.addActionListener(this);
			
			three = new JButton("3");
			three.setBackground(Color.darkGray);
			three.setForeground(Color.white);
			gbc.gridx = 2;
			gbc.gridy = 3;
			basicPanel.add(three, gbc);
			three.addActionListener(this);
			
			four = new JButton("4");
			four.setBackground(Color.darkGray);
			four.setForeground(Color.white);
			gbc.gridx = 0;
			gbc.gridy = 4;
			basicPanel.add(four, gbc);
			four.addActionListener(this);
			
			five = new JButton("5");
			five.setBackground(Color.darkGray);
			five.setForeground(Color.white);
			gbc.gridx = 1;
			gbc.gridy = 4;
			basicPanel.add(five, gbc);
			five.addActionListener(this);
			
			six = new JButton("6");
			six.setBackground(Color.darkGray);
			six.setForeground(Color.white);
			gbc.gridx = 2;
			gbc.gridy = 4;
			basicPanel.add(six, gbc);
			six.addActionListener(this);
			
			seven = new JButton("7");
			seven.setBackground(Color.darkGray);
			seven.setForeground(Color.white);
			gbc.gridx = 0;
			gbc.gridy = 5;
			basicPanel.add(seven, gbc);
			seven.addActionListener(this);
			
			eight = new JButton("8");
			eight.setBackground(Color.darkGray);
			eight.setForeground(Color.white);
			gbc.gridx = 1;
			gbc.gridy = 5;
			basicPanel.add(eight, gbc);
			eight.addActionListener(this);
			
			nine = new JButton("9");
			nine.setBackground(Color.darkGray);
			nine.setForeground(Color.white);
			gbc.gridx = 2;
			gbc.gridy = 5;
			basicPanel.add(nine, gbc);
			nine.addActionListener(this);
			
			zero = new JButton("0");
			zero.setBackground(Color.darkGray);
			zero.setForeground(Color.white);
			gbc.gridx = 1;
			gbc.gridy = 6;
			basicPanel.add(zero, gbc);
			zero.addActionListener(this);
			
			dot = new JButton(".");
			dot.setBackground(Color.darkGray);
			dot.setForeground(Color.white);
			gbc.gridx = 0;
			gbc.gridy = 6;
			basicPanel.add(dot, gbc);
			dot.addActionListener(this);
			
			plusMinus = new JButton("±");
			plusMinus.setBackground(Color.darkGray);
			plusMinus.setForeground(Color.white);
			gbc.gridy = 6;
			gbc.gridx = 2;
			basicPanel.add(plusMinus, gbc);
			plusMinus.addActionListener(this);
			
			clear = new JButton("C");
			clear.setBackground(Color.red);
			clear.setForeground(Color.black);
			gbc.gridx = 3;
			gbc.gridy = 3;
			basicPanel.add(clear, gbc);
			clear.addActionListener(this);
			
			plus = new JButton("+");
			plus.setBackground(Color.darkGray);
			plus.setForeground(Color.white);
			gbc.gridx = 3;
			gbc.gridy = 4;
			basicPanel.add(plus, gbc);
			plus.addActionListener(this);
			
			minus = new JButton("-");
			minus.setBackground(Color.darkGray);
			minus.setForeground(Color.white);
			gbc.gridx = 3;
			gbc.gridy = 5;
			gbc.gridwidth = 2;
			basicPanel.add(minus, gbc);
			minus.addActionListener(this);
			
			multiply = new JButton("x");
			multiply.setBackground(Color.darkGray);
			multiply.setForeground(Color.white);
			gbc.gridx = 3;
			gbc.gridy = 6;
			gbc.gridwidth = 2;
			basicPanel.add(multiply, gbc);
			multiply.addActionListener(this);
			
			gbc.gridwidth = 1;
		
			percent = new JButton("%");
			percent.setBackground(Color.darkGray);
			percent.setForeground(Color.white);
			gbc.gridx = 0;
			gbc.gridy = 7;
			basicPanel.add(percent, gbc);
			percent.addActionListener(this);
			
			squareRoot = new JButton("√");
			squareRoot.setBackground(Color.darkGray);
			squareRoot.setForeground(Color.white);
			gbc.gridx = 1;
			gbc.gridy = 7;
			basicPanel.add(squareRoot, gbc);
			squareRoot.addActionListener(this);
			
			square = new JButton("x²");
			square.setBackground(Color.darkGray);
			square.setForeground(Color.white);
			gbc.gridx = 2;
			gbc.gridy = 7;
			basicPanel.add(square, gbc);
			square.addActionListener(this);
			
			divide = new JButton("/");
			divide.setBackground(Color.darkGray);
			divide.setForeground(Color.white);
			gbc.gridx = 3;
			gbc.gridy = 7;
			basicPanel.add(divide, gbc);
			divide.addActionListener(this);
			
			mod = new JButton("mod");
			mod.setBackground(Color.darkGray);
			mod.setForeground(Color.white);
			gbc.gridx = 0;
			gbc.gridy = 8;
			basicPanel.add(mod, gbc);
			mod.addActionListener(this);
			
			cube = new JButton("x³");
			cube.setBackground(Color.darkGray);
			cube.setForeground(Color.white);
			gbc.gridx = 1;
			gbc.gridy = 8;
			basicPanel.add(cube, gbc);
			cube.addActionListener(this);
			
			equals = new JButton("=");
			equals.setBackground(Color.green);
			equals.setForeground(Color.black);
			gbc.gridx = 2;
			gbc.gridy = 8;
			gbc.gridwidth = 2;
			basicPanel.add(equals, gbc);
			equals.addActionListener(this);
		
			gbc.gridwidth = 1;
			
			advanced = new JPanel();
			advanced.setBackground(Color.BLACK);
			advanced.setLayout(new GridBagLayout());
			advanced.setBorder(new EmptyBorder(5, 5, 5, 5));
			gbc = new GridBagConstraints();
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			gbc.fill = GridBagConstraints.BOTH;
			add(advanced);
			
			sin = new JButton("sin");
			sin.setBackground(Color.darkGray);
			sin.setForeground(Color.white);
			gbc.gridx = 0;
			gbc.gridy = 1;
			advanced.add(sin, gbc);
			sin.addActionListener(this);
			
			tan = new JButton("tan");
			tan.setBackground(Color.darkGray);
			tan.setForeground(Color.white);
			gbc.gridx = 1;
			gbc.gridy = 1;
			advanced.add(tan, gbc);
			tan.addActionListener(this);
			
			cos = new JButton("cos");
			cos.setBackground(Color.darkGray);
			cos.setForeground(Color.white);
			gbc.gridx = 2;
			gbc.gridy = 1;
			advanced.add(cos, gbc);
			cos.addActionListener(this);
			
			log = new JButton("log");
			log.setBackground(Color.darkGray);
			log.setForeground(Color.white);
			gbc.gridx = 3;
			gbc.gridy = 1;
			advanced.add(log, gbc);
			log.addActionListener(this);
			
			ln = new JButton("ln");
			ln.setBackground(Color.darkGray);
			ln.setForeground(Color.white);
			gbc.gridx = 4;
			gbc.gridy = 1;
			advanced.add(ln, gbc);
			ln.addActionListener(this);
			
			asin = new JButton("asin");
			asin.setBackground(Color.darkGray);
			asin.setForeground(Color.white);
			gbc.gridx = 0;
			gbc.gridy = 2;
			advanced.add(asin, gbc);
			asin.addActionListener(this);
			
			atan = new JButton("atan");
			atan.setBackground(Color.darkGray);
			atan.setForeground(Color.white);
			gbc.gridx = 1;
			gbc.gridy = 2;
			advanced.add(atan, gbc);
			atan.addActionListener(this);
			
			acos = new JButton("acos");
			acos.setBackground(Color.darkGray);
			acos.setForeground(Color.white);
			gbc.gridx = 2;
			gbc.gridy = 2;
			advanced.add(acos, gbc);
			acos.addActionListener(this);
			
			tenRoot = new JButton("10^n");
			tenRoot.setBackground(Color.darkGray);
			tenRoot.setForeground(Color.white);
			gbc.gridx = 3;
			gbc.gridy = 2;
			advanced.add(tenRoot, gbc);
			tenRoot.addActionListener(this);
			
			oneOverN = new JButton("1/n");
			oneOverN.setBackground(Color.darkGray);
			oneOverN.setForeground(Color.white);
			gbc.gridx = 4;
			gbc.gridy = 2;
			advanced.add(oneOverN, gbc);
			oneOverN.addActionListener(this);
			
			sinh = new JButton("sinh");
			sinh.setBackground(Color.darkGray);
			sinh.setForeground(Color.white);
			gbc.gridx = 0;
			gbc.gridy = 3;
			advanced.add(sinh, gbc);
			sinh.addActionListener(this);
			
			tanh = new JButton("tanh");
			tanh.setBackground(Color.darkGray);
			tanh.setForeground(Color.white);
			gbc.gridx = 1;
			gbc.gridy = 3;
			advanced.add(tanh, gbc);
			tanh.addActionListener(this);
			
			cosh = new JButton("cosh");
			cosh.setBackground(Color.darkGray);
			cosh.setForeground(Color.white);
			gbc.gridx = 2;
			gbc.gridy = 3;
			advanced.add(cosh, gbc);
			cosh.addActionListener(this);
			
			exit = new JButton("EXIT");
			exit.setBackground(Color.darkGray);
			exit.setForeground(Color.white);
			gbc.gridx = 3;
			gbc.gridy = 3;
			gbc.gridwidth = 2;
			advanced.add(exit, gbc);
			exit.addActionListener(this);
			
			gbc.gridwidth = 1;
			
			setSize(400, 450);
			setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String buttonText = ((JButton)e.getSource()).getText();
			
			switch (buttonText) {
				case "1":
					opField.append("1");
					ansField.setText("");
					opField.requestFocus();
					break;
				case "2":
					opField.append("2");
					ansField.setText("");
					opField.requestFocus();
					break;
				case "3":
					opField.append("3");
					ansField.setText("");
					opField.requestFocus();
					break;
				case "4":
					opField.append("4");
					ansField.setText("");
					opField.requestFocus();
					break;
				case "5":
					opField.append("5");
					ansField.setText("");
					opField.requestFocus();
					break;
				case "6":
					opField.append("6");
					ansField.setText("");
					opField.requestFocus();
					break;
				case "7":
					opField.append("7");
					ansField.setText("");
					opField.requestFocus();
					break;
				case "8":
					opField.append("8");
					ansField.setText("");
					opField.requestFocus();
					break;
				case "9":
					opField.append("9");
					ansField.setText("");
					opField.requestFocus();
					break;
				case "0":
					opField.append("0");
					ansField.setText("");
					opField.requestFocus();
					break;
				case ".":
					opField.append(".");
					ansField.setText("");
					opField.requestFocus();
					break;
				case "C":
					calc = new Evaluator();
					opField.setText("");
					ansField.setText("");
					break;
				case "+":
					opField.append("+");
					break;
				case "-":
					opField.append("-");
					break;
				case "x":
					opField.append("*");
					break;
				case "/":
					opField.append("/");
					break;
				case "=":
					if (opString == "mod") {
						try {
							num2 = Double.parseDouble(opField.getText());
							ansField.setText(Double.toString(num1 % num2));
						}
						catch (InputMismatchException except) {
							ansField.setText("Error. Input numbers only");
						}
						catch (Exception except) {
							ansField.setText("Syntax error");
						}
					}
					else {
						try {
							String input = opField.getText();
							ansField.setText(Double.toString(calc.InfixToPostFix(input)));
						}
						catch (ArithmeticException except) {
							ansField.setText("Divide by zero error");
						}
						catch (Exception except) {
							ansField.setText("Syntax error");
						}
						finally {
							opField.setText("");
						}
					}
					opField.setText("");
					break;
				case "√":
					try {
						num1 = Double.parseDouble(opField.getText());
						ansField.setText(Double.toString(Math.sqrt(num1)));
					}
					catch (InputMismatchException except) {
						ansField.setText("Error. Only numbers");
					}
					catch (Exception except) {
						ansField.setText("Error");
					}
					finally {
						opField.setText("");
					}
					break;
				case "x²":
					try {
						num1 = Double.parseDouble(opField.getText());
						ansField.setText(Double.toString(Math.pow(num1, 2)));
					}
					catch (InputMismatchException except) {
						ansField.setText("Error. Input only numbers");
					}
					catch (Exception except) {
						ansField.setText("Error");
					}
					finally {
						opField.setText("");
					}
					break;
				case "x³":
					try {
						num1 = Double.parseDouble(opField.getText());
						ansField.setText(Double.toString(Math.pow(num1, 3)));
					}
					catch (InputMismatchException except) {
						ansField.setText("Error. Input numbers only");
					}
					catch (Exception except) {
						ansField.setText("Error");
					}
					finally {
						opField.setText("");
					}
					break;
				case "%":
					try {
						num1 = Double.parseDouble(opField.getText());
						ansField.setText(Double.toString(num1 / 100));
					}
					catch (InputMismatchException except) {
						ansField.setText("Error. Input numbers only");
					}
					catch (Exception except) {
						ansField.setText("Error");
					}
					finally {
						opField.setText("");
					}
					break;
				case "sin":
					try {
						num1 = Double.parseDouble(opField.getText());
						ansField.setText(Double.toString(Math.sin(num1)));
					}
					catch (InputMismatchException except) {
						ansField.setText("Error. Input only numbers");
					}
					catch (Exception except) {
						ansField.setText("Error");
					}
					finally {
						opField.setText("");
					}
					break;
				case "tan":
					try {
						num1 = Double.parseDouble(opField.getText());
						ansField.setText(Double.toString(Math.tan(num1)));
					}
					catch (InputMismatchException except) {
						ansField.setText("Error. Input only numbers");
					}
					catch (Exception except) {
						ansField.setText("Error");
					}
					finally {
						opField.setText("");
					}
					break;
				case "cos":
					try {
						num1 = Double.parseDouble(opField.getText());
						ansField.setText(Double.toString(Math.cos(num1)));
					}
					catch (InputMismatchException except) {
						ansField.setText("Error. Input only numbers");
					}
					catch (Exception except) {
						ansField.setText("Error");
					}
					finally {
						opField.setText("");
					}
					break;
				case "asin":
					try {
						num1 = Double.parseDouble(opField.getText());
						ansField.setText(Double.toString(Math.asin(num1)));
					}
					catch (InputMismatchException except) {
						ansField.setText("Error. Input only numbers");
					}
					catch (Exception except) {
						ansField.setText("Error");
					}
					finally {
						opField.setText("");
					}
					break;
				case "atan":
					try {
						num1 = Double.parseDouble(opField.getText());
						ansField.setText(Double.toString(Math.atan(num1)));
					}
					catch (InputMismatchException except) {
						ansField.setText("Error. Input only numbers");
					}
					catch (Exception except) {
						ansField.setText("Error");
					}
					finally {
						opField.setText("");
					}
					break;
				case "acos":
					try {
						num1 = Double.parseDouble(opField.getText());
						ansField.setText(Double.toString(Math.acos(num1)));
					}
					catch (InputMismatchException except) {
						ansField.setText("Error. Input only numbers");
					}
					catch (Exception except) {
						ansField.setText("Error");
					}
					finally {
						opField.setText("");
					}
					break;
				case "sinh":
					try {
						num1 = Double.parseDouble(opField.getText());
						ansField.setText(Double.toString(Math.sinh(num1)));
					}
					catch (InputMismatchException except) {
						ansField.setText("Error. Input only numbers");
					}
					catch (Exception except) {
						ansField.setText("Error");
					}
					finally {
						opField.setText("");
					}
					break;
				case "tanh":
					try {
						num1 = Double.parseDouble(opField.getText());
						ansField.setText(Double.toString(Math.tanh(num1)));
					}
					catch (InputMismatchException except) {
						ansField.setText("Error. Input only numbers");
					}
					catch (Exception except) {
						ansField.setText("Error");
					}
					finally {
						opField.setText("");
					}
					break;
				case "cosh":
					try {
						num1 = Double.parseDouble(opField.getText());
						ansField.setText(Double.toString(Math.cosh(num1)));
					}
					catch (InputMismatchException except) {
						ansField.setText("Error. Input only numbers");
					}
					catch (Exception except) {
						ansField.setText("Error");
					}
					finally {
						opField.setText("");
					}
					break;
				case "log":
					try {
						num1 = Double.parseDouble(opField.getText());
						ansField.setText(Double.toString(Math.log10(num1)));
					}
					catch (InputMismatchException except) {
						ansField.setText("Error. Input numbers only");
					}
					catch (Exception except) {
						opField.setText("Error");
					}
					finally {
						opField.setText("");
					}
					break;
				case "ln":
					try {
						num1 = Double.parseDouble(opField.getText());
						ansField.setText(Double.toString(Math.log(num1)));
					}
					catch (InputMismatchException except) {
						ansField.setText("Error. Input numbers only");
					}
					catch (Exception except) {
						ansField.setText("Error");
					}
					finally {
						opField.setText("");
					}
					break;
				case "10^n":
					try {
						num1 = Double.parseDouble(opField.getText());
						ansField.setText(Double.toString(Math.pow(10, num1)));
					}
					catch (InputMismatchException except) {
						ansField.setText("Error. Input numbers only");
					}
					catch (Exception except) {
						ansField.setText("Error");
					}
					finally {
						opField.setText("");
					}
					break;
				case "1/n":
					try {
						num1 = Double.parseDouble(opField.getText());
						ansField.setText(Double.toString(1 / num1));
					}
					catch (InputMismatchException except) {
						ansField.setText("Error. Input numbers only");
					}
					catch (ArithmeticException except) {
						ansField.setText("Error. Can't divide by zero");						
					}
					finally {
						opField.setText("");
					}
					break;
				case "EXIT":
					dispose();
					break;
				case "mod":
					opString = "mod";
					try {
						num1 = Double.parseDouble(opField.getText());
					}
					catch (InputMismatchException except) {
						 ansField.setText("Error. Input numbers only");
					}
					catch (Exception except) {
						ansField.setText("Error");
					}
					finally {
						opField.setText("");
					}
					break;
				default:
					opField.setText("");
					ansField.setText("Invalid operand");
			}
		}

		@Override
		public void focusGained(FocusEvent e) {
			ansField.setText("");
		}

		@Override
		public void focusLost(FocusEvent e) {
			// empty method
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// empty method
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				try {
					String input = opField.getText();
					ansField.setText(Double.toString(calc.InfixToPostFix(input)));
				}
				catch (InputMismatchException except) {
					ansField.setText("Error. Input only numbers");
				}
				catch (ArithmeticException except) {
					ansField.setText("Divide by zero error");
				}
				catch (Exception except) {
					ansField.setText("Syntax error");
				}
				finally {
					opField.setText("");
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// empty method
		}

}
