import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

// icon credit: <div>Icons made by <a href="https://www.flaticon.com/authors/freepik" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/"             title="Flaticon">www.flaticon.com</a></div>

public class View extends JFrame {
    Controller controller;

    public View(Controller c) {
        super("More GUI Component Fun");
        controller = c;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));
        setupUI();
        setVisible(true);
        pack();
    }

    private void setupUI() {
        checkBoxDemo();
        radioButtonDemo();
        comboBoxDemo();
        listDemo();
        sliderDemo();
        menuDemo();
    }

    private void checkBoxDemo() {
        // https://docs.oracle.com/javase/tutorial/uiswing/components/button.html
        JPanel centerPanel = new JPanel();
        centerPanel.setBorder(BorderFactory.createTitledBorder("Check Boxes"));

        Controller.MyCheckBoxItemListener myItemListener = controller.new MyCheckBoxItemListener();

        JCheckBox checkBox1 = new JCheckBox("Choice 1");
        checkBox1.addItemListener(myItemListener);
        centerPanel.add(checkBox1);
        JCheckBox checkBox2 = new JCheckBox("Choice 2");
        checkBox2.addItemListener(myItemListener);
        centerPanel.add(checkBox2);
        JCheckBox checkBox3 = new JCheckBox("Choice 3");
        checkBox3.addItemListener(myItemListener);
        centerPanel.add(checkBox3);

        getContentPane().add(centerPanel, BorderLayout.NORTH);
    }

    private void radioButtonDemo() {
        // https://docs.oracle.com/javase/tutorial/uiswing/components/button.html
        JPanel centerPanel = new JPanel();
        centerPanel.setBorder(BorderFactory.createTitledBorder("Radio Buttons"));

        Controller.MyRadioButtonItemListener myItemListener = controller.new MyRadioButtonItemListener();

        JRadioButton radioButton1 = new JRadioButton("Choice 1");
        radioButton1.addItemListener(myItemListener);
        centerPanel.add(radioButton1);
        JRadioButton radioButton2 = new JRadioButton("Choice 2");
        radioButton2.setSelected(true);
        radioButton2.addItemListener(myItemListener);
        centerPanel.add(radioButton2);
        JRadioButton radioButton3 = new JRadioButton("Choice 3");
        radioButton3.addItemListener(myItemListener);
        centerPanel.add(radioButton3);

        // put in a ButtonGroup so only one can be selected at a time
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        buttonGroup.add(radioButton3);

        getContentPane().add(centerPanel, BorderLayout.SOUTH);
    }

    private void comboBoxDemo() {
        // https://docs.oracle.com/javase/tutorial/uiswing/components/combobox.html
        JPanel centerPanel = new JPanel();
        centerPanel.setBorder(BorderFactory.createTitledBorder("Combo Box"));

        String[] choices = {"Choice 1", "Choice 2", "Choice 3"};

        JComboBox<String> comboBox = new JComboBox<>(choices);
        comboBox.setSelectedIndex(0); // 0 by default
        comboBox.addActionListener(controller.new MyComboBoxActionListener());
        centerPanel.add(comboBox);

        getContentPane().add(centerPanel, BorderLayout.WEST);
    }

    private void listDemo() {
        // https://docs.oracle.com/javase/tutorial/uiswing/components/list.html
        JPanel centerPanel = new JPanel();
        centerPanel.setBorder(BorderFactory.createTitledBorder("List"));

        String[] choices = new String[50];
        for (int i = 0; i < choices.length; i++) {
            choices[i] = "Choice " + (i + 1);
        }

        JList<String> list = new JList<>(choices);
        list.setSelectedIndex(0); // none selected by default
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // this is default
        //list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.addListSelectionListener(controller.new MyListSelectionListener());

        // put in scroll pane in case there are so many items the user
        // has to scroll to see them all
        JScrollPane listScroller = new JScrollPane(list);
        centerPanel.add(listScroller);

        getContentPane().add(centerPanel, BorderLayout.CENTER);
    }

    private void sliderDemo() {
        // https://docs.oracle.com/javase/tutorial/uiswing/components/slider.html
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Slider"));

        final int SLIDER_MIN = 0;
        final int SLIDER_MAX = 100;
        final int SLIDER_INITIAL = 15;

        JSlider slider = new JSlider(JSlider.VERTICAL, SLIDER_MIN, SLIDER_MAX, SLIDER_INITIAL);
        slider.addChangeListener(controller.new MySliderChangeListener());
        panel.add(slider);

        //Turn on labels at major tick marks.
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        getContentPane().add(panel, BorderLayout.EAST);
    }

    private void menuDemo() {
        // https://docs.oracle.com/javase/tutorial/uiswing/components/menu.html
        // adapted from the above link
        JMenuBar menuBar;
        JMenu menu, submenu;
        JMenuItem menuItem;
        JRadioButtonMenuItem rbMenuItem;
        JCheckBoxMenuItem cbMenuItem;

        //Create the menu bar.
        menuBar = new JMenuBar();

        //Build the first menu.
        menu = new JMenu("A Menu");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        menuBar.add(menu);

        //a group of JMenuItems
        menuItem = new JMenuItem("A text-only menu item", KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
        menuItem.addActionListener(controller.new MyMenuActionListener());
        menu.add(menuItem);
        menuItem = new JMenuItem("Both text and icon", new ImageIcon("images/bulldog.png"));
        menuItem.setMnemonic(KeyEvent.VK_B);
        menu.add(menuItem);

        menuItem = new JMenuItem(new ImageIcon("images/bulldog.png"));
        menuItem.setMnemonic(KeyEvent.VK_D);
        menu.add(menuItem);

        //a group of radio button menu items
        menu.addSeparator();
        ButtonGroup group = new ButtonGroup();
        rbMenuItem = new JRadioButtonMenuItem("A radio button menu item 1");
        rbMenuItem.setSelected(true);
        rbMenuItem.setMnemonic(KeyEvent.VK_R);
        group.add(rbMenuItem);
        menu.add(rbMenuItem);
        rbMenuItem = new JRadioButtonMenuItem("Another one");
        rbMenuItem.setMnemonic(KeyEvent.VK_O);
        group.add(rbMenuItem);
        menu.add(rbMenuItem);

        //a group of check box menu items
        menu.addSeparator();
        cbMenuItem = new JCheckBoxMenuItem("A check box menu item");
        cbMenuItem.setMnemonic(KeyEvent.VK_C);
        menu.add(cbMenuItem);

        cbMenuItem = new JCheckBoxMenuItem("Another one");
        cbMenuItem.setMnemonic(KeyEvent.VK_H);
        menu.add(cbMenuItem);

        //a submenu
        menu.addSeparator();
        submenu = new JMenu("A submenu");
        submenu.setMnemonic(KeyEvent.VK_S);

        menuItem = new JMenuItem("An item in the submenu");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_2, ActionEvent.ALT_MASK));
        submenu.add(menuItem);

        menuItem = new JMenuItem("Another item");
        submenu.add(menuItem);
        menu.add(submenu);

        //Build second menu in the menu bar.
        menu = new JMenu("Another Menu");
        menu.setMnemonic(KeyEvent.VK_N);
        menu.getAccessibleContext().setAccessibleDescription("This menu does nothing");
        menuBar.add(menu);

        setJMenuBar(menuBar);
    }
}
