import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Gui {
    JFrame frame;
    JPanel input;
    JPanel output;
    JPanel buttonContainer;
    JTextArea textAreaIn;
    JTextArea textAreaOut;
    JButton format;
    JComboBox<String> options;

    TextFormatter formatter;
    String input_Str = "input text here";
    String output_Str = "text outputs here";
    public static int type = 0;


    public Gui()
    {

        String[] choices = {"Upper 1st Letter", "Upper All", "Upper 1st All", "Lower 1st Letter", "Lower All"};
        formatter = new TextFormatter();
        frame = new JFrame("Text Manipulator");
        input = new JPanel();
        output = new JPanel();
        buttonContainer = new JPanel();
        textAreaIn = new JTextArea(input_Str, 200, 200);
        textAreaOut = new JTextArea(output_Str, 200, 200);
        format = new JButton(" Format ");
        options = new JComboBox<String>(choices);

        textAreaIn.setLineWrap(true);
        textAreaIn.setBorder(new EmptyBorder(2, 2, 2, 2));
        textAreaOut.setLineWrap(true);
        textAreaOut.setBorder(new EmptyBorder(2, 2, 2, 2));

        input.setBounds(10, 10, 300, 300);
        input.setBorder(new LineBorder(Color.GREEN, 1, false));
        input.setLayout(new BorderLayout());
        input.add(textAreaIn, BorderLayout.CENTER);

        output.setBounds(315, 10, 300, 300);
        output.setBorder(new LineBorder(Color.RED, 1, false));
        output.setLayout(new BorderLayout());
        output.add(textAreaOut, BorderLayout.CENTER);

        format.setPreferredSize(new Dimension(120, 50));
        format.setFont(new Font("Arial", Font.BOLD, 20));
        format.setBorder(new LineBorder(Color.BLUE, 2, false));

        buttonContainer.setBounds(10, 325, 270, 40);
        buttonContainer.setLayout(new BorderLayout());
        buttonContainer.add(format, BorderLayout.WEST);
        buttonContainer.add(options, BorderLayout.EAST);

        frame.setLayout(new BorderLayout());
        frame.add(input, BorderLayout.WEST);
        frame.add(output, BorderLayout.EAST);
        frame.add(buttonContainer, BorderLayout.SOUTH);
        frame.setSize(650, 450);
        frame.setMinimumSize(new Dimension(625, 425));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);

        options.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent actionEvent) {
               String temp = options.getItemAt(options.getSelectedIndex());
               if(temp.compareTo("Upper 1st Letter") == 0)
                   type = 0;
               else if(temp.compareTo("Upper All") == 0)
                   type = 1;
               else if(temp.compareTo("Upper 1st All") == 0)
                   type = 2;
               else if(temp.compareTo("Lower 1st Letter") == 0)
                   type = 3;
               else if(temp.compareTo("Lower All") == 0)
                   type = 4;
           }
        });

        format.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                input_Str = formatter.format(textAreaIn.getText(), type);
                textAreaOut.setText(input_Str);
            }
        });
    }

    public void addExceptions(Vector<String> input)
    {

    }

    public static void main(String[] args) {
        new Gui();
    }
}
