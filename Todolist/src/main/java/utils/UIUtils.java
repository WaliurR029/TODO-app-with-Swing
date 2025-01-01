package utils;

import javax.swing.*;
import java.awt.*;

public class UIUtils {
    public static void setGlobalFont(Font font) {
        UIManager.put("Label.font", font);
        UIManager.put("Button.font", font);
        UIManager.put("Table.font", font);
        UIManager.put("TableHeader.font", font);
        UIManager.put("TextField.font", font);
        UIManager.put("TextArea.font", font);
    }
}
