package Polynomial;

import Interfata.*;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        view.setSize(950, 550);
        view.setResizable(false);
        view.setVisible(true);

        new Controller(view);
    }
}
