package shoesshop;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MainView {
	JFrame f;
	JLabel login, signin, logout, basket, mypage, title;
	JLabel p1, p2, p3, p4, p5, p6;
	JLabel pn1, pn2, pn3, pn4, pn5, pn6;
	JLabel page, before, after;
	JTextField searchfield;
	JButton WriteButton, search;
	int pagenumber, totalpage, pagecount;
	ArrayList<String> picturelist, picturelistaddnull, pnamelist, pnamelistaddnull;
	ArrayList<ProductDTO> dblist;
	static CustomerDTO cdto;

	public void MainViewLogIn(CustomerDTO cdto) {
		this.cdto = cdto;
		
		picturelist = new ArrayList<>();
		picturelistaddnull = new ArrayList<>();
		pnamelist = new ArrayList<>();
		pnamelistaddnull = new ArrayList<>();
		
		ProductDAO dao = new ProductDAO();
		try {
			dblist = dao.getAllDb();
		} catch (Exception e101) {
		}
		
		for (int i = 0; i < dblist.size(); i++) {
			picturelist.add(dblist.get(i).getPicture());
			}
		
		for (int i = 0; i < dblist.size(); i++) {
			pnamelist.add(dblist.get(i).getPname());
			}
		
		picturelistaddnull = picturelist;
		while(picturelistaddnull.size()%6 != 0) {
			picturelistaddnull.add(null);
		}
		if (picturelistaddnull.size() == 0) {
			for (int i = 0; i < 6; i++) {
				picturelistaddnull.add(null);
			}
		}
		
		pnamelistaddnull = pnamelist;
		while(pnamelistaddnull.size()%6 != 0) {
			pnamelistaddnull.add(null);
		}
		if (pnamelistaddnull.size() == 0) {
			for (int i = 0; i < 6; i++) {
				pnamelistaddnull.add(null);
			}
		}
		

		pagecount = dblist.size();
		
		if (pagecount == 0) {
			totalpage = 1;
		} else if (pagecount % 6 == 0) {
			totalpage = pagecount / 6;
		} else {
			totalpage = pagecount / 6 + 1;
		}

		pagenumber = 1;
		
		f = new JFrame();
		f.setTitle("빈티지 슈즈샵");
		f.setSize(500, 580);
		f.setLocationRelativeTo(null);
		
		f.getContentPane().setLayout(null);

		

		logout = new JLabel("로그아웃");
		logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				f.dispose();
				MainView main = new MainView();
				main.MainViewLogOut();
			}
		});
		logout.setHorizontalAlignment(SwingConstants.CENTER);
		logout.setBounds(283, 10, 59, 15);
		f.getContentPane().add(logout);

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

		title = new JLabel();
		title.setIcon(new ImageIcon(new ImageIcon("title.jpg").getImage().getScaledInstance(422, 67, Image.SCALE_DEFAULT)));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(31, 40, 422, 67);
		f.getContentPane().add(title);

		p1 = new JLabel("");
		p1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ep11) {
				if ((pagenumber - 1) * 6 + 0 < dblist.size()) {
				ProductView product1 = new ProductView();
				product1.ProductViewLogIn(dblist.get((pagenumber - 1) * 6 + 0), cdto);
				f.dispose();
				}
			}
		});
		p1.setHorizontalAlignment(SwingConstants.CENTER);
		p1.setBounds(31, 137, 130, 130);
		f.getContentPane().add(p1);

		pn1 = new JLabel("p1name");
		pn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ep12) {
				if ((pagenumber - 1) * 6 + 0 < dblist.size()) {
					ProductView product1 = new ProductView();
					product1.ProductViewLogIn(dblist.get((pagenumber - 1) * 6 + 0), cdto);
					f.dispose();
					}
			}
		});
		pn1.setHorizontalAlignment(SwingConstants.CENTER);
		pn1.setBounds(31, 277, 130, 15);
		f.getContentPane().add(pn1);

		p2 = new JLabel("");
		p2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ep21) {
				if ((pagenumber - 1) * 6 + 1 < dblist.size()) {
					ProductView product1 = new ProductView();
					product1.ProductViewLogIn(dblist.get((pagenumber - 1) * 6 + 1), cdto);
					f.dispose();
					}
			}
		});
		p2.setHorizontalAlignment(SwingConstants.CENTER);
		p2.setBounds(183, 137, 130, 130);
		f.getContentPane().add(p2);

		pn2 = new JLabel("p2name");
		pn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ep22) {
				if ((pagenumber - 1) * 6 + 1 < dblist.size()) {
					ProductView product1 = new ProductView();
					product1.ProductViewLogIn(dblist.get((pagenumber - 1) * 6 + 1), cdto);
					f.dispose();
					}
			}
		});
		pn2.setHorizontalAlignment(SwingConstants.CENTER);
		pn2.setBounds(183, 277, 130, 15);
		f.getContentPane().add(pn2);

		p3 = new JLabel("");
		p3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ep31) {
				if ((pagenumber - 1) * 6 + 2 < dblist.size()) {
					ProductView product1 = new ProductView();
					product1.ProductViewLogIn(dblist.get((pagenumber - 1) * 6 + 2), cdto);
					f.dispose();
					}
			}
		});
		p3.setHorizontalAlignment(SwingConstants.CENTER);
		p3.setBounds(325, 137, 130, 130);
		f.getContentPane().add(p3);

		pn3 = new JLabel("p3name");
		pn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ep32) {
				if ((pagenumber - 1) * 6 + 2 < dblist.size()) {
					ProductView product1 = new ProductView();
					product1.ProductViewLogIn(dblist.get((pagenumber - 1) * 6 + 2), cdto);
					f.dispose();
					}
			}
		});
		pn3.setHorizontalAlignment(SwingConstants.CENTER);
		pn3.setBounds(325, 277, 130, 15);
		f.getContentPane().add(pn3);

		p4 = new JLabel("");
		p4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ep41) {
				if ((pagenumber - 1) * 6 + 3 < dblist.size()) {
					ProductView product1 = new ProductView();
					product1.ProductViewLogIn(dblist.get((pagenumber - 1) * 6 + 3), cdto);
					f.dispose();
					}
			}
		});
		p4.setHorizontalAlignment(SwingConstants.CENTER);
		p4.setBounds(31, 302, 130, 130);
		f.getContentPane().add(p4);

		pn4 = new JLabel("p4name");
		pn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ep42) {
				if ((pagenumber - 1) * 6 + 3 < dblist.size()) {
					ProductView product1 = new ProductView();
					product1.ProductViewLogIn(dblist.get((pagenumber - 1) * 6 + 3), cdto);
					f.dispose();
					}
			}
		});
		pn4.setHorizontalAlignment(SwingConstants.CENTER);
		pn4.setBounds(31, 442, 130, 15);
		f.getContentPane().add(pn4);

		p5 = new JLabel("");
		p5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ep51) {
				if ((pagenumber - 1) * 6 + 4 < dblist.size()) {
					ProductView product1 = new ProductView();
					product1.ProductViewLogIn(dblist.get((pagenumber - 1) * 6 + 4), cdto);
					f.dispose();
					}
			}
		});
		p5.setHorizontalAlignment(SwingConstants.CENTER);
		p5.setBounds(183, 302, 130, 130);
		f.getContentPane().add(p5);

		pn5 = new JLabel("p5name");
		pn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ep52) {
				if ((pagenumber - 1) * 6 + 4 < dblist.size()) {
					ProductView product1 = new ProductView();
					product1.ProductViewLogIn(dblist.get((pagenumber - 1) * 6 + 4), cdto);
					f.dispose();
					}
			}
		});
		pn5.setHorizontalAlignment(SwingConstants.CENTER);
		pn5.setBounds(183, 442, 130, 15);
		f.getContentPane().add(pn5);

		p6 = new JLabel("");
		p6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ep61) {
				if ((pagenumber - 1) * 6 + 5 < dblist.size()) {
					ProductView product1 = new ProductView();
					product1.ProductViewLogIn(dblist.get((pagenumber - 1) * 6 + 5), cdto);
					f.dispose();
					}
			}
		});
		p6.setHorizontalAlignment(SwingConstants.CENTER);
		p6.setBounds(323, 302, 130, 130);
		f.getContentPane().add(p6);

		pn6 = new JLabel("p6name");
		pn6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ep62) {
				if ((pagenumber - 1) * 6 + 5 < dblist.size()) {
					ProductView product1 = new ProductView();
					product1.ProductViewLogIn(dblist.get((pagenumber - 1) * 6 + 5), cdto);
					f.dispose();
					}
			}
		});
		pn6.setHorizontalAlignment(SwingConstants.CENTER);
		pn6.setBounds(323, 442, 130, 15);
		f.getContentPane().add(pn6);

		page = new JLabel(pagenumber + "/" + totalpage);
		page.setHorizontalAlignment(SwingConstants.CENTER);
		page.setBounds(226, 516, 34, 15);
		f.getContentPane().add(page);

		before = new JLabel("<<");
		before.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (pagenumber == 1) {
					JOptionPane.showMessageDialog(null, "첫 페이지입니다!");
				} else {
					page.setText(String.valueOf(pagenumber - 1) + "/" + totalpage);
					pagenumber--;
					f.remove(p1);
					f.remove(p2);
					f.remove(p3);
					f.remove(p4);
					f.remove(p5);
					f.remove(p6);
					f.remove(pn1);
					f.remove(pn2);
					f.remove(pn3);
					f.remove(pn4);
					f.remove(pn5);
					f.remove(pn6);
					p1.setIcon(new ImageIcon(new ImageIcon(picturelistaddnull.get((pagenumber - 1) * 6 + 0)).getImage()
							.getScaledInstance(130, 130, Image.SCALE_DEFAULT)));
					p2.setIcon(new ImageIcon(new ImageIcon(picturelistaddnull.get((pagenumber - 1) * 6 + 1)).getImage()
							.getScaledInstance(130, 130, Image.SCALE_DEFAULT)));
					p3.setIcon(new ImageIcon(new ImageIcon(picturelistaddnull.get((pagenumber - 1) * 6 + 2)).getImage()
							.getScaledInstance(130, 130, Image.SCALE_DEFAULT)));
					p4.setIcon(new ImageIcon(new ImageIcon(picturelistaddnull.get((pagenumber - 1) * 6 + 3)).getImage()
							.getScaledInstance(130, 130, Image.SCALE_DEFAULT)));
					p5.setIcon(new ImageIcon(new ImageIcon(picturelistaddnull.get((pagenumber - 1) * 6 + 4)).getImage()
							.getScaledInstance(130, 130, Image.SCALE_DEFAULT)));
					p6.setIcon(new ImageIcon(new ImageIcon(picturelistaddnull.get((pagenumber - 1) * 6 + 5)).getImage()
							.getScaledInstance(130, 130, Image.SCALE_DEFAULT)));
					pn1.setText(pnamelistaddnull.get((pagenumber - 1) * 6 + 0));
					pn2.setText(pnamelistaddnull.get((pagenumber - 1) * 6 + 1));
					pn3.setText(pnamelistaddnull.get((pagenumber - 1) * 6 + 2));
					pn4.setText(pnamelistaddnull.get((pagenumber - 1) * 6 + 3));
					pn5.setText(pnamelistaddnull.get((pagenumber - 1) * 6 + 4));
					pn6.setText(pnamelistaddnull.get((pagenumber - 1) * 6 + 5));
					f.getContentPane().add(p1);
					f.getContentPane().add(p2);
					f.getContentPane().add(p3);
					f.getContentPane().add(p4);
					f.getContentPane().add(p5);
					f.getContentPane().add(p6);
					f.getContentPane().add(pn1);
					f.getContentPane().add(pn2);
					f.getContentPane().add(pn3);
					f.getContentPane().add(pn4);
					f.getContentPane().add(pn5);
					f.getContentPane().add(pn6);
					f.repaint();
				}
			}
		});
		before.setHorizontalAlignment(SwingConstants.CENTER);
		before.setBounds(197, 516, 39, 15);
		f.getContentPane().add(before);

		after = new JLabel(">>");
		after.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (pagenumber == totalpage) {
					JOptionPane.showMessageDialog(null, "마지막 페이지입니다!");
				} else {
					page.setText(String.valueOf(pagenumber + 1) + "/" + totalpage);
					pagenumber++;
					f.remove(p1);
					f.remove(p2);
					f.remove(p3);
					f.remove(p4);
					f.remove(p5);
					f.remove(p6);
					f.remove(pn1);
					f.remove(pn2);
					f.remove(pn3);
					f.remove(pn4);
					f.remove(pn5);
					f.remove(pn6);
					p1.setIcon(new ImageIcon(new ImageIcon(picturelistaddnull.get((pagenumber - 1) * 6 + 0)).getImage()
							.getScaledInstance(130, 130, Image.SCALE_DEFAULT)));
					p2.setIcon(new ImageIcon(new ImageIcon(picturelistaddnull.get((pagenumber - 1) * 6 + 1)).getImage()
							.getScaledInstance(130, 130, Image.SCALE_DEFAULT)));
					p3.setIcon(new ImageIcon(new ImageIcon(picturelistaddnull.get((pagenumber - 1) * 6 + 2)).getImage()
							.getScaledInstance(130, 130, Image.SCALE_DEFAULT)));
					p4.setIcon(new ImageIcon(new ImageIcon(picturelistaddnull.get((pagenumber - 1) * 6 + 3)).getImage()
							.getScaledInstance(130, 130, Image.SCALE_DEFAULT)));
					p5.setIcon(new ImageIcon(new ImageIcon(picturelistaddnull.get((pagenumber - 1) * 6 + 4)).getImage()
							.getScaledInstance(130, 130, Image.SCALE_DEFAULT)));
					p6.setIcon(new ImageIcon(new ImageIcon(picturelistaddnull.get((pagenumber - 1) * 6 + 5)).getImage()
							.getScaledInstance(130, 130, Image.SCALE_DEFAULT)));
					pn1.setText(pnamelistaddnull.get((pagenumber - 1) * 6 + 0));
					pn2.setText(pnamelistaddnull.get((pagenumber - 1) * 6 + 1));
					pn3.setText(pnamelistaddnull.get((pagenumber - 1) * 6 + 2));
					pn4.setText(pnamelistaddnull.get((pagenumber - 1) * 6 + 3));
					pn5.setText(pnamelistaddnull.get((pagenumber - 1) * 6 + 4));
					pn6.setText(pnamelistaddnull.get((pagenumber - 1) * 6 + 5));
					f.getContentPane().add(p1);
					f.getContentPane().add(p2);
					f.getContentPane().add(p3);
					f.getContentPane().add(p4);
					f.getContentPane().add(p5);
					f.getContentPane().add(p6);
					f.getContentPane().add(pn1);
					f.getContentPane().add(pn2);
					f.getContentPane().add(pn3);
					f.getContentPane().add(pn4);
					f.getContentPane().add(pn5);
					f.getContentPane().add(pn6);
					f.repaint();
				}
			}
		});
		after.setHorizontalAlignment(SwingConstants.CENTER);
		after.setBounds(252, 516, 39, 15);
		f.getContentPane().add(after);

		searchfield = new JTextField();
		searchfield.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent e) {
	            if (e.getKeyCode()==KeyEvent.VK_ENTER) {
	            	ProductDAO pdao = new ProductDAO();
					ArrayList<ProductDTO> slist = new ArrayList<ProductDTO>();
					try {
						slist = pdao.search(searchfield.getText());
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					f.dispose();
					Search sss = new Search();
					sss.seacrchView(slist, cdto);
	            }
	         }
	      });
		searchfield.setBounds(106, 485, 275, 21);
		f.getContentPane().add(searchfield);
		searchfield.setColumns(10);

		search = new JButton();
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductDAO pdao = new ProductDAO();
				ArrayList<ProductDTO> slist = new ArrayList<ProductDTO>();
				try {
					slist = pdao.search(searchfield.getText());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				f.dispose();
				Search sss = new Search();
				sss.seacrchView(slist, cdto);
			}
		});
		search.setBounds(382, 485, 21, 21);
		f.getContentPane().add(search);
		search.setIcon(
				new ImageIcon(new ImageIcon("이미지 004.png").getImage().getScaledInstance(21, 21, Image.SCALE_DEFAULT)));

		WriteButton = new JButton("작성하기");
		WriteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WriteProduct write = new WriteProduct();
				write.WriteProductView(cdto);
				f.dispose();
			}
		});
		WriteButton.setBounds(382, 512, 97, 23);
		
		if (cdto.getAdmin() == 99) {
			f.getContentPane().add(WriteButton);
		}



		p1.setIcon(new ImageIcon(new ImageIcon(picturelistaddnull.get((pagenumber - 1) * 6 + 0)).getImage()
				.getScaledInstance(130, 130, Image.SCALE_DEFAULT)));
		p2.setIcon(new ImageIcon(new ImageIcon(picturelistaddnull.get((pagenumber - 1) * 6 + 1)).getImage()
				.getScaledInstance(130, 130, Image.SCALE_DEFAULT)));
		p3.setIcon(new ImageIcon(new ImageIcon(picturelistaddnull.get((pagenumber - 1) * 6 + 2)).getImage()
				.getScaledInstance(130, 130, Image.SCALE_DEFAULT)));
		p4.setIcon(new ImageIcon(new ImageIcon(picturelistaddnull.get((pagenumber - 1) * 6 + 3)).getImage()
				.getScaledInstance(130, 130, Image.SCALE_DEFAULT)));
		p5.setIcon(new ImageIcon(new ImageIcon(picturelistaddnull.get((pagenumber - 1) * 6 + 4)).getImage()
				.getScaledInstance(130, 130, Image.SCALE_DEFAULT)));
		p6.setIcon(new ImageIcon(new ImageIcon(picturelistaddnull.get((pagenumber - 1) * 6 + 5)).getImage()
				.getScaledInstance(130, 130, Image.SCALE_DEFAULT)));
		pn1.setText(pnamelistaddnull.get((pagenumber - 1) * 6 + 0));
		pn2.setText(pnamelistaddnull.get((pagenumber - 1) * 6 + 1));
		pn3.setText(pnamelistaddnull.get((pagenumber - 1) * 6 + 2));
		pn4.setText(pnamelistaddnull.get((pagenumber - 1) * 6 + 3));
		pn5.setText(pnamelistaddnull.get((pagenumber - 1) * 6 + 4));
		pn6.setText(pnamelistaddnull.get((pagenumber - 1) * 6 + 5));
		
		

		f.setVisible(true);
		// f.remove(label);
		// f.add
		// f.setVisible(); f.repaint();
	}
	
	// 바뀌는 곳 ------------------------------------------ Log Out --------------------------------------------------------------------------------------
	
	public void MainViewLogOut() {
		picturelist = new ArrayList<>();
		picturelistaddnull = new ArrayList<>();
		pnamelist = new ArrayList<>();
		pnamelistaddnull = new ArrayList<>();
		
		ProductDAO dao = new ProductDAO();

		try {
			dblist = dao.getAllDb();
		} catch (Exception e101) {
		}
		
		for (int i = 0; i < dblist.size(); i++) {
			picturelist.add(dblist.get(i).getPicture());
			}
		
		for (int i = 0; i < dblist.size(); i++) {
			pnamelist.add(dblist.get(i).getPname());
			}
		
		picturelistaddnull = picturelist;
		while(picturelistaddnull.size()%6 != 0) {
			picturelistaddnull.add(null);
		}
		if (picturelistaddnull.size() == 0) {
			for (int i = 0; i < 6; i++) {
				picturelistaddnull.add(null);
			}
		}
		
		pnamelistaddnull = pnamelist;
		while(pnamelistaddnull.size()%6 != 0) {
			pnamelistaddnull.add(null);
		}
		if (pnamelistaddnull.size() == 0) {
			for (int i = 0; i < 6; i++) {
				pnamelistaddnull.add(null);
			}
		}
		

		pagecount = dblist.size();
		
		if (pagecount == 0) {
			totalpage = 1;
		} else if (pagecount % 6 == 0) {
			totalpage = pagecount / 6;
		} else {
			totalpage = pagecount / 6 + 1;
		}

		pagenumber = 1;
		
		f = new JFrame();
		f.setTitle("빈티지 슈즈샵");
		f.setSize(500, 580);
		f.setLocationRelativeTo(null);

		f.getContentPane().setLayout(null);

		login = new JLabel("로그인");
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LogIn login = new LogIn();
				login.LogInView(f);
			}
		});
		login.setHorizontalAlignment(SwingConstants.CENTER);
		login.setBounds(423, 10, 49, 15);
		f.getContentPane().add(login);

		signin = new JLabel("회원가입");
		signin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Signin si = new Signin();
				si.SigninView();
			}
		});
		signin.setHorizontalAlignment(SwingConstants.CENTER);
		signin.setBounds(354, 10, 57, 15);
		f.getContentPane().add(signin);

		title = new JLabel();
		title.setIcon(new ImageIcon(new ImageIcon("title.jpg").getImage().getScaledInstance(422, 67, Image.SCALE_DEFAULT)));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(31, 40, 422, 67);
		f.getContentPane().add(title);

		p1 = new JLabel("");
		p1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ep11) {
				if ((pagenumber - 1) * 6 + 0 < dblist.size()) {
				ProductView product1 = new ProductView();
				product1.ProductViewLogOut(dblist.get((pagenumber - 1) * 6 + 0));
				f.dispose();
				}
			}
		});
		p1.setHorizontalAlignment(SwingConstants.CENTER);
		p1.setBounds(31, 137, 130, 130);
		f.getContentPane().add(p1);

		pn1 = new JLabel("p1name");
		pn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ep12) {
				if ((pagenumber - 1) * 6 + 0 < dblist.size()) {
					ProductView product1 = new ProductView();
					product1.ProductViewLogOut(dblist.get((pagenumber - 1) * 6 + 0));
					f.dispose();
					}
			}
		});
		pn1.setHorizontalAlignment(SwingConstants.CENTER);
		pn1.setBounds(31, 277, 130, 15);
		f.getContentPane().add(pn1);

		p2 = new JLabel("");
		p2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ep21) {
				if ((pagenumber - 1) * 6 + 1 < dblist.size()) {
					ProductView product1 = new ProductView();
					product1.ProductViewLogOut(dblist.get((pagenumber - 1) * 6 + 1));
					f.dispose();
					}
			}
		});
		p2.setHorizontalAlignment(SwingConstants.CENTER);
		p2.setBounds(183, 137, 130, 130);
		f.getContentPane().add(p2);

		pn2 = new JLabel("p2name");
		pn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ep22) {
				if ((pagenumber - 1) * 6 + 1 < dblist.size()) {
					ProductView product1 = new ProductView();
					product1.ProductViewLogOut(dblist.get((pagenumber - 1) * 6 + 1));
					f.dispose();
					}
			}
		});
		pn2.setHorizontalAlignment(SwingConstants.CENTER);
		pn2.setBounds(183, 277, 130, 15);
		f.getContentPane().add(pn2);

		p3 = new JLabel("");
		p3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ep31) {
				if ((pagenumber - 1) * 6 + 2 < dblist.size()) {
					ProductView product1 = new ProductView();
					product1.ProductViewLogOut(dblist.get((pagenumber - 1) * 6 + 2));
					f.dispose();
					}
			}
		});
		p3.setHorizontalAlignment(SwingConstants.CENTER);
		p3.setBounds(325, 137, 130, 130);
		f.getContentPane().add(p3);

		pn3 = new JLabel("p3name");
		pn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ep32) {
				if ((pagenumber - 1) * 6 + 2 < dblist.size()) {
					ProductView product1 = new ProductView();
					product1.ProductViewLogOut(dblist.get((pagenumber - 1) * 6 + 2));
					f.dispose();
					}
			}
		});
		pn3.setHorizontalAlignment(SwingConstants.CENTER);
		pn3.setBounds(325, 277, 130, 15);
		f.getContentPane().add(pn3);

		p4 = new JLabel("");
		p4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ep41) {
				if ((pagenumber - 1) * 6 + 3 < dblist.size()) {
					ProductView product1 = new ProductView();
					product1.ProductViewLogOut(dblist.get((pagenumber - 1) * 6 + 3));
					f.dispose();
					}
			}
		});
		p4.setHorizontalAlignment(SwingConstants.CENTER);
		p4.setBounds(31, 302, 130, 130);
		f.getContentPane().add(p4);

		pn4 = new JLabel("p4name");
		pn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ep42) {
				if ((pagenumber - 1) * 6 + 3 < dblist.size()) {
					ProductView product1 = new ProductView();
					product1.ProductViewLogOut(dblist.get((pagenumber - 1) * 6 + 3));
					f.dispose();
					}
			}
		});
		pn4.setHorizontalAlignment(SwingConstants.CENTER);
		pn4.setBounds(31, 442, 130, 15);
		f.getContentPane().add(pn4);

		p5 = new JLabel("");
		p5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ep51) {
				if ((pagenumber - 1) * 6 + 4 < dblist.size()) {
					ProductView product1 = new ProductView();
					product1.ProductViewLogOut(dblist.get((pagenumber - 1) * 6 + 4));
					f.dispose();
					}
			}
		});
		p5.setHorizontalAlignment(SwingConstants.CENTER);
		p5.setBounds(183, 302, 130, 130);
		f.getContentPane().add(p5);

		pn5 = new JLabel("p5name");
		pn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ep52) {
				if ((pagenumber - 1) * 6 + 4 < dblist.size()) {
					ProductView product1 = new ProductView();
					product1.ProductViewLogOut(dblist.get((pagenumber - 1) * 6 + 4));
					f.dispose();
					}
			}
		});
		pn5.setHorizontalAlignment(SwingConstants.CENTER);
		pn5.setBounds(183, 442, 130, 15);
		f.getContentPane().add(pn5);

		p6 = new JLabel("");
		p6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ep61) {
				if ((pagenumber - 1) * 6 + 5 < dblist.size()) {
					ProductView product1 = new ProductView();
					product1.ProductViewLogOut(dblist.get((pagenumber - 1) * 6 + 5));
					f.dispose();
					}
			}
		});
		p6.setHorizontalAlignment(SwingConstants.CENTER);
		p6.setBounds(323, 302, 130, 130);
		f.getContentPane().add(p6);

		pn6 = new JLabel("p6name");
		pn6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ep62) {
				if ((pagenumber - 1) * 6 + 5 < dblist.size()) {
					ProductView product1 = new ProductView();
					product1.ProductViewLogOut(dblist.get((pagenumber - 1) * 6 + 5));
					f.dispose();
					}
			}
		});
		pn6.setHorizontalAlignment(SwingConstants.CENTER);
		pn6.setBounds(323, 442, 130, 15);
		f.getContentPane().add(pn6);

		page = new JLabel(pagenumber + "/" + totalpage);
		page.setHorizontalAlignment(SwingConstants.CENTER);
		page.setBounds(226, 516, 34, 15);
		f.getContentPane().add(page);

		before = new JLabel("<<");
		before.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (pagenumber == 1) {
					JOptionPane.showMessageDialog(null, "첫 페이지입니다!");
				} else {
					page.setText(String.valueOf(pagenumber - 1) + "/" + totalpage);
					pagenumber--;
					f.remove(p1);
					f.remove(p2);
					f.remove(p3);
					f.remove(p4);
					f.remove(p5);
					f.remove(p6);
					f.remove(pn1);
					f.remove(pn2);
					f.remove(pn3);
					f.remove(pn4);
					f.remove(pn5);
					f.remove(pn6);
					p1.setIcon(new ImageIcon(new ImageIcon(picturelistaddnull.get((pagenumber - 1) * 6 + 0)).getImage()
							.getScaledInstance(130, 130, Image.SCALE_DEFAULT)));
					p2.setIcon(new ImageIcon(new ImageIcon(picturelistaddnull.get((pagenumber - 1) * 6 + 1)).getImage()
							.getScaledInstance(130, 130, Image.SCALE_DEFAULT)));
					p3.setIcon(new ImageIcon(new ImageIcon(picturelistaddnull.get((pagenumber - 1) * 6 + 2)).getImage()
							.getScaledInstance(130, 130, Image.SCALE_DEFAULT)));
					p4.setIcon(new ImageIcon(new ImageIcon(picturelistaddnull.get((pagenumber - 1) * 6 + 3)).getImage()
							.getScaledInstance(130, 130, Image.SCALE_DEFAULT)));
					p5.setIcon(new ImageIcon(new ImageIcon(picturelistaddnull.get((pagenumber - 1) * 6 + 4)).getImage()
							.getScaledInstance(130, 130, Image.SCALE_DEFAULT)));
					p6.setIcon(new ImageIcon(new ImageIcon(picturelistaddnull.get((pagenumber - 1) * 6 + 5)).getImage()
							.getScaledInstance(130, 130, Image.SCALE_DEFAULT)));
					pn1.setText(pnamelistaddnull.get((pagenumber - 1) * 6 + 0));
					pn2.setText(pnamelistaddnull.get((pagenumber - 1) * 6 + 1));
					pn3.setText(pnamelistaddnull.get((pagenumber - 1) * 6 + 2));
					pn4.setText(pnamelistaddnull.get((pagenumber - 1) * 6 + 3));
					pn5.setText(pnamelistaddnull.get((pagenumber - 1) * 6 + 4));
					pn6.setText(pnamelistaddnull.get((pagenumber - 1) * 6 + 5));
					f.getContentPane().add(p1);
					f.getContentPane().add(p2);
					f.getContentPane().add(p3);
					f.getContentPane().add(p4);
					f.getContentPane().add(p5);
					f.getContentPane().add(p6);
					f.getContentPane().add(pn1);
					f.getContentPane().add(pn2);
					f.getContentPane().add(pn3);
					f.getContentPane().add(pn4);
					f.getContentPane().add(pn5);
					f.getContentPane().add(pn6);
					f.repaint();
				}
			}
		});
		before.setHorizontalAlignment(SwingConstants.CENTER);
		before.setBounds(197, 516, 39, 15);
		f.getContentPane().add(before);

		after = new JLabel(">>");
		after.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (pagenumber == totalpage) {
					JOptionPane.showMessageDialog(null, "마지막 페이지입니다!");
				} else {
					page.setText(String.valueOf(pagenumber + 1) + "/" + totalpage);
					pagenumber++;
					f.remove(p1);
					f.remove(p2);
					f.remove(p3);
					f.remove(p4);
					f.remove(p5);
					f.remove(p6);
					f.remove(pn1);
					f.remove(pn2);
					f.remove(pn3);
					f.remove(pn4);
					f.remove(pn5);
					f.remove(pn6);
					p1.setIcon(new ImageIcon(new ImageIcon(picturelistaddnull.get((pagenumber - 1) * 6 + 0)).getImage()
							.getScaledInstance(130, 130, Image.SCALE_DEFAULT)));
					p2.setIcon(new ImageIcon(new ImageIcon(picturelistaddnull.get((pagenumber - 1) * 6 + 1)).getImage()
							.getScaledInstance(130, 130, Image.SCALE_DEFAULT)));
					p3.setIcon(new ImageIcon(new ImageIcon(picturelistaddnull.get((pagenumber - 1) * 6 + 2)).getImage()
							.getScaledInstance(130, 130, Image.SCALE_DEFAULT)));
					p4.setIcon(new ImageIcon(new ImageIcon(picturelistaddnull.get((pagenumber - 1) * 6 + 3)).getImage()
							.getScaledInstance(130, 130, Image.SCALE_DEFAULT)));
					p5.setIcon(new ImageIcon(new ImageIcon(picturelistaddnull.get((pagenumber - 1) * 6 + 4)).getImage()
							.getScaledInstance(130, 130, Image.SCALE_DEFAULT)));
					p6.setIcon(new ImageIcon(new ImageIcon(picturelistaddnull.get((pagenumber - 1) * 6 + 5)).getImage()
							.getScaledInstance(130, 130, Image.SCALE_DEFAULT)));
					pn1.setText(pnamelistaddnull.get((pagenumber - 1) * 6 + 0));
					pn2.setText(pnamelistaddnull.get((pagenumber - 1) * 6 + 1));
					pn3.setText(pnamelistaddnull.get((pagenumber - 1) * 6 + 2));
					pn4.setText(pnamelistaddnull.get((pagenumber - 1) * 6 + 3));
					pn5.setText(pnamelistaddnull.get((pagenumber - 1) * 6 + 4));
					pn6.setText(pnamelistaddnull.get((pagenumber - 1) * 6 + 5));
					f.getContentPane().add(p1);
					f.getContentPane().add(p2);
					f.getContentPane().add(p3);
					f.getContentPane().add(p4);
					f.getContentPane().add(p5);
					f.getContentPane().add(p6);
					f.getContentPane().add(pn1);
					f.getContentPane().add(pn2);
					f.getContentPane().add(pn3);
					f.getContentPane().add(pn4);
					f.getContentPane().add(pn5);
					f.getContentPane().add(pn6);
					f.repaint();
				}
			}
		});
		after.setHorizontalAlignment(SwingConstants.CENTER);
		after.setBounds(252, 516, 39, 15);
		f.getContentPane().add(after);

		searchfield = new JTextField();
		searchfield.setText("검색은 로그인 후에 사용가능합니다.");
		searchfield.setEditable(false);
		searchfield.setBounds(106, 485, 275, 21);
		f.getContentPane().add(searchfield);
		searchfield.setColumns(10);

		search = new JButton();
		search.setBounds(382, 485, 21, 21);
		f.getContentPane().add(search);
		search.setIcon(
				new ImageIcon(new ImageIcon("이미지 004.png").getImage().getScaledInstance(21, 21, Image.SCALE_DEFAULT)));
		
		p1.setIcon(new ImageIcon(new ImageIcon(picturelistaddnull.get((pagenumber - 1) * 6 + 0)).getImage()
				.getScaledInstance(130, 130, Image.SCALE_DEFAULT)));
		p2.setIcon(new ImageIcon(new ImageIcon(picturelistaddnull.get((pagenumber - 1) * 6 + 1)).getImage()
				.getScaledInstance(130, 130, Image.SCALE_DEFAULT)));
		p3.setIcon(new ImageIcon(new ImageIcon(picturelistaddnull.get((pagenumber - 1) * 6 + 2)).getImage()
				.getScaledInstance(130, 130, Image.SCALE_DEFAULT)));
		p4.setIcon(new ImageIcon(new ImageIcon(picturelistaddnull.get((pagenumber - 1) * 6 + 3)).getImage()
				.getScaledInstance(130, 130, Image.SCALE_DEFAULT)));
		p5.setIcon(new ImageIcon(new ImageIcon(picturelistaddnull.get((pagenumber - 1) * 6 + 4)).getImage()
				.getScaledInstance(130, 130, Image.SCALE_DEFAULT)));
		p6.setIcon(new ImageIcon(new ImageIcon(picturelistaddnull.get((pagenumber - 1) * 6 + 5)).getImage()
				.getScaledInstance(130, 130, Image.SCALE_DEFAULT)));
		pn1.setText(pnamelistaddnull.get((pagenumber - 1) * 6 + 0));
		pn2.setText(pnamelistaddnull.get((pagenumber - 1) * 6 + 1));
		pn3.setText(pnamelistaddnull.get((pagenumber - 1) * 6 + 2));
		pn4.setText(pnamelistaddnull.get((pagenumber - 1) * 6 + 3));
		pn5.setText(pnamelistaddnull.get((pagenumber - 1) * 6 + 4));
		pn6.setText(pnamelistaddnull.get((pagenumber - 1) * 6 + 5));
		

		f.setVisible(true);
		// f.remove(label);
		// f.add
		// f.setVisible(); f.repaint();
	}
	
}
