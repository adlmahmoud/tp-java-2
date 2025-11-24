package tp2_7;

import javax.swing.*;
import java.awt.*;
// j'ai utiliser Youtube pour m'aider a faire ce tp
public class ButtonTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ButtonTest::createAndShowGui);
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("Test des boutons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));

        JButton simple = new JButton("Bouton simple");
        JButton fancy = new JButton("Bouton fantaisie");
        Icon infoIcon = UIManager.getIcon("OptionPane.informationIcon");
        if (infoIcon != null) {
            fancy.setIcon(infoIcon);
            fancy.setHorizontalTextPosition(SwingConstants.RIGHT);
        }

        simple.addActionListener(e ->
            JOptionPane.showMessageDialog(frame,
                "Vous avez appuyé sur : Bouton simple",
                "Message",
                JOptionPane.INFORMATION_MESSAGE)
        );

        fancy.addActionListener(e ->
            JOptionPane.showMessageDialog(frame,
                "Vous avez appuyé sur : Bouton fantaisie",
                "Message",
                JOptionPane.INFORMATION_MESSAGE)
        );

        panel.add(simple);
        panel.add(fancy);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setSize(520, 140);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
