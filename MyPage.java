package shoesshop;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class MyPage {
	private static JPasswordField textPw;
	private static JPasswordField textPw2;
	private static JTextField texttel;
	private static JTextField textaddress;
	private static JTextField textaddress2;
	private static JTextField textph;
	JLabel checkpw;
	

	public void MyPageView(CustomerDTO dto) {
		JFrame mypageview = new JFrame();
		mypageview.getContentPane().setBackground(Color.WHITE);
		mypageview.getContentPane().setFont(new Font("휴먼엑스포", Font.PLAIN, 12));
		mypageview.setTitle("회원가입");
		mypageview.setSize(501, 600);
		mypageview.setLocationRelativeTo(null);
		mypageview.getContentPane().setLayout(null);

		JLabel pagelabel = new JLabel("마이 페이지");
		pagelabel.setHorizontalAlignment(SwingConstants.CENTER);
		pagelabel.setFont(new Font("휴먼엑스포", Font.PLAIN, 12));
		pagelabel.setBounds(137, 25, 192, 35);
		mypageview.getContentPane().add(pagelabel);

		JLabel namelabel = new JLabel("이름");
		namelabel.setFont(new Font("휴먼엑스포", Font.PLAIN, 12));
		namelabel.setBounds(25, 85, 57, 21);
		mypageview.getContentPane().add(namelabel);


		JLabel IDlabel = new JLabel("ID :");
		IDlabel.setFont(new Font("Dubai", Font.PLAIN, 15));
		IDlabel.setBounds(25, 136, 57, 15);
		mypageview.getContentPane().add(IDlabel);


		JLabel pwlabel = new JLabel("pw");
		pwlabel.setFont(new Font("Dubai", Font.PLAIN, 15));
		pwlabel.setBounds(25, 189, 57, 15);
		mypageview.getContentPane().add(pwlabel);
		

		JLabel tellabel = new JLabel("tel");
		tellabel.setFont(new Font("Dubai", Font.PLAIN, 15));
		tellabel.setBounds(25, 315, 57, 15);
		mypageview.getContentPane().add(tellabel);

		JLabel addresslabel = new JLabel("주소");
		addresslabel.setFont(new Font("휴먼엑스포", Font.PLAIN, 12));
		addresslabel.setBounds(25, 358, 57, 15);
		mypageview.getContentPane().add(addresslabel);

		JLabel address2label = new JLabel("pw 확인");
		address2label.setFont(new Font("휴먼엑스포", Font.PLAIN, 12));
		address2label.setBounds(25, 230, 57, 15);
		mypageview.getContentPane().add(address2label);

		JLabel phlabel = new JLabel("비밀번호 힌트");
		phlabel.setFont(new Font("휴먼엑스포", Font.PLAIN, 12));
		phlabel.setBounds(12, 457, 97, 15);
		mypageview.getContentPane().add(phlabel);

		textPw = new JPasswordField();
		textPw.setFont(new Font("굴림", Font.PLAIN, 17));
		textPw.setColumns(10);
		textPw.setBounds(92, 186, 237, 26);
		textPw.setText("");
		mypageview.getContentPane().add(textPw);

		textPw2 = new JPasswordField();
		textPw2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (!textPw.getText().equals(textPw2.getText())) {
					checkpw.setText("비밀번호가 틀립니다!");
				} else {
					checkpw.setText("비밀번호가 같습니다.");
				}
			}
		});
		textPw2.setFont(new Font("굴림", Font.PLAIN, 17));
		textPw2.setColumns(10);
		textPw2.setBounds(92, 227, 237, 26);
		textPw2.setText("");
		mypageview.getContentPane().add(textPw2);

		texttel = new JTextField();
		texttel.setFont(new Font("굴림", Font.PLAIN, 17));
		texttel.setColumns(10);
		texttel.setBounds(92, 312, 237, 26);
		texttel.setText(dto.getTel());
		mypageview.getContentPane().add(texttel);

		textaddress = new JTextField();
		textaddress.setFont(new Font("굴림", Font.PLAIN, 17));
		textaddress.setColumns(10);
		textaddress.setBounds(92, 352, 237, 26);
		textaddress.setText(dto.getAddress1());
		mypageview.getContentPane().add(textaddress);

		textaddress2 = new JTextField();
		textaddress2.setFont(new Font("굴림", Font.PLAIN, 17));
		textaddress2.setColumns(10);
		textaddress2.setBounds(92, 394, 237, 26);
		textaddress2.setText(dto.getAddress2());
		mypageview.getContentPane().add(textaddress2);

		textph = new JTextField();
		textph.setFont(new Font("굴림", Font.PLAIN, 17));
		textph.setColumns(10);
		textph.setBounds(92, 449, 237, 26);
		textph.setText(dto.getPwhint());
		mypageview.getContentPane().add(textph);

		JButton b1 = new JButton("확인");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e313) {
				dto.setTel(texttel.getText());
				dto.setAddress1(textaddress.getText());
				dto.setAddress2(textaddress2.getText());
				dto.setPwhint(textph.getText());				
				CustomerDAO dao = new CustomerDAO();
				try {
					dao.update(dto);
				} catch (Exception e2) {}
				int result = JOptionPane.showConfirmDialog(null, "계속 수정하시겠습니까?","Confirm",JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.NO_OPTION) {
					mypageview.dispose();
				}
			}
		});
		b1.setForeground(new Color(0, 0, 0));
		b1.setBackground(new Color(192, 192, 192));
		b1.setFont(new Font("휴먼엑스포", Font.PLAIN, 12));
		b1.setBounds(147, 511, 97, 23);
		mypageview.getContentPane().add(b1);

		JLabel lname = new JLabel();
		lname.setBounds(92, 87, 125, 26);
		lname.setText(dto.getName());
		mypageview.getContentPane().add(lname);

		JLabel lid = new JLabel();
		lid.setBounds(92, 136, 125, 26);
		lid.setText(dto.getId());
		mypageview.getContentPane().add(lid);

		JButton pkbutton = new JButton("비밀번호 변경");
		pkbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e12333) {
				if (!textPw.getText().equals(textPw2.getText())) {
					JOptionPane.showMessageDialog(null, "비밀번호가 같지 않습니다!");
				} else {
					dto.setPw(textPw.getText());
					CustomerDAO dao = new CustomerDAO();
					try {dao.pwupdate(dto);} catch (Exception pw123) {}
					JOptionPane.showMessageDialog(null, "비밀번호가 성공적으로 변경되었습니다.");
				}
			}
		});
		pkbutton.setFont(new Font("휴먼엑스포", Font.PLAIN, 12));
		pkbutton.setBounds(341, 230, 132, 23);
		mypageview.getContentPane().add(pkbutton);
		
		JButton cancelbutton = new JButton("취소");
		cancelbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c) {
				mypageview.dispose();
			}
		});
		cancelbutton.setFont(new Font("휴먼엑스포", Font.PLAIN, 12));
		cancelbutton.setBounds(256, 510, 104, 24);
		mypageview.getContentPane().add(cancelbutton);
		
		checkpw = new JLabel("");
		checkpw.setBounds(92, 265, 237, 15);
		mypageview.getContentPane().add(checkpw);

		mypageview.setVisible(true);
	}
}
