package shoesshop;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.SelectableChannel;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.*;
import java.awt.Color;

public class Signin {
	JTextField textField;
	JTextField textname;
	JTextField textID;
	JPasswordField textPw;
	JPasswordField textPw2;
	JTextField textTell;
	JTextField textA1;
	JTextField textA2;
	JTextField textPh;
	JLabel IDlabel;
	ArrayList<String> idlist;

	public void SigninView() {
		JFrame Su = new JFrame();
		Su.getContentPane().setBackground(Color.WHITE);
		Su.getContentPane().setFont(new Font("휴먼엑스포", Font.PLAIN, 12));
		Su.setTitle("회원가입");
		Su.setSize(501, 600);
		Su.setLocationRelativeTo(null);
		Su.getContentPane().setLayout(null);

		JLabel label1 = new JLabel("회원 가입");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setFont(new Font("휴먼엑스포", Font.PLAIN, 12));
		label1.setBounds(137, 25, 192, 35);
		Su.getContentPane().add(label1);

		JLabel nameL = new JLabel("이름");
		nameL.setFont(new Font("휴먼엑스포", Font.PLAIN, 12));
		nameL.setBounds(25, 85, 57, 21);
		Su.getContentPane().add(nameL);

		JLabel idL = new JLabel("ID :");
		idL.setFont(new Font("Dubai", Font.PLAIN, 15));
		idL.setBounds(25, 136, 57, 15);
		Su.getContentPane().add(idL);

		IDlabel = new JLabel("");
		IDlabel.setBounds(92, 161, 237, 15);
		Su.getContentPane().add(IDlabel);

		JLabel pwL = new JLabel("pw");
		pwL.setFont(new Font("Dubai", Font.PLAIN, 15));
		pwL.setBounds(25, 189, 57, 15);
		Su.getContentPane().add(pwL);

		JLabel pw2L = new JLabel("pw 확인");
		pw2L.setFont(new Font("휴먼엑스포", Font.PLAIN, 12));
		pw2L.setBounds(25, 230, 57, 15);
		Su.getContentPane().add(pw2L);

		JLabel tellL = new JLabel("tell");
		tellL.setFont(new Font("Dubai", Font.PLAIN, 15));
		tellL.setBounds(25, 315, 57, 15);
		Su.getContentPane().add(tellL);

		JLabel addressL = new JLabel("주소");
		addressL.setFont(new Font("휴먼엑스포", Font.PLAIN, 12));
		addressL.setBounds(25, 358, 57, 15);
		Su.getContentPane().add(addressL);

		JLabel phL = new JLabel("비밀번호 힌트");
		phL.setFont(new Font("휴먼엑스포", Font.PLAIN, 12));
		phL.setBounds(12, 457, 97, 15);
		Su.getContentPane().add(phL);

		textname = new JTextField();
		textname.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		textname.setBounds(92, 80, 237, 26);
		Su.getContentPane().add(textname);
		textname.setColumns(10);

		textID = new JTextField();
		textID.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		textID.setColumns(10);
		textID.setBounds(92, 133, 237, 26);
		Su.getContentPane().add(textID);

		textPw = new JPasswordField();
		textPw.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		textPw.setColumns(10);
		textPw.setBounds(92, 186, 237, 26);
		Su.getContentPane().add(textPw);

		textPw2 = new JPasswordField();
		textPw2.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		textPw2.setColumns(10);
		textPw2.setBounds(92, 227, 237, 26);
		Su.getContentPane().add(textPw2);

		textTell = new JTextField();
		textTell.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		textTell.setColumns(10);
		textTell.setBounds(92, 312, 237, 26);
		Su.getContentPane().add(textTell);

		textA1 = new JTextField();
		textA1.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		textA1.setColumns(10);
		textA1.setBounds(92, 352, 237, 26);
		Su.getContentPane().add(textA1);

		textA2 = new JTextField();
		textA2.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		textA2.setColumns(10);
		textA2.setBounds(92, 394, 237, 26);
		Su.getContentPane().add(textA2);

		textPh = new JTextField();
		textPh.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		textPh.setColumns(10);
		textPh.setBounds(92, 449, 237, 26);
		Su.getContentPane().add(textPh);
		
		CustomerDAO cdao = new CustomerDAO();

		JButton b1 = new JButton("중복확인"); // 아이디 중복 확인 창
		b1.setForeground(new Color(0, 0, 0));
		b1.setBackground(new Color(192, 192, 192));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				try {
					idlist = cdao.checkID();
				} catch (Exception e10) {
				}
				if (idlist.indexOf(textID.getText()) == -1) {
					IDlabel.setText("사용할 수 있는 아이디입니다");
				} else {
					IDlabel.setText("사용할 수 없는 아이디입니다");
				}

			}
		});
		b1.setFont(new Font("휴먼엑스포", Font.PLAIN, 12));
		b1.setBounds(361, 132, 97, 23);
		Su.getContentPane().add(b1);
		
		
		JButton b2 = new JButton("중복확인"); // 비밀번호 중복확인
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data1 = textPw.getText();
				String data2 = textPw2.getText();
				if (data1.equals(data2)) {
					JOptionPane.showMessageDialog(null, "사용 가능한 비밀 번호 입니다.");
				} else {
					JOptionPane.showMessageDialog(null, "비밀 번호가 같지 않습니다.");
				}

			}
		});
		b2.setForeground(new Color(0, 0, 0));
		b2.setBackground(new Color(192, 192, 192));
		b2.setFont(new Font("휴먼엑스포", Font.PLAIN, 12));
		b2.setBounds(361, 226, 97, 23);
		Su.getContentPane().add(b2);

		JButton b3 = new JButton("확인"); // 확인창
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textname.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "이름을 입력하세요.");
				} else if (textID.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "ID를 입력하세요.");
				} else if (textPw.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "비밀번호 를 입력하세요.");
				} else if (textPw2.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "비밀번호를 확인해 주세요.");
				} else if (textTell.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "전화번호 를 입력하세요.");
				} else if (textA1.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "주소를 입력하세요.");
				} else if (textA2.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "주소를 정확히 입력하세요.");
				} else if (textPh.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "비밀번호 힌트를 입력하세요.");
				} else {
					CustomerDTO cdto = new CustomerDTO();
					cdto.setName(textname.getText());
					cdto.setId(textID.getText());
					cdto.setPw(textPw.getText());
					cdto.setTel(textTell.getText());
					cdto.setAddress1(textA1.getText());
					cdto.setAddress2(textA2.getText());
					cdto.setPwhint(textPh.getText());
					try {
						String data1 = textPw.getText();
						String data2 = textPw2.getText();
						if (idlist == null) {
							JOptionPane.showMessageDialog(null, "아이디 중복확인을 해주세요");
						} else if (idlist.indexOf(textID.getText()) != -1 || data1.equals(data2)) {
							cdao.insert(cdto);
							Su.dispose();
						} else {
							JOptionPane.showMessageDialog(null, "아이디가 중복되지 않거나 비밀번호가 틀립니다!");
						}
					} catch (Exception e2) {

					}
				}

			}
		});
		b3.setForeground(new Color(0, 0, 0));
		b3.setBackground(new Color(192, 192, 192));
		b3.setFont(new Font("휴먼엑스포", Font.PLAIN, 12));
		b3.setBounds(147, 511, 97, 23);
		Su.getContentPane().add(b3);

		Su.setVisible(true);
	}

}
