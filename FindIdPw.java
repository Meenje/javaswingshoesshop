package shoesshop;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FindIdPw {
	JTextField nametext;
	JTextField teltext;
	static CustomerDTO cdto;

	public void IdView() {
		JFrame idview = new JFrame("ID 찾기");
		idview.getContentPane().setLayout(null);
		idview.setSize(253, 192);
		idview.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("이름");
		lblNewLabel.setBounds(24, 10, 57, 15);
		idview.getContentPane().add(lblNewLabel);

		nametext = new JTextField();
		nametext.setBounds(24, 35, 201, 21);
		idview.getContentPane().add(nametext);
		nametext.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("전화번호");
		lblNewLabel_1.setBounds(24, 64, 57, 15);
		idview.getContentPane().add(lblNewLabel_1);

		teltext = new JTextField();
		teltext.setBounds(24, 89, 201, 21);
		teltext.setColumns(15);
		idview.getContentPane().add(teltext);

		JButton button = new JButton("찾기");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerDAO cdao = new CustomerDAO();
				try {
					cdto = cdao.FindId(nametext.getText(), teltext.getText());
					if (cdto == null) {
						JOptionPane.showMessageDialog(null, "찾는 아이디가 없습니다.");
					} else {
						idview.dispose();
						FindIdPw fip = new FindIdPw();
						fip.HintView(cdto);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(73, 120, 97, 23);
		idview.getContentPane().add(button);

		idview.setVisible(true);
	}

	public void HintView(CustomerDTO cdto) {
		JFrame hintview = new JFrame("PW 찾기");
		hintview.getContentPane().setLayout(null);
		hintview.setSize(253, 192);
		hintview.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setBounds(24, 10, 57, 15);
		hintview.getContentPane().add(lblNewLabel);

		JLabel idlabel = new JLabel();
		idlabel.setBounds(24, 35, 201, 21);
		hintview.getContentPane().add(idlabel);
		idlabel.setText(cdto.getId());

		JLabel lblNewLabel_1 = new JLabel("패스워드 힌트");
		lblNewLabel_1.setBounds(24, 64, 90, 15);
		hintview.getContentPane().add(lblNewLabel_1);

		JLabel hintlabel = new JLabel();
		hintlabel.setBounds(24, 89, 201, 21);
		hintview.getContentPane().add(hintlabel);
		hintlabel.setText(cdto.getPwhint());


		JButton button = new JButton("닫기");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hintview.dispose();
			}
		});
		button.setBounds(73, 120, 97, 23);
		hintview.getContentPane().add(button);

		hintview.setVisible(true);
	}
}
