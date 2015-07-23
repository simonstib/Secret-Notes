/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secretnotes.Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import secretnotes.CryptoException;
import secretnotes.CryptoUtils;
import secretnotes.model.Model;
import secretnotes.views.BaseView;

/**
 *
 * @author MSimons
 */
public class Controller {

    private final Model model;
    private final BaseView view;
    private ActionListener actionListener;

    public Controller(Model model, BaseView view) {
        this.model = model;
        this.view = view;
        model.setKey("Mary has one xa1");
    }

    public void setButtonListeners() {
        actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                launchEncrypt();
            }
        };
        view.getEncrypt().addActionListener(actionListener);

        actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    launchDecrypt();
                } catch (IOException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        view.getDecrypt().addActionListener(actionListener);
    }

    private void launchEncrypt() {
        
        view.dispose();
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(null);
        fc.setVisible(true);
        
        File fileName = fc.getSelectedFile();
        String s = fc.getDescription(fileName);
        File inputFile = new File(fileName.getAbsolutePath());
        File encryptedFile = new File("D:\\Users\\msimons\\Documents\\secrets\\encrypted\\" + s + ".encrypted");
        try {
            CryptoUtils.encrypt(model.getKey(), inputFile, encryptedFile);

        } catch (CryptoException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void launchDecrypt() throws IOException {
        view.dispose();
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(null);
        fc.setVisible(true);
        
        File fileName = fc.getSelectedFile();
        //String s = fc.getDescription(fileName);
        String s = convertEnding(fileName);
        File inputFile = new File(fileName.getAbsolutePath());
        File decryptedFile = new File("D:\\Users\\msimons\\Documents\\secrets\\decrypted\\" + s);
        try {
            CryptoUtils.decrypt(model.getKey(), inputFile, decryptedFile);
            Files.delete(inputFile.toPath());
        } catch (CryptoException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    //check extension of the file
    public String convertEnding(File in) {
        String encry = "encrypted";
        String fileName = in.getName();
        String exten = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
        if (!encry.equalsIgnoreCase(exten)) {
            JOptionPane.showMessageDialog(null, "Choose an encrypted File please!");
            
        } else {
            String filepath = in.getAbsolutePath();
            JOptionPane.showMessageDialog(null, "You have chosen "+filepath);
            
            String returnedString = fileName.substring(0, fileName.lastIndexOf("."));
            return returnedString;
            //String upload = UploadPoData.initialize(null, filepath);
            /*
             if (upload == "OK") {
             JOptionPane.showMessageDialog(null, "Upload Successful!");
             }*/
            
        }
        return null;
    }
}
