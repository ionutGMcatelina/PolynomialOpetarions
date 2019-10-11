package Interfata;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private JTextField inPolynomial1 = new JTextField(50);
    private JTextField inPolynomial2 = new JTextField(50);
    private JTextField result = new JTextField(50);                 // The result will be displayed here

    private JButton add = new JButton("ADD");                      // Buttons for operations
    private JButton sub = new JButton("SUB");
    private JButton mull = new JButton("MULL");
    private JButton div = new JButton("DIV");
    private JButton derivation = new JButton("DERIVATION");
    private JButton integration = new JButton("INTEGRATION");

    public View (){
        JLabel title = new JLabel("POLYNOMIAL OPERATION");
        JLabel pol1 = new JLabel("First polynomial");
        JLabel pol2 = new JLabel("Second polynomial");
        JLabel resultL = new JLabel("Result");

        inPolynomial1.setFont(new Font( "Serif", Font.PLAIN, 25));
        inPolynomial2.setFont(new Font( "Serif", Font.PLAIN, 25));
        result.setFont(new Font( "Serif", Font.PLAIN, 25));

        title.setFont(new Font( "Serif", Font.PLAIN, 30));
        title.setBackground(new Color(176,224,230));
        title.setOpaque(true);
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
        JPanel titlePanel = new JPanel();
        JPanel polynomial1 = new JPanel();
        JPanel polynomial2= new JPanel();
        JPanel polynomial3 = new JPanel();

        polynomial1.add(pol1);
        polynomial1.add(inPolynomial1);
        polynomial1.setBackground(new Color(176,224,230));

        polynomial2.add(pol2);
        polynomial2.add(inPolynomial2);
        polynomial2.setBackground(new Color(176,224,230));

        polynomial3.add(resultL);
        polynomial3.add(result);
        polynomial3.setBackground(new Color(176,224,230));
        titlePanel.add(title);
        titlePanel.setBackground(new Color(176,224,230));

        buttons.add(add);
        buttons.add(sub);
        buttons.add(mull);
        buttons.add(div);
        buttons.add(derivation);
        buttons.add(derivation);
        buttons.setLayout(new FlowLayout());
        buttons.setBackground(new Color(135,206,250));
        buttons.setOpaque(true);

        content.add(titlePanel);
        content.add(polynomial1);
        content.add( Box.createRigidArea(new Dimension(0,30)));
        content.add(polynomial2);
        content.add( Box.createRigidArea(new Dimension(0,30)));
        content.add(polynomial3);
        content.add( Box.createRigidArea(new Dimension(0,30)));
        content.add(buttons);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBackground(new Color(176,224,230));

        this.setContentPane(content);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void addAddButtonListener(ActionListener e){
        add.addActionListener(e);
    }

    void addSubButtonListener(ActionListener e){
        sub.addActionListener(e);
    }

    void addMullButtonListener(ActionListener e){
        mull.addActionListener(e);
    }

    void addDivButtonListener(ActionListener e){
        div.addActionListener(e);
    }

    void addDerivationButtonListener(ActionListener e){
        derivation.addActionListener(e);
    }

    void addIntegrationButtonListener(ActionListener e){
        derivation.addActionListener(e);
    }

    JTextField getInPolynomial1() {
        return inPolynomial1;
    }

    JTextField getInPolynomial2() {
        return inPolynomial2;
    }

    void showJOptionPane(String message){
        JOptionPane.showMessageDialog(this,message);
    }

    void setResult(String result) {
        this.result.setText(result);
    }
}
