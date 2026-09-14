package hangmanc2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hangmanc2 extends JFrame {
    JButton jbA = new JButton("A");
    JButton jbB = new JButton("B");
    DrawHangmanPanel panel = new DrawHangmanPanel();
    Hangmanc2() {
        add(panel);
        JPanel p = new JPanel();
        p.add(jbA);
        p.add(jbB);
        add(p, BorderLayout.SOUTH);
        Listener lis = new Listener();
        jbA.addActionListener(lis);
        jbB.addActionListener(lis);
    }
    class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == jbA) {
                panel.mode = 1;
            }
            if (e.getSource() == jbB) {
                panel.mode = 2;
            }
        }
    }
    class DrawHangmanPanel extends JPanel {
        double angle = 0;
        double speed = 0.02;
        int mode = 0;
        Timer timer = new Timer(30, new TimerListener());
        public DrawHangmanPanel() {
            timer.start();
        }
        class TimerListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mode == 1) {
                    angle = angle + speed;
                    if (angle > Math.toRadians(20)) {
                        speed = -0.02;
                    }
                    if (angle < Math.toRadians(-20)) {
                        speed = 0.02;
                    }
                } else if (mode == 2) {
                    angle = angle + 1;
                    if (angle >= Math.toRadians(360)) {
                        angle = 0;
                    }
                }
                repaint();
            }
        }
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawArc(20, 220, 80, 40, 0, 180);
            g.drawLine(60, 220, 60, 20);
            g.drawLine(60, 20, 160, 20);
            g.drawLine(160, 20, 160, 40);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.rotate(angle, 160, 40);
            g2.drawOval(140, 40, 40, 40);
            g2.drawLine(160, 80, 160, 150);
            g2.drawLine(160, 100, 130, 120);
            g2.drawLine(160, 100, 190, 120);
            g2.drawLine(160, 150, 130, 190);
            g2.drawLine(160, 150, 190, 190);
            g2.dispose();
        }
    }

    public static void main(String[] args) {
        JFrame hangman = new Hangmanc2();
        hangman.setSize(400, 500);
        hangman.setTitle("Demo Hangman");
        hangman.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hangman.setLocationRelativeTo(null);
        hangman.setVisible(true);
    }
}