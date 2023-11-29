//package com.demo.util;
//
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.*;
//
//public class PrettyGraphics {
//    public static void main(String[] args) {
//        JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        Container pane = frame.getContentPane();
//
//        // Create a JPanel to hold the graphics
//        JPanel graphics = new JPanel();
//
//        // Set the size and background color of the panel
//        int width = 600;
//        int height = 600;
//        Color bgColor = Color.WHITE;
//        graphics.setPreferredSize(new Dimension(width, height));
//        graphics.setBackground(bgColor);
//
//        // Create a string array to hold the graphics
//        String[] lines = {"H", "e", "l", "l", "o", "w", "o", "r", "l", "d"};
//        int[] colors = {Color.BLUE, Color.GREEN, Color.ORANGE, Color.CYAN, Color.MAGENTA,
//                Color.YELLOW, Color.RED, Color.MAGENTA, Color.CYAN, Color.BLUE};
//
//        // Create a for loop to create each line of the graphics
//        for (int i = 0; i < lines.length; i++) {
//            // Get the RGB values for the color
//            int r = (int) (255 * colors[i]);
//            int g = (int) (255 * colors[i]);
//            int b = (int) (255 * colors[i]);
//
//            // Create a string for the line
//            String line = lines[i] + " " + Integer.toString(r) + " " + Integer.toString(g) + " " + Integer.toString(b);
//
//            // Draw the line on the graphics panel
//            graphics.setColor(new Color(r, g, b));
//            graphics.drawString(line, 10, 20);
//        }
//
//        // Create a button to display the graphics
//        JButton button = new JButton("Display Graphics");
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Clear the graphics panel
//                graphics.setColor(Color.WHITE);
//
//                // Create a string array to hold the graphics
//                String[] lines = {"H", "e", "l", "l", "o", "w", "o", "r", "l", "d"};
//                int[] colors = {Color.BLUE, Color.GREEN, Color.ORANGE, Color.CYAN, Color.MAGENTA,
//                        Color.YELLOW, Color.RED, Color.MAGENTA, Color.CYAN, Color.BLUE};
//
//                // Create a for loop to create each line of the graphics
//                for (int i = 0; i < lines.length; i++) {
//                    // Get the RGB values for the color
//                    int r = (int) (255 * colors[i]);
//                    int g = (int) (255 * colors[i]);
//                    int b = (int) (255 * colors[i]);
//
//                    // Create a string for the line
//                    String line = lines[i] + " " + Integer.toString(r) + " " + Integer.toString(g) + " " + Integer.toString(b);
//
//                    // Draw the line on the graphics panel
//                    graphics.setColor(new Color(r, g, b));
//                    graphics.drawString(line, 10, 20);
//                }
//
//                // Display the graphics in a window
//                frame.getContentPane().add(graphics);
//                frame.pack();
//                frame.setVisible(true);
//            }
//        });
//
//        // Make the window visible
//        frame.setVisible(true);
//    }
//}
