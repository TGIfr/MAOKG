package sample;





import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;

public class Main extends JPanel implements ActionListener {

    private static int maxWidth;
    private static int maxHeight;

    // for movement animation
    private double tx = -250;
    private double ty = 200;

    private double dx = 1;
    private double dy = 1;
    private double counter = 0;

    private double angle = 0;

    private int radius = 240;
    private int radiusExtention = 130;

    double points[][] = {
            {-50, -42}, {48, -119}, {200, -52}, {104, -12}, {135, 52}, {1, 63}
    };

    Timer timer;


    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Set rendering params.
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);

        // Set background color.
        g2d.setBackground(new java.awt.Color(0, 128, 128));
        g2d.clearRect(0, 0, maxWidth, maxHeight);


        // Set (0;0) to the center to draw main Frame.
        g2d.translate(maxWidth/2, maxHeight/2);
        // Draw the main Frame.
        BasicStroke bs2 = new BasicStroke(16, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
        g2d.setStroke(bs2);
        g2d.drawRect(
                -(radius + radiusExtention),
                -(radius + radiusExtention),
                (radius + radiusExtention)*2,
                (radius + radiusExtention)*2
        );

        // Reset center to default value for the main animation.
        g2d.translate(tx, ty);


        GeneralPath body = new GeneralPath();
        body.moveTo(points[0][0], points[0][1]);
        for (int k = 1; k < points.length; k++)
            body.lineTo(points[k][0], points[k][1]);
        body.closePath();

        // Draw antenna.
        GradientPaint gp = new GradientPaint(
                25, 50,
                new java.awt.Color(202, 0, 66),
                60, 5,
                new java.awt.Color(252, 163, 205),
                true
        );
        g2d.setPaint(gp);

        g2d.rotate(angle, body.getBounds2D().getCenterX(),
                body.getBounds2D().getCenterY());

        g2d.fill(body);

        //back
        g2d.setPaint(Color.YELLOW);
        g2d.fillPolygon(new int[]{123, 186, 146}, new int[]{-11, -24, 37}, 3);

        //middle
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(3));
        g2d.drawLine(-49, -42, 104, -12);

        //horn top
        g2d.setStroke(new BasicStroke(6, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
        g2d.drawLine(-24, -60, -86, -116);

        //horn bottom
        g2d.drawLine(-23, 11, -94, 37);

        //eyes
        g2d.setPaint(Color.GREEN);
        g2d.fillRect(16, -64, 10, 10);
        g2d.fillRect(0, -8, 10, 10);

    }


    public Main() {
        timer = new Timer(10, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        var counterMax = 1400;
        // movement
        if(counter < counterMax/4){
            tx += 1;
        } else if(counter < 2 * counterMax/4){
            ty -= 1;
        } else if(counter < 3 * counterMax/4){
            tx -= 1;
        } else if(counter < counterMax){
            ty += 1;
        }
        counter += 1;
        if(counterMax <= counter){
            counter = 0;
        }
        
        angle += 0.01;

        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lab2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.add(new Main());

        frame.setVisible(true);

        Dimension size = frame.getSize();
        Insets insets = frame.getInsets();
        maxWidth = size.width - insets.left - insets.right - 1;
        maxHeight = size.height - insets.top - insets.bottom - 1;
    }
}
