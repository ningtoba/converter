package Converter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    private JLabel lb1;
    private JPanel p1, p2;
    private JButton length, temp, mass, water;

    public Main() {
        lb1 = new JLabel("<html>Welcome to unit calculator!<br/> &nbsp &nbsp &nbsp Choose a Converter", JLabel.CENTER);
        lb1.setForeground(Color.WHITE);

        lb1.setFont(new Font("Verdana", Font.BOLD, 20));
        length = new JButton("LENGTH");
        length.setPreferredSize(new Dimension(100, 30));
        temp = new JButton("TEMPERATURE");
        temp.setPreferredSize(new Dimension(150, 30));
        mass = new JButton("MASS");
        mass.setPreferredSize(new Dimension(100, 30));
        water = new JButton("WATER");
        water.setPreferredSize(new Dimension(100, 30));

        length.setBackground(new Color(22, 160, 133));
        temp.setBackground(new Color(22, 160, 133));
        mass.setBackground(new Color(22, 160, 133));
        water.setBackground(new Color(22, 160, 133));
        length.setForeground(Color.WHITE);
        temp.setForeground(Color.WHITE);
        mass.setForeground(Color.WHITE);
        water.setForeground(Color.WHITE);


        p1 = new JPanel();
        p1.setBackground((new Color(26, 188, 156)));

        p1.add(lb1);

        p2 = new JPanel();
        p2.add(length);
        p2.add(temp);
        p2.add(mass);
        p2.add(water);
        p2.setLocation(10, 10);
        p2.setBackground((new Color(26, 188, 156)));

        setLayout(new BorderLayout());
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);

        length.addActionListener(this);
        temp.addActionListener(this);
        mass.addActionListener(this);
        water.addActionListener(this);

    }

    public static void main(String[] args) {
        Main obj = new Main();
        obj.setSize(600, 400);
        obj.setTitle("Unit Calculator");
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == length)
            createFrame(new Length(), "Length Converter");
        if (e.getSource() == temp)
            createFrame(new Temperature(), "Temperature Converter");
        if (e.getSource() == mass)
            createFrame(new Mass(), "Mass Converter");
        if (e.getSource() == water)
            createFrame(new Water(), "Water Converter");
        this.dispose();
    }

    private void createFrame(JFrame obj, String title) {
        obj.setSize(500, 600);
        obj.setTitle(title);
        obj.setVisible(true);
    }


}
