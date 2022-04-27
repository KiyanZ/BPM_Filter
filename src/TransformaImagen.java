import java.io.*;

public class TransformaImagen {

    File f;

    public TransformaImagen(File fEnt) {
        // Control de existencia del fichero y control de la extensión .bmp (sacar
        // mensajes de error)

        if (fEnt.getName().endsWith(".bmp")) {
            this.f = fEnt;
        } else {
            System.out.println("The required file format is .bmp");
        }
    }

    public void transformaNegativo() throws IOException {
        // Transformar a negativo y guardar como *_n.bmp
        File negative = new File("Resources/Jada-Kingdom-1_n.bmp");
        //Reado
        FileInputStream fileReader = new FileInputStream(f);
        BufferedInputStream bufferInput = new BufferedInputStream(fileReader);
        byte[] meta = bufferInput.readNBytes(54);
        //Write
        FileOutputStream fileWriter = new FileOutputStream(negative);
        fileWriter.write(meta);
        int change;
        int value = bufferInput.read();
        while (value != -1) {
            change = 255 - value;
            fileWriter.write((byte) change);
            value = bufferInput.read();
        }
    }

    public void transformaOscuro() throws IOException {
        // Transformar a una imagen más oscura y guardar como *_o.bmp
        File darktheme = new File("Resources/Jada-Kingdom-1_o.bmp");
        //Read
        FileInputStream fileReader = new FileInputStream(f);
        BufferedInputStream bufferInput = new BufferedInputStream(fileReader);
        byte[] meta = bufferInput.readNBytes(54);
        //Write
        FileOutputStream fileWriter = new FileOutputStream(darktheme);
        fileWriter.write(meta);
        int change;
        int value = bufferInput.read();
        while (value != -1) {
            change = value / 2;
            fileWriter.write(change);
            value = bufferInput.read();
        }
    }
        public void transformaBlancoNegro () throws IOException  {
            // Transformar a una imagen en blanco y negro y guardar como *_bn.bmp
            File blackwhitetheme = new File("Resources/Jada-Kingdom-1_o.bmp");
            //Read
            FileInputStream fileReader = new FileInputStream(f);
            BufferedInputStream bufferInput = new BufferedInputStream(fileReader);
            byte[] meta = bufferInput.readNBytes(54);
            //Write
            FileOutputStream fileWriter = new FileOutputStream(blackwhitetheme);
            fileWriter.write(meta);
            int change;
            int value = bufferInput.read();
            while (value != -1) {
                change = value / 2;
                fileWriter.write(change);
                value = bufferInput.read();
        }

        private String getNombreSinExtension () {
            //Devuelve el nombre del archivo f sin extensión
            return "";
        }
    }