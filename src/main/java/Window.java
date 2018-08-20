import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class Window extends JPanel{

    Box mainBox = Box.createHorizontalBox();
    Box controlBox = Box.createVerticalBox();

    JPanel tilesPanel = new JPanel();
    JPanel pickedTilesPanel = new JPanel();
    JPanel rightPanel = new JPanel();

    JButton getSolution;

    JTextArea bestSolutions = new JTextArea(20, 22);
    JScrollPane solutionsPane = new JScrollPane(bestSolutions);

    JTable gameBoard;
    JTable pickedTiles;

    Window() {
        setLayout(new BorderLayout());
        setComponents();
    }


    private void setComponents(){
        setTables();

        tilesPanel.setLayout(new BoxLayout(tilesPanel, BoxLayout.PAGE_AXIS));
        pickedTilesPanel.setLayout(new BoxLayout(pickedTilesPanel, BoxLayout.PAGE_AXIS));

        tilesPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        tilesPanel.add(gameBoard);
        tilesPanel.add(Box.createRigidArea(new Dimension(0, 40)));
        tilesPanel.add(pickedTiles);
        tilesPanel.add(Box.createRigidArea(new Dimension(0, 60)));

        rightPanel.add(solutionsPane);

        controlBox.add(Box.createRigidArea(new Dimension(250, 30)));
        controlBox.add(rightPanel);
        controlBox.add(Box.createRigidArea(new Dimension(0, 100))); // reduce height when new component added

        mainBox.add(Box.createRigidArea(new Dimension(25, 0)));
        mainBox.add(tilesPanel);
        mainBox.add(Box.createRigidArea(new Dimension(20, 0)));
        mainBox.add(controlBox);
        mainBox.add(Box.createRigidArea(new Dimension(10, 0)));


        getSolution = new JButton("GET SCRABBLE!");
        rightPanel.add(getSolution);

        this.add(mainBox);
    }

    private void setTables(){
        DefaultTableModel pickedTilesModel = new DefaultTableModel(1, 7) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return String.class;
            }
        };

        pickedTiles = new JTable(pickedTilesModel) {
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        };

        pickedTiles.setDefaultRenderer(String.class, new ImagePanel());

        pickedTiles.setEnabled(true);
        pickedTiles.setFocusable(true);
        pickedTiles.setShowGrid(true);
        // pickedTiles.setRowMargin(0);
        pickedTiles.setIntercellSpacing(new Dimension(0, 0));
        pickedTiles.setRowSelectionAllowed(false);
        pickedTiles.setVisible(true);
        pickedTiles.setRowHeight(30);

        DefaultTableModel gameBoardModel = new DefaultTableModel(15, 15);

        gameBoard = new JTable(gameBoardModel) {

            public boolean isCellEditable(int row, int column) {
                return true;
            }

            final ImageIcon image = new ImageIcon(System.getProperty("user.dir") + "\\src\\main\\resources\\images\\scrabble_board.jpg");

            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                final Component c = super.prepareRenderer(renderer, row, column);
                if (c instanceof JComponent) {
                    ((JComponent) c).setOpaque(false);
                }
                return c;
            }

            @Override
            public void paint(Graphics g) {
                final int imageWidth = image.getIconWidth();
                final int imageHeight = image.getIconHeight();
                final Dimension d = getSize();
                final int x = (d.width - imageWidth) / 2;
                final int y = (d.height - imageHeight) / 2;
                g.drawImage(image.getImage(), x, y, null, null);
                super.paint(g);
            }


        };

        gameBoard.setRowHeight(40);
        gameBoard.setOpaque(false);
    }



    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Points Splitter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new Window());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setSize(967, 760);
        frame.setVisible(true);
    }


}

////USE LATER////

class BoardTableCellRenderer extends DefaultTableCellRenderer {

    private static final long serialVersionUID = 1L;

    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int col) {



        Component c = super.getTableCellRendererComponent(table, value,
                isSelected, hasFocus, row, col);
        Object valueAt = table.getModel().getValueAt(row, col);
        String s = "";
        if (valueAt != null) {
            s = valueAt.toString();
        }

        if (!s.equalsIgnoreCase("")) {
            c.setForeground(Color.YELLOW);
            c.setBackground(Color.gray);
        } else {
            c.setForeground(Color.black);
            c.setBackground(Color.WHITE);

        }

        return c;

    }
}