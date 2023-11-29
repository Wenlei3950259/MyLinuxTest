package com.demo.chatgpt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

;

public class SnakeGame extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JPanel gamePanel;
    private JButton startButton;
    private JButton exitButton;
    private Timer timer;
    private int delay = 100;
    private boolean running = false;
    private int snakeX[] = new int[100];
    private int snakeY[] = new int[100];
    private int appleX;
    private int appleY;
    private int snakeLength = 3;
    private int direction = 0;
    private int width = 400;
    private int height = 400;

    public SnakeGame() {
        setTitle("Snake Game");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        gamePanel = new JPanel();
        gamePanel.setPreferredSize(new Dimension(width, height));
        gamePanel.setBackground(Color.BLACK);
        gamePanel.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_LEFT && direction != 1) {
                    direction = 3;
                } else if (key == KeyEvent.VK_RIGHT && direction != 3) {
                    direction = 1;
                } else if (key == KeyEvent.VK_UP && direction != 2) {
                    direction = 0;
                } else if (key == KeyEvent.VK_DOWN && direction != 0) {
                    direction = 2;
                }
            }
        });
        add(gamePanel, BorderLayout.CENTER);

        startButton = new JButton("Start");
        startButton.addActionListener(this);
        add(startButton, BorderLayout.NORTH);

        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        add(exitButton, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            startGame();
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        } else if (e.getSource() == timer) {
            moveSnake();
        }
    }

    private void startGame() {
        running = true;
        snakeX[0] = width / 2;
        snakeY[0] = height / 2;
        spawnApple();
        timer = new Timer(delay, this);
        timer.start();
        startButton.setEnabled(false);
    }

    private void spawnApple() {
        appleX = (int) (Math.random() * width / 10) * 10;
        appleY = (int) (Math.random() * height / 10) * 10;
    }

    private void moveSnake() {
        for (int i = snakeLength; i > 0; i--) {
            snakeX[i] = snakeX[i - 1];
            snakeY[i] = snakeY[i - 1];
        }

        if (direction == 0) {
            snakeY[0] -= 10;
        } else if (direction == 1) {
            snakeX[0] += 10;
        } else if (direction == 2) {
            snakeY[0] += 10;
        } else if (direction == 3) {
            snakeX[0]
                    -= 10;
        }

        if (snakeX[0] < 0) {
            snakeX[0] = width - 10;
        } else if (snakeX[0] >= width) {
            snakeX[0] = 0;
        } else if (snakeY[0] < 0) {
            snakeY[0] = height - 10;
        } else if (snakeY[0] >= height) {
            snakeY[0] = 0;
        }

        if (snakeX[0] == appleX && snakeY[0] == appleY) {
            snakeLength++;
            spawnApple();
        }

        for (int i = 1; i < snakeLength; i++) {
            if (snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]) {
                gameOver();
            }
        }

        gamePanel.repaint();
    }

    private void gameOver() {
        running = false;
        timer.stop();
        startButton.setEnabled(true);
    }

    private void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(appleX, appleY, 10, 10);

        g.setColor(Color.GREEN);
        for (int i = 0; i < snakeLength; i++) {
            g.fillRect(snakeX[i], snakeY[i], 10, 10);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        if (running) {
            draw(g);
        } else {
            g.setColor(Color.WHITE);
            g.drawString("Press Start to begin", 165, 180);
        }
    }

    public static void main(String[] args) {
        new SnakeGame();
    }
}
