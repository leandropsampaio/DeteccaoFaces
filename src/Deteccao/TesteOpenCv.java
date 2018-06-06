package Deteccao;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import static org.opencv.imgcodecs.Imgcodecs.CV_LOAD_IMAGE_COLOR;
import org.opencv.imgproc.Imgproc;
import static org.opencv.imgproc.Imgproc.COLOR_BGR2GRAY;

/**
 *
 * @author Leandro Pereira Sampaio
 */
public class TesteOpenCv {

    public static void main(String[] args) {
        Utilitarios ut = new Utilitarios();
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.out.println(Core.VERSION);

        Mat imagemColorida = Imgcodecs.imread("src/Imagens/opencv-java.jpg", CV_LOAD_IMAGE_COLOR);
        // Mostrar uma imagem na interface gráfica
        ut.mostraImagem(ut.convertMatToImage(imagemColorida));
        
        // Cria uma matriz para armazenar uma imagem
        Mat imagemCinza = new Mat();
        // Transformar imagem colorida para uma imagem em escala de cinza
        Imgproc.cvtColor(imagemColorida, imagemCinza, COLOR_BGR2GRAY);
        ut.mostraImagem(ut.convertMatToImage(imagemCinza));
    }
}
