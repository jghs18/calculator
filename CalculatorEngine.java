
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.applet.Applet;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
public class CalculatorEngine  {
    JPanel num;
    JFrame mainFrame;
    JLabel txtBox;
    JPanel mainPanel;
    JButton jB9;
    JButton jB8;
    JButton jB7;
    JButton jB6;
    JButton jB5;
    JButton jB4;
    JButton jB3;
    JButton jB2;
    JButton jB1;
    JButton jB0;
    JButton jBd;
    JButton jBtimes;
    JButton jBsqrt;
    JButton jBminus;
    JButton jBplus;
    JButton jBequals;
    JButton jBAC;
    JButton jBpm;
    JButton jBPercent;
    JButton jBdivide;
    JButton jBe;
    double num1;
    String a = "";
    String b = "";
    String operation;
    boolean first = true;
    double num2;
    String number;
    public CalculatorEngine()
    {
        mainFrame = new JFrame("Calculator");
        mainFrame.setSize(800, 1000);
        txtBox = new JLabel(number);
        txtBox.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
        txtBox.setText("0");
    }

    public void createUI()
    {
        class ButtonListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource()==jBAC)
                {
                    txtBox.setText("0");
                    a = "";
                    b = "";
                    num1 = 0;
                    num2 = 0;
                    first = true;
                }
               
                else if(e.getSource()==jBplus)
                {
                    txtBox.setText(((JButton) e.getSource()).getText());
                    operation = "+ ";
                    first = false;
                }
                else if(e.getSource()==jBminus)
                {
                    txtBox.setText(((JButton) e.getSource()).getText());
                    operation = "- ";
                    first = false;
                }
                else if(e.getSource()==jBtimes)
                {
                    txtBox.setText(((JButton) e.getSource()).getText());
                    operation = "x ";
                    first = false;
                }
                else if(e.getSource()==jBPercent)
                {
                    num1 = Double.parseDouble(a);
                    txtBox.setText(Double.toString(num1/100));
                }
                else if(e.getSource()==jBpm)
                {
                    String c = txtBox.getText();
                    num1 = Double.parseDouble(c);
                    if(num1<0) num1 = 0-(num1);
                    else num1 = 0-num1;
                    txtBox.setText(Double.toString(num1));
                }
                else if(e.getSource()==jBdivide)
                {
                    txtBox.setText(((JButton) e.getSource()).getText());
                    operation = "/ ";
                    first = false;
                }
                else if(e.getSource()==jBe)
                {
                    num1 = Double.parseDouble(a);
                    num2 =  Double.parseDouble(b);
                    if(operation=="x " ) txtBox.setText(Double.toString(num1*num2));
                    if(operation=="+ ") txtBox.setText(Double.toString(num1+num2));
                    if(operation=="- ") txtBox.setText(Double.toString(num1-num2));
                    if(operation=="/ ") txtBox.setText(Double.toString(num1/num2));
                    if(operation=="√ ") txtBox.setText(Double.toString(Math.sqrt(num1)));
                    //num1 = Double.parseDouble(txtBox.getText());
                    //System.out.println(Double.toString(num1+num2));
                }
                else
                {
                    //txtBox.setText("");
                    JButton placeholder = (JButton) e.getSource();
                    if(first)
                    {
                        a = a + placeholder.getText();
                        txtBox.setText(a);
                    }
                    if(!first)
                    {
                        b = b + placeholder.getText();
                        txtBox.setText(b);
                    }
                    txtBox.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
                }
            }
        }
        ButtonListener bL = new ButtonListener();

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        num = new JPanel();
        num.setLayout(new GridLayout(5,4));
        num.setBorder(BorderFactory.createLineBorder(Color.black));

        jBAC = new JButton("AC");
        jBAC.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
        jBAC.addActionListener(bL);
        num.add(jBAC);

        jBpm = new JButton("+/-");
        jBpm.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
        jBpm.addActionListener(bL);
        num.add(jBpm);

        jBPercent = new JButton("%");
        jBPercent.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
        jBPercent.addActionListener(bL);
        num.add(jBPercent);

        jBdivide = new JButton("/");
        jBdivide.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
        jBdivide.addActionListener(bL);
        num.add(jBdivide);

        //jBsqrt = new JButton("√");
        //jBsqrt.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
        //jBsqrt.addActionListener(bL);
        //num.add(jBsqrt);

        jB7 = new JButton("7");
        jB7.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
        jB7.addActionListener(bL);
        num.add(jB7);

        jB8 = new JButton("8");
        jB8.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
        jB8.addActionListener(bL);
        num.add(jB8);

        jB9 = new JButton("9");
        jB9.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
        jB9.addActionListener(bL);
        num.add(jB9);

        jBtimes = new JButton("x");
        jBtimes.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
        jBtimes.addActionListener(bL);
        num.add(jBtimes);

        jB4 = new JButton("4");
        jB4.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
        jB4.addActionListener(bL);
        num.add(jB4);

        jB5 = new JButton("5");
        jB5.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
        jB5.addActionListener(bL);
        num.add(jB5);

        jB6 = new JButton("6");
        jB6.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
        jB6.addActionListener(bL);
        num.add(jB6);

        jBminus = new JButton("-");
        jBminus.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
        jBminus.addActionListener(bL);
        num.add(jBminus);

        jB1 = new JButton("1");
        jB1.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
        jB1.addActionListener(bL);
        num.add(jB1);

        jB2 = new JButton("2");
        jB2.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
        jB2.addActionListener(bL);
        num.add(jB2);

        jB3 = new JButton("3");
        jB3.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
        jB3.addActionListener(bL);
        num.add(jB3);

        jBplus = new JButton("+");
        jBplus.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
        jBplus.addActionListener(bL);
        num.add(jBplus);

        JPanel blank = new JPanel();
        num.add(blank);

        jB0 = new JButton("0");
        jB0.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
        jB0.addActionListener(bL);
        num.add(jB0);

        jBd = new JButton(".");
        jBd.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
        jBd.addActionListener(bL);
        num.add(jBd);

        jBe = new JButton("=");
        jBe.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
        jBe.addActionListener(bL);
        num.add(jBe);
    }

    public void drawCalc()
    {
        mainPanel.add(num, BorderLayout.CENTER);
        mainPanel.add(txtBox, BorderLayout.NORTH);
        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }

}
