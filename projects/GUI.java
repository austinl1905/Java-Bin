import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import java.util.Random;

public class GUI {

    private static int count = 0;

    public static void createAndShowGUI() {
      
      JFrame jFrame = new JFrame("image-display-java-thing");
      jFrame.setLayout(new FlowLayout());
      jFrame.setSize(600, 600);
      jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      JPanel container = new JPanel();
      container.setLayout(new FlowLayout());
      jFrame.add(container, BorderLayout.CENTER);
      container.setPreferredSize(new Dimension(600, 600));
      container.setVisible(true);

      JScrollPane scrollPane = new JScrollPane(container);
      jFrame.add(scrollPane);

      Border border = BorderFactory.createLineBorder(Color.BLACK);

      JButton button = new JButton("Button");
      button.setBorder(border);
      button.setPreferredSize(new Dimension(50, 25));
      container.add(button);
      button.setVisible(true);
      button.setText("Click here");
      button.setHorizontalAlignment(JButton.CENTER);
      button.setVerticalAlignment(JButton.CENTER);
      button.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent a) {
      count++;
      if (count > 9) {
        return;
      }
		  ImageIcon ca1 = new ImageIcon("imgs/ca1.png");
		  ImageIcon ca4 = new ImageIcon("imgs/ca4.png");
		  ImageIcon ca9 = new ImageIcon("imgs/ca9.png");
		  ImageIcon ca10 = new ImageIcon("imgs/ca_10.png");
		  ImageIcon ca30 = new ImageIcon("imgs/ca30.png");
      ImageIcon ca23 = new ImageIcon("imgs/ca23.png");
		  
		  ImageIcon[] ranImg = {ca1, ca4, ca9, ca10, ca30, ca23};

		  Random generator = new Random();
		  int randomIndex = generator.nextInt(ranImg.length);
		  
		  ImageIcon ranIcon = (ranImg[randomIndex]);
		  ImageIcon imageIcon = ranIcon;
		  Image image = imageIcon.getImage();
		  Image newimg = image.getScaledInstance(160, 160,  java.awt.Image.SCALE_SMOOTH);
		  imageIcon = new ImageIcon(newimg);
		  JLabel label = new JLabel(imageIcon);
		  label.setBorder(border);
		  label.setPreferredSize(new Dimension(160, 160));
		  label.setHorizontalAlignment(JLabel.CENTER);
		  label.setVerticalAlignment(JLabel.CENTER);

		  container.add(label);
      container.repaint();
      scrollPane.revalidate();
	} });

      jFrame.setVisible(true);
    }
    
  public static void main(String[] args) {
    createAndShowGUI();
    
    
  }
}
