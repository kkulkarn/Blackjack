


import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 


@SuppressWarnings("serial")
public class playBlackJack  extends Component implements ActionListener {
	
    Deck deck = new Deck();                  // A deck of cards.  A new deck for each game.
    BlackjackHand dealerHand = new BlackjackHand();   // The dealer's hand.
    BlackjackHand userHand = new BlackjackHand(); 
    
    public String cardVal;
    public final Graphics g = null;
    static JFrame f = new JFrame("Blackjack New.....");

	
	  private enum Actions {
		    Hit,
		    Stand,
		    Deal
		  }	
           
    BufferedImage img;
    BufferedImage img1;
    BufferedImage img2;
    BufferedImage img3;
    BufferedImage img4;
    
    public JPanel LoadButton() {
    	
    	playBlackJack instance = new playBlackJack();
    	
        JButton button1 = new JButton("Hit");
        JButton button2 = new JButton("Stand");
        JButton button3 = new JButton("Deal");
        
        button1.setActionCommand(Actions.Hit.name());
        button1.addActionListener(instance);
        
        button2.setActionCommand(Actions.Stand.name());
        button2.addActionListener((ActionListener) instance);

        button3.setActionCommand(Actions.Deal.name());
        button3.addActionListener((ActionListener) instance);        
        
        JPanel buttonPaneMain = new JPanel();
        JPanel buttonPane1 = new JPanel();
        JPanel buttonPane2 = new JPanel();
        JPanel buttonPane3 = new JPanel();

        button1.setPreferredSize(new Dimension(60, 60));
        button2.setPreferredSize(new Dimension(60, 60));
        button3.setPreferredSize(new Dimension(60, 60));

        buttonPane1.add(button1);
        buttonPane2.add(button2);
        buttonPane3.add(button3);

        buttonPaneMain.add(buttonPane1);
        buttonPaneMain.add(buttonPane2);
        buttonPaneMain.add(buttonPane3);
        //f.add(buttonPaneMain, BorderLayout.SOUTH);
         
       return buttonPaneMain;
    }

    public String dealValue(){
        Card newCard = deck.dealCard();
        return cardVal = newCard.toString();
    }

	public  void actionPerformed(ActionEvent evt) {
		
	    if (evt.getActionCommand() == Actions.Hit.name()) {   
            //userHand.addCard(newCard);	        
	    	
	        //JOptionPane.showMessageDialog(null, dealValue());
            Card newCard = deck.dealCard();
            userHand.addCard(newCard);
            try
            {
            	TextIO.putln("resources/" + newCard + ".png");
            //BufferedImage imageName = ImageIO.read(new File("resources/" + newCard + ".png"));
            	BufferedImage imageName = ImageIO.read(new File("resources/01.png"));	
            //f.add(getParent(), g.drawImage(imageName, 170, 220, null));
            //g.drawImage(imageName, 170, 220, null);
            //super.paint(g);
            //g.drawImage(imageName, 170, 220, null);
            	Graphics g = imageName.getGraphics();
            	g.drawImage(imageName,170,220,null);
            	f.validate();
            	f.pack();
            	f.repaint();
            	//f.setVisible(true);
            //drawImg(imageName, 170, 220);
            
            
            }
            catch (IOException e)
            {
            	
            }
	        
            
	      } else if (evt.getActionCommand() == Actions.Stand.name()) {
	        //JOptionPane.showMessageDialog(null, "Stand");
	    	  TextIO.putln("Stand");
	      }		
	      else {
		      //  JOptionPane.showMessageDialog(null, "Deal"); 
	    	  TextIO.putln("Deal");

	      }
	    		
	}
 
    private void drawImg(BufferedImage imageName, int i, int j) {
		// TODO Auto-generated method stub
    	super.paint(g);

    	TextIO.putln("i = " + i + " j = " + j);
    	Graphics g = imageName.getGraphics();
    	g.drawImage(imageName,i,j,null);
    	//g.drawImage(imageName, j, j, background, parent);
	}

	public void paint(Graphics g) {
        Font font = new Font(Font.SERIF, Font.PLAIN, 24);
        g.setFont(font);
        String text = "Dealer Hand....";
        g.drawString(text, 10, 20);
        g.drawImage(img, 10, 40, null);
        g.drawImage(img1, 90, 40, null);
        text = "Player Hand....";
        g.drawString(text, 10, 200);
        g.drawImage(img3, 10, 220, null);
        g.drawImage(img2, 90, 220, null);
        //g.drawImage(img4, 280, 120, null);
    }
    
    
 
    public void LoadImageApp() {
    			try{
    					img = ImageIO.read(new File("resources/312.png"));
    					img1 = ImageIO.read(new File("resources/01.png"));
    					img2 = ImageIO.read(new File("resources/02.png"));
    					img3 = ImageIO.read(new File("resources/14.png"));
    					//img4 = ImageIO.read(new File("resources/313.png"));
    				} catch (IOException e) {
    				}
    }
 
    public Dimension getPreferredSize() {
             return new Dimension(1000,500);
    }
    
    
 
    public static void main(String[] args) {
 
             
        f.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
 
        f.add(new LoadImageApp());
        
        playBlackJack loadBtn = new playBlackJack();
          
        f.add(loadBtn.LoadButton(), BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);

    
}
}