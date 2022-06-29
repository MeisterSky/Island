package com.javarush.island.sheff.view;

import com.javarush.island.sheff.entities.map.Cell;
import com.javarush.island.sheff.entities.map.GameMap;

import java.awt.*;
import javax.swing.*;

public class SimulatorView extends JFrame {

    private JLabel stepLabel, population;
    private final String STEP_PREFIX = "Days: ";
    private final String POPULATION_PREFIX = "Population: ";

    public void getView(GameMap gameMap) {
        Cell[][] cells = gameMap.getCells();
        int rows = cells.length;
        int cols = cells[0].length;


        EventQueue.invokeLater(() -> {

            setTitle("Island Simulation");
            stepLabel = new JLabel(STEP_PREFIX, JLabel.CENTER);
            population = new JLabel(POPULATION_PREFIX, JLabel.CENTER);

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            setLocation(rows, cols);

            JPanel infoPane = new JPanel(new BorderLayout());
            infoPane.add(stepLabel, BorderLayout.WEST);
            infoPane.add(population, BorderLayout.CENTER);

            JTextArea[][] fields = new JTextArea[rows][cols];

            JPanel panel = new JPanel(new GridLayout(rows, cols));
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    fields[i][j] = new JTextArea();
                    fields[i][j].setLineWrap(true);
                    fields[i][j].setWrapStyleWord(false);
                    fields[i][j].setFont(fields[i][j].getFont().deriveFont(9f));
                    fields[i][j].setText(cells[i][j].toString());
                    fields[i][j].revalidate();
                    panel.add(fields[i][j]);
                }
            }

            Container contents = getContentPane();
            contents.add(infoPane, BorderLayout.NORTH);

            add(panel);
            pack();
            setLocationRelativeTo(null);
            setVisible(true);
        });
    }
}
