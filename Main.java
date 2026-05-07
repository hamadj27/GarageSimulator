public class Main {

    public static void main(String[] args) {
        HomeFrame homeFrame = new HomeFrame();
        Garage garage = new Garage();

        Controller controller = new Controller(homeFrame, garage);

        homeFrame.setVisible(true);
      }
    }
