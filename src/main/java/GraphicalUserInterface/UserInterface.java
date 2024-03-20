package GraphicalUserInterface;

import DataModels.MonomialWithIntegerCoefficient;
import DataModels.Polynomial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInterface {

    private JTextField textFieldPolinom1 = new JTextField(30);
    private JTextField textFieldPolinom2 = new JTextField(30);

    private JTextField textFieldResult = new JTextField(30);
    private JButton addBtn = new JButton("Add");
    private JButton subBtn = new JButton("Substract");
    private JButton mulBtn = new JButton("Multiplicate");
    private JButton divBtn = new JButton("Divide");
    private JButton derivFirstBtn = new JButton("Derivate First Polynom");
    private JButton derivSecondBtn = new JButton("Derivate Second Polynom");
    private JButton intFirstBtn = new JButton("Integrate First Polynom");
    private JButton intSecondBtn = new JButton("Integrate Second Polynom");

    public UserInterface() {
        JFrame frame = new JFrame("Polynomial Calculator");
        frame.setSize(450, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JLabel labelPolinom1 = new JLabel("            First Polynomial = ");


        JLabel labelPolinom2 = new JLabel("            Second Polynomial = ");

        JLabel labelResult = new JLabel("             Resulted Polynomial = ");


        JPanel cifre = new JPanel();
        cifre.setLayout(new GridLayout(3, 3));
        JButton one = new JButton("1");
        one.setBackground(Color.yellow);
        JButton two = new JButton("2");
        two.setBackground(Color.yellow);
        JButton three = new JButton("3");
        three.setBackground(Color.yellow);
        JButton four = new JButton("4");
        four.setBackground(Color.yellow);
        JButton five = new JButton("5");
        five.setBackground(Color.yellow);
        JButton six = new JButton("6");
        six.setBackground(Color.yellow);
        JButton seven = new JButton("7");
        seven.setBackground(Color.yellow);
        JButton eight = new JButton("8");
        eight.setBackground(Color.yellow);
        JButton nine = new JButton("9");
        nine.setBackground(Color.yellow);

        cifre.add(one);
        cifre.add(two);
        cifre.add(three);
        cifre.add(four);
        cifre.add(five);
        cifre.add(six);
        cifre.add(seven);
        cifre.add(eight);
        cifre.add(nine);

        JPanel semne = new JPanel();
        semne.setLayout(new GridLayout(3, 3));
        JButton zero = new JButton("0");
        zero.setBackground(Color.yellow);
        JButton plus = new JButton("+");
        plus.setBackground(Color.green);
        JButton minus = new JButton("-");
        minus.setBackground(Color.green);
        JButton division = new JButton("/");
        division.setBackground(Color.green);
        JButton multiplication = new JButton("*");
        multiplication.setBackground(Color.green);
        JButton power = new JButton("^");
        power.setBackground(Color.green);
        JButton point = new JButton(".");
        point.setBackground(Color.green);
        JButton x = new JButton("x");
        x.setBackground(Color.green);
        JButton del = new JButton("Del");
        del.setBackground(Color.red);

        semne.add(zero);
        semne.add(plus);
        semne.add(minus);
        semne.add(division);
        semne.add(multiplication);
        semne.add(power);
        semne.add(point);
        semne.add(x);
        semne.add(del);

        textFieldResult.setEditable(false);
        GridLayout gridLayout = new GridLayout(7, 2);
        gridLayout.setHgap(10);
        gridLayout.setVgap(6);
        frame.setLayout(gridLayout);
        frame.add(labelPolinom1);
        frame.add(textFieldPolinom1);
        frame.add(labelPolinom2);
        frame.add(textFieldPolinom2);
        frame.add(labelResult);
        frame.add(textFieldResult);
        frame.add(addBtn);
        frame.add(subBtn);
        frame.add(mulBtn);
        frame.add(divBtn);
        frame.add(derivFirstBtn);
        frame.add(derivSecondBtn);
        frame.add(intFirstBtn);
        frame.add(intSecondBtn);


        frame.setVisible(true);

    }

    public String getPolinom1Text() {
        String pfirst = textFieldPolinom1.getText();
        return pfirst;
    }

    public String getPolinom2Text() {
        String psecond = textFieldPolinom2.getText();
        return psecond;
    }




    public void showResult(Polynomial result) {
        textFieldResult.setText(result.toString());
    }

    public void showDivisionResult(Polynomial quotient, Polynomial remainder) {
        textFieldResult.setText("Quotient:" + quotient.toString() + "   Remainder:" + remainder.toString());
    }


    public void addAddListener(ActionListener addl) {
        addBtn.addActionListener(addl);
    }

    public void addSubListener(ActionListener subl) {
        subBtn.addActionListener(subl);
    }

    public void addMultiplyListener(ActionListener multpl) {
        mulBtn.addActionListener(multpl);
    }

    public void addDerivateFirstListener(ActionListener derivFirstl) {
        derivFirstBtn.addActionListener(derivFirstl);
    }

    public void addDerivateSecondListener(ActionListener derivSecondl) {
        derivSecondBtn.addActionListener(derivSecondl);
    }

    public void addIntegrateFirstListener(ActionListener integrateFirstl) {
        intFirstBtn.addActionListener(integrateFirstl);
    }

    public void addIntegrateSecondListener(ActionListener integrateSecondl) {
        intSecondBtn.addActionListener(integrateSecondl);
    }

    public void addDivideListener(ActionListener dividel) {
        divBtn.addActionListener(dividel);
    }
}
