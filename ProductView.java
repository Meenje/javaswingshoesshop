package shoesshop;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ProductView {
	static JFrame f;
	static JLabel basket, mypage, signin, login;
	private JLabel productname;
	private JLabel 판매가, picture, 상품명;
	private JLabel price;
	static JButton cart, buy;
	static JScrollPane scroll;
	private JPanel panel;
	private JPanel contentPanel;
	private JLabel home;
	JTextArea content;
	static ProductDTO dto;
	static CustomerDTO cdto;

	public void ProductViewLogIn(ProductDTO dto, CustomerDTO cdto) {
		this.cdto = cdto;
		this.dto = dto;
		
		f = new JFrame();
		f.getContentPane().setLayout(null);
		f.setSize(500, 580);
		f.setLocationRelativeTo(null);

		basket = new JLabel("장바구니");
		basket.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BasketDAO bdao = new BasketDAO();
				ArrayList<ProductDTO> plist = new ArrayList<ProductDTO>();
				f.dispose();
				Basket basket = new Basket();
				try {
					plist = bdao.getProduct(cdto);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				basket.BasketView(plist, cdto);
			}
		});
		basket.setHorizontalAlignment(SwingConstants.CENTER);
		basket.setBounds(343, 10, 57, 15);
		f.getContentPane().add(basket);

		mypage = new JLabel("마이페이지");
		mypage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent em) {
				MyPage mp = new MyPage();
				mp.MyPageView(cdto);
			}
		});
		mypage.setHorizontalAlignment(SwingConstants.CENTER);
		mypage.setBounds(403, 10, 69, 15);
		f.getContentPane().add(mypage);

		home = new JLabel("");
		home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainView main = new MainView();
				main.MainViewLogIn(cdto);
				f.dispose();
			}
		});
		home.setBounds(13, 10, 15, 15);
		home.setIcon(
				new ImageIcon(new ImageIcon("home.png").getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT)));
		f.getContentPane().add(home);

		panel = new JPanel();
		panel.setBounds(12, 29, 460, 502);
		f.getContentPane().add(panel);
		panel.setLayout(null);

		picture = new JLabel("product view");
		picture.setBounds(12, 10, 150, 150);
		panel.add(picture);

		상품명 = new JLabel("상품명");
		상품명.setBounds(193, 10, 236, 15);
		panel.add(상품명);

		productname = new JLabel("productname");
		productname.setBounds(193, 35, 236, 15);
		panel.add(productname);

		판매가 = new JLabel("판매가");
		판매가.setBounds(193, 74, 74, 15);
		panel.add(판매가);

		price = new JLabel("price");
		price.setBounds(193, 99, 236, 15);
		panel.add(price);
		
		if (cdto.getAdmin() == 99) {
			cart = new JButton("삭제하기");
			cart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ProductDAO pdao = new ProductDAO();
					try {
						pdao.delete(dto);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					MainView mmain = new MainView();
					mmain.MainViewLogIn(cdto);
					f.dispose();
				}
			});
			cart.setBounds(193, 135, 100, 25);
			panel.add(cart);
		} else {
		cart = new JButton("Cart");
		cart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "장바구니에 넣겠습니까?", "장바구니", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					BasketDAO bdao = new BasketDAO();
					try {
						bdao.insert(cdto, dto);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else {
				}
			}
		});
		cart.setBounds(193, 135, 74, 25);
		panel.add(cart);
		cart.setFont(new Font("HancomEQN", Font.BOLD, 14));
		}
		
		if (cdto.getAdmin() != 99 ) {
		buy = new JButton("Buy now");
		buy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<ProductDTO> plist = new ArrayList<ProductDTO>();
				plist.add(dto);
				Payment pppm = new Payment();
				pppm.PaymentView(plist, cdto);
				f.dispose();
			}
		});
		buy.setBounds(285, 135, 109, 25);
		panel.add(buy);
		buy.setFont(new Font("HancomEQN", Font.BOLD, 14));
		}

		scroll = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		contentPanel = new JPanel();
		contentPanel.setBounds(0, 170, 441, 330);
		panel.add(contentPanel);

		content = new JTextArea();
		content.setEditable(false);
		content.setBounds(0, 170, 441, 330);
		contentPanel.add(content);

		scroll.setBounds(12, 29, 460, 502);
		f.getContentPane().add(scroll);

		productname.setText(dto.getPname());
		price.setText(String.valueOf(dto.getPrice()));
		picture.setIcon(new ImageIcon(
				new ImageIcon(dto.getPicture()).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
		content.setText(dto.getPcontent());

		f.setVisible(true);
	}
	
	//--------------------------------------------------------------------------------------------------------------------------

	public void ProductViewLogOut(ProductDTO dto) {
		f = new JFrame();
		f.getContentPane().setLayout(null);
		f.setSize(500, 580);
		f.setLocationRelativeTo(null);

		signin = new JLabel("회원가입");
		signin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Signin si = new Signin();
				si.SigninView();
			}
		});
		signin.setHorizontalAlignment(SwingConstants.CENTER);
		signin.setBounds(343, 10, 57, 15);
		f.getContentPane().add(signin);

		login = new JLabel("로그인");
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LogIn login = new LogIn();
				login.LogInView(f);
			}
		});
		login.setHorizontalAlignment(SwingConstants.CENTER);
		login.setBounds(403, 10, 69, 15);
		f.getContentPane().add(login);

		home = new JLabel("");
		home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainView main = new MainView();
				main.MainViewLogOut();
				f.dispose();
			}
		});
		home.setBounds(13, 10, 15, 15);
		home.setIcon(
				new ImageIcon(new ImageIcon("home.png").getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT)));
		f.getContentPane().add(home);

		panel = new JPanel();
		panel.setBounds(12, 29, 460, 502);
		f.getContentPane().add(panel);
		panel.setLayout(null);

		picture = new JLabel("product view");
		picture.setBounds(12, 10, 150, 150);
		panel.add(picture);

		상품명 = new JLabel("상품명");
		상품명.setBounds(193, 10, 236, 15);
		panel.add(상품명);

		productname = new JLabel("productname");
		productname.setBounds(193, 35, 236, 15);
		panel.add(productname);

		판매가 = new JLabel("판매가");
		판매가.setBounds(193, 74, 74, 15);
		panel.add(판매가);

		price = new JLabel("price");
		price.setBounds(193, 99, 236, 15);
		panel.add(price);

		cart = new JButton("Cart");
		cart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "회원가입을 하시겠습니까?", "장바구니는 로그인 후 이용가능합니다.", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					Signin si = new Signin();
					si.SigninView();
				}
			}
		});
		cart.setBounds(193, 135, 74, 25);
		panel.add(cart);
		cart.setFont(new Font("HancomEQN", Font.BOLD, 14));

		buy = new JButton("Buy now");
		buy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "회원가입을 하시겠습니까?", "상품구매는 로그인 후 이용가능합니다.", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					Signin si = new Signin();
					si.SigninView();
				}
			}
		});
		buy.setBounds(285, 135, 109, 25);
		panel.add(buy);
		buy.setFont(new Font("HancomEQN", Font.BOLD, 14));

		scroll = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		contentPanel = new JPanel();
		contentPanel.setBounds(0, 170, 441, 330);
		panel.add(contentPanel);

		content = new JTextArea();
		content.setEditable(false);
		content.setBounds(0, 170, 441, 330);
		contentPanel.add(content);

		scroll.setBounds(12, 29, 460, 502);
		f.getContentPane().add(scroll);

		productname.setText(dto.getPname());
		price.setText(String.valueOf(dto.getPrice()));
		picture.setIcon(new ImageIcon(
				new ImageIcon(dto.getPicture()).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
		content.setText(dto.getPcontent());

		f.setVisible(true);
	}
}
