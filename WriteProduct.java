package shoesshop;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class WriteProduct {

	static JFrame WriteFrame;
	JLabel 판매가, 상품명, nulllabel1, nulllabel2;
	JButton Write, Cancel;
	JScrollPane scroll;
	JPanel mainpanel, panel;
	JTextField PnameText;
	JTextField PriceText;
	JTextArea PcontentText;
	JButton PictureButton;
	JTextField PictureName;
	FindPhoto fp;
	MainView main;
	static CustomerDTO cdto;
	String path;

	public void WriteProductView(CustomerDTO cdto) {
		this.cdto = cdto;
		
		WriteFrame = new JFrame("상품 작성");
		WriteFrame = new JFrame();
		WriteFrame.getContentPane().setLayout(null);
		WriteFrame.setSize(500, 580);
		WriteFrame.setLocationRelativeTo(null);

		ProductDTO dto = new ProductDTO();
		ProductDAO dao = new ProductDAO();

		Write = new JButton("작성하기");
		Write.setBounds(135, 0, 115, 25);
		WriteFrame.getContentPane().add(Write);
		Write.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				if (PnameText.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "이름을 입력해주세요");
				} else if (PriceText.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "가격을 입력해주세요");
				} else {
					dto.setPname(PnameText.getText());
					dto.setPrice(Integer.parseInt(PriceText.getText()));
					dto.setPcontent(PcontentText.getText());
					dto.setPicture(PictureName.getText());
					try {
						dao.insert(dto);
					} catch (Exception e2) {
					}
					int keep = JOptionPane.showConfirmDialog(null, "계속 작성하시겠습니까?","Confirm",JOptionPane.YES_NO_OPTION);
					if (keep == JOptionPane.YES_OPTION) {
						PnameText.setText("");
						PriceText.setText("");
						PcontentText.setText("");
						PictureName.setText("");
					} else {
						main = new MainView();
						main.MainViewLogIn(cdto);
						WriteFrame.dispose();
					}
				}

			}
		});
		Write.setFont(new Font("굴림", Font.PLAIN, 14));

		Cancel = new JButton("작성취소");
		Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e3) {
				main = new MainView();
				main.MainViewLogIn(cdto);
				WriteFrame.dispose();
			}
		});
		Cancel.setBounds(250, 0, 109, 25);
		WriteFrame.getContentPane().add(Cancel);
		Cancel.setFont(new Font("굴림", Font.PLAIN, 14));

		상품명 = new JLabel("상품명");
		판매가 = new JLabel("판매가");

		PcontentText = new JTextArea();
		PcontentText.setSize(420,500);

		PnameText = new JTextField();

		PriceText = new JTextField();

		PictureButton = new JButton("사진 넣기");
		PictureButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e4) {
				fp = new FindPhoto();
				fp.getImage();
			}
		});

		PictureName = new JTextField();
		PictureName.setText(path);
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(4, 2));
		panel.setSize(420, 60);
		
		nulllabel1 = new JLabel(" ");
		nulllabel2 = new JLabel(" ");
		
		panel.add(PictureButton);
		panel.add(상품명);
		panel.add(PictureName);
		panel.add(PnameText);
		panel.add(nulllabel1);
		panel.add(판매가);
		panel.add(nulllabel2);
		panel.add(PriceText);
		
		mainpanel = new JPanel();
		mainpanel.setBounds(12, 29, 460, 502);
		mainpanel.setLayout(new BoxLayout(mainpanel, BoxLayout.PAGE_AXIS));
		mainpanel.add(panel);
		mainpanel.add(PcontentText);
		
		scroll = new JScrollPane(mainpanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		scroll.setBounds(12, 29, 460, 502);
		WriteFrame.getContentPane().add(scroll);

		WriteFrame.setVisible(true);
	}
	
	void rep() {
		WriteFrame.dispose();
		WriteProductView(cdto);
	}

	
}
