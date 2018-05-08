package Game;

import javax.swing.*;
import javax.swing.plaf.basic.DefaultMenuLayout;
import java.awt.*;

public class StartupPage extends JPanel
{
    private JButton singlePlayer;
    public StartupPage()
    {
        setLayout(new DefaultMenuLayout(this,DefaultMenuLayout.PAGE_AXIS));
        singlePlayer = new JButton("Single Player");
        add(Box.createRigidArea(new Dimension(0,20)));
        add(singlePlayer);
    }
}
