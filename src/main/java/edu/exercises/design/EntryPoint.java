package edu.exercises.design;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.plaf.basic.BasicScrollBarUI;

import edu.exercises.controller.InfoManager;

public class EntryPoint extends JFrame implements Theme {

    private JPanel textPane;
    private JLabel textLabel;
    private JTextPane inputTextPane;
    private JScrollPane textScrollPane;

    private JPanel analysisPanel;
    private JButton startAnalysisBtn;

    private JPanel listPane;
    private JLabel listLabel;
    private JScrollPane listScrollPane;
    private JList<Object> list;

    private InfoManager infoManager;

    private void setPrefixedSettings() {
        this.setBounds(0, 0, 750, 500);
        this.setVisible(true);
        this.setMinimumSize(new Dimension(500, 500));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void buildDesign() {
        this.textPane = new JPanel(new BorderLayout(10, 10));
        this.getContentPane().add(this.textPane);

        this.textLabel = new JLabel("Texto a Analizar");
        this.setStyleLabel(this.textLabel);
        this.textPane.add(this.textLabel, BorderLayout.NORTH);

        this.inputTextPane = new JTextPane();
        this.inputTextPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        this.textScrollPane = new JScrollPane(this.inputTextPane);
        this.textScrollPane.setBorder(null);
        this.textPane.add(this.textScrollPane, BorderLayout.CENTER);

        this.textScrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI());
        this.textScrollPane.getHorizontalScrollBar().setUI(new BasicScrollBarUI());

        this.analysisPanel = new JPanel(new BorderLayout(10, 10));
        this.analysisPanel.setBackground(Color.LIGHT_GRAY);
        this.analysisPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        this.getContentPane().add(this.analysisPanel);

        this.startAnalysisBtn = new JButton("Realizar Analisis");
        this.analysisPanel.add(this.startAnalysisBtn, BorderLayout.NORTH);

        this.listPane = new JPanel(new BorderLayout(10, 10));
        this.analysisPanel.add(this.listPane);

        this.listLabel = new JLabel("Resultados del Analisis");
        this.setStyleLabel(this.listLabel);
        this.listPane.add(this.listLabel, BorderLayout.NORTH);

        this.list = new JList<>();
        this.list.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        this.listScrollPane = new JScrollPane(this.list);
        this.listScrollPane.setBorder(null);
        this.listPane.add(this.listScrollPane, BorderLayout.CENTER);

        this.listScrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI());
        this.listScrollPane.getHorizontalScrollBar().setUI(new BasicScrollBarUI());
    }

    private void setStyleLabel(JLabel label) {
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBorder(BorderFactory.createEmptyBorder(3, 10, 3, 10));
        label.setBackground(Color.DARK_GRAY);
        label.setForeground(Color.LIGHT_GRAY);
        label.setOpaque(true);
        label.setFont(JB_BOLD);
    }

    private void buildListeners() {
        this.infoManager = new InfoManager(this.list);

        AnalizeListener analizeListener = new AnalizeListener(this.infoManager, this.inputTextPane);
        this.startAnalysisBtn.addActionListener(analizeListener);
    }

    public EntryPoint() {
        super("Java : Buscador de vocales y numeros");
        this.setLayout(new GridLayout(1, 2, 10, 10));
        ((JPanel) this.getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.getContentPane().setBackground(Color.LIGHT_GRAY);

        runUIManager();

        buildDesign();
        buildListeners();
    }

    public void launch() {
        this.setPrefixedSettings();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

}
