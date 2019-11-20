package GUI;

import javax.swing.*;

public interface InterfaceLayout {

    /**
     * The left part of the panel. Should contain buttons.
     * @return the JPanel of left part
     */
    JPanel left();

    /**
     * The right part of the panel. Should contain buttons.
     * @return the JPanel of right part
     */
    JPanel right();

    /**
     * The main part of the panel, containing the main information shown to user.
     * @return the JPanel of main part
     */
    JPanel main();

    /**
     * Initial the JPanel.
     */
    void initialize();

    /**
     * Get the interface.
     * @return the JPanel of the interface
     */
    JPanel getInterface();

}
