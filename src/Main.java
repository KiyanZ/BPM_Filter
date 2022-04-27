import java.io.File;
import java.io.IOException;
public class Main{
public static void main(String[] args) throws IOException {

        File f = new File("Resources/Jada-Kingdom-1.bmp");

        TransformaImagen ti = new TransformaImagen(f);
        ti.transformaNegativo();
        ti.transformaOscuro();
        ti.transformaBlancoNegro();
    }
}