    package tp2_6;

    import javax.swing.*;
    import java.awt.*;

    public class JDialog extends javax.swing.JDialog {
        public JDialog() {
            super((Frame) null, "About Dialog Test", true);
            initComponents();
        }

        private void initComponents() {
            JPanel content = new JPanel(new BorderLayout(10, 10));
            content.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

            JLabel title = new JLabel("Core Java");
            title.setFont(new Font("SansSerif", Font.BOLD, 36));
            title.setHorizontalAlignment(SwingConstants.LEFT);
            content.add(title, BorderLayout.NORTH);

            JTextArea desc = new JTextArea("bla bla bla, test test test, 1 2 3 test du label");
            desc.setFont(new Font("SansSerif", Font.PLAIN, 16));
            desc.setLineWrap(true);
            desc.setWrapStyleWord(true);
            desc.setEditable(false);
            desc.setOpaque(false);
            desc.setBorder(null);
            JPanel center = new JPanel(new BorderLayout());
            center.setOpaque(false);
            center.add(desc, BorderLayout.NORTH);
            content.add(center, BorderLayout.CENTER);

            JPanel south = new JPanel();
            JButton ok = new JButton("OK");
            ok.addActionListener(e -> setVisible(false));
            south.add(ok);
            content.add(south, BorderLayout.SOUTH);
            content.setPreferredSize(new Dimension(520, 200));
            setContentPane(content);
            pack();
            setResizable(false);
            setLocationRelativeTo(null);
        }
    }
