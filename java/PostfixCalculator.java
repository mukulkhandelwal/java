import javax.swing.*;
import javax.swing.border.Border;

import java.util.Arrays;
import java.util.Stack;
import java.awt.*;
import java.awt.event.*;

public class PostfixCalculator extends JFrame
{
private JPanel calculatedResultPanel;
private JPanel northPanel;
private JPanel centerPanel;
private JPanel southPanel;
private JPanel num1Panel;
private JPanel num2Panel;
private JPanel num3Panel;
private JPanel num4Panel;
private JPanel num5Panel;
private JPanel num6Panel;
private JPanel num7Panel;
private JPanel num8Panel;
private JPanel num9Panel;
private JPanel addPanel;
private JPanel subtractPanel;
private JPanel multiplyPanel;
private JPanel dividePanel;
private JPanel zeroPanel;
private JPanel spacePanel;
private JPanel calculatePanel;
private JPanel clearPanel;
private JButton zero;
private JButton one;
private JButton two;
private JButton three;
private JButton four;
private JButton five;
private JButton six;
private JButton seven;
private JButton eight;
private JButton nine;
private JButton add;
private JButton subtract;
private JButton multiply;
private JButton divide;
private JButton space;
private JButton calculate;
private JButton clear;
private JLabel calculatorLabel;
private final int WINDOW_WIDTH = 350;
private final int WINDOW_HEIGHT = 250;

// Main
public static void main(String[] args)
{
    new PostfixCalculator();
}

// Constructor
public PostfixCalculator()
{
    setTitle("Posfix Calculator");
    setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Build the panel and add it to the frame
    buildPanel();

    //Get the string output from the buttons pressed
    getStringOutput();

    // Display the window
    setVisible(true);
}

// The buildPanel method is created to add a label, text field,
// and a button to the panel
public void buildPanel()
{
    // Use the insert containers method
    insertContainers();

    // Adjust the north panel to display the label bar
    Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
    calculatorLabel.setBorder(border);
    calculatorLabel.setPreferredSize(new Dimension(150, 25));
    calculatedResultPanel.add(calculatorLabel);
    northPanel.add(calculatedResultPanel);
    add(northPanel, BorderLayout.NORTH);

    // Adjust the east panel to display the majority
    // of the buttons
    centerPanel.setLayout(new GridLayout(4,4));
    num1Panel.add(one);
    num2Panel.add(two);
    num3Panel.add(three);
    addPanel.add(add);
    num4Panel.add(four);
    num5Panel.add(five);
    num6Panel.add(six);
    subtractPanel.add(subtract);
    num7Panel.add(seven);
    num8Panel.add(eight);
    num9Panel.add(nine);
    multiplyPanel.add(multiply);
    zeroPanel.add(zero);
    clearPanel.add(clear);
    dividePanel.add(divide);
    centerPanel.add(num1Panel);
    centerPanel.add(num2Panel);
    centerPanel.add(num3Panel);
    centerPanel.add(addPanel);
    centerPanel.add(num4Panel);
    centerPanel.add(num5Panel);
    centerPanel.add(num6Panel);
    centerPanel.add(subtractPanel);
    centerPanel.add(num7Panel);
    centerPanel.add(num8Panel);
    centerPanel.add(num9Panel);
    centerPanel.add(multiplyPanel);
    centerPanel.add(Box.createRigidArea(new Dimension(0,5)));
    centerPanel.add(zeroPanel);
    centerPanel.add(clearPanel);
    centerPanel.add(dividePanel);
    add(centerPanel, BorderLayout.CENTER);

    // Put the remaining buttons and labels inside the South panel
    southPanel.setLayout(new GridLayout(1,3));
    calculatePanel.add(calculate);
    spacePanel.add(space);
    southPanel.add(Box.createRigidArea(new Dimension(0,5)));
    southPanel.add(calculatePanel);
    southPanel.add(spacePanel);
    add(southPanel, BorderLayout.SOUTH);

    // Add the action listeners to the panel
    zero.addActionListener(new buttonListener());
    one.addActionListener(new buttonListener());
    two.addActionListener(new buttonListener());
    three.addActionListener(new buttonListener());
    four.addActionListener(new buttonListener());
    five.addActionListener(new buttonListener());
    six.addActionListener(new buttonListener());
    seven.addActionListener(new buttonListener());
    eight.addActionListener(new buttonListener());
    nine.addActionListener(new buttonListener());
    add.addActionListener(new buttonListener());
    subtract.addActionListener(new buttonListener());
    multiply.addActionListener(new buttonListener());
    divide.addActionListener(new buttonListener());
    space.addActionListener(new buttonListener());
    clear.addActionListener(new buttonListener());

    //Add the action listener for the calculate button
    calculate.addActionListener(new buttonListener());
}

// Insert the panels, buttons and labels into the frame
public void insertContainers()
{
    // Insert a label for the calculator output
    calculatorLabel = new JLabel("");

    // Create the panels
    calculatedResultPanel = new JPanel();
    northPanel = new JPanel();
    centerPanel = new JPanel();
    southPanel = new JPanel();

    // Create the specialized panels

    num1Panel = new JPanel();
    num2Panel = new JPanel();
    num3Panel = new JPanel();
    num4Panel = new JPanel();
    num5Panel = new JPanel();
    num6Panel = new JPanel();
    num7Panel = new JPanel();
    num8Panel = new JPanel();
    num9Panel = new JPanel();
    addPanel = new JPanel();
    subtractPanel = new JPanel();
    multiplyPanel = new JPanel();
    zeroPanel = new JPanel();
    clearPanel = new JPanel();
    dividePanel = new JPanel();
    calculatePanel = new JPanel();
    spacePanel = new JPanel();

    // Create the buttons to be displayed
    one = new JButton("1");
    two = new JButton("2");
    three = new JButton("3");
    four = new JButton("4");
    five = new JButton("5");
    six = new JButton("6");
    seven = new JButton("7");
    eight = new JButton("8");
    nine = new JButton("9");
    add = new JButton("+");
    subtract = new JButton("-");
    multiply = new JButton("*");
    zero = new JButton("0");
    clear = new JButton("C");
    divide = new JButton("/");
    calculate = new JButton("Calculate");
    space = new JButton("_");
}

// Use the String's split method to get rid of spaces
public String[] getStringOutput()
{
    String str = calculatorLabel.getText();
    String[] string = str.split(" ");

    return string;
}

// Needed to convert the getStringOutput() method above from a String[] to a String.
private static String convertStringArrayToString(String[] strArr) {
    StringBuilder sb = new StringBuilder();
    for(String str : strArr) sb.append(str);
    return sb.toString();
}

// Add the button pressed to the JLabel field
private class buttonListener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        // Determine which button was clicked and add this to the JLabel
        if( e.getSource() == zero)
            calculatorLabel.setText(calculatorLabel.getText() + "0");

        if( e.getSource() == one)
            calculatorLabel.setText(calculatorLabel.getText() + "1");

        if( e.getSource() == two)
            calculatorLabel.setText(calculatorLabel.getText() + "2");

        if( e.getSource() == three)
            calculatorLabel.setText(calculatorLabel.getText() + "3");

        if( e.getSource() == four)
            calculatorLabel.setText(calculatorLabel.getText() + "4");

        if( e.getSource() == five)
            calculatorLabel.setText(calculatorLabel.getText() + "5");

        if( e.getSource() == six)
            calculatorLabel.setText(calculatorLabel.getText() + "6");

        if( e.getSource() == seven)
            calculatorLabel.setText(calculatorLabel.getText() + "7");

        if( e.getSource() == eight)
            calculatorLabel.setText(calculatorLabel.getText() + "8");

        if( e.getSource() == nine)
            calculatorLabel.setText(calculatorLabel.getText() + "9");

        if( e.getSource() == add)
            calculatorLabel.setText(calculatorLabel.getText() + "+");

        if( e.getSource() == subtract)
            calculatorLabel.setText(calculatorLabel.getText() + "-");

        if( e.getSource() == multiply)
            calculatorLabel.setText(calculatorLabel.getText() + "*");

        if( e.getSource() == divide)
            calculatorLabel.setText(calculatorLabel.getText() + "/");

        if( e.getSource() == space)
            calculatorLabel.setText(calculatorLabel.getText() + " ");

        if( e.getSource() == clear)
            calculatorLabel.setText("");
    }

    // Create the calculator button action listener.

    // Add the button pressed to the JLabel field
    private class calcButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String[] str = getStringOutput();
            String string = convertStringArrayToString(str);
            Stack<String> stack = new Stack<String>();
            stack.add(string);
            double a = 0;
            double b = 0;
            double sum = 0;
            while (!stack.isEmpty())
            {
                if(stack.peek().equals("+"))
                {
                    a = Double.parseDouble(stack.peek());
                    stack.pop();
                    b = Double.parseDouble(stack.peek());
                    stack.pop();
                    sum = a + b;
                    //Write something to push back the sum of the last 2 numbers a + b
                    stack.push("" + sum);
                }

                else if(stack.peek().equals("*"))
                {
                    a = Double.parseDouble(stack.peek());
                    stack.pop();
                    b = Double.parseDouble(stack.peek());
                    stack.pop();
                    sum = a * b;
                    //Write something to push back the product of the last 2 numbers a * b
                    stack.push("" + sum);
                }

                else if(stack.peek().equals("-"))
                {
                    a = Double.parseDouble(stack.peek());
                    stack.pop();
                    b = Double.parseDouble(stack.peek());
                    stack.pop();
                    sum = a - b;
                    //Write something to push back the difference of the last 2 numbers a - b
                    stack.push("" + sum);
                }

                else if(stack.peek().equals("/"))
                {
                    a = Double.parseDouble(stack.peek());
                    stack.pop();
                    b = Double.parseDouble(stack.peek());
                    stack.pop();
                    sum = a / b;
                    //Write something to push back the quotient of the last 2 numbers a/b
                    stack.push("" + sum);
                }

                else 
                {
                    //Convert the last item in the stack to a double and push
                    //this into the stack
                    String elem = stack.peek();
                    a = Double.parseDouble(elem);
                    stack.push("" + a);
                }

            }
        }
}
}
}