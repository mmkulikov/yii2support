package com.nvlad.yii2support.ui.settings;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.project.Project;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import com.nvlad.yii2support.utils.Yii2SupportSettings;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SettingsForm implements Configurable {
    private JPanel mainPanel;
    private JTextField tablePrefixTextbox;
    private JCheckBox insertTableNamesWithCheckBox;
    private Yii2SupportSettings settings;

    public SettingsForm(Project project) {
        settings = Yii2SupportSettings.getInstance(project);


        tablePrefixTextbox.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                adjustInputs();
            }
        });
    }

    private void adjustInputs() {
        if (tablePrefixTextbox.getText().length() > 0)
            insertTableNamesWithCheckBox.setSelected(true);
        insertTableNamesWithCheckBox.setEnabled(tablePrefixTextbox.getText().length() == 0);
    }

    @Nls
    @Override
    public String getDisplayName() {
        return "Yii2 Support";
    }

    @Nullable
    @Override
    public String getHelpTopic() {
        return null;
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        return mainPanel;
    }

    @Override
    public boolean isModified() {
        return !tablePrefixTextbox.getText().equals(settings.tablePrefix) || settings.insertWithTablePrefix != insertTableNamesWithCheckBox.isSelected();
    }

    @Override
    public void apply() {
        settings.tablePrefix = tablePrefixTextbox.getText();
        settings.insertWithTablePrefix = insertTableNamesWithCheckBox.isSelected();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    @Override
    public void reset() {
        tablePrefixTextbox.setText(settings.tablePrefix);
        insertTableNamesWithCheckBox.setSelected(settings.insertWithTablePrefix);
        adjustInputs();
    }

    @Override
    public void disposeUIResources() {
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayoutManager(4, 5, new Insets(10, 10, 10, 10), -1, -1));
        mainPanel.putClientProperty("html.disable", Boolean.FALSE);
        mainPanel.setBorder(BorderFactory.createTitledBorder("9"));
        final JLabel label1 = new JLabel();
        label1.setText("Table Prefix");
        mainPanel.add(label1, new GridConstraints(2, 0, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        mainPanel.add(spacer1, new GridConstraints(3, 2, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        tablePrefixTextbox = new JTextField();
        mainPanel.add(tablePrefixTextbox, new GridConstraints(2, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setFont(new Font(label2.getFont().getName(), Font.BOLD, 18));
        label2.setText("Table Prefix Support");
        mainPanel.add(label2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        insertTableNamesWithCheckBox = new JCheckBox();
        insertTableNamesWithCheckBox.setText("Insert table names with prefix");
        insertTableNamesWithCheckBox.setToolTipText("Insert {{%tableName}}");
        mainPanel.add(insertTableNamesWithCheckBox, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}
