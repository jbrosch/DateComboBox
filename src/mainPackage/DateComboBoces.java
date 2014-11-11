package mainPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import com.google.common.collect.Lists;
import com.google.common.base.Functions;

import com.ibm.icu.util.Calendar;

public class DateComboBoces extends JFrame {

	private JPanel contentPane;
	private JLabel selectedMonth;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DateComboBoces frame = new DateComboBoces();
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
	public DateComboBoces() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		int month = Calendar.getInstance().get(Calendar.MONTH); //this returns an int from 1 to 12. 
		int today = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		ArrayList<Integer> nums = new ArrayList<Integer>();

		for (int i=1; i<=28;i++){
			nums.add(i);
		}


		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);

		JLabel lblMonth = new JLabel("Month");
		panel.add(lblMonth);
		String[] months = {"1 January","2 February","3 March","4 April","5 May","6 June","7 July","8 August","9 September","10 October","11 November","12 December"};
		JComboBox comboBox = new JComboBox(months);
		comboBox.setSelectedIndex(month);
		comboBox.setEditable(true);

		panel.add(comboBox);

		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String month = (String) comboBox.getSelectedItem();
				selectedMonth.setText(month);
			}
		});

		JLabel lblDay = new JLabel("Day");
		panel.add(lblDay);

		ArrayList<Integer> days = new ArrayList<Integer>();

		if (selectedMonth.getText()=="2 February") { 
			for(int i=1; i<=28; i++){
				days.add(i);
			}
		}
		if(selectedMonth.getText()=="1 January" || selectedMonth.getText()=="3 March" || selectedMonth.getText()=="5 May" || selectedMonth.getText()=="7 July" || selectedMonth.getText()=="8 August" || selectedMonth.getText()=="10 October" || selectedMonth.getText()=="12 January"){
			for(int i=1; i<=31; i++){
				days.add(i);
			}
		}
		else{
			for(int i=1; i<=30; i++){
				days.add(i);
			}
		}


		JComboBox comboBox_1 = new JComboBox(Lists.transform(integers, Functions.toStringFunction()));
		comboBox_1.setSelectedIndex(today);
		comboBox_1.setEditable(true);
		panel.add(comboBox_1);

		JLabel lblYear = new JLabel("Year");
		panel.add(lblYear);

		String[] years = {"2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019"};
		JComboBox comboBox_2 = new JComboBox(years);
		comboBox_2.setSelectedIndex(currentYear-2009);
		comboBox_2.setEditable(true);
		panel.add(comboBox_2);
	}

}
