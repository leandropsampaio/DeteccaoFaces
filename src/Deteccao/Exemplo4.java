package Deteccao;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

/**
 *
 * @author Leandro Pereira Sampaio
 */
public class Exemplo4 {
    
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        Mat imagemColorida = Imgcodecs.imread("src/outros/carro3.jpg");
        Mat imagemCinza = new Mat();

        Imgproc.cvtColor(imagemColorida, imagemCinza, Imgproc.COLOR_BGR2GRAY);

        CascadeClassifier classificador = new CascadeClassifier("src/cascades/cars.xml");

        MatOfRect facesDetectadas = new MatOfRect();
        // Passa a imagem e os parâmetros que transforma em facesDetectadas
        classificador.detectMultiScale(imagemCinza, facesDetectadas,
                1.01, // Scale Factor, valor default = 1.1
                3, // minNeighbors
                0, // flags
                new Size(30, 30), // minSize
                new Size(200, 200)); // maxSize

        System.out.println("Quantidade de faces: " + facesDetectadas.toArray().length);

        for (Rect rect : facesDetectadas.toArray()) {
            System.out.println(rect.x + " " + rect.y + " " + rect.width + " " + rect.height);
            Imgproc.rectangle(imagemColorida, new Point(rect.x, rect.y),
                    new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 0, 255), 2);
        }

        Utilitarios ut = new Utilitarios();
        ut.mostraImagem(ut.convertMatToImage(imagemColorida));
    }
}
