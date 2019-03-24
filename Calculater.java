package calculater;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicArrowButton;

public class Calculater extends JFrame implements ActionListener {
    
    JButton[] b;
    JTextField lcd;
    
    public Calculater() {
        setTitle("Calculator");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(Color.white);
        this.setDefaultCloseOperation(Calculater.EXIT_ON_CLOSE);
        
        lcd = new JTextField();
        
        JPanel keys = new JPanel(new GridLayout(4, 4));
        
        b = new JButton[16];
        for (int i = 0; i < b.length; i++) {
            b[i] = new JButton(String.valueOf(i));
        }
        b[10] = new JButton("A");
        b[11] = new JButton("B");
        b[12] = new JButton("C");
        b[13] = new JButton("D");
        b[14] = new JButton("E");
        b[15] = new JButton("F");
        
        for (JButton b1 : b) {
            keys.add(b1);
            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    lcd.setText(lcd.getText()+ "" + b1.getText());
                }
            });
        }
        this.setLayout(new BorderLayout());
        this.add(lcd, BorderLayout.NORTH);
        this.add(keys, BorderLayout.CENTER);
        
        JPanel select = new JPanel(new GridLayout(5, 1));
        JRadioButton bin = new JRadioButton("Bin");
        bin.addActionListener(this);
        JRadioButton dec = new JRadioButton("Dec");
        dec.addActionListener(this);
        JRadioButton hex = new JRadioButton("Hex");
        hex.addActionListener(this);
        JRadioButton oct = new JRadioButton("Oct");
        oct.addActionListener(this);
        ButtonGroup bg = new ButtonGroup();
        bg.add(bin);
        bg.add(dec);
        bg.add(hex);
        bg.add(oct);
        dec.setSelected(true);
        select.add(dec);
        select.add(bin);
        select.add(hex);
        select.add(oct);
        JButton c = new JButton("C");
        c.setFocusPainted(false);
        c.setForeground(Color.red);
        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lcd.setText("");
            }
        });
        select.add(c);
        this.add(select, BorderLayout.EAST);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Calculater();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        switch (e.getActionCommand()) {
            case "Bin":
                def(b);
                for (int i = 2; i < b.length; i++) {
                    b[i].setEnabled(false);
                }
                break;
            
            case "Hex":
                def(b);
//                for (int i = 11; i < b.length; i++) {
//                    b[i].setEnabled(false);
//                }
                break;
            case "Oct":
                def(b);
                for (int i = 9; i < b.length; i++) {
                    b[i].setEnabled(false);
                }
                break;
            case "Dec":
                def(b);
                for (int i = 10; i < b.length; i++) {
                    b[i].setEnabled(false);
                }
                break;
        }
        
    }
    
    public void def(JButton[] b) {
        for (int i = 0; i < b.length; i++) {
            b[i].setEnabled(true);
        }
    }
}
