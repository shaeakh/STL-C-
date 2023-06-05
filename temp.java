/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Shaeakh
 */


public class Calculator implements ActionListener {

    // all the initialization
    JFrame frame; //bg
    JTextField txtfield; //display 
    JButton[] num_buttons = new JButton[10]; //0,1,2,3,4,5,6,7,8,9
    JButton[] func_buttons = new JButton[9]; //
    JButton add,sub,multi,div; // +,-,*,/
    JButton dec,equ,del,clr,neg;
    JPanel panel; 
    Font fnt = new Font("Calibri",Font.BOLD,30);
    double num1=0,num2=0,ans=0;
    char operator;
    
    Calculator(){
        frame = new JFrame("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        
        //text field formation
        txtfield = new JTextField();
        txtfield.setBounds(50, 25, 300, 50);
        txtfield.setFont(fnt);
        txtfield.setEditable(false);
        
        //initializing operational buttons
        add = new JButton("+");
        sub = new JButton("-");
        multi = new JButton("*");
        div = new JButton("/");
        
        dec = new JButton(".");
        equ = new JButton("=");
        del = new JButton("Del");
        clr = new JButton("Clear");
        neg = new JButton("(-)");
        
        //adding functional buttons
        func_buttons[0] = add;
        func_buttons[1] = sub;
        func_buttons[2] = multi;
        func_buttons[3] = div;
        func_buttons[4] = dec;
        func_buttons[5] = equ;
        func_buttons[6] = del;
        func_buttons[7] = clr;
        func_buttons[8] = neg;
        
        //formating the operational buttons
        for(int i=0;i<9;i++){
            func_buttons[i].addActionListener(this);
            func_buttons[i].setFont(fnt);
            func_buttons[i].setFocusable(false);
        }
        
        //initializing and formating number buttons
        for(int i=0;i<10;i++){
            num_buttons[i] = new JButton(String.valueOf(i));
            num_buttons[i].addActionListener(this);
            num_buttons[i].setFont(fnt);
            num_buttons[i].setFocusable(false);
        }
                
        //setting bounds
        del.setBounds(150, 430, 100, 50);
        clr.setBounds(250, 430, 100, 50);
        neg.setBounds(50, 430, 100, 50);
        
        //adding panel
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.GRAY);
        
        //adding objects to the panel
        
        panel.add(num_buttons[1]);
        panel.add(num_buttons[2]);
        panel.add(num_buttons[3]);
        panel.add(add);
        
        panel.add(num_buttons[4]);
        panel.add(num_buttons[5]);
        panel.add(num_buttons[6]);
        panel.add(sub);
        
        panel.add(num_buttons[7]);
        panel.add(num_buttons[8]);
        panel.add(num_buttons[9]);
        panel.add(multi);
        
        panel.add(num_buttons[0]);
        panel.add(div);
        panel.add(dec);
        panel.add(equ);
        
        //adding objects to the frame
        frame.add(panel);
        frame.add(del);    
        frame.add(clr);    
        frame.add(neg);  
        frame.add(txtfield);    
        frame.setVisible(true);
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
         Calculator calc = new Calculator();
         
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //adding buttons interactions
        
        //numbuttons
        for(int i=0;i<10;i++){
            if(ae.getSource() ==num_buttons[i]){
                txtfield.setText(txtfield.getText().concat(String.valueOf(i)));
            }
        }
        
        //operational buttons
        if(ae.getSource() ==add){
            num1 = Double.parseDouble(txtfield.getText());
            operator = '+';
            txtfield.setText("");
        }
        if(ae.getSource() ==sub){
            num1 = Double.parseDouble(txtfield.getText());
            operator = '-';
            txtfield.setText("");
        }
        if(ae.getSource() ==multi){
            num1 = Double.parseDouble(txtfield.getText());
            operator = '*';
            txtfield.setText("");
        }
        if(ae.getSource() ==div){
            num1 = Double.parseDouble(txtfield.getText());
            operator = '/';
            txtfield.setText("");
        }
        if(ae.getSource() ==dec){
            txtfield.setText(txtfield.getText().concat("."));
        }
        if(ae.getSource() ==equ){
            num2=Double.parseDouble(txtfield.getText());
            switch(operator){
                case'+':
                    ans = num1 + num2;
                    break;
                case'-':
                    ans = num1 - num2;
                    break;
                case'*':
                    ans = num1 * num2;
                    break;
                case'/':
                    ans = num1 / num2;
                    break;
            }
            txtfield.setText(String.valueOf(ans));
            num1 = ans;
        }
        if(ae.getSource() ==del){
            String string = txtfield.getText();
            txtfield.setText("");
            for(int i=0;i<string.length()-1;i++){
            txtfield.setText(txtfield.getText()+string.charAt(i));
            }
        }
        if(ae.getSource() ==clr){
            txtfield.setText(""); 
        }
        if(ae.getSource() ==neg){
            double temp = Double.parseDouble(txtfield.getText());
            temp *= (-1);
            txtfield.setText(String.valueOf(temp));
        }
    }
    
}
