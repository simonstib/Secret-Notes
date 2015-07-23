/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secretnotes.views;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author MSimons
 */
public class BaseView {
    private JFrame frame;
    private JLabel label;
    private JButton encrypt;
    private JButton decrypt;

    
    public BaseView(String text){
        frame = new JFrame("Secret Notes Encrypt/Decrypt Service");                                    
        frame.getContentPane().setLayout(new BorderLayout());                                          
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           
        frame.setSize(350,250);        
        frame.setVisible(true);
        Container con = new Container();
        con.setLayout(new FlowLayout());
        
        label = new JLabel(text);
        frame.getContentPane().add(label, BorderLayout.CENTER);
        
        encrypt = new JButton("Encrypt");  
        decrypt = new JButton("Decrypt");
        con.add(encrypt);
        con.add(decrypt);
        frame.getContentPane().add(con, BorderLayout.SOUTH);        
    }
        
    public JButton getEncrypt(){
        return encrypt;
    }
    
    public void setText(String text){
        label.setText(text);
    }

    /**
     * @return the decrypt
     */
    public JButton getDecrypt() {
        return decrypt;
    }

    /**
     * @param decrypt the decrypt to set
     */
    public void setDecrypt(JButton decrypt) {
        this.decrypt = decrypt;
    }
    
    public void dispose(){
        frame.dispose();
    }
    
}
