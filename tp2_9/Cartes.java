// j'ai utiliser Youtube pour m'aider a faire ce tp 
package tp2_9;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class Cartes {
    private static final String IMAGES_DIR = "tp2_9/cartes-gif";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Cartes::createAndShowGui);
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("Tirer des cartes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10,10));

        JLabel header = new JLabel("Tirer des cartes au hasard et afficher les cartes", SwingConstants.CENTER);
        header.setFont(new Font("SansSerif", Font.PLAIN, 20));
        header.setBorder(new LineBorder(Color.BLACK, 2));
        header.setOpaque(true);
        header.setBackground(Color.WHITE);
        header.setPreferredSize(new Dimension(700, 60));
        frame.add(header, BorderLayout.NORTH);

        JPanel cardsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 20));
        cardsPanel.setBackground(Color.WHITE);
        JLabel c1 = new JLabel();
        JLabel c2 = new JLabel();
        JLabel c3 = new JLabel();
        cardsPanel.add(c1);
        cardsPanel.add(c2);
        cardsPanel.add(c3);
        frame.add(cardsPanel, BorderLayout.CENTER);

        JButton draw = new JButton("Tirer des cartes");
        draw.addActionListener((ActionEvent e) -> drawThreeCards(c1, c2, c3));
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.add(draw);
        frame.add(topPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setSize(820, 420);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void drawThreeCards(JLabel a, JLabel b, JLabel c) {
        File dir = new File(IMAGES_DIR);
        if (!dir.exists() || !dir.isDirectory()) {
            JOptionPane.showMessageDialog(null, "Dossier d'images introuvable: " + IMAGES_DIR,
                    "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String[] files = dir.list((d, name) -> {
            String low = name.toLowerCase();
            return low.endsWith(".gif") || low.endsWith(".png") || low.endsWith(".jpg") || low.endsWith(".jpeg");
        });

        if (files == null || files.length < 3) {
            JOptionPane.showMessageDialog(null, "Pas assez d'images dans: " + IMAGES_DIR,
                    "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, files);
        Collections.shuffle(list);

        setCardIcon(a, new File(dir, list.get(0)).getPath());
        setCardIcon(b, new File(dir, list.get(1)).getPath());
        setCardIcon(c, new File(dir, list.get(2)).getPath());
    }

    private static void setCardIcon(JLabel label, String path) {
        try {
            ImageIcon ico = new ImageIcon(path);
            Image img = ico.getImage().getScaledInstance(160, 240, Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            label.setText("(image)");
        }
    }
}
