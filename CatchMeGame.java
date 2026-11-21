import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class CatchMeGame {
    static int score = 0;
    static int timeLeft = 15; 

    public static void main(String[] args) {
        JFrame frame = new JFrame("Catch Me Game");
        frame.setSize(400, 400);
        frame.setLayout(null); 
        JLabel scoreLabel = new JLabel("Score: 0");
        scoreLabel.setBounds(10, 10, 100, 30);
        frame.add(scoreLabel);
        JLabel timeLabel = new JLabel("Time Left: 15");
        timeLabel.setBounds(270, 10, 100, 30);
        frame.add(timeLabel);

        JButton catchButton = new JButton("Click Me");
        catchButton.setBounds(150, 150, 100, 40);
        frame.add(catchButton);

        catchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                score++; 
                scoreLabel.setText("Score: " + score); 
                
                Random rand = new Random();
                int x = rand.nextInt(280); 
                int y = rand.nextInt(300) + 40; 
                
                catchButton.setBounds(x, y, 100, 40); 
            }
        });
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timeLeft--; 
                timeLabel.setText("Time Left: " + timeLeft);

                if (timeLeft == 0) {
                    ((Timer) e.getSource()).stop(); 
                    catchButton.setEnabled(false); 
                    JOptionPane.showMessageDialog(frame, "Time's Up! Your Final Score is: " + score);
                }
            }
        });
        timer.start(); 

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}