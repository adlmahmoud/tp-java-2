package tp2_8;

import javax.swing.*;
import java.awt.*;

public class RadioButtonTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(RadioButtonTest::createAndShowGui);
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("Test RadioButton");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel content = new JPanel(new BorderLayout(8, 8));
        content.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        JTextField header = new JTextField("Voyez les changements de style");
        header.setEditable(false);
        header.setBorder(BorderFactory.createEtchedBorder());
        header.setFont(new Font("Serif", Font.ITALIC, 14));
        content.add(header, BorderLayout.NORTH);

        JPanel center = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 18));

        JRadioButton normal = new JRadioButton("Normal");
        JRadioButton bold = new JRadioButton("Gras");
        JRadioButton italic = new JRadioButton("Italique");
        JRadioButton boldItalic = new JRadioButton("Gras/Italique");

        ButtonGroup group = new ButtonGroup();
        group.add(normal);
        group.add(bold);
        group.add(italic);
        group.add(boldItalic);

        center.add(normal);
        center.add(bold);
        center.add(italic);
        center.add(boldItalic);

        content.add(center, BorderLayout.CENTER);
        JPanel samplePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel sample = new JLabel("Exemple de texte : Voyez les changements de style");
        sample.setFont(new Font("Serif", Font.PLAIN, 16));
        samplePanel.add(sample);
        content.add(samplePanel, BorderLayout.SOUTH);
        normal.addActionListener(e -> sample.setFont(new Font("Serif", Font.PLAIN, 16)));
        bold.addActionListener(e -> sample.setFont(new Font("Serif", Font.BOLD, 16)));
        italic.addActionListener(e -> sample.setFont(new Font("Serif", Font.ITALIC, 16)));
        boldItalic.addActionListener(e -> sample.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 16)));
        normal.setSelected(true);

        frame.getContentPane().add(content);
        frame.pack();
        frame.setSize(520, 160);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
