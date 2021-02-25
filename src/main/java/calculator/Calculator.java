package calculator;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 *
 * @author alfredrumsz
 */
public class Calculator extends JFrame implements ActionListener{
    
    static JFrame f;
    
    static JTextField jtf;
    
    private String s0,s1,s2;
    
    static Color white = new Color(255,255,255);
    static Color orange = new Color(255,200,0);
    static Color green = new Color(0,255,0);

    public Calculator(){
        s0 = s1 = s2 = "";
    }
    
    public static void main(String[] args) {
        f = new JFrame("Calulator");
        Container container = f.getContentPane();
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        Calculator calculator = new Calculator();
        
        jtf = new JTextField(20);
        Font font = new Font("Courier", Font.BOLD,18);
        jtf.setFont(font);
        jtf.setEditable(false);
        
        //buttons
        JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9;
        //symbols
        JButton ba, bs, bd, bm, be, beq, beq1; 
        
        b0 = createButton(10,10,350,250,"0",white);
        b1 = createButton(20,20,350,250,"1",white);
        b2 = createButton(30,30,350,250,"2",white);
        b3 = createButton(40,40,350,250,"3",white);
        b4 = createButton(50,50,350,250,"4",white);
        b5 = createButton(60,60,350,250,"5",white);
        b6 = createButton(70,70,350,250,"6",white);
        b7 = createButton(80,80,350,250,"7",white);
        b8 = createButton(90,90,350,250,"8",white);
        b9 = createButton(100,100,350,250,"9",white);
        
        // equals button 
        beq1 = createButton(110,110,350,250,"=",green);
  
        // create operator buttons 
        ba = createButton(120,120,350,250,"+",orange);
        bs = createButton(130,130,350,250,"-",orange);
        bd = createButton(140,140,350,250,"/",orange);
        bm = createButton(150,150,350,250,"*",orange);
        beq = createButton(160,160,350,250,"C",white);
        
        // create . button 
        be = createButton(170,170,350,250,".",white);
        
        // create a panel 
        JPanel p = new JPanel(); 
        
        // add action listeners 
        bm.addActionListener(calculator); 
        bd.addActionListener(calculator); 
        bs.addActionListener(calculator); 
        ba.addActionListener(calculator); 
        b9.addActionListener(calculator); 
        b8.addActionListener(calculator); 
        b7.addActionListener(calculator); 
        b6.addActionListener(calculator); 
        b5.addActionListener(calculator); 
        b4.addActionListener(calculator); 
        b3.addActionListener(calculator); 
        b2.addActionListener(calculator); 
        b1.addActionListener(calculator); 
        b0.addActionListener(calculator); 
        be.addActionListener(calculator); 
        beq.addActionListener(calculator); 
        beq1.addActionListener(calculator); 
        
        p.add(jtf);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(ba);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(bs);
        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(bm);
        p.add(be);
        p.add(b0);
        p.add(beq);
        p.add(beq1);
        container.add(p);
        
        // set Background of panel 
        p.setBackground(Color.DARK_GRAY); 
  
        // add panel to frame 
        f.add(p); 
  
        f.setSize(250, 280); 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);
        f.show(); 
    }
    public void actionPerformed(ActionEvent e) 
    { 
        String s = e.getActionCommand(); 
  
        // if the value is a number 
        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') { 
            // if operand is present then add to second no 
            if (!s1.equals("")) 
                s2 = s2 + s; 
            else
                s0 = s0 + s; 
  
            // set the value of text 
            jtf.setText(s0 + s1 + s2); 
        } 
        else if (s.charAt(0) == 'C') { 
            // clear the one letter 
            s0 = s1 = s2 = ""; 
  
            // set the value of text 
            jtf.setText(s0 + s1 + s2); 
        } 
        else if (s.charAt(0) == '=') { 
  
            double te; 
  
            // store the value in 1st 
            if (s1.equals("+")) 
                te = (Double.parseDouble(s0) + Double.parseDouble(s2)); 
            else if (s1.equals("-")) 
                te = (Double.parseDouble(s0) - Double.parseDouble(s2)); 
            else if (s1.equals("/")) 
                te = (Double.parseDouble(s0) / Double.parseDouble(s2)); 
            else
                te = (Double.parseDouble(s0) * Double.parseDouble(s2)); 
  
            // set the value of text 
            jtf.setText(s0 + s1 + s2 + "=" + te); 
  
            // convert it to string 
            s0 = Double.toString(te); 
  
            s1 = s2 = ""; 
        } 
        else { 
            // if there was no operand 
            if (s1.equals("") || s2.equals("")) 
                s1 = s; 
            // else evaluate 
            else { 
                double te; 
  
                // store the value in 1st 
                if (s1.equals("+")) 
                    te = (Double.parseDouble(s0) + Double.parseDouble(s2)); 
                else if (s1.equals("-")) 
                    te = (Double.parseDouble(s0) - Double.parseDouble(s2)); 
                else if (s1.equals("/")) 
                    te = (Double.parseDouble(s0) / Double.parseDouble(s2)); 
                else
                    te = (Double.parseDouble(s0) * Double.parseDouble(s2)); 
  
                // convert it to string 
                s0 = Double.toString(te); 
  
                // place the operator 
                s1 = s; 
  
                // make the operand blank 
                s2 = ""; 
            } 
  
            // set the value of text 
            jtf.setText(s0 + s1 + s2); 
        }
    }
    
    public static JButton createButton(int x, int y, int w , int h, String t, Color color) {
    JButton b = new JButton();
    b.setText(t);
    b.setBounds(x, y, w, h);
    b.setBackground(color);
    b.setFont(new Font("TimesRoman",Font.BOLD,20));
    b.setForeground(Color.BLACK);
    return b;
    }
}