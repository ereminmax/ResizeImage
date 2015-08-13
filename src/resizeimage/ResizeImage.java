package resizeimage;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

/**
 * Created by Maxim Eremin on 11.08.2015.
 */
public class ResizeImage {
    public static boolean resizeImage(InputStream imageStream, int width, int height, String extension, String fileName,
                                      String destiny) throws IOException {

        //CREATING A NEW IMAGE FILE NAME
        StringBuilder nomeImagem = new StringBuilder();

        nomeImagem.append(width);
        nomeImagem.append("x");
        nomeImagem.append(height);
        nomeImagem.append("_");
        nomeImagem.append(fileName);
        nomeImagem.append(".");
        nomeImagem.append(extension.toLowerCase());

        //CONVERT LOGIC HERE
        try {

            BufferedImage imagem = ImageIO.read(imageStream);
            BufferedImage newImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = newImg.createGraphics();
            g.drawImage(imagem, 0, 0, width, height, null); //DRAW THE IMAGE IN THE LEFT UPPER CORNER PAGE 356
            ImageIO.write(newImg, extension.toUpperCase(), new File(destiny + nomeImagem));

        } catch (IOException ex) {
            return false;
        } finally {
            imageStream.close();
        }

        return true;

    }
}
