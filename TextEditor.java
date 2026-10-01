package week8;

import javax.swing.*;
import java.awt.*;

public class TextEditor {
    public static void main(String[] args) {
        JFrame f = new JFrame("Text Editor");
        f.setSize(600, 400);

        JTextArea area = new JTextArea();
        f.add(new JScrollPane(area));

        JMenuBar bar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");

        JMenuItem newFile = new JMenuItem("New");
        JMenuItem clear = new JMenuItem("Clear");
        JMenuItem exit = new JMenuItem("Exit");

        JMenuItem cut = new JMenuItem("Cut");
        JMenuItem copy = new JMenuItem("Copy");
        JMenuItem paste = new JMenuItem("Paste");

        file.add(newFile);
        file.add(clear);
        file.add(exit);

        edit.add(cut);
        edit.add(copy);
        edit.add(paste);

        bar.add(file);
        bar.add(edit);

        f.setJMenuBar(bar);

        newFile.addActionListener(e -> area.setText(""));
        clear.addActionListener(e -> area.setText(""));
        exit.addActionListener(e -> System.exit(0));

        cut.addActionListener(e -> area.cut());
        copy.addActionListener(e -> area.copy());
        paste.addActionListener(e -> area.paste());

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
