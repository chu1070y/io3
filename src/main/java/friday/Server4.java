package friday;

import friday.jr.Hellolet;
import friday.jr.Jrlet;
import friday.jr.Timelet;
import sub.FileSender;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server4 {

    //bad code
    public static void main(String[] args) throws Exception{

        ServerSocket serverSocket = new ServerSocket(7777);
        JrletFactory factory = new JrletFactory();

        while(true){

            try(
                    Socket socket = serverSocket.accept();
                    InputStream inputStream = socket.getInputStream();
                    OutputStream outputStream = socket.getOutputStream();
                    Scanner inScanner = new Scanner(inputStream);
            ){
                System.out.println(socket);
                String firstLine = inScanner.nextLine();
                System.out.println("firstLine: "+firstLine);

                String[] arr = firstLine.split(" ");

                // /input.html /bmi /aaa.jpg
                String target = arr[1];
                System.out.println(target);

                if(target.contains("test") == false){
                    outputStream.write(new String("HTTP/1.1 200 OK\r\n").getBytes());
                    outputStream.write(new String("Cache-Control: private\r\n").getBytes());
                }

                if(target.endsWith(".html") || target.endsWith(".jpg")||target.endsWith(".mp3")||target.endsWith(".mp4")){
                    System.out.println("정적인 컨텐츠");
                    FileSender sender = new FileSender();
                    System.out.println("TARGET: " + target);
                    sender.sendFile(target, outputStream);
                }else {
                    System.out.println("else------------------------------");
                    Jrlet jrlet = factory.get(target);
                    jrlet.service(target,outputStream);
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }//end catch
        }//end while
    }
}
