package acidrain;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;

public final class AcidRainGame {
    private static final String MENU = "menu";
    private static final String GAME = "game";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AcidRainGame::showWindow);
    }

    private static void showWindow() {
        JFrame window = new JFrame("산성비");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(createScreens());
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    private static JPanel createScreens() {
        CardLayout layout = new CardLayout();
        JPanel screens = new JPanel(layout);
        screens.setPreferredSize(new Dimension(640, 480));

        JPanel menu = new JPanel(new BorderLayout());
        menu.add(new JLabel("산성비", SwingConstants.CENTER), BorderLayout.CENTER);
        JButton startButton = new JButton("게임 시작");
        startButton.addActionListener(event -> layout.show(screens, GAME));
        menu.add(startButton, BorderLayout.SOUTH);

        JPanel game = new JPanel(new BorderLayout());
        JButton menuButton = new JButton("메뉴로 돌아가기");
        menuButton.addActionListener(event -> layout.show(screens, MENU));
        game.add(menuButton, BorderLayout.SOUTH);

        screens.add(menu, MENU);
        screens.add(game, GAME);
        return screens;
    }
}
