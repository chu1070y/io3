import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.Mp3File;
import java.io.FileOutputStream;
import java.io.OutputStream;
// mp3에 사진이 들어있을 때 사진을 추출하는 코드이다.
public class Mp3Test {
    //bad code
    public static void main(String[] args) throws Exception{

        Mp3File mp3file = new Mp3File("C:\\zzz\\abc.mp3"); //mp3 객체 생성

        //mp3정보 알아내기
        System.out.println("Length of this mp3 is: " + mp3file.getLengthInSeconds() + " seconds");
        System.out.println("Bitrate: " + mp3file.getBitrate() + " kbps " + (mp3file.isVbr() ? "(VBR)" : "(CBR)"));
        System.out.println("Sample rate: " + mp3file.getSampleRate() + " Hz");
        System.out.println("Has ID3v1 tag?: " + (mp3file.hasId3v1Tag() ? "YES" : "NO"));
        System.out.println("Has ID3v2 tag?: " + (mp3file.hasId3v2Tag() ? "YES" : "NO"));
        System.out.println("Has custom tag?: " + (mp3file.hasCustomTag() ? "YES" : "NO"));

        ID3v2 id3v2Tag = mp3file.getId3v2Tag(); //mp3파일 넣기
        byte[] imageData = id3v2Tag.getAlbumImage(); //이미지 추출

        System.out.println(id3v2Tag);

        OutputStream out = new FileOutputStream("C:\\zzz\\album\\bg.jpg");
        out.write(imageData);
        out.close();
    }
}
