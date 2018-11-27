package osoby;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;

public class Frame extends JFrame implements ActionListener, DocumentListener, UndoableEditListener {

    public Frame() {
        //setSize(300,200);
        ui();
        pack();
        setTitle("Simple Window");
    }

    public void ui() {


        String[] items = new String[] {"a","b","c" };
        JList<String> list = new JList<>(items);
        JButton button = new JButton("OK");
        JCheckBox checkBox = new JCheckBox("checked?");
        JSpinner spinner = new JSpinner();
        JTextField textField = new JTextField(20);
        JTextArea textArea = new JTextArea(24,80);
        String[] items2 = new String[] {"blue","red","green" };
        JComboBox<String> comboBox = new JComboBox<>(items2);

        button.addActionListener(this);
        checkBox.addActionListener(this);
        comboBox.addActionListener(this);
        textField.getDocument().addDocumentListener(this);
        textArea.getDocument().addDocumentListener(this);
        textArea.getDocument().addUndoableEditListener(this);

        JPanel panel = new JPanel();
        //panel.setLayout(new GridLayout(4, 2));
        panel.add(list);
        panel.add(button);
        panel.add(checkBox);
        panel.add(spinner);
        panel.add(textField);
        panel.add(textArea);
        panel.add(comboBox);
        this.add(panel,BorderLayout.CENTER);

        JMenuBar menu = new JMenuBar();
        JMenu menuFile = new JMenu("Plik");
        menu.add(menuFile);
        JMenuItem exit = new JMenuItem("Wyjście");
        exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menuFile.add(exit);
        this.setJMenuBar(menu);

        JPanel statusPanel = new JPanel();
        statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        this.add(statusPanel, BorderLayout.SOUTH);
        statusPanel.setPreferredSize(new Dimension(this.getWidth(), 16));
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
        JLabel statusLabel = new JLabel("status");
        statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
        statusPanel.add(statusLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("ActionEvent:");
        System.out.println(e);
        System.out.println("getActionCommand():");
        System.out.println(e.getActionCommand());
        System.out.println("getID():");
        System.out.println(e.getID());
        System.out.println("getSource():");
        System.out.println(e.getSource());
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        System.out.println("insertUpdated");
        System.out.println("DocumentEvent:");
        System.out.println(e);
        System.out.println("getType():");
        System.out.println(e.getType());
        System.out.println("getOffset():");
        System.out.println(e.getOffset());
        System.out.println("getLength():");
        System.out.println(e.getLength());
        System.out.println("getDefaultRootElement():");
        System.out.println(e.getDocument().getDefaultRootElement());

    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        // :(
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        System.out.println("chagnedUpdated");
        System.out.println("DocumentEvent:");
        System.out.println(e);
        System.out.println("getType():");
        System.out.println(e.getType());
        System.out.println("getOffset():");
        System.out.println(e.getOffset());
        System.out.println("getLength():");
        System.out.println(e.getLength());
        System.out.println("getDefaultRootElement():");
        System.out.println(e.getDocument().getDefaultRootElement());

    }

    @Override
    public void undoableEditHappened(UndoableEditEvent e) {
        System.out.println("UdoableEditEvent:");
        System.out.println(e);
        System.out.println("getEdit():");
        System.out.println(e.getEdit().getPresentationName());

    }
}
