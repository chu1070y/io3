import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;

public class Server3_teach {
    //bad code
    public static void main(String[] args) throws Exception{

        ServerSocket serverSocket = new ServerSocket(7777);

        while(true){
            try(
                    Socket socket = serverSocket.accept();
                    InputStream inputStream = socket.getInputStream();
                    OutputStream outputStream = socket.getOutputStream();
                    Scanner inScanner = new Scanner(inputStream);
            ){
                System.out.println(socket);
                String firstLine = inScanner.nextLine();
                System.out.println(firstLine);

                String[] arr = firstLine.split(" ");
                String target = arr[1];

                outputStream.write(new String("HTTP/1.1 200 OK\r\n").getBytes());
                outputStream.write(new String("Cache-Control: private\r\n").getBytes());
                outputStream.write(new String("Content-Type: text/html;\r\n\r\n").getBytes());

                if(target.equals("/")){
                    System.out.println("skip");
                  }else if (target.endsWith(".html")){
                    File targetFile = new File("C:\\zzz\\" + target.substring(1));      //
                    FileInputStream fin = new FileInputStream(targetFile);

                    System.out.println(fin);
                    byte[] buffer = new byte[1024*8];
                    while(true){
                        int count = fin.read(buffer);
                        if (count == -1){break;}
                        outputStream.write(buffer, 0, count);
                    }

                    fin.close();

                }else if (target.startsWith("/bmi")){
                   System.out.println("bmi service");
                    outputStream.write("<h1>bmi service</h1>".getBytes());

                    Map<String, String> paramMap = RequestParser.parse(target);

                    double height = Double.parseDouble(paramMap.get("height"));
                    double weight = Double.parseDouble(paramMap.get("weight"));

                    double bmi = weight / (height * height);

                    outputStream.write(("<h1>" + paramMap.get("height")+"</h1>").getBytes());
                    outputStream.write(("<h1>" + paramMap.get("weight")+"</h1>").getBytes());
                    outputStream.write(("<hr/>").getBytes());
                    outputStream.write(("<h2>" + bmi + "</h2>").getBytes());
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }//end catch
        }//end while
    }
}