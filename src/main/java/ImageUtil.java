import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * @author Alin
 * @version 1.0
 * @description //
 * @date 2019/8/23 16:30
 */
public class ImageUtil {
    private static final int LOGO_WIDTH = 100;
    private ImageUtil(){}
    /**
     * 改变图片的尺寸
     *
     * @return boolean
     */
    public static boolean changeSize(String path) {
        BufferedInputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream(path));

            //字节流转图片对象
            BufferedImage bi = ImageIO.read(in);
            int width = bi.getWidth();
            int height = bi.getHeight();
            int loopTimes = 0;
            while (width/10 > LOGO_WIDTH){
                width /= 10;
                loopTimes++;
            }

            for (int i = 0; i < loopTimes; i++) {
                width /= 10;
            }

            //构建图片流
            BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            //绘制改变尺寸后的图
            tag.getGraphics().drawImage(bi, 0, 0, width, height, null);
            //输出流
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("/test.jpg"));
            //JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            //encoder.encode(tag);
            ImageIO.write(tag, "JPG", out);
            in.close();
            out.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        changeSize("C:\\Users\\king_zl\\Pictures\\Saved Pictures\\test.png");
    }
}
