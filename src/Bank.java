import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Bank extends JFrame implements ActionListener{
	
	
	
	JList list;
	JButton Deposit;
	JButton Withdraw;
	JButton Transfer;
	JButton Balance;
	JLabel showInfo;
	JTextField depositField;
	JTextField transferField;
	JTextField withdrawField;
	JPanel[] row = new JPanel[5];
	JList<String> accountList;
	
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException{
		Scanner s = new Scanner(System.in);
		Bank b = new Bank();
		String msg = s.nextLine();
		 Files.write(Paths.get("./Anton.txt"), msg.getBytes());
	}

	
	public Bank(){
		
		/* Skapar fönstret som vi ska använda  */
		
		
		super("Bankomat");
		this.setSize(320, 350);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		FlowLayout första = new FlowLayout(FlowLayout.LEFT);
		FlowLayout andra = new FlowLayout(FlowLayout.LEFT,1,1);
		GridLayout grid = new GridLayout(5,5,3,3);
		JButton Deposit = new JButton("Deposit: ");
		JButton Withdraw = new JButton("Withdraw: ");
		JButton transfer = new JButton("Transfer: ");
		JButton Balance = new JButton("Balance: ");
		JTextField depositField = new JTextField(15);
		JTextField transferField = new JTextField ( 15 );
		JTextField withdrawField = new JTextField(15);
		Scanner sc = new Scanner(System.in);
		showInfo = new JLabel(" ");
		
		
		
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
		listModel.addElement("Anton");
		listModel.addElement("Dennis");
		listModel.addElement("Tom");
		listModel.addElement("Adnan");
		listModel.addElement("Youssef");
		accountList = new JList<>(listModel);
		accountList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		accountList.setVisibleRowCount(-1);
		int a = accountList.getSelectedIndex();
		
		
		try {
			sc = new Scanner(new FileReader("Anton.txt"));
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		String antonFile = sc.nextLine();
		
		accountList.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                  showInfo.setText("Namn: " + accountList.getSelectedValue().toString() + "Saldo: " + antonFile);
                }
            }
        });
		
		
		
		
		this.setLayout(new FlowLayout());
		for(int i = 0; i < 4; i++)
			row[i] = new JPanel();
		row[0].setLayout(första);
		
		for(int i = 1; i < 4; i++)
			row[i].setLayout(andra);
		
		row[0].add(accountList);
		
		this.add(row[0]);
		this.add(showInfo);
		row[1].add(Deposit );
		row[1].add(depositField);
		this.add(row[1]);
		
		
		setVisible(true);	
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
}
