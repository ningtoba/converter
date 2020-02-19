//Ning
//Edit TITLE,convertList, convertRateToOther
package Converter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mass extends JFrame {
    //  Edit TITLE accordingly
    private final String TITLE = "Mass Converter";
    //  Edit convertList[] according to type
    private final String[] convertList = {"MG", "G", "KG", "Pounds"};
    private JTextField tfMsg, value0, value1, value2, value3;
    private JLabel title = new JLabel(TITLE), result;
    private JPanel contentPane = new JPanel();

    //  Constructor
    public Mass () {

        contentPane.setForeground(new Color(31, 138, 192));
        contentPane.setBackground(new Color(26, 188, 156));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //Title Label
        JLabel lblLength2Conversion = new JLabel(TITLE);
        lblLength2Conversion.setHorizontalAlignment(SwingConstants.CENTER);
        lblLength2Conversion.setForeground(Color.WHITE);
        lblLength2Conversion.setFont(new Font("Verdana", Font.PLAIN, 30));
        lblLength2Conversion.setBounds(12, 13, 458, 54);
        contentPane.add(lblLength2Conversion);

        //Initializes Labels
        newLabel(convertList[0], 12, 91, 107, 40);
        newLabel(convertList[1], 12, 157, 107, 40);
        newLabel(convertList[2], 12, 220, 107, 40);
        newLabel(convertList[3], 12, 281, 107, 40);

        //Initializes Text Fields;
        value0 = newField(131, 91, 338, 40);
        value1 = newField(131, 157, 338, 40);
        value2 = newField(131, 220, 338, 40);
        value3 = newField(131, 281, 338, 40);
        tfMsg = newField(12, 349, 458, 60);
        tfMsg.setText("Enter value to only one field");
        tfMsg.setFont(new Font("Verdana", Font.BOLD, 20));
        tfMsg.setForeground(new Color(75, 119, 190));
        tfMsg.setBackground((new Color(26, 188, 156)));

        JLabel label1 = new JLabel("Enter Value:");

        //Directs to Main Menu
        JButton button = new JButton("Main Menu");
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Verdana", Font.PLAIN, 20));
        button.setBackground(new Color(22, 160, 133));
        button.setBounds(12, 499, 162, 41);
        contentPane.add(button);
        button.addActionListener(e -> {
            Main home = new Main();
            home.setVisible(true);
            home.setSize(500, 600);
            Mass.this.dispose();
        });

        //Convert Button
        JButton btnMg = new JButton("Convert");
        btnMg.setForeground(Color.WHITE);
        btnMg.setFont(new Font("Verdana", Font.PLAIN, 18));
        btnMg.setBackground(new Color(22, 160, 133));
        btnMg.setBounds(12, 410, 458, 60);
        contentPane.add(btnMg);
        btnMg.addActionListener(e -> convertRateToOther());

//      Clear Button : Clears all value
        JButton button_2 = new JButton("Clear");
        button_2.setForeground(Color.WHITE);
        button_2.setFont(new Font("Verdana", Font.PLAIN, 20));
        button_2.setBackground(new Color(22, 160, 133));
        button_2.setBounds(200, 499, 129, 41);
        button_2.addActionListener(e -> {
            value0.setText(null);
            value1.setText(null);
            value2.setText(null);
            value3.setText(null);
        });

//      Exit Button
        JButton button_1 = new JButton("Exit");
        button_1.setForeground(Color.WHITE);
        button_1.setFont(new Font("Verdana", Font.PLAIN, 20));
        button_1.setBackground(new Color(22, 160, 133));
        button_1.setBounds(341, 499, 129, 41);
        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mass.this.dispose();
            }
        });
        contentPane.add(button_1);

        //Panel Content
        contentPane.add(label1);
        contentPane.add(button);
        contentPane.add(button_2);

    }

    //    Edit Values in here
    private void convertRateToOther() {
        String s1 = "", s2 = "", s3 = "";
        if (value0.getText().isEmpty() && value1.getText().isEmpty() && value2.getText().isEmpty() && value3.getText().isEmpty())
            tfMsg.setText("Your input is empty !");

        else if (!value0.getText().isEmpty() && value1.getText().isEmpty() && value2.getText().isEmpty() && value3.getText().isEmpty()) {
            tfMsg.setText(null);
            double v0 = Double.parseDouble(value0.getText());
            double v1 = v0 * 0.001;
            double v2 = v0 * 0.0000010;
            double v3 = v0 * 0.0000022046226218488;
            s1 = String.format("%.2f", v1);
            s2 = String.format("%.2f", v2);
            s3 = String.format("%.2f", v3);
            value1.setText(s1);
            value2.setText(s2);
            value3.setText(s3);
            tfMsg.setText("SUCCESSFULLY CONVERTED!");
        } else if (value0.getText().isEmpty() && !value1.getText().isEmpty() && value2.getText().isEmpty() && value3.getText().isEmpty()) {
            tfMsg.setText(null);
            double v0 = Double.parseDouble(value1.getText());
            double v1 = v0 * 1000;
            double v2 = v0 * 0.001;
            double v3 = v0 * 0.0022046226218488;
            s1 = String.format("%.2f", v1);
            s2 = String.format("%.2f", v2);
            s3 = String.format("%.2f", v3);
            value0.setText(s1);
            value2.setText(s2);
            value3.setText(s3);
            tfMsg.setText("SUCCESSFULLY CONVERTED!");
        } else if (value0.getText().isEmpty() && value1.getText().isEmpty() && !value2.getText().isEmpty() && value3.getText().isEmpty()) {
            tfMsg.setText(null);
            double v0 = Double.parseDouble(value2.getText());
            double v1 = v0 * 1000000;
            double v2 = v0 * 1000;
            double v3 = v0 * 2.2046226218488;
            s1 = String.format("%.2f", v1);
            s2 = String.format("%.2f", v2);
            s3 = String.format("%.2f", v3);
            value0.setText(s1);
            value1.setText(s2);
            value3.setText(s3);
            tfMsg.setText("SUCCESSFULLY CONVERTED!");
        } else if (value0.getText().isEmpty() && value1.getText().isEmpty() && value2.getText().isEmpty() && !value3.getText().isEmpty()) {
            tfMsg.setText(null);
            double v0 = Double.parseDouble(value3.getText());
            double v1 = v0 * 453592.37;
            double v2 = v0 * 453.59237;
            double v3 = v0 * 0.45359237;
            s1 = String.format("%.2f", v1);
            s2 = String.format("%.2f", v2);
            s3 = String.format("%.2f", v3);
            value0.setText(s1);
            value1.setText(s2);
            value2.setText(s3);
            tfMsg.setText("SUCCESSFULLY CONVERTED!");
        }

    }

    private JTextField newField(int axisX, int axisY, int width, int height) {
        JTextField x = new JTextField();
        x.setHorizontalAlignment(SwingConstants.CENTER);
        x.setFont(new Font("Montserrat", Font.PLAIN, 20));
        x.setColumns(10);
        x.setBounds(axisX, axisY, width, height);
        contentPane.add(x);

        return x;
    }

    private void newLabel(String y, int axisX, int axisY, int width, int height) {
        JLabel lblMg = new JLabel(y);
        lblMg.setForeground(Color.WHITE);
        lblMg.setFont(new Font("Verdana", Font.PLAIN, 18));
        lblMg.setBackground(Color.BLACK);
        lblMg.setBounds(axisX, axisY, width, height);
        contentPane.add(lblMg);
    }
}