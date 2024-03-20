import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Puzzle extends JFrame implements ActionListener {

    public static void main(String[] args) {
        new Puzzle();
    }

    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, shirk;
    int counter = 0;
    JLabel counterLabel;

    // timer
    private Timer timer;
    private long startTime = -1;//when 
    private long duration = 400000; // game time
    private JLabel timerlabel;

    // Constructor to build the puzzle
    Puzzle() {
        // Set up the window (frame)
        setSize(400, 400);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // timer
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (startTime < 0) {
                    startTime = System.currentTimeMillis();
                }
                long now = System.currentTimeMillis();
                long clockTime = now - startTime;
                if (clockTime >= duration) {
                    clockTime = duration;
                    timer.stop();

                    String s = b4.getText();
                    b4.setText(b9.getText());
                    b9.setText(s);
                    s = b1.getText();
                    b1.setText(b5.getText());
                    b5.setText(s);
                    s = b2.getText();
                    b2.setText(b7.getText());
                    b7.setText(s);
                    counter = -1;
                    counterLabel.setText("Clicks: 0");
                    timerlabel.setText("00:00:000");
                    JOptionPane.showMessageDialog(Puzzle.this, "Game Over!");
                }
                SimpleDateFormat df = new SimpleDateFormat("mm:ss:SSS");
                timerlabel.setText(df.format(duration - clockTime));
            }
        });
        timer.setInitialDelay(0);
        timerlabel = new JLabel("00:00:00");
        add(timerlabel);
        timerlabel.setBounds(145, 300, 100, 40);
        // addMouseListener(new MouseAdapter() {
        //     @Override
        //     public void mouseClicked(MouseEvent e) {
        //         if (!timer.isRunning()) {
        //             startTime = -1;
        //             timer.start();
        //         }
        //     }
        // });
        // ====================================================

        // Create elements
        b1 = new JButton("2");
        b2 = new JButton(" ");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("1");
        shirk = new JButton("shirk!");
        counterLabel = new JLabel("Clicks: 0");

        // Attach elements to window
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        add(b9);
        add(shirk);
        Container contentPane = this.getContentPane();
        contentPane.add(counterLabel);

        // Put elements on the right places of window (Frame)
        b1.setBounds(90, 60, 50, 40);
        b2.setBounds(160, 60, 50, 40);
        b3.setBounds(230, 60, 50, 40);
        b4.setBounds(90, 115, 50, 40);
        b5.setBounds(160, 115, 50, 40);
        b6.setBounds(230, 115, 50, 40);
        b7.setBounds(90, 170, 50, 40);
        b8.setBounds(160, 170, 50, 40);
        b9.setBounds(230, 170, 50, 40);
        shirk.setBounds(135, 245, 100, 40);
        counterLabel.setBounds(145, 15, 180, 40);

        // Customize elements & Colour picker
        shirk.setBackground(Color.LIGHT_GRAY);

        b1.setBackground(Color.decode("#416682"));
        b2.setBackground(Color.decode("#416682"));
        b3.setBackground(Color.decode("#416682"));
        b4.setBackground(Color.decode("#416682"));
        b5.setBackground(Color.decode("#416682"));
        b6.setBackground(Color.decode("#416682"));
        b7.setBackground(Color.decode("#416682"));
        b8.setBackground(Color.decode("#416682"));
        b9.setBackground(Color.decode("#416682"));

        b1.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));
        b2.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));
        b3.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));
        b4.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));
        b5.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));
        b6.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));
        b7.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));
        b8.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));
        b9.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));
        shirk.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
        counterLabel.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
        timerlabel.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));

        // Add an event listener
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        shirk.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == shirk) {
            String s = b4.getText();
            b4.setText(b9.getText());
            b9.setText(s);
            s = b1.getText();
            b1.setText(b5.getText());
            b5.setText(s);
            s = b2.getText();
            b2.setText(b7.getText());
            b7.setText(s);
            counter = -1;
            counterLabel.setText("Clicks: 0");
        } else if (!timer.isRunning()) {
            startTime = -1;
            timer.start();
        }
        if (e.getSource() == b1) { // if b1
            String s = b1.getText();
            if (b2.getText().equals(" ")) { // if b2 == empty
                b2.setText(s); // set b2 = b1
                b1.setText(" "); // set b1 empty
            } else if (b4.getText().equals(" ")) {
                b4.setText(s);
                b1.setText(" ");
            }
        }
        if (e.getSource() == b2) {
            String s = b2.getText();
            if (b1.getText().equals(" ")) {
                b1.setText(s);
                b2.setText(" ");
            } else if (b3.getText().equals(" ")) {
                b3.setText(s);
                b2.setText(" ");
            } else if (b5.getText().equals(" ")) {
                b5.setText(s);
                b2.setText(" ");
            }
        }
        if (e.getSource() == b3) {
            String s = b3.getText();
            if (b2.getText().equals(" ")) {
                b2.setText(s);
                b3.setText(" ");
            } else if (b6.getText().equals(" ")) {
                b6.setText(s);
                b3.setText(" ");
            }
        }
        if (e.getSource() == b4) {
            String s = b4.getText();
            if (b1.getText().equals(" ")) {
                b1.setText(s);
                b4.setText(" ");
            } else if (b7.getText().equals(" ")) {
                b7.setText(s);
                b4.setText(" ");
            } else if (b5.getText().equals(" ")) {
                b5.setText(s);
                b4.setText(" ");
            }
        }
        if (e.getSource() == b5) {
            String s = b5.getText();
            if (b2.getText().equals(" ")) {
                b2.setText(s);
                b5.setText(" ");
            } else if (b4.getText().equals(" ")) {
                b4.setText(s);
                b5.setText(" ");
            } else if (b6.getText().equals(" ")) {
                b6.setText(s);
                b5.setText(" ");
            } else if (b8.getText().equals(" ")) {
                b8.setText(s);
                b5.setText(" ");
            }
        }
        if (e.getSource() == b6) {

            String s = b6.getText();
            if (b9.getText().equals(" ")) {
                b9.setText(s);
                b6.setText(" ");
            } else if (b3.getText().equals(" ")) {
                b3.setText(s);
                b6.setText(" ");
            } else if (b5.getText().equals(" ")) {
                b5.setText(s);
                b6.setText(" ");
            }

        }
        if (e.getSource() == b7) {
            String s = b7.getText();
            if (b4.getText().equals(" ")) {
                b4.setText(s);
                b7.setText(" ");
            } else if (b8.getText().equals(" ")) {
                b8.setText(s);
                b7.setText(" ");
            }

        }
        if (e.getSource() == b8) {
            String s = b8.getText();
            if (b7.getText().equals(" ")) {
                b7.setText(s);
                b8.setText(" ");
            } else if (b9.getText().equals(" ")) {
                b9.setText(s);
                b8.setText(" ");
            } else if (b5.getText().equals(" ")) {
                b5.setText(s);
                b8.setText(" ");
            }

        }
        if (e.getSource() == b9) {
            String s = b9.getText();
            if (b6.getText().equals(" ")) {
                b6.setText(s);
                b9.setText(" ");
            } else if (b8.getText().equals(" ")) {
                b8.setText(s);
                b9.setText(" ");
            }

            if (b1.getText().equals("1") && b2.getText().equals("2") && b3.getText()
                    .equals("3") && b4.getText().equals("4") && b5.getText().equals("5")
                    && b6.getText().equals("6") && b7.getText().equals("7") && b8.getText()
                            .equals("8")
                    && b9.getText().equals(" ")) {
                JOptionPane.showMessageDialog(Puzzle.this, "YOU WON!\n" + "You clicked: " + counter + " times.");
            }
        }
        counter++;
        counterLabel.setText("Clicks: " + counter);
    }
}