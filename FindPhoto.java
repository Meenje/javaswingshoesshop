package shoesshop;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;


public class FindPhoto extends WriteProduct implements ActionListener {
	static JButton[] buttons;
	static JScrollPane scroll;
	static JPanel panel;
	static String Path;
	static JFrame ImageFrame;
	static WriteProduct write;

    public void getImage() {
    	
    	ImageFrame = new JFrame("그림을 골라라");
    	ImageFrame.setSize(500, 500);
    	ImageFrame.setLocationRelativeTo(null);
    	ImageFrame.getContentPane().setLayout(new BorderLayout());
    	panel = new JPanel();
    	panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
    	ImageFrame.getContentPane().add(panel);
    	
    	final File folder = new File("E:\\minje\\bigproject1");
		
        List<String> result = new ArrayList<>();
        
        ImageSearch is = new ImageSearch();
        is.search(".*\\.jpg", folder, result);

        buttons = new JButton[result.size()];
    	for (int i= 0; i < result.size(); i++) {
    		buttons[i] = new JButton(result.get(i));
    		buttons[i].setIcon(new ImageIcon(new ImageIcon(result.get(i)).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
    		panel.add(buttons[i]);
    		buttons[i].addActionListener(this);
    	}
    	panel.add(Box.createVerticalGlue());
    	scroll = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    	ImageFrame.getContentPane().add(scroll);

    	
    	ImageFrame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	Path = e.getActionCommand();
    	this.path = Path;
    	rep();
    	ImageFrame.dispose();
    }
    

}
