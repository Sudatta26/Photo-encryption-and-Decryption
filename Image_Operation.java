package com.company;

import jdk.dynalink.Operation;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Image_Operation {
    public static void operation(int key){
        JFileChooser fileChooser=new JFileChooser();
        fileChooser.showOpenDialog(null);
       File file= fileChooser.getSelectedFile();
       try{
           FileInputStream fis=new FileInputStream(file);

           byte []data=new byte[fis.available()];
           fis.read(data);
           int i =0;
           for(byte b:data){
               System.out.println(b);
               data[i]=(byte)(b^key);
               i++;
           }
           FileOutputStream fos=new FileOutputStream(file);
           fos.write(data);
           fos.close();
           fis.close();
           JOptionPane.showMessageDialog(null,"Done");

       }
       catch (Exception e){
           e.printStackTrace();
       }
    }




    public static void main(String[] args) {
        JFrame f=new JFrame();
        f.setTitle("Image Operation");
        f.setSize(400,400);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Fonts
        Font font=new Font("Roboto",Font.BOLD,25);

        //Buttons
        JButton Button = new JButton();
        Button.setText("Open Image");
        Button.setFont(font);


        //Creating text field
        JTextField m=new JTextField(10);
        m.setFont(font);
        Button.addActionListener(e -> {
            String text=m.getText();
            int passcode=Integer.parseInt(text);
            operation(passcode);
        });
        f.setLayout(new FlowLayout());
        f.add(Button);
        f.add(m);
        f.setVisible(true);
    }
}
