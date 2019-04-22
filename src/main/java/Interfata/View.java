package Interfata;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private JTextField inPolinom1 = new JTextField(50);             // Aici se introduce primul polinom
    private JTextField inPolinom2 = new JTextField(50);             // Aici se introduce al doilea polinom
    private JTextField result = new JTextField(50);                 // Aici se afiseaza rezultatul

    private JButton adunare = new JButton("ADD");                      // Butoane pentru operatii
    private JButton scadere = new JButton("SUB");
    private JButton inmultire = new JButton("MULL");
    private JButton impartire = new JButton("DIV");
    private JButton derivare = new JButton("DERIVATION");
    private JButton integrare = new JButton("INTEGRATION");

    public View (){
        JLabel titlu = new JLabel("POLYNOMIAL OPERATION");
        JLabel pol1 = new JLabel("First polynomial");
        JLabel pol2 = new JLabel("Second polynomial");
        JLabel resultL = new JLabel("Result");

        inPolinom1.setFont(new Font( "Serif", Font.PLAIN, 25));
        inPolinom2.setFont(new Font( "Serif", Font.PLAIN, 25));
        result.setFont(new Font( "Serif", Font.PLAIN, 25));

        titlu.setFont(new Font( "Serif", Font.PLAIN, 30));
        titlu.setBackground(new Color(176,224,230));
        titlu.setOpaque(true);
        pol1.setFont(new Font( "Serif", Font.PLAIN, 25));
        pol1.setBackground(new Color(176,224,230));
        pol1.setOpaque(true);
        pol2.setFont(new Font( "Serif", Font.PLAIN, 25));
        pol2.setBackground(new Color(176,224,230));
        pol2.setOpaque(true);
        resultL.setFont(new Font( "Serif", Font.PLAIN, 25));
        resultL.setBackground(new Color(176,224,230));
        resultL.setOpaque(true);

        JPanel content = new JPanel();
        JPanel buttons = new JPanel();
        JPanel titluPanel = new JPanel();
        JPanel polinoame1 = new JPanel();
        JPanel polinoame2= new JPanel();
        JPanel polinoame3 = new JPanel();

        polinoame1.add(pol1);
        polinoame1.add(inPolinom1);
        polinoame1.setBackground(new Color(176,224,230));

        polinoame2.add(pol2);
        polinoame2.add(inPolinom2);
        polinoame2.setBackground(new Color(176,224,230));

        polinoame3.add(resultL);
        polinoame3.add(result);
        polinoame3.setBackground(new Color(176,224,230));
        titluPanel.add(titlu);
        titluPanel.setBackground(new Color(176,224,230));

        buttons.add(adunare);
        buttons.add(scadere);
        buttons.add(inmultire);
        buttons.add(impartire);
        buttons.add(derivare);
        buttons.add(integrare);
        buttons.setLayout(new FlowLayout());
        buttons.setBackground(new Color(135,206,250));
        buttons.setOpaque(true);

        content.add(titluPanel);
        content.add(polinoame1);
        content.add( Box.createRigidArea(new Dimension(0,30)));
        content.add(polinoame2);
        content.add( Box.createRigidArea(new Dimension(0,30)));
        content.add(polinoame3);
        content.add( Box.createRigidArea(new Dimension(0,30)));
        content.add(buttons);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBackground(new Color(176,224,230));

        this.setContentPane(content);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void addAddButtonListener(ActionListener e){
        adunare.addActionListener(e);
    }

    void addSubButtonListener(ActionListener e){
        scadere.addActionListener(e);
    }

    void addMullButtonListener(ActionListener e){
        inmultire.addActionListener(e);
    }

    void addDivButtonListener(ActionListener e){
        impartire.addActionListener(e);
    }

    void addDerivButtonListener(ActionListener e){
        derivare.addActionListener(e);
    }

    void addIntegButtonListener(ActionListener e){
        integrare.addActionListener(e);
    }

    JTextField getInPolinom1() {
        return inPolinom1;
    }

    JTextField getInPolinom2() {
        return inPolinom2;
    }

    void showJOptionPane(String message){
        JOptionPane.showMessageDialog(this,message);
    }

    void setResult(String result) {
        this.result.setText(result);
    }
}
