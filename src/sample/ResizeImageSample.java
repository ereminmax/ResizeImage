package sample;

import java.awt.event.ActionListener;
import java.io.IOException;
import resizeimage.ResizeImage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * YOU HAVE TO CREATE THE DIRECTORY C:\TEST TO DO THIS TEST OR CHANGE THE DESTINY AT THE METHOD test()
 * THE ORIGINAL IMAGE IS 1024X768 AND HAS A JPG EXTENSION. THE SAMPLE SAVE AS PNG WITH SPECIFIED WIDTH AND HEIGHT
 * Created by Maxim Eremin on 11.08.2015.
 */
public class ResizeImageSample extends JFrame{

    JLabel jlab;
    JTextField jtfw, jtfh;
    int width, height;
    int screenWidth, screenHeight;

    ResizeImageSample () {
        //CREATING FRAME
        //HORSTMANN
        JFrame jfrm = new JFrame("Resize your image simply");
        jfrm.setLayout(new FlowLayout());
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        screenWidth = screenSize.width;
        screenHeight = screenSize.height;
        jfrm.setSize(screenWidth / 2, screenHeight / 2); //SIZE OF THE FRAME IS A HALF OF USER'S SCREENSIZE
        setLocationByPlatform(true); //OS SETS THE FRAME'S LOCATION
        setResizable(true); //USER CAN CHANGE THE SIZE OF THE FRAME
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //ONE LABEL
        JLabel jlab = new JLabel("Simply type below width and height of an image you want it to be converted to");
        jfrm.add(jlab);

        //TWO TEXT FIELDS
        JTextField jtfw = new JTextField(4);
        JTextField jtfh = new JTextField(4);
        jfrm.add(jtfw);
        jfrm.add(jtfh);

        //ONE BUTTON
        //SHILDT
        JButton jbtn = new JButton("Convert");
        jbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //USER FOOL CHECK
                if (jtfw.getText().equals("") || jtfh.getText().equals("")) {
                    jlab.setText("Field missed");
                    return;
                }

                //READING WIDTH AND HEIGHT FROM THE TEXT FIELDS
                String w = jtfw.getText();
                width = Integer.parseInt(w);
                String h = jtfh.getText();
                height = Integer.parseInt(h);

                //CONVERTING...
                //new ResizeImageSample().test();
                test();

                jlab.setText("Done");
            }
        });
        jfrm.add(jbtn);

        //MAKE IT VISIBLE
        jfrm.setVisible(true);
    }

    public static void main(String... args) {
        //BUILDING THE FRAME...
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ResizeImageSample();
            }
        });

        //new ResizeImageSample().test();
    }

    public void test() {
        try {
            ResizeImage.resizeImage(this.getClass().getResourceAsStream("test.jpg"), width , height , "png",
                                                                        "testResizeImage","C:\\test\\");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
