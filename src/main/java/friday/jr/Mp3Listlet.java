package friday.jr;

import java.io.File;
import java.io.OutputStream;

public class Mp3Listlet extends AbstractJrlet {

    @Override
    public void service(String line, OutputStream out)throws Exception{
        out.write(new String("Content-Type: text/html;\r\n\r\n").getBytes());
        System.out.println("mp3 service");
        out.write("<h1>MP3 service</h1>".getBytes());

        File mp3Folder = new File("C:\\webroot\\music");// 파일이 있는 곳 지정

        String[] fileNames = mp3Folder.list();// 파일 리스트 모두 저장

        //mp3파일 리스트를 보여주고 각 리스트를 클릭하면 mp3 재생
        out.write("<ul>".getBytes());
        for(String fileName: fileNames){
            out.write(("<li><a href='music/" + fileName + "' target='songFrame'>" + fileName + "</a></li>").getBytes());
        }
        out.write("</ul>".getBytes());
        out.write("<iframe name='songFrame'></iframe>".getBytes());
    }
}


