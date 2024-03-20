import BusinessLogic.CalcController;
import DataModels.Polynomial;
import GraphicalUserInterface.UserInterface;

public class PolynomialCalculator {

    public static void main(String[] args) {
        UserInterface GUI = new UserInterface();
        CalcController controller = new CalcController(GUI);


    }
}
