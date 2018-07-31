import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class MainWindow extends JFrame {

    DefaultTableModel tableModel2 = new DefaultTableModel(1, 7);
    JTable pickedTiles = new JTable(tableModel2) {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    Box mainBox = Box.createHorizontalBox();
    Box controlBox = Box.createVerticalBox();

    JPanel tilesPanel = new JPanel();
    JPanel pickedTilesPanel = new JPanel();
    JPanel rightPanel = new JPanel();

    JButton getSolution;

    JTextArea bestSolutions = new JTextArea(10,2);
    JScrollPane solutionsPane = new JScrollPane(bestSolutions);


    public MainWindow() {

        final JTable gameBoard = new JTable(15, 15) {

            final ImageIcon image = new ImageIcon(System.getProperty("user.dir") +"\\src\\main\\resources\\scrabble_board.jpg");

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
              //  final int imageWidth = image.getIconWidth();
              //  final int imageHeight = image.getIconHeight();
              //  final Dimension d = getSize();
              //  final int x = (d.width - imageWidth) / 2;
              //  final int y = (d.height - imageHeight) / 2;
                g.drawImage(image.getImage(), 0, 0, null, null);
                super.paint(g);
            }
        };
        gameBoard.setRowHeight(40);
        gameBoard.setOpaque(false);

        setSize(916, 760);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setLocationRelativeTo(null);

        pickedTiles.setRowHeight(30);
        tilesPanel.setLayout(new BoxLayout(tilesPanel, BoxLayout.PAGE_AXIS));
        pickedTilesPanel.setLayout(new BoxLayout(pickedTilesPanel, BoxLayout.PAGE_AXIS));

        tilesPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        tilesPanel.add(gameBoard);
        tilesPanel.add(Box.createRigidArea(new Dimension(0, 40)));
        tilesPanel.add(pickedTiles);
        tilesPanel.add(Box.createRigidArea(new Dimension(0, 60)));

       // solutionsPane.add(bestSolutions);

        bestSolutions.append("asdasdas!\n\n\n\n\n\n\n\n\n\\n\n\n\n\\n\n\\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nadsas");

        controlBox.add(Box.createRigidArea(new Dimension(250, 30)));
        controlBox.add(bestSolutions);
        controlBox.add(Box.createRigidArea(new Dimension(0, 50)));
        rightPanel.add(solutionsPane);
        controlBox.add(rightPanel);
        controlBox.add(Box.createRigidArea(new Dimension(0, 100))); // reduce height when new component added

        mainBox.add(Box.createRigidArea(new Dimension(20, 0)));
        mainBox.add(tilesPanel);
        mainBox.add(Box.createRigidArea(new Dimension(20, 0)));
        mainBox.add(controlBox);
        mainBox.add(Box.createRigidArea(new Dimension(20, 0)));

        getSolution = new JButton("GET SCRABBLE!");
        rightPanel.add(getSolution);

        this.setResizable(false);
        this.add(mainBox);
        setVisible(true);
    }


}
