import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        HomeFrame homeFrame = new HomeFrame();
        InputFrame inputFrame = new InputFrame();
        InfoFrame infoFrame = new InfoFrame();
        Garage garage = new Garage();

        Controller controller = new Controller(homeFrame, inputFrame, infoFrame, garage);

        homeFrame.setVisible(true);
      }
    }
