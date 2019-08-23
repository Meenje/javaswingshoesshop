package shoesshop;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LogIn {
	private static JTextField pwtext;

	public void LogInView(JFrame f) {

		JFrame loginview = new JFrame();
		loginview.getContentPane().setBackground(Color.WHITE);
		loginview.setTitle("login");
		loginview.setSize(501, 300);
		loginview.setLocationRelativeTo(null);
		
		JTextField idtext = new JTextField();
		idtext.setBounds(117, 49, 261, 30);
		idtext.setColumns(17);
		idtext.setFont(new Font("굴림", Font.PLAIN, 20));
		JButton b1 = new JButton("로그인");
		b1.setBackground(Color.WHITE);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CustomerDTO dto = new CustomerDTO();
				CustomerDAO dao = new CustomerDAO();
				try {
					dto = dao.Iogin(idtext.getText());
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (dto.getId() == null) {
					JOptionPane.showMessageDialog(null, "ID와 비밀번호를 다시 확인해주세요.");
				} else if (dto.getPw().equals(pwtext.getText())) {
					JOptionPane.showMessageDialog(null, "로그인 되었습니다.");
					loginview.dispose();
					f.dispose();
					MainView main = new MainView();
					main.MainViewLogIn(dto);
				} else {
					JOptionPane.showMessageDialog(null, "ID와 비밀번호를 다시 확인해주세요.");
				}
			}
		});
		b1.setBounds(169, 172, 123, 29);
		b1.setFont(new Font("휴먼모음T", Font.PLAIN, 12));
		loginview.getContentPane().setLayout(null);

		JLabel idlb = new JLabel("ID");
		idlb.setBackground(Color.WHITE);
		idlb.setForeground(Color.BLACK);
		idlb.setBounds(36, 47, 22, 30);
		idlb.setFont(new Font("굴림", Font.PLAIN, 25));
		loginview.getContentPane().add(idlb);

		loginview.getContentPane().add(idtext);
		loginview.getContentPane().add(b1);

		JLabel pwlb = new JLabel("PW");
		pwlb.setBackground(Color.WHITE);
		pwlb.setForeground(Color.BLACK);
		pwlb.setBounds(36, 112, 38, 30);
		pwlb.setFont(new Font("굴림", Font.PLAIN, 25));
		loginview.getContentPane().add(pwlb);

		pwtext = new JPasswordField();
		pwtext.setBounds(117, 114, 261, 30);
		pwtext.setFont(new Font("굴림", Font.PLAIN, 20));
		loginview.getContentPane().add(pwtext);
		pwtext.setColumns(17);

		JButton btnNewButton = new JButton("회원가입");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Signin si = new Signin();
				si.SigninView();
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("휴먼모음T", Font.PLAIN, 12));
		btnNewButton.setBounds(81, 211, 97, 23);
		loginview.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("ID,PW 찾기");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FindIdPw fip = new FindIdPw();
				fip.IdView();
			}
		});
		
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("휴먼모음T", Font.PLAIN, 12));
		btnNewButton_1.setBounds(271, 211, 97, 23);
		loginview.getContentPane().add(btnNewButton_1);

		loginview.setVisible(true);
	}
}
