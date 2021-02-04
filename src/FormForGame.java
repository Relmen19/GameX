import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormForGame extends JFrame{

    public FormForGame(){

        super("Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(1200, 500, 500, 300);

        JPanel grid = new JPanel();
//        GridLayout layout = new GridLayout(2, 0, 5, 12);
        grid.setLayout(new GridLayout(3, 3, 5, 12));

//        Container container = this.getContentPane();
//        container.setLayout(new GridLayout());

        for(int i = 1; i <= 9; i++){
            grid.add(new JButton("Button" + i));
        }

        button1.addActionListener( new ActionListener(){

            public void actionPerformed(ActionEvent e) {
                System.out.println();
            }
        });
//        button = new JButton("PRESS");
//        grid.add(textField);
//        grid.add(textField1);
//        button.addActionListener( new ActionListener(){
//
//            public void actionPerformed(ActionEvent e) {
//                System.out.println(textField.getText());
//
//                textField.setText("");
//            }
//        });

        getContentPane().add(grid);
        pack();
    }

//    class ButtonEventListener implements ActionListener{
//        @Override
//        public void actionPerformed(ActionEvent e) {
//
//            System.out.println(textField.getText());
//            textField.
//            String message = "Button was pressed\n";
//            message += "Text: " + textField.getText() + "\n";
//            JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);
//        }
//    }
}
