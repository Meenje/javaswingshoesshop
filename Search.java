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

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Search implements ActionListener {
	static CustomerDTO cdto;
	ArrayList<ProductDTO> plist;
	JLabel[] photos;
	JLabel[] pnames;
	JLabel[] pricelabels;
	JButton[] seebuttons;
	JPanel[] panels, buttonpanels;
	JFrame sView;

	public void seacrchView(ArrayList<ProductDTO> plist, CustomerDTO cdto) {
		this.cdto = cdto;
		this.plist = plist;
		
		sView = new JFrame();
		sView.setSize(422, 500);
		sView.setLocationRelativeTo(null);
		sView.getContentPane().setLayout(null);
		
		JLabel title = new JLabel();
		title.setIcon(new ImageIcon(new ImageIcon("title.jpg").getImage().getScaledInstance(382, 50, Image.SCALE_DEFAULT)));
		title.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainView mmain = new MainView();
				mmain.MainViewLogIn(cdto);
				sView.dispose();
			}
		});
		title.setBounds(12, 10, 382, 50);
		sView.getContentPane().add(title);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 70, 382, 374);
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(12, 70, 382, 374);
		sView.getContentPane().add(scrollPane);
		
		photos = new JLabel[plist.size()];
		pnames = new JLabel[plist.size()];
		pricelabels = new JLabel[plist.size()];
		seebuttons = new JButton[plist.size()];
		buttonpanels = new JPanel[plist.size()];
		panels = new JPanel[plist.size()];
		
    	for (int i= 0; i < plist.size() ; i++) {

    		photos[i] = new JLabel();
    		pnames[i] = new JLabel();
    		pricelabels[i] = new JLabel();
    		seebuttons[i] = new JButton();
    		seebuttons[i].setText("보기");
    		seebuttons[i].setActionCommand(String.valueOf(plist.get(i).getPid()));
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
    		buttonpanels[i].add(seebuttons [i], new GridBagConstraints());
    		panels[i].add(buttonpanels[i]);
    		panel.add(panels[i]);
    		
    		seebuttons[i].addActionListener(this);
    	}
		
		sView.setVisible(true);
	}
	
	@Override
    public void actionPerformed(ActionEvent e) {
		int index = Integer.parseInt(e.getActionCommand());
		int check = -1;
		for (int i = 0; i < plist.size(); i++) {
			if (index == plist.get(i).getPid()) {
				check = i;
			}
		}
		ProductView pv = new ProductView();
		pv.ProductViewLogIn(plist.get(check), cdto);
		sView.dispose();
    }
	
}
