package democircle;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;

class Drawcircle extends JPanel {

    int r = 5;
            
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.drawOval(getWidth() / 2 - r,getHeight() / 2 - r,2 * r,2 * r);
    }
}

public class Democircle extends JFrame {

    JButton jbE = new JButton("E");
    JButton jbS = new JButton("S");

    Drawcircle circle = new Drawcircle();

    Democircle() {

        JPanel P = new JPanel();

        P.add(jbE);
        P.add(jbS);

        add(P, BorderLayout.SOUTH);
        add(circle, BorderLayout.CENTER);
        Listener lis = new Listener();
        jbE.addActionListener(lis);
        jbS.addActionListener(lis);
    }
    
    class Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == jbE) {
                circle.r += 5;      
            }

            if (e.getSource() == jbS) {
                if (circle.r > 5) {
                    circle.r -= 5;  
                }
            }

            circle.repaint();      
        }
    }

    public static void main(String[] args) {

        JFrame demo = new Democircle();

        demo.setTitle("Circle");
        demo.setSize(400, 500);
        demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        demo.setLocationRelativeTo(null);
        demo.setVisible(true);
    }
}