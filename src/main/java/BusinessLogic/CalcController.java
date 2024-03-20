package BusinessLogic;

import DataModels.Polynomial;
import GraphicalUserInterface.UserInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static javax.swing.JOptionPane.showMessageDialog;

public class CalcController {

    private Polynomial polynom1;
    private Polynomial polynom2;
    private UserInterface GUI;

    public CalcController(UserInterface GUI) {

        this.GUI = GUI;

        GUI.addAddListener(new AddListener());
        GUI.addSubListener(new SubListener());
        GUI.addMultiplyListener(new MultiplyListener());
        GUI.addDerivateFirstListener(new DerivateFirstListener());
        GUI.addDerivateSecondListener(new DerivateSecondListener());
        GUI.addIntegrateFirstListener(new IntegrateFirstListener());
        GUI.addIntegrateSecondListener(new IntegrateSecondListener());
        GUI.addDivideListener(new DivideListener());
    }

    class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String textPolynom1 = GUI.getPolinom1Text();
            String textPolynom2 = GUI.getPolinom2Text();
            try {
                Polynomial polynom1 = new Polynomial(textPolynom1);
                Polynomial polynom2 = new Polynomial(textPolynom2);
                Polynomial result = Operations.add(polynom1, polynom2);
                GUI.showResult(result);
            } catch (Exception ex) {
                showMessageDialog(null, "Introduceti un polinom valid! (ex: 2x^3+3x^2-5x+7)");
            }

        }
    }

    class SubListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String textPolinom1 = GUI.getPolinom1Text();
            String textPolinom2 = GUI.getPolinom2Text();
            try {
                Polynomial polynom1 = new Polynomial(textPolinom1);
                Polynomial polynom2 = new Polynomial(textPolinom2);
                Polynomial result = Operations.subtract(polynom1, polynom2);
                GUI.showResult(result);
            } catch (Exception ex) {
                showMessageDialog(null, "Introduceti un polinom valid! (ex: 2x^3+3x^2-5x+7)");
            }

        }
    }

    class MultiplyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String textPolynom1 = GUI.getPolinom1Text();
            String textPolynom2 = GUI.getPolinom2Text();
            try {
                Polynomial polynom1 = new Polynomial(textPolynom1);
                Polynomial polynom2 = new Polynomial(textPolynom2);
                Polynomial result = Operations.multiply(polynom1, polynom2);
                GUI.showResult(result);
            } catch (Exception ex) {
                showMessageDialog(null, "Introduceti un polinom valid! (ex: 2x^3+3x^2-5x+7)");
            }

        }
    }


    class DivideListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String textPolynom1 = GUI.getPolinom1Text();
            String textPolynom2 = GUI.getPolinom2Text();
            try {
                Polynomial polynom1 = new Polynomial(textPolynom1);
                Polynomial polynom2 = new Polynomial(textPolynom2);
                ArrayList<Polynomial> results = Operations.divide(polynom1, polynom2);
                GUI.showDivisionResult(results.get(0), results.get(1));
            } catch (Exception ex) {
                showMessageDialog(null, "Introduceti un polinom valid! (ex: 2x^3+3x^2-5x+7)");
            }

        }
    }


    class DerivateFirstListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String textPolynom1 = GUI.getPolinom1Text();
            try {
                Polynomial polynom1 = new Polynomial(textPolynom1);
                Polynomial result = Operations.derivatePolynomial(polynom1);
                GUI.showResult(result);
            } catch (Exception ex) {
                showMessageDialog(null, "Introduceti un polinom valid! (ex: 2x^3+3x^2-5x+7)");
            }

        }
    }

    class DerivateSecondListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String textPolynom2 = GUI.getPolinom2Text();
            try {
                Polynomial polynom2 = new Polynomial(textPolynom2);
                Polynomial result = Operations.derivatePolynomial(polynom2);
                GUI.showResult(result);
            } catch (Exception ex) {
                showMessageDialog(null, "Introduceti un polinom valid! (ex: 2x^3+3x^2-5x+7)");
            }

        }
    }

    class IntegrateFirstListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String textPolynom1 = GUI.getPolinom1Text();
            try {
                Polynomial polynom1 = new Polynomial(textPolynom1);
                Polynomial result = Operations.integratePolynomial(polynom1);
                GUI.showResult(result);
            } catch (Exception ex) {
                showMessageDialog(null, "Introduceti un polinom valid! (ex: 2x^3+3x^2-5x+7)");
            }
        }
    }

    class IntegrateSecondListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String textPolynom2 = GUI.getPolinom2Text();
            try {
                Polynomial polynom2 = new Polynomial(textPolynom2);
                Polynomial result = Operations.integratePolynomial(polynom2);
                GUI.showResult(result);
            } catch (Exception ex) {
                showMessageDialog(null, "Introduceti un polinom valid! (ex: 2x^3+3x^2-5x+7)");
            }

        }
    }


}

