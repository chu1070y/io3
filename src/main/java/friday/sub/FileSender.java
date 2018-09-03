package sub;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Properties;

public class FileSender {

    private static Properties prop; //객체 생성

    static{ //초기화블럭
        try{
            String path = "C:\\webroot\\mime.properties";
            prop = new Properties();
            prop.load(new FileInputStream(path)); //파일 저장
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void sendFile(String path, OutputStream out)throws Exception{
        int idx = path.lastIndexOf(".");
        String subfix = path.substring(idx);

        System.out.println(subfix);

        out.write(new String("Content-Type: " + prop.getProperty(subfix) + ";\r\n\r\n").getBytes());
        System.out.println("input page service");

        File targetFile = new File("C:\\webroot\\" + path.substring(1)); //파일 경로로 파일 불러오기
        FileInputStream fin = new FileInputStream(targetFile);

        System.out.println(fin);

        byte[] buffer = new byte[1024*8];

        while(true){
            int count = fin.read(buffer);
            if(count == -1){ break;}
            out.write(buffer,0,count);
        }
        fin.close();
    }
}

