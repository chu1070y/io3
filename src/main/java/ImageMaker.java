import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageMaker {

    //bad code
    public static void main(String[] args) throws Exception{

        BufferedImage image = new BufferedImage(1000,1000,BufferedImage.TYPE_INT_RGB);

        File bgfile = new File("C:\\zzz\\album\\bg.jpg");
        BufferedImage bgImage = ImageIO.read(bgfile);

        Graphics graphics = image.getGraphics();   //붓을 만든다.
        graphics.drawImage(bgImage,0,0,null);

        graphics.setColor(Color.lightGray);            //붓에다 핑크색을 찍는다.
        //폰트 적용
        Font myFont = new Font ("TimesRoman", 3, 50);
        graphics.setFont (myFont);
        graphics.drawString("Happy Smile~",100,700);

        //graphics.fillRect(10,10,280,280); //색을 어디서부터 어디까지 채워넣는다.


        ImageIO.write(image,"jpg",new File("C:\\zzz\\album\\test.jpg"));





    }
}
