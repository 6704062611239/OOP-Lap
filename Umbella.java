package umbella;

import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;

public class Umbella extends JFrame {
    Umbella(){
        add(new DrawArcPanel());
    }
    
    public static void main(String[] args) {
        JFrame demo = new Umbella();
        demo.setTitle("Draw Arcs Demo");
        demo.setSize(1700, 1500);
        demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        demo.setLocationRelativeTo(null);
        demo.setVisible(true);
    } 
}
class DrawArcPanel extends JPanel{
    int t = 0;
    int speed = 0;
    Timer time = new Timer(10,new Listener());
    
    JButton jb0 = new JButton("0");
    JButton jb1 = new JButton("1");
    JButton jb2 = new JButton("2");
    JButton jb3 = new JButton("3");
    DrawArcPanel(){
        JPanel p = new JPanel();
        p.add(jb0);
        p.add(jb1);
        p.add(jb2);
        p.add(jb3);
        add(p, BorderLayout.SOUTH);
        jb0.addActionListener(new Listener());
        jb1.addActionListener(new Listener());
        jb2.addActionListener(new Listener());
        jb3.addActionListener(new Listener());
    }
    class Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
            if (e.getSource() == time) {
                t = t + speed;
                repaint();
            }
            if(e.getSource() == jb0){
                time.stop();
            }else if(e.getSource() == jb1){
                speed = 5;
                time.start();
            }else if(e.getSource() == jb2){
                speed = 10;
                time.start();
            }else if(e.getSource() == jb3){
                speed = 15;
                time.start();
            }
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int xcenter =getWidth()/2;
        int ycenter=getHeight()/2;
        int radius = (int)(Math.min(getWidth(), getHeight()) * 0.4);
        int x = xcenter-radius;
        int y = ycenter-radius;
        g.setColor(Color.red);
        t++;
        g.fillArc(x, y, 2*radius, 2*radius,0+t,30);
        g.fillArc(x, y, 2*radius, 2*radius,90+t,30);
        g.fillArc(x, y, 2*radius, 2*radius,180+t,30);
        g.fillArc(x, y, 2*radius, 2*radius,270+t,30);
    }


}