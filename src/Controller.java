import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;
import java.util.List;

public class Controller {
    View view;

    public Controller() {
        view = new View(this);
    }

    class MyCheckBoxItemListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            // https://docs.oracle.com/javase/7/docs/api/java/awt/event/ItemEvent.html
            JCheckBox checkBox = (JCheckBox) e.getSource();
            System.out.println(checkBox.isSelected());
            switch (e.getStateChange()) {
                case ItemEvent.SELECTED:
                    System.out.println(checkBox.getText() + " is now selected");
                    break;
                case ItemEvent.DESELECTED:
                    System.out.println(checkBox.getText() + " is now deselected");
                    break;
            }
        }
    }

    class MyRadioButtonItemListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            // https://docs.oracle.com/javase/7/docs/api/java/awt/event/ItemEvent.html
            JRadioButton radioButton = (JRadioButton) e.getSource();
            System.out.println(radioButton.isSelected());
            switch (e.getStateChange()) {
                case ItemEvent.SELECTED:
                    System.out.println(radioButton.getText() + " is now selected");
                    break;
                case ItemEvent.DESELECTED:
                    System.out.println(radioButton.getText() + " is now deselected");
                    break;
            }
        }
    }

    class MyComboBoxActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox comboBox = (JComboBox) e.getSource();
            String choice = (String) comboBox.getSelectedItem();
            System.out.println("Selected: " + choice);
        }
    }

    class MyListSelectionListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            JList list = (JList) e.getSource();
            List<String> choices = list.getSelectedValuesList();
            System.out.println("Selected: " + choices);
        }
    }

    class MySliderChangeListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            JSlider source = (JSlider) e.getSource();
            int value  = source.getValue();
            System.out.println("Selected: " + value);
        }
    }

    class MyMenuActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JMenuItem menuItem = (JMenuItem) e.getSource();
            String choice = menuItem.getLabel();
            System.out.println("Selected: " + choice);
        }
    }
}
