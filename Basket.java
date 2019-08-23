package shoesshop;

import java.util.ArrayList;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Basket implements ActionListener {
	static CustomerDTO cdto;
	static ArrayList<ProductDTO> plist;
	JLabel[] photos;
	JLabel[] pnames;
	JLabel[] pricelabels;
	JButton[] deletebuttons;
	JPanel[] panels, buttonpanels;
	static JFrame basketframe;
	
	public void BasketView(ArrayList<ProductDTO> plist, CustomerDTO cdto){
		this.cdto = cdto;
		this.plist = plist;
		
		basketframe = new JFrame("장바구니");
		basketframe.setSize(500, 496);
		basketframe.setLocationRelativeTo(null);
		basketframe.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 87, 460, 316);
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(12, 87, 460, 316);
		basketframe.getContentPane().add(scrollPane);
		
		
		JLabel titlelabel = new JLabel("title");
		titlelabel.setIcon(new ImageIcon(new ImageIcon("title.jpg").getImage().getScaledInstance(422, 67, Image.SCALE_DEFAULT)));
		titlelabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainView main = new MainView();
				main.MainViewLogIn(cdto);
				basketframe.dispose();
			}
		});
		titlelabel.setHorizontalAlignment(SwingConstants.CENTER);
		titlelabel.setBounds(35, 10, 422, 67);
		basketframe.getContentPane().add(titlelabel);
		
		JButton paymentbutton = new JButton("결제하기");
		paymentbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e3) {
				if (plist == null) {
					JOptionPane.showMessageDialog(null, "장바구니가 비었습니다!");
				} else if (plist.size()==0) {
					JOptionPane.showMessageDialog(null, "장바구니가 비었습니다!");
				} else {
				Payment pm = new Payment();
				pm.PaymentView(plist, cdto);
				basketframe.dispose();
				}
			}
		});
		paymentbutton.setBounds(193, 413, 97, 23);
		basketframe.getContentPane().add(paymentbutton);
		
		

		photos = new JLabel[plist.size()];
		pnames = new JLabel[plist.size()];
		pricelabels = new JLabel[plist.size()];
		deletebuttons = new JButton[plist.size()];
		buttonpanels = new JPanel[plist.size()];
		panels = new JPanel[plist.size()];
		
    	for (int i= 0; i < plist.size() ; i++) {

    		photos[i] = new JLabel();
    		pnames[i] = new JLabel();
    		pricelabels[i] = new JLabel();
    		deletebuttons[i] = new JButton();
    		deletebuttons[i].setText("삭제");
    		deletebuttons[i].setActionCommand(plist.get(i).getPname());
    		buttonpanels[i] = new JPanel();
    		panels[i] = new JPanel();
    		panels[i].setLayout(new GridLayout(1,4));
    		buttonpanels[i].setLayout(new GridBagLayout());
    		
    		photos[i].setIcon(new ImageIcon(new ImageIcon(plist.get(i).getPicture()).getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT)));
    		pnames[i].setText(plist.get(i).getPname());
    		pricelabels[i].setText(String.valueOf(plist.get(i).getPrice()) + "원");
    		
    		panels[i].add(photos[i]);
    		panels[i].add(pnames[i]);
    		panels[i].add(pricelabels[i]);
    		buttonpanels[i].add(deletebuttons [i], new GridBagConstraints());
    		panels[i].add(buttonpanels[i]);
    		panel.add(panels[i]);
    		
    		deletebuttons[i].addActionListener(this);
    	}
    	basketframe.setVisible(true);
		
		
	}
	
	@Override
    public void actionPerformed(ActionEvent e) {
		BasketDAO bdao = new BasketDAO();
		try {
			bdao.deleteProduct(e.getActionCommand(), cdto.getId());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			this.plist = bdao.getProduct(cdto);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		basketframe.dispose();
		Basket basket = new Basket();
		basket.BasketView(plist, cdto);
    }
}
