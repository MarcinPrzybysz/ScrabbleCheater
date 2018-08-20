import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;

public class ImagePanel extends JPanel implements TableCellRenderer {

    public Component getTableCellRendererComponent(
            JTable table, Object color,
            boolean isSelected, boolean hasFocus,
            int row, int column) {

        Object valueAt = table.getModel().getValueAt(row, column);
        String s = "";
        if (valueAt != null) {
            s = valueAt.toString();
        }

        if (!s.equalsIgnoreCase("")) {
            this.setForeground(Color.YELLOW);
            this.setBackground(Color.gray);
        } else {
            this.setForeground(Color.black);
            this.setBackground(Color.WHITE);
        }

        return this;
    }


    private BufferedImage image;

    public ImagePanel() {
        try {
            image = ImageIO.read(new File(System.getProperty("user.dir") + "\\src\\main\\resources\\images\\tile.jpg"));
        } catch (IOException ex) {
            // handle exception...
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters            
    }

}






