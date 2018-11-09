package com.alexchenny;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;

public class Driver extends JFrame {

	private JPanel contentPane;
	private JTextField txtInsert;
	private String list = "";
	private double[] numArray;
	private double[] sorted;

	Quick_Sort qs = new Quick_Sort();
	Merge_Sort ms = new Merge_Sort();

	private JTextArea txtResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		createWindow();
	}

	// create GUI
	private static void createWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Driver frame = new Driver();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Driver() {
		setTitle("Number Sorter");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnMergeSort = new JButton("Merge Sort");
		btnMergeSort.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// get input from text field (list of unsorted numbers from
				// user)
				list = txtInsert.getText();
				// convert to number array
				numArray = toArray(list);
				// if user doesn't enter anything in the text field
				if (list.equals("")) {
					System.out.println("please enter a list of numbers");
				}
				// sort array
				sorted = ms.sort(numArray);
				// dispaly sorted array on GUI
				txtResult.setText(displayList(sorted));
			}
		});
		btnMergeSort.setBounds(163, 101, 117, 29);
		contentPane.add(btnMergeSort);

		JButton btnInsertionSort = new JButton("Insertion Sort");
		btnInsertionSort.setBounds(477, 101, 117, 29);
		contentPane.add(btnInsertionSort);

		JButton btnBubbleSort = new JButton("Bubble Sort");
		btnBubbleSort.setBounds(311, 101, 117, 29);
		contentPane.add(btnBubbleSort);

		JButton btnQuickSort = new JButton("Quick Sort");
		btnQuickSort.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// get input from text field (list of unsorted numbers from
				// user)
				list = txtInsert.getText();
				// convert to number array
				numArray = toArray(list);
				// if user doesn't enter anything in the text field
				if (list.equals("")) {
					System.out.println("please enter a list of numbers");
				}
				// sort array
				sorted = qs.sort(numArray);
				// dispaly sorted array on GUI
				txtResult.setText(displayList(sorted));
			}
		});

		btnQuickSort.setBounds(6, 101, 117, 29);
		contentPane.add(btnQuickSort);

		txtInsert = new JTextField();
		txtInsert.setText("Example: 9 6 5 0 8 2 4 7");
		txtInsert.setBounds(6, 48, 588, 41);
		contentPane.add(txtInsert);
		txtInsert.setColumns(10);

		JLabel lblNewLabel = new JLabel("Please enter a list of numbers to be sorted:");
		lblNewLabel.setBounds(16, 20, 333, 16);
		contentPane.add(lblNewLabel);

		txtResult = new JTextArea();
		txtResult.setBounds(16, 162, 578, 29);
		contentPane.add(txtResult);
	} // constructor

	// take string of numbers and store them in an array
	private static double[] toArray(String s) {
		String[] temp = s.split(" ");
		double[] numList = new double[temp.length];
		for (int n = 0; n < temp.length; n++) {
			numList[n] = Integer.parseInt(temp[n]);
		}
		return numList;
	}

	// display the sorted array
	private static String displayList(double[] list) {
		String output = "Sorted Array: ";
		for (int i = 0; i < list.length; i++)
			output += (int) list[i] + " ";
		return output;
	}
} // end class
