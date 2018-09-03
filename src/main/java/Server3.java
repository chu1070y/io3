import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server3 {
    //bad code
    public static void main(String[] args)throws Exception {

        ServerSocket serverSocket = new ServerSocket(7777);

        while(true){

            try( // JDK 1.7버젼에서는 try안에 넣으면 자동 close됨
                    Socket socket = serverSocket.accept();
                    InputStream inputStream = socket.getInputStream();
                    OutputStream outputStream = socket.getOutputStream();
                    Scanner inScanner = new Scanner(inputStream);
            ){

                System.out.println(socket);
                String firstLine = inScanner.nextLine();
                System.out.println(firstLine);

                String[] arr = firstLine.split(" ");             //firstLine을 공백으로 끊어내는 것.
                String target = arr[1];

                outputStream.write(new String("HTTP/1.1 200 OK\r\n").getBytes());
                outputStream.write(new String("Cache-Control: private\r\n").getBytes());
                outputStream.write(new String("Content-Type: text/html; charset=UTF-8\r\n\r\n").getBytes());
                outputStream.write("<h1>Hello</h1>".getBytes());

                if(target.equals("/")){
                    System.out.println("skip");
                }else if(target.equals("/input.html")){
                    System.out.println("input page service");
                    outputStream.write("<h1>input page service</h1>".getBytes());
                }else if(target.startsWith("/bmi")){    //startWiths은 "bmi로 시작한다면" 을 뜻함
                    System.out.println("bmi service");
                    outputStream.write("<h1>bmi service</h1>".getBytes());
                }
            }catch(Exception e){
                System.out.println(e.getMessage());                 // 문제 생기면 출력하도록
            }//end catch
        }//end while
    }
}
