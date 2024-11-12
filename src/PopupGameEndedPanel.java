import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PopupGameEndedPanel extends JDialog {
    private boolean victory;
    private PuzzleCombination solution;

    public PopupGameEndedPanel(Frame owner, boolean victory, PuzzleCombination solution) {
        super(owner, "Game Over", true);
        this.victory = victory;
        this.solution = solution;

        setLayout(new BorderLayout());
        setSize(300, 200);

        JPanel messagePanel = new JPanel(new GridLayout(3, 1));
        JLabel messageLabel;
        if (victory) {
            messageLabel = new JLabel("You won! :D");
            messageLabel.setForeground(Color.GREEN);
        } else {
            messageLabel = new JLabel("You lost! :(");
            messageLabel.setForeground(Color.RED);
        }
        messagePanel.add(messageLabel);

        JLabel solutionLabel = new JLabel("Solution was:");
        messagePanel.add(solutionLabel);

        JPanel solutionPanel = new JPanel();
        for (int i = 0; i < PuzzleCombination.COMBINATION_LENGTH; i++) {
            JLabel pegLabel = new JLabel(Integer.toString(solution.getCombination()[i]));
            solutionPanel.add(pegLabel);
        }
        messagePanel.add(solutionPanel);

        JButton restartButton = new JButton("Restart");
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // restart the game
                GamePanel.getInstance().restart();
                // close the popup window
                dispose();
            }
        });

        add(messagePanel, BorderLayout.CENTER);
        add(restartButton, BorderLayout.SOUTH);

        setLocationRelativeTo(owner);
    }
}