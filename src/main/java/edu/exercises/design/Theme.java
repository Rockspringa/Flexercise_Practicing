package edu.exercises.design;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.UIManager;

public interface Theme {
    Font JB_BOLDER = new Font("JetBrains Mono Mono", 1, 16);
    Font JB_BOLD = new Font("JetBrains Mono Mono", 1, 14);
    Font JBRAINS = new Font("JetBrains Mono", 1, 13);
    
    default void runUIManager() {
        UIManager.put("List.font", JBRAINS);
        UIManager.put("Label.font", JB_BOLD);
        UIManager.put("Button.font", JB_BOLDER);
        UIManager.put("TextPane.font", JBRAINS);

        UIManager.put("ScrollBar.thumbDarkShadow", Color.LIGHT_GRAY);
        UIManager.put("ScrollBar.thumbHighlight", Color.DARK_GRAY);
        UIManager.put("ScrollBar.thumbShadow", Color.DARK_GRAY);
        UIManager.put("ScrollBar.background", Color.GRAY);
        UIManager.put("ScrollBar.thumb", Color.DARK_GRAY);
        UIManager.put("ScrollBar.track", Color.GRAY);
        UIManager.put("ScrollBar.width", 12);

        UIManager.put("Panel.background", Color.LIGHT_GRAY);
        UIManager.put("Panel.border", BorderFactory.createLineBorder(Color.BLACK));

        UIManager.put("TextPane.background", Color.LIGHT_GRAY);
        UIManager.put("TextPane.foreground", Color.DARK_GRAY);

        UIManager.put("ScrollPane.background", Color.LIGHT_GRAY);
        UIManager.put("ScrollPane.foreground", Color.DARK_GRAY);

        UIManager.put("List.background", Color.LIGHT_GRAY);
        UIManager.put("List.foreground", Color.DARK_GRAY);

        UIManager.put("Button.background", Color.LIGHT_GRAY);
        UIManager.put("Button.foreground", Color.DARK_GRAY);
        UIManager.put("Button.select", Color.BLACK);
        UIManager.put("Button.focus", Color.DARK_GRAY);
        UIManager.put("Button.border", BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.DARK_GRAY, 2),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)));
    }

}