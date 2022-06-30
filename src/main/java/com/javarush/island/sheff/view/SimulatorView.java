package com.javarush.island.sheff.view;

import com.javarush.island.sheff.entities.map.Cell;
import com.javarush.island.sheff.entities.map.GameMap;

import java.awt.*;
import javax.swing.*;

public class SimulatorView extends JFrame {

    private JLabel stepLabel, population;
    private final String STEP_PREFIX = "Days: ";
    public int day;
    private final String POPULATION_PREFIX = "Population: ";
    Cell[][] cells;
    int rows;
    int cols;
    JPanel panel;
    JTextArea[][] fields;
    JPanel infoPane;
    Container contents;

    public void startView(GameMap gameMap) {
        cells = gameMap.getCells();
        rows = cells.length;
        cols = cells[0].length;

        setTitle("Island Simulation");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(rows, cols);
        contents = getContentPane();
        updateView(day);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    public void updateView(int day) {

        contents.removeAll();

        EventQueue.invokeLater(() -> {
            stepLabel = new JLabel(STEP_PREFIX + day, JLabel.CENTER);
            population = new JLabel(POPULATION_PREFIX, JLabel.CENTER);
            infoPane = new JPanel(new BorderLayout());


            infoPane.add(stepLabel, BorderLayout.WEST);
            infoPane.add(population, BorderLayout.CENTER);

            fields = new JTextArea[rows][cols];
            panel = new JPanel(new GridLayout(rows, cols));

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    fields[row][col] = new JTextArea();
                    fields[row][col].setLineWrap(true);
                    fields[row][col].setWrapStyleWord(false);
                    fields[row][col].setFont(fields[row][col].getFont().deriveFont(9f));
                    fields[row][col].setText(cells[row][col].toString());
                    fields[row][col].revalidate();
                    panel.add(fields[row][col]);
                    panel.revalidate();
                }
            }

            infoPane.revalidate();
            contents.add(infoPane, BorderLayout.NORTH);
            contents.revalidate();
            add(panel);
            pack();
            setVisible(true);
            invalidate();
        });
    }
}
