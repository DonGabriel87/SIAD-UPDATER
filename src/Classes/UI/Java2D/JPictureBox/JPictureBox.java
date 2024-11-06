package Classes.UI.Java2D.JPictureBox;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.security.InvalidParameterException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

public final class JPictureBox extends JComponent {

    public enum JPictureBoxSizeMode {
        NORMAL,
        AUTO,
        STRETCH
    };
    private JPictureBoxSizeMode imageMode = JPictureBoxSizeMode.NORMAL;
    private Icon image = null;

    public JPictureBox() {
        setDoubleBuffered(true);
        setMinimumSize(new Dimension(10, 10));
    }

    public JPictureBox(Icon image) {
        setDoubleBuffered(true);
        setMinimumSize(new Dimension(10, 10));
        setImage(image);
    }

    public JPictureBox(Icon image, JPictureBoxSizeMode imageMode) {
        setDoubleBuffered(true);
        setMinimumSize(new Dimension(10, 10));
        setImage(image);
        setMode(imageMode);
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (image != null) {
            switch (imageMode) {
                case NORMAL:
                    g2.drawImage(toImage(image), 0, 0, image.getIconWidth(), image.getIconHeight(), null);
                    break;

                case AUTO:
                    int width = getWidth();
                    int height = getHeight();
                    int diameter = Math.min(width, height);

                    Rectangle size = getAutoSize(image, diameter);

                    BufferedImage img = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB);
                    Graphics2D g2_img = img.createGraphics();
                    g2_img.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2_img.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

                    g2_img.drawImage(toImage(image), 0, 0, size.width, size.height, null);
                    g2_img.dispose();

                    int x = (width - size.width) / 2;
                    int y = (height - size.height) / 2;
                    g2.drawImage(img, x, y, null);
                    break;

                case STRETCH:
                    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                    g2.drawImage(toImage(image), 0, 0, getWidth(), getHeight(), null);
                    break;
                default:
                    throw new InvalidParameterException("Not such valid '" + imageMode + "' image mode");
            }
        }
        super.paintComponent(grphcs);
    }

    private Rectangle getAutoSize(Icon image, int maxSize) {
        int iw = image.getIconWidth();
        int ih = image.getIconHeight();

        double scale = Math.min((double) maxSize / iw, (double) maxSize / ih);
        int width = (int) (iw * scale);
        int height = (int) (ih * scale);

        return new Rectangle(0, 0, width, height);
    }

    private Image toImage(Icon icon) {
        return ((ImageIcon) icon).getImage();
    }

    public Icon getImage() {
        return image;
    }

    public void setImage(Icon image) {
        this.image = image;
        repaint();
    }

    public JPictureBoxSizeMode getMode() {
        return imageMode;
    }

    public void setMode(JPictureBoxSizeMode mode) {
        if (mode == null) {
            throw new IllegalArgumentException();
        }
        this.imageMode = mode;
        invalidate();
        revalidate();
    }
}
