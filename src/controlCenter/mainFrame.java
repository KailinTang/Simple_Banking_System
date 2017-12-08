package controlCenter;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import account.BankAccount;
import customer.Guest;
import customer.checkUser;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class mainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private controller controller = new controller();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrame frame = new mainFrame();
					frame.setTitle("Banking System");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setSize(600, 200);
					frame.setLocationRelativeTo(null);
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
	public mainFrame() {
		controller.SystemLoad();
		this.addWindowListener(new WindowListener(){

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				if(controller.checkDebts()){			
					controller.systemsave();	//When you close the software, save all data
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}else{
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE );
				}
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		

		main_Frame();
		
		
	}
	public void main_Frame(){
		
		setSize(600, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		JLabel lblSimpleBankSystem = new JLabel("Banking System");
		lblSimpleBankSystem.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		lblSimpleBankSystem.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(BorderLayout.NORTH,lblSimpleBankSystem);

		JLabel lblWelcomeInfo = new JLabel("Welcome to our bank system, Please select the function!");
		lblWelcomeInfo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblWelcomeInfo.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(BorderLayout.SOUTH,lblWelcomeInfo);
				
		JButton btnNewButton = new JButton("Bank control");
		btnNewButton.setPreferredSize(new Dimension(280,100));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				init();
				bankControl();
			}
		});
		this.add(BorderLayout.WEST,btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Transaction");
		btnNewButton_1.setPreferredSize(new Dimension(280,100));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				init();
				transaction();
			}
		});
		this.add(BorderLayout.EAST,btnNewButton_1);
		
	}
	
	public void init(){
		this.getContentPane().removeAll();
		this.repaint();
		this.pack();
		
	}
	public void bankControl(){
		
		this.setSize(500, 300);
		contentPane.setLayout(new GridLayout(5,1));
		
		JLabel bankcon = new JLabel("Bank Control");
		bankcon.setHorizontalAlignment(SwingConstants.CENTER);
		bankcon.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		contentPane.add(bankcon);
		
		JButton btnNewButton = new JButton("Custom Control");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		btnNewButton.setHorizontalAlignment(SwingConstants.CENTER);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				init();
				customControl();
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Account Control");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				init();
				accountControl();
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Clear fund");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.clearFund();
			}
		});
		contentPane.add(btnNewButton_2);
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				init();
				main_Frame();
			}
		});
		contentPane.add(btnNewButton_3);
	}
	public void customControl(){
		
		this.setSize(500, 300);
		contentPane.setLayout(new GridLayout(5,1));
		
		
		JLabel lblSimpleBankSystem = new JLabel("Custom Control");
		lblSimpleBankSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblSimpleBankSystem.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		contentPane.add(lblSimpleBankSystem);
		
		JButton btnNewButton = new JButton("Add customer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				init();
				addCustomer();
			}
		});
		contentPane.add(btnNewButton);
		
		JButton DC = new JButton("Delete customer");
		DC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				init();
				deleteCustomer();
			}
		});
		contentPane.add(DC);
		
		JButton btnNewButton_1 = new JButton("Confirm credit status");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				init();
				confirmCreditStatus();
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				init();
				bankControl();
			}
		});
		contentPane.add(btnNewButton_2);
	}
	
	public void addCustomer(){
		
		this.setSize(500, 250);
		contentPane.setLayout(new BorderLayout(0,10));
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4,2));
		final JTextField ID = new JTextField();
		final JTextField address = new JTextField();
		final JTextField name = new JTextField();
		final JTextField dateofbirth = new JTextField();
		panel.add(new JLabel("ID"));
		panel.add(ID);
		panel.add(new JLabel("name"));
		panel.add(name);
		panel.add(new JLabel("address"));
		panel.add(address);
		panel.add(new JLabel("date of birth"));
		panel.add(dateofbirth);
		JLabel lblSimpleBankSystem = new JLabel("Add custom ");
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1,3));
		JButton next = new JButton("next");
		panel2.add(next);
		JButton back = new JButton("Back");
		panel2.add(back);
		JButton show = new JButton("Show the list");
		panel2.add(show);
		contentPane.add(lblSimpleBankSystem, BorderLayout.NORTH);
		contentPane.add(panel,BorderLayout.CENTER);
		contentPane.add(panel2,BorderLayout.SOUTH);
		
		
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.addGuest(Integer.parseInt(ID.getText()),name.getText(),address.getText(),dateofbirth.getText());				
				init();
				addCustomer();
			}
		});
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				init();
				customControl();
			}
		});
		
		show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				init();
				showCusList();
			}
		});
	}
	
	public void deleteCustomer(){
		
		this.setSize(500, 150);
		contentPane.setLayout(new BorderLayout(0,10));
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,2));
		ArrayList<String> namelist = new ArrayList<String>();
		for(Guest cell:controller.getGuestList()){
			namelist.add(cell.getID()+" "+cell.getName());
		}
		final JComboBox jcb = new JComboBox(namelist.toArray());
		panel.add(new JLabel("Chose the customer"));
		panel.add(jcb);	
		JLabel lblSimpleBankSystem = new JLabel("Delete customer");
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1,3));	
		JButton next = new JButton("next");
		panel2.add(next);
		JButton back = new JButton("Back");
		panel2.add(back);
		JButton show = new JButton("Show the list");
		panel2.add(show);
		contentPane.add(lblSimpleBankSystem, BorderLayout.NORTH);
		contentPane.add(panel,BorderLayout.CENTER);
		contentPane.add(panel2,BorderLayout.SOUTH);
		
		
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.deleteGuest((String)jcb.getSelectedItem());
				init();
				deleteCustomer();
			}
		});
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				init();
				customControl();
			}
		});
		show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				init();
				showCusList();
			}
		});
	}
	
	public void showCusList(){
		
		this.setSize(500, 300);
		contentPane.setLayout(new BorderLayout(0,10));
		JPanel panel = new JPanel();
		int size=controller.getGuestList().size();
		panel.setLayout(new GridLayout(size+1,5));
		panel.add(new JLabel("ID"));
		panel.add(new JLabel("name"));
		panel.add(new JLabel("address"));
		panel.add(new JLabel("date of brith"));
		panel.add(new JLabel("credit state"));
		for(int i=0;i<size;i++){
			panel.add(new JLabel(controller.getGuestList().get(i).getID()+""));
			panel.add(new JLabel(controller.getGuestList().get(i).getName()+""));
			panel.add(new JLabel(controller.getGuestList().get(i).getAddr()+""));  
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/M/d");  
			String str = (dateFormat.format(controller.getGuestList().get(i).getDob()));   
			panel.add(new JLabel(str));
			panel.add(new JLabel(controller.getGuestList().get(i).isCreStat()+""));
		}
		JLabel lblSimpleBankSystem = new JLabel("customer list");
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1,1));
		JButton back = new JButton("Back");
		panel2.add(back);
		contentPane.add(lblSimpleBankSystem, BorderLayout.NORTH);
		contentPane.add(panel,BorderLayout.CENTER);
		contentPane.add(panel2,BorderLayout.SOUTH);
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				init();
				addCustomer();
			}
		});
	}
	
	public void confirmCreditStatus(){
		
		this.setSize(500, 150);
		contentPane.setLayout(new BorderLayout(0,10));
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2));
		panel.add(new JLabel("please input ID"));
		final JTextField ID = new JTextField();
		panel.add(ID);
		JLabel lblSimpleBankSystem = new JLabel("Confirm Credit Status");
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1,2));
		JButton check = new JButton("check");
		panel2.add(check);
		JButton back = new JButton("Back");
		panel2.add(back);
		contentPane.add(lblSimpleBankSystem, BorderLayout.NORTH);
		contentPane.add(panel,BorderLayout.CENTER);
		contentPane.add(panel2,BorderLayout.SOUTH);		
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				boolean CreSta=new checkUser().confirmCreditStatus(Integer.parseInt(ID.getText()));
				JOptionPane.showMessageDialog(null, CreSta);
			}
		});
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				init();
				customControl();
			}
		});
	}
	public void accountControl(){
		
		this.setSize(500, 150);
		contentPane.setLayout(new BorderLayout(0,10));
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2));
		panel.add(new JLabel("please input ID"));
		final JTextField ID = new JTextField();
		panel.add(ID);
		JLabel lblSimpleBankSystem = new JLabel("Account control");
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1,2));
		JButton next = new JButton("Next");
		panel2.add(next);
		JButton back = new JButton("Back");
		panel2.add(back);
		contentPane.add(lblSimpleBankSystem, BorderLayout.NORTH);
		contentPane.add(panel,BorderLayout.CENTER);
		contentPane.add(panel2,BorderLayout.SOUTH);		
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				
				if(controller.checkID(Integer.parseInt(ID.getText()))){
					init();
					accountControl2(Integer.parseInt(ID.getText()));
				}
			}
		});
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				init();
				bankControl();
			}
		});	
	}
	public void accountControl2(int ID){
		this.setSize(350, 600);
		this.setLocationRelativeTo(null);
		contentPane.setLayout(new GridLayout(8,1));
		
		JLabel lblSimpleBankSystem = new JLabel("Account Control      Welcome:"+ID);
		contentPane.add(lblSimpleBankSystem);
		
		JButton btnNewButton = new JButton("Create account");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				init();
				creatAccount(ID);
			}
		});
		contentPane.add(btnNewButton);
		
		JButton DC = new JButton("Deposit");
		DC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				init();
				deposit(ID);
			}
		});
		contentPane.add(DC);
		
		JButton btnNewButton_1 = new JButton("Withdral");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				init();
				withdraw(ID);
			}
		});
		contentPane.add(btnNewButton_1);
	
		JButton btnNewButton_2 = new JButton("Suspend");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				init();
				suspend(ID);
			}
		});
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Reinstate");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				init();
				reinstate(ID);
			}
		});
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Close account");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				init();
				closeAccount(ID);
			}
		});
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Back");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				init();
				bankControl();
			}
		});
		contentPane.add(btnNewButton_5);
	}
	
	public void creatAccount(int ID){
		
		this.setSize(500, 200);
		this.setLocationRelativeTo(null);
		contentPane.setLayout(new BorderLayout(0,10));
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 2));
		panel.add(new JLabel("please input PIN"));
		final JTextField PIN = new JTextField();
		panel.add(PIN);
		panel.add(new JLabel("please input account type"));
		final JTextField accTyp = new JTextField();
		panel.add(accTyp);
		JLabel lblSimpleBankSystem = new JLabel("Creat Account");
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1,2));
		JButton finish = new JButton("finish");
		panel2.add(finish);
		JButton back = new JButton("Back");
		panel2.add(back);
		contentPane.add(lblSimpleBankSystem, BorderLayout.NORTH);
		contentPane.add(panel,BorderLayout.CENTER);
		contentPane.add(panel2,BorderLayout.SOUTH);		
		finish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {								
					init();
					controller.createAccount(ID, Integer.parseInt(PIN.getText()),Integer.parseInt(accTyp.getText()));
					accountList(ID);
			}
		});
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				init();
				accountControl2(ID);
			}
		});
	}
	public void accountList(int ID){;
		this.setSize(500, 300);
		contentPane.setLayout(new BorderLayout(0,10));
		JPanel panel = new JPanel();
		int size=0;
		for(int j=0;j<controller.getAccList().size();j++){
			if(controller.getAccList().get(j).getID()==ID){
				size++;
			}
		}
		panel.setLayout(new GridLayout(size+1,4));
		panel.add(new JLabel("account number"));
		panel.add(new JLabel("balance"));
		panel.add(new JLabel("is suspend"));
		panel.add(new JLabel("account type"));
		for(int i=0;i<controller.getAccList().size();i++){
			if(controller.getAccList().get(i).getID()==ID){
			panel.add(new JLabel(controller.getAccList().get(i).getAccNo()+""));
			panel.add(new JLabel(controller.getAccList().get(i).getBalance()+""));
			panel.add(new JLabel(controller.getAccList().get(i).isSus()+""));
			panel.add(new JLabel(controller.getAccList().get(i).getAccTyp()+""));
			}
		}
		JLabel lblSimpleBankSystem = new JLabel("Account list for ID:"+ID);
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1,1));
		JButton back = new JButton("Back");
		panel2.add(back);
		contentPane.add(lblSimpleBankSystem, BorderLayout.NORTH);
		contentPane.add(panel,BorderLayout.CENTER);
		contentPane.add(panel2,BorderLayout.SOUTH);
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				init();
				accountControl2(ID);
			}
		});		
	}
	
	public void deposit(int ID){
		
		this.setSize(700, 250);
		this.setLocationRelativeTo(null);
		contentPane.setLayout(new BorderLayout(0,10));
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,2));
		ArrayList<String> namelist = new ArrayList<String>();
		for(int i=0;i<controller.getAccList().size();i++){
			if(controller.getAccList().get(i).getID()==ID){
			namelist.add(controller.getAccList().get(i).getAccNo()+" "+controller.getAccList().get(i).getAccTyp()+" "+controller.getAccList().get(i).getBalance());
			}
		}
		final JComboBox jcb = new JComboBox(namelist.toArray());
		panel.add(new JLabel("Chose the account"));
		panel.add(jcb);	
		panel.add(new JLabel("input amount"));
		final JTextField amount=new JTextField();
		panel.add(amount);	
		panel.add(new JLabel("choose payment method"));
		ArrayList<String> namelist2 = new ArrayList<String>();
		namelist2.add("1.cash");
		namelist2.add("2.cheque");
		final JComboBox jcb2 = new JComboBox(namelist2.toArray());
		JLabel lblSimpleBankSystem = new JLabel("Doposit");
		panel.add(jcb2);	
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1,4));	
		JButton next = new JButton("next");
		panel2.add(next);
		JButton back = new JButton("Back");
		panel2.add(back);
		JButton show = new JButton("Show the account list");
		panel2.add(show);
		JButton show2 = new JButton("Show the uncleared list");
		panel2.add(show2);
		contentPane.add(lblSimpleBankSystem, BorderLayout.NORTH);
		contentPane.add(panel,BorderLayout.CENTER);
		contentPane.add(panel2,BorderLayout.SOUTH);
		
		
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(((String)jcb2.getSelectedItem()).equals("1.cash")){
				controller.deposit((String)jcb.getSelectedItem(),Integer.parseInt(amount.getText()));
				init();
				deposit(ID);
				}else{
					controller.depositUnclear((String)jcb.getSelectedItem(),Integer.parseInt(amount.getText()));
					init();
					deposit(ID);
				}
			}
		});
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				init();
				accountControl2(ID);
			}
		});
		show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				init();
				accountList(ID);
			}
		});
		show2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				init();
				unlearList(ID);
			}
		});	
	}
	
	public void unlearList(int ID){
		
		this.setSize(500, 300);
		contentPane.setLayout(new BorderLayout(0,10));
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(6,2));
		panel.add(new JLabel("account number"));
		panel.add(new JLabel("amount"));
		for(int i=0;i<controller.getAccList().size();i++){
			if(controller.getAccList().get(i).getID()==ID){
				for(int j=0;j<controller.getBillList().size();j++){
					if(controller.getAccList().get(i).getAccNo()==controller.getBillList().get(j).getAccNo()){
						panel.add(new JLabel(controller.getBillList().get(j).getAccNo()+""));
						panel.add(new JLabel(controller.getBillList().get(j).getAmount()+""));
					}
				}
			}
		}
		JLabel lblSimpleBankSystem = new JLabel("Account list for ID:"+ID);
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1,1));
		JButton back = new JButton("Back");
		panel2.add(back);
		contentPane.add(lblSimpleBankSystem, BorderLayout.NORTH);
		contentPane.add(panel,BorderLayout.CENTER);
		contentPane.add(panel2,BorderLayout.SOUTH);
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				init();
				accountControl2(ID);
			}
		});	
	}
	
	public void suspend(int ID){
		
		this.setSize(500, 150);
		contentPane.setLayout(new BorderLayout(0,10));
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,2));
		ArrayList<String> namelist = new ArrayList<String>();
		for(int i=0;i<controller.getAccList().size();i++){
			if(controller.getAccList().get(i).getID()==ID&&(!controller.getAccList().get(i).isSus())){
			namelist.add(controller.getAccList().get(i).getAccNo()+" "+controller.getAccList().get(i).getAccTyp()+" "+controller.getAccList().get(i).isSus()+" ");
			}
		}
		final JComboBox jcb = new JComboBox(namelist.toArray());
		panel.add(new JLabel("Chose the account"));
		panel.add(jcb);	
		JLabel lblSimpleBankSystem = new JLabel("Suspend");	
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1,4));	
		JButton confirm = new JButton("confirm");
		panel2.add(confirm);
		JButton back = new JButton("Back");
		panel2.add(back);
		contentPane.add(lblSimpleBankSystem, BorderLayout.NORTH);
		contentPane.add(panel,BorderLayout.CENTER);
		contentPane.add(panel2,BorderLayout.SOUTH);
		
		
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				controller.suspend((String)jcb.getSelectedItem());
				init();
				suspend(ID);
			}
		});
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				init();
				accountControl2(ID);
			}
		});
	}
	
	public void reinstate(int ID){
		
		this.setSize(500, 150);
		contentPane.setLayout(new BorderLayout(0,10));
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,2));
		ArrayList<String> namelist = new ArrayList<String>();
		for(int i=0;i<controller.getAccList().size();i++){
			if(controller.getAccList().get(i).getID()==ID&&(controller.getAccList().get(i).isSus())){
			namelist.add(controller.getAccList().get(i).getAccNo()+" "+controller.getAccList().get(i).getAccTyp()+" "+controller.getAccList().get(i).isSus()+" ");
			}
		}
		final JComboBox jcb = new JComboBox(namelist.toArray());
		panel.add(new JLabel("Chose the account"));
		panel.add(jcb);	
		JLabel lblSimpleBankSystem = new JLabel("Reinstate");	
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1,4));	
		JButton confirm = new JButton("confirm");
		panel2.add(confirm);
		JButton back = new JButton("Back");
		panel2.add(back);
		contentPane.add(lblSimpleBankSystem, BorderLayout.NORTH);
		contentPane.add(panel,BorderLayout.CENTER);
		contentPane.add(panel2,BorderLayout.SOUTH);
		
		
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				controller.reinstate((String)jcb.getSelectedItem());
				init();
				reinstate(ID);
			}
		});
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				init();
				accountControl2(ID);
			}
		});
	}
	
	public void closeAccount(int ID){
		
		this.setSize(500, 150);
		contentPane.setLayout(new BorderLayout(0,10));
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,2));
		ArrayList<String> namelist = new ArrayList<String>();
		for(int i=0;i<controller.getAccList().size();i++){
			if(controller.getAccList().get(i).getID()==ID){
			namelist.add(controller.getAccList().get(i).getAccNo()+" "+controller.getAccList().get(i).getAccTyp()+" "+controller.getAccList().get(i).getBalance()+" ");
			}
		}
		final JComboBox jcb = new JComboBox(namelist.toArray());
		panel.add(new JLabel("Chose the account"));
		panel.add(jcb);
		JLabel lblSimpleBankSystem = new JLabel("close account");	
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1,4));	
		JButton confirm = new JButton("confirm");
		panel2.add(confirm);
		JButton back = new JButton("Back");
		panel2.add(back);
		contentPane.add(lblSimpleBankSystem, BorderLayout.NORTH);
		contentPane.add(panel,BorderLayout.CENTER);
		contentPane.add(panel2,BorderLayout.SOUTH);
		
		
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				controller.closeAccount((String)jcb.getSelectedItem());
				init();
				closeAccount(ID);
			}
		});
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				init();
				accountControl2(ID);
			}
		});
	}
	
	public void withdraw(int ID){
		
		this.setSize(500, 250);
		this.setLocationRelativeTo(null);
		contentPane.setLayout(new BorderLayout(0,10));
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,2));
		final JTextField accNo = new JTextField();
		final JTextField PIN = new JTextField();
		final JTextField amount = new JTextField();
		panel.add(new JLabel("Accout number"));
		panel.add(accNo);
		panel.add(new JLabel("PIN"));
		panel.add(PIN);
		panel.add(new JLabel("amount"));
		panel.add(amount);
		JLabel lblSimpleBankSystem = new JLabel("Withdraw");
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1,2));
		JButton next = new JButton("next");
		panel2.add(next);
		JButton back = new JButton("Back");
		panel2.add(back);
		contentPane.add(lblSimpleBankSystem, BorderLayout.NORTH);
		contentPane.add(panel,BorderLayout.CENTER);
		contentPane.add(panel2,BorderLayout.SOUTH);
		
		
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.withdraw(Integer.parseInt(accNo.getText()),Integer.parseInt(PIN.getText()),Integer.parseInt(amount.getText()));				
				init();
				withdraw(ID);
			}
		});
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				init();
				accountControl2(ID);
			}
		});		
	}
	
	
	public void transaction(){
		
		this.setSize(600, 200);
		contentPane.setLayout(new BorderLayout(0,10));
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,2));
		final JTextField accNo = new JTextField();
		accNo.setHorizontalAlignment(SwingConstants.CENTER);
		final JPasswordField PIN = new JPasswordField();
		PIN.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel userAccNum = new JLabel("Account Number:");
		userAccNum.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		userAccNum.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(userAccNum);
		JLabel userPIN = new JLabel("PIN:");
		userPIN.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		userPIN.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(accNo);
		panel.add(userPIN);
		panel.add(PIN);
		JLabel lblSimpleBankSystem = new JLabel("Transaction - Login");
		lblSimpleBankSystem.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		lblSimpleBankSystem.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1,3));
		JButton next = new JButton("Next");
		next.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		next.setHorizontalAlignment(SwingConstants.CENTER);
		panel2.add(next);
		JButton back = new JButton("Back");
		back.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		back.setHorizontalAlignment(SwingConstants.CENTER);
		panel2.add(back);
		contentPane.add(lblSimpleBankSystem, BorderLayout.NORTH);
		contentPane.add(panel,BorderLayout.CENTER);
		contentPane.add(panel2,BorderLayout.SOUTH);
		
		
		next.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				if(controller.checkAcc(Integer.parseInt(accNo.getText()),Integer.parseInt(PIN.getText()))){									
				init();
				transaction2(Integer.parseInt(accNo.getText()));
				}
			}
		});
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				init();
				main_Frame();
			}
		});
	}
	
	public void transaction2(int accNo){
		BankAccount bankacc=new BankAccount();
		
		this.setSize(500, 150);
		this.setLocationRelativeTo(null);
		contentPane.setLayout(new BorderLayout(0,10));
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,4));
		panel.add(new JLabel("account number"));
		panel.add(new JLabel("balance"));
		panel.add(new JLabel("is suspend"));
		panel.add(new JLabel("account type"));
		JLabel balance=new JLabel();
		for(int i=0;i<controller.getAccList().size();i++){
			if(controller.getAccList().get(i).getAccNo()==accNo){
			bankacc=controller.getAccList().get(i);
			panel.add(new JLabel(controller.getAccList().get(i).getAccNo()+""));
			balance.setText(controller.getAccList().get(i).getBalance()+"");
			//JLabel balance=new JLabel(controller.getAccList().get(i).getBalance()+"");
			panel.add(balance);
			panel.add(new JLabel(controller.getAccList().get(i).isSus()+""));
			panel.add(new JLabel(controller.getAccList().get(i).getAccTyp()+""));
			break;
			}
		}
		JLabel lblSimpleBankSystem = new JLabel("Account of "+bankacc.getAccNo());
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1,3));
		JButton deposit = new JButton("Deposit");
		JButton withdraw = new JButton("Withdraw");
		JButton back = new JButton("Back");
		panel2.add(deposit);
		panel2.add(withdraw);
		panel2.add(back);
		contentPane.add(lblSimpleBankSystem, BorderLayout.NORTH);
		contentPane.add(panel,BorderLayout.CENTER);
		contentPane.add(panel2,BorderLayout.SOUTH);
		deposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s=JOptionPane.showInputDialog(null,"Input amount:\n","title",JOptionPane.PLAIN_MESSAGE);
				controller.deposit(accNo+" ",Integer.parseInt(s));
				for(int i=0;i<controller.getAccList().size();i++){
					if(controller.getAccList().get(i).getAccNo()==accNo){
						balance.setText(controller.getAccList().get(i).getBalance()+"");
						break;
					}
				}
			}
		});
		withdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s=JOptionPane.showInputDialog(null,"Input amount:\n","title",JOptionPane.PLAIN_MESSAGE);
				for(int i=0;i<controller.getAccList().size();i++){
					if(controller.getAccList().get(i).getAccNo()==accNo){
						controller.withdraw(accNo,controller.getAccList().get(i).getPIN(),Integer.parseInt(s));
						balance.setText(controller.getAccList().get(i).getBalance()+"");
						break;
					}
				}
				
			}
		});
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				init();
				main_Frame();
			}
		});
	}
}
