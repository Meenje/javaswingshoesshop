package shoesshop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class PayMethod {
	static CustomerDTO cdto;

	public void depositView(JFrame payview, CustomerDTO cdto, ArrayList<ProductDTO> plist, int price) {
		this.cdto = cdto;
		
		JFrame Deposic = new JFrame();
		Deposic.getContentPane().setBackground(Color.WHITE);
		Deposic.setSize(264, 319);
		Deposic.setLocationRelativeTo(null);
		Deposic.setTitle("무통장 입금");
		Deposic.getContentPane().setLayout(null);

		JLabel namelb = new JLabel("예금주 :  ");
		namelb.setFont(new Font("휴먼엑스포", Font.PLAIN, 12));
		namelb.setBounds(26, 29, 84, 32);
		Deposic.getContentPane().add(namelb);

		JLabel accountlb = new JLabel("DB은행 : 060 -134 -95994");
		accountlb.setFont(new Font("휴먼엑스포", Font.PLAIN, 12));
		accountlb.setBounds(26, 71, 210, 38);
		Deposic.getContentPane().add(accountlb);

		JLabel LB = new JLabel("입금부탁드리겠습니다.");
		LB.setFont(new Font("휴먼엑스포", Font.PLAIN, 12));
		LB.setBounds(26, 201, 210, 32);
		Deposic.getContentPane().add(LB);

		JLabel pricelb = new JLabel("결제금액");
		pricelb.setFont(new Font("휴먼엑스포", Font.PLAIN, 12));
		pricelb.setBounds(12, 136, 84, 32);
		Deposic.getContentPane().add(pricelb);

		JButton payment = new JButton("닫기");
		payment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductDAO pdao = new ProductDAO();
				BasketDAO bdao = new BasketDAO();
				for (int i = 0; i < plist.size(); i++) {
					try {
						bdao.erase(plist.get(i));
						pdao.delete(plist.get(i));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				Deposic.dispose();
				payview.dispose();
				MainView maaaain = new MainView();
				maaaain.MainViewLogIn(cdto);
			}
		});
		payment.setBounds(85, 247, 84, 23);
		Deposic.getContentPane().add(payment);

		JLabel namelb1 = new JLabel("Shoes Shop");
		namelb1.setBounds(116, 28, 101, 32);
		Deposic.getContentPane().add(namelb1);

		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setText(String.valueOf(price) +"원");
		lblNewLabel_1.setBounds(115, 140, 121, 23);
		Deposic.getContentPane().add(lblNewLabel_1);

		Deposic.setVisible(true);
	}

	//-------------------------------------------------------실시간 계좌이체-----------------------------------------------------------------
	
	public void accountView(JFrame payview, CustomerDTO cdto, ArrayList<ProductDTO> plist, int price) {
		this.cdto = cdto;
		JFrame transfer = new JFrame();
		JTextField num1;
		JTextField num2;
		JTextField nameText;
		JTextField AcText;
		JTextField priceText;
		JTextField textField_3;

		transfer.getContentPane().setBackground(Color.WHITE);
		transfer.setSize(600, 400);
		transfer.setLocationRelativeTo(null);
		transfer.setTitle("계좌이체");
		transfer.getContentPane().setLayout(null);

		JLabel namelb = new JLabel("입금자명");
		namelb.setBounds(28, 39, 67, 24);
		transfer.getContentPane().add(namelb);

		JLabel account = new JLabel("계좌번호");
		account.setBounds(28, 98, 67, 24);
		transfer.getContentPane().add(account);

		JLabel pricelb = new JLabel("금액");
		pricelb.setBounds(28, 144, 67, 24);
		transfer.getContentPane().add(pricelb);

		JLabel numlb = new JLabel("공인인증");
		numlb.setBounds(28, 188, 67, 24);
		transfer.getContentPane().add(numlb);

		JLabel checklb = new JLabel("");
		checklb.setBounds(28, 222, 217, 15);
		transfer.getContentPane().add(checklb);

		JLabel label_1 = new JLabel("보안카드 번호");
		label_1.setBounds(14, 259, 81, 24);
		transfer.getContentPane().add(label_1);

		JLabel flb = new JLabel("앞 두자리");
		flb.setBounds(107, 259, 57, 24);
		transfer.getContentPane().add(flb);

		JLabel numlb1 = new JLabel("");
		numlb1.setBounds(184, 259, 57, 24);
		transfer.getContentPane().add(numlb1);

		JLabel blb = new JLabel("뒤 두자리");
		blb.setBounds(327, 259, 57, 24);
		transfer.getContentPane().add(blb);

		JLabel numlb2 = new JLabel("");
		numlb2.setBounds(460, 259, 57, 24);
		transfer.getContentPane().add(numlb2);

		num1 = new JTextField();
		num1.setBounds(246, 261, 57, 22);
		transfer.getContentPane().add(num1);
		num1.setColumns(10);

		num2 = new JTextField();
		num2.setColumns(10);
		num2.setBounds(396, 261, 57, 22);
		transfer.getContentPane().add(num2);

		nameText = new JTextField();
		nameText.setBounds(107, 41, 116, 24);
		transfer.getContentPane().add(nameText);
		nameText.setColumns(10);

		AcText = new JTextField();
		AcText.setColumns(10);
		AcText.setBounds(107, 99, 312, 24);
		transfer.getContentPane().add(AcText);

		priceText = new JTextField();
		priceText.setColumns(10);
		priceText.setText(String.valueOf(price) +"원");
		priceText.setEditable(false);
		priceText.setBounds(107, 146, 161, 22);
		transfer.getContentPane().add(priceText);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(107, 190, 312, 24);
		transfer.getContentPane().add(textField_3);

		JComboBox bankB = new JComboBox();
		bankB.setBackground(UIManager.getColor("Button.disabledShadow"));
		bankB.setMaximumRowCount(4);
		bankB.setModel(new DefaultComboBoxModel(new String[] { " DB은행 ", " java은행 ", " jsp은행 ", " python은행 " }));
		bankB.setBounds(107, 75, 115, 22);
		transfer.getContentPane().add(bankB);

		JButton checkB = new JButton("확인");
		checkB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checklb.setText(" 인증되었습니다. ");
			}
		});
		checkB.setBounds(431, 190, 97, 23);
		transfer.getContentPane().add(checkB);
		bankB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox year = (JComboBox) e.getSource();
				int index = year.getSelectedIndex();
			}
		});
		JButton payment = new JButton("결제");
		payment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "결제가 완료 되었습니다.");
				ProductDAO pdao = new ProductDAO();
				BasketDAO bdao = new BasketDAO();
				for (int i = 0; i < plist.size(); i++) {
					try {
						bdao.erase(plist.get(i));
						pdao.delete(plist.get(i));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				transfer.dispose();
				payview.dispose();
				MainView maaaain = new MainView();
				maaaain.MainViewLogIn(cdto);
			}
		});
		payment.setBounds(218, 307, 115, 30);
		transfer.getContentPane().add(payment);
		
		Random r = new Random();
		int key = r.nextInt(50);
		int key1 = r.nextInt(50);

		numlb1.setText(String.valueOf(key));
		numlb2.setText(String.valueOf(key1));

		transfer.setVisible(true);
	}
	
	//----------------------------------------카드 결제---------------------------------------------------------------------

	public void cardView(JFrame payview, CustomerDTO cdto, ArrayList<ProductDTO> plist) {
		this.cdto = cdto;
		
		JFrame card = new JFrame();
		
		JTextField num1;
		JTextField num2;
		JTextField num3;
		JTextField CVCnum;
		JPasswordField num4;
		
		card.getContentPane().setBackground(Color.WHITE);
		card.setTitle("카드 결제창");
		card.setSize(600, 300);
		card.setLocationRelativeTo(null);
		card.getContentPane().setLayout(null);

		num1 = new JTextField();
		num1.setBounds(134, 21, 74, 30);
		card.getContentPane().add(num1);
		num1.setColumns(10);

		num2 = new JTextField();
		num2.setColumns(10);
		num2.setBounds(233, 21, 74, 30);
		card.getContentPane().add(num2);

		num3 = new JTextField();
		num3.setColumns(10);
		num3.setBounds(335, 21, 74, 30);
		card.getContentPane().add(num3);

		num4 = new JPasswordField();
		num4.setBounds(439, 21, 74, 30);
		card.getContentPane().add(num4);

		CVCnum = new JTextField();
		CVCnum.setColumns(10);
		CVCnum.setBounds(134, 85, 74, 30);
		card.getContentPane().add(CVCnum);

		JLabel lblNewLabel = new JLabel("카드번호");
		lblNewLabel.setFont(new Font("휴먼엑스포", Font.PLAIN, 12));
		lblNewLabel.setBounds(32, 28, 68, 24);
		card.getContentPane().add(lblNewLabel);

		JLabel lblCvc = new JLabel("cvc");
		lblCvc.setFont(new Font("Adobe Caslon Pro", Font.PLAIN, 17));
		lblCvc.setBounds(32, 92, 68, 24);
		card.getContentPane().add(lblCvc);

		JLabel vaildity = new JLabel("유효기간");
		vaildity.setFont(new Font("휴먼엑스포", Font.PLAIN, 12));
		vaildity.setBounds(32, 155, 68, 24);
		card.getContentPane().add(vaildity);

		JButton payment = new JButton("결제");
		payment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "결제가 완료 되었습니다.");
				ProductDAO pdao = new ProductDAO();
				BasketDAO bdao = new BasketDAO();
				for (int i = 0; i < plist.size(); i++) {
					try {
						bdao.erase(plist.get(i));
						pdao.delete(plist.get(i));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				card.dispose();
				payview.dispose();
				MainView maaaain = new MainView();
				maaaain.MainViewLogIn(cdto);
			}
		});
		payment.setFont(new Font("휴먼엑스포", Font.PLAIN, 12));
		payment.setBounds(134, 206, 102, 30);
		card.getContentPane().add(payment);

		JButton cancel = new JButton("취소");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.dispose();
			}
		});
		cancel.setFont(new Font("휴먼엑스포", Font.PLAIN, 12));
		cancel.setBounds(276, 206, 102, 30);
		card.getContentPane().add(cancel);

		JComboBox month = new JComboBox();
		month.setMaximumRowCount(12);
		month.setModel(new DefaultComboBoxModel(new String[] { " 01 ", " 02 ", " 03 ", " 04 ", " 05 ", " 06 ", " 07 ",
				" 08 ", " 09 ", " 10 ", " 11 ", " 12 " }));
		month.setBounds(135, 157, 73, 21);
		card.getContentPane().add(month);
		month.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox month = (JComboBox) e.getSource();
				int index = month.getSelectedIndex();
			}
		});
		JComboBox year = new JComboBox();
		year.setMaximumRowCount(11);
		year.setModel(new DefaultComboBoxModel(new String[] { " 18 ", " 19 ", " 20 ", " 21 ", " 22 ", " 23 ", " 24 ",
				" 25 ", " 26 ", " 27 ", " 28 " }));
		year.setBounds(233, 157, 73, 21);
		card.getContentPane().add(year);
		year.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox year = (JComboBox) e.getSource();
				int index = year.getSelectedIndex();
			}
		});
		card.setVisible(true);
	}
}
