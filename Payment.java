package shoesshop;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class Payment implements ActionListener {
	static JFrame payview;
	static JLabel basket, mypage;
	static JLabel showtotalprice;
	private static JTextField nametext;
	private static JTextField phonetext;
	private static JTextField addresstext1;
	private static JTextField addresstext2;
	private static JTextField emailtext;
	int selectbutton = 1;
	ArrayList<ProductDTO> plist;
	ArrayList<ProductDTO> paylist;
	static CustomerDTO cdto;
	JLabel[] photos;
	JLabel[] pnames;
	JLabel[] pricelabels;
	JButton[] deletebuttons;
	JPanel[] panels, buttonpanels;
	int pricesum;

	public void PaymentView(ArrayList<ProductDTO> plist, CustomerDTO cdto) {
		this.plist = plist;
		this.cdto = cdto;

		payview = new JFrame("결재창");
		payview.setSize(500, 562);
		payview.setLocationRelativeTo(null);
		payview.getContentPane().setLayout(null);

		basket = new JLabel("장바구니");
		basket.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Basket basket = new Basket();
				BasketDAO bdao = new BasketDAO();
				try {
					paylist = bdao.getProduct(cdto);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				basket.BasketView(paylist, cdto);
				payview.dispose();
			}
		});
		basket.setHorizontalAlignment(SwingConstants.CENTER);
		basket.setBounds(300, 10, 80, 15);
		payview.getContentPane().add(basket);

		mypage = new JLabel("마이페이지");
		mypage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent em) {
				MyPage mp = new MyPage();
				mp.MyPageView(cdto);
			}
		});
		mypage.setHorizontalAlignment(SwingConstants.CENTER);
		mypage.setBounds(392, 10, 80, 15);
		payview.getContentPane().add(mypage);

		JPanel panel = new JPanel();
		panel.setBounds(12, 30, 460, 159);
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(12, 30, 460, 159);
		payview.getContentPane().add(scrollPane);

		photos = new JLabel[plist.size()];
		pnames = new JLabel[plist.size()];
		pricelabels = new JLabel[plist.size()];
		deletebuttons = new JButton[plist.size()];
		buttonpanels = new JPanel[plist.size()];
		panels = new JPanel[plist.size()];

		pricesum = 0;

		for (int i = 0; i < plist.size(); i++) {
			photos[i] = new JLabel();
			pnames[i] = new JLabel();
			pricelabels[i] = new JLabel();
			deletebuttons[i] = new JButton();
			deletebuttons[i].setText("삭제");
			deletebuttons[i].setActionCommand(plist.get(i).getPname());
			buttonpanels[i] = new JPanel();
			panels[i] = new JPanel();
			panels[i].setLayout(new GridLayout(1, 4));
			buttonpanels[i].setLayout(new GridBagLayout());

			photos[i].setIcon(new ImageIcon(new ImageIcon(plist.get(i).getPicture()).getImage().getScaledInstance(80,
					80, Image.SCALE_DEFAULT)));
			pnames[i].setText(plist.get(i).getPname());
			pricelabels[i].setText(String.valueOf(plist.get(i).getPrice()) + "원");

			panels[i].add(photos[i]);
			panels[i].add(pnames[i]);
			panels[i].add(pricelabels[i]);
			buttonpanels[i].add(deletebuttons[i], new GridBagConstraints());
			panels[i].add(buttonpanels[i]);
			panel.add(panels[i]);

			deletebuttons[i].addActionListener(this);

			pricesum = pricesum + plist.get(i).getPrice();
		}

		showtotalprice = new JLabel("총 가격은 " + String.valueOf(pricesum) + "원입니다.");
		showtotalprice.setHorizontalAlignment(SwingConstants.CENTER);
		showtotalprice.setBounds(29, 213, 421, 15);
		payview.getContentPane().add(showtotalprice);

		JRadioButton rbutton1 = new JRadioButton(" 새 배송지");
		rbutton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nametext.setText("");
				phonetext.setText("");
				addresstext1.setText("");
				addresstext2.setText("");
			}
		});
		rbutton1.setBounds(29, 246, 96, 23);
		payview.getContentPane().add(rbutton1);

		JRadioButton rbutton2 = new JRadioButton(" 기존 배송지");
		rbutton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nametext.setText(cdto.getName());
				phonetext.setText(cdto.getTel());
				addresstext1.setText(cdto.getAddress1());
				addresstext2.setText(cdto.getAddress2());
			}
		});
		rbutton2.setBounds(129, 246, 109, 23);
		payview.getContentPane().add(rbutton2);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rbutton1);
		bg.add(rbutton2);
		rbutton1.setSelected(true);

		JLabel name = new JLabel("이름");
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setBounds(29, 285, 38, 15);
		payview.getContentPane().add(name);

		nametext = new JTextField();
		nametext.setBounds(79, 282, 116, 21);
		payview.getContentPane().add(nametext);
		nametext.setColumns(10);

		JLabel phonelabel = new JLabel("Tel.");
		phonelabel.setHorizontalAlignment(SwingConstants.CENTER);
		phonelabel.setBounds(29, 320, 38, 15);
		payview.getContentPane().add(phonelabel);

		phonetext = new JTextField();
		phonetext.setColumns(10);
		phonetext.setBounds(79, 317, 214, 21);
		payview.getContentPane().add(phonetext);

		JLabel addresslabel = new JLabel("주소");
		addresslabel.setHorizontalAlignment(SwingConstants.CENTER);
		addresslabel.setBounds(29, 351, 38, 15);
		payview.getContentPane().add(addresslabel);

		addresstext1 = new JTextField();
		addresstext1.setColumns(10);
		addresstext1.setBounds(79, 348, 324, 21);
		payview.getContentPane().add(addresstext1);

		addresstext2 = new JTextField();
		addresstext2.setColumns(10);
		addresstext2.setBounds(79, 381, 324, 21);
		payview.getContentPane().add(addresstext2);

		JLabel emaillabel = new JLabel("E-mail");
		emaillabel.setHorizontalAlignment(SwingConstants.CENTER);
		emaillabel.setBounds(23, 416, 50, 15);
		payview.getContentPane().add(emaillabel);

		emailtext = new JTextField();
		emailtext.setColumns(10);
		emailtext.setBounds(79, 413, 214, 21);
		payview.getContentPane().add(emailtext);

		JLabel home = new JLabel("홈으로가기");
		home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent em) {
				MainView m = new MainView();
				m.MainViewLogIn(cdto);
				payview.dispose();
			}
		});
		home.setBounds(23, 10, 67, 15);
		payview.getContentPane().add(home);

		JButton paymentbutton = new JButton("결제하기");
		paymentbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PayMethod way = new PayMethod();
				if (selectbutton == 1) {
					way.depositView(payview, cdto, plist, pricesum);
				} else if (selectbutton == 2) {
					way.accountView(payview, cdto, plist, pricesum);
				} else if (selectbutton == 3) {
					way.cardView(payview, cdto, plist);
				} else {
					JOptionPane.showMessageDialog(null, "????????");
				}
			}
		});
		paymentbutton.setBounds(193, 488, 97, 23);
		payview.getContentPane().add(paymentbutton);

		JRadioButton paybutton1 = new JRadioButton(" 무통장 입금");
		paybutton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectbutton = 1;
			}
		});
		paybutton1.setHorizontalAlignment(SwingConstants.CENTER);
		paybutton1.setBounds(35, 452, 116, 23);
		payview.getContentPane().add(paybutton1);

		JRadioButton paybutton2 = new JRadioButton(" 실시간 계좌이체");
		paybutton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectbutton = 2;
			}
		});
		paybutton2.setHorizontalAlignment(SwingConstants.CENTER);
		paybutton2.setBounds(171, 452, 128, 23);
		payview.getContentPane().add(paybutton2);

		JRadioButton paybutton3 = new JRadioButton(" 신용카드");
		paybutton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectbutton = 3;
			}
		});
		paybutton3.setHorizontalAlignment(SwingConstants.CENTER);
		paybutton3.setBounds(319, 452, 116, 23);
		payview.getContentPane().add(paybutton3);

		ButtonGroup pbg = new ButtonGroup();
		pbg.add(paybutton1);
		pbg.add(paybutton2);
		pbg.add(paybutton3);
		paybutton1.setSelected(true);

		payview.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int index = -1;
		for (int i = 0; i < plist.size(); i++) {
			if (plist.get(i).getPname().equals(e.getActionCommand())) {
				index = i;
			}
		}
		plist.remove(index);
		if (plist.size() ==0 || plist == null) {
			JOptionPane.showMessageDialog(null, "결재할 상품이 없어 장바구니로 넘어갑니다.");
			Basket basket = new Basket();
			BasketDAO bdao = new BasketDAO();
			try {
				paylist = bdao.getProduct(cdto);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			basket.BasketView(paylist, cdto);
			payview.dispose();
		} else {
		payview.dispose();
		Payment pm = new Payment();
		pm.PaymentView(plist, cdto);
		}
	}

}
