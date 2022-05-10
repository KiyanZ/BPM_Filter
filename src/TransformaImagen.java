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

    public void transformaBlancoNegro() throws IOException {
        // Transformar a una imagen en blanco y negro y guardar como *_bn.bmp
        File greyscale = new File("Resources/Jada-Kingdom-1_bn.bmp");
        //Read
        FileInputStream fileReader = new FileInputStream(f);
        BufferedInputStream bufferInput = new BufferedInputStream(fileReader);
        byte[] meta = bufferInput.readNBytes(54);
        //Write
        FileOutputStream fileWriter = new FileOutputStream(greyscale);
        fileWriter.write(meta);
        int change;
        int value1 = bufferInput.read();
        int value2 = bufferInput.read();
        int value3 = bufferInput.read();
        while (value1 != -1) {
            change = (value1 + value2 + value3) / 3;
            fileWriter.write(change);
            fileWriter.write(change);
            fileWriter.write(change);
            value1 = bufferInput.read();
            value2 = bufferInput.read();
            value3 = bufferInput.read();
        }
    }

    public void transformaBlue(){
        File redtheme = new File("Resources/Jada-Kingdom-1_blue.bmp");
        try {
            FileInputStream fileInputStream = new FileInputStream(f);
            BufferedInputStream reader = new BufferedInputStream(fileInputStream);
            try {
                byte[] meta = reader.readNBytes(54);
                FileOutputStream writer = new FileOutputStream(redtheme);
                writer.write(meta);
                int change;
                int red = reader.read();
                int green = reader.read();
                int blue = reader.read();
                while((red) != -1){
                    change = 0 ;
                    writer.write(red);
                    writer.write(change);
                    writer.write(change);
                    red = reader.read();
                    green = reader.read();
                    blue = reader.read();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void transformaRed(){
        File redtheme = new File("Resources/Jada-Kingdom-1_red.bmp");
        try {
            FileInputStream fileInputStream = new FileInputStream(f);
            BufferedInputStream reader = new BufferedInputStream(fileInputStream);
            try {
                byte[] meta = reader.readNBytes(54);
                FileOutputStream writer = new FileOutputStream(redtheme);
                writer.write(meta);
                int change;
                int blue = reader.read();
                int green = reader.read();
                int red = reader.read();
                while((red) != -1){
                    change = 0 ;
                    writer.write(change);
                    writer.write(change);
                    writer.write(red);
                    red = reader.read();
                    green = reader.read();
                    blue = reader.read();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void transformaGreen(){
        File redtheme = new File("Resources/Jada-Kingdom-1_green.bmp");
        try {
            FileInputStream fileInputStream = new FileInputStream(f);
            BufferedInputStream reader = new BufferedInputStream(fileInputStream);
            try {
                byte[] meta = reader.readNBytes(54);
                FileOutputStream writer = new FileOutputStream(redtheme);
                writer.write(meta);
                int change;
                int blue = reader.read();
                int green = reader.read();
                int red = reader.read();
                while((red) != -1){
                    change = 0 ;
                    writer.write(change);
                    writer.write(green);
                    writer.write(change);
                    red = reader.read();
                    green = reader.read();
                    blue = reader.read();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String getNombreSinExtension() {
        //Devuelve el nombre del archivo f sin extensión
        String[] filename = this.f.getName().split("\\.");
        return filename[0];
    }
}