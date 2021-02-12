package lesson04;

import javax.management.monitor.Monitor;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class MainWindow extends JFrame {
    public static final int GC_MAIN_W = 400;
    public static final int GC_MAIN_H = 600;
    public static final int GC_EP_H = 40;

    private JTextField moEnterText;
    private JTextArea moTextArea;

    public MainWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(GC_MAIN_W, GC_MAIN_H);
        setResizable(false);
        setBackground(Color.gray);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setLocation(300,300);

        add(getTextAreaPanel());
        add(getEnterPanel());

        setVisible(true);
    }

    private JPanel getEnterPanel() {
        JPanel loEnterPanel = new JPanel();
        loEnterPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        moEnterText = new JTextField();
        moEnterText.setPreferredSize(new Dimension(GC_MAIN_W - GC_EP_H - 40, GC_EP_H));
        moEnterText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                int lvChar = e.getKeyChar();
                if (lvChar == KeyEvent.VK_ENTER) {
                    postMessage();
                } else super.keyTyped(e);
            }
        });
        loEnterPanel.add(moEnterText);
        JButton loEnterButton = new JButton("OK");
        loEnterButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                postMessage();
            }
        });
        loEnterPanel.add(loEnterButton);
        return loEnterPanel;
    }

    private JScrollPane getTextAreaPanel() {
        moTextArea = new JTextArea("");
        moTextArea.setBorder(new LineBorder(Color.black));
        moTextArea.setBackground(Color.white);
        moTextArea.setEditable(false);

        JScrollPane roJSP = new JScrollPane(moTextArea);
        roJSP.setPreferredSize(new Dimension(GC_MAIN_W - 20, GC_MAIN_H - GC_EP_H - 60));

        return roJSP;
    }

    private void postMessage() {
        moTextArea.append("\n" + moEnterText.getText());
        moEnterText.setText("");
    }
}
