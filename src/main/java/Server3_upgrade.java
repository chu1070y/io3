import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;

public class Server3_upgrade {

    //bad code
    public static void main(String[] args) throws Exception{

        ServerSocket serverSocket = new ServerSocket(7777);

        while(true){

            try( //여기에다가 생성해주면 Java가 close();를 자동으로 해줍니다.
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
                System.out.println("target: "+ target);
                outputStream.write(new String("HTTP/1.1 200 OK\r\n").getBytes());
                outputStream.write(new String("Cache-Control: private\r\n").getBytes());

                if(target.equals("/")){
                    System.out.println("skip");

//                }else if (target.equals("/input.html")){ //이렇게 쓰면 input.html만 적용가능하므로 별로 안좋다.
                }else if (target.endsWith(".html")){
                    outputStream.write(new String("Content-Type: text/html;\r\n\r\n").getBytes());

                    File targetFile = new File("C:\\zzz\\" + target.substring(1));//substring을 쓰는 이유는 공백을 제거하기 위해서
                    FileInputStream fin = new FileInputStream(targetFile);

                    System.out.println("fin1:" + fin);
                    byte[] buffer = new byte[1024*8];
                    while(true){
                        int count = fin.read(buffer);
                        if (count == -1){break;}
                        outputStream.write(buffer, 0, count);
                    }

                    fin.close();

                }else if (target.endsWith(".jpg")){
                    outputStream.write(new String("Content-Type: image/jpeg;\r\n\r\n").getBytes());
                    System.out.println(target);
                    File targetFile = new File("C:\\zzz\\" + target.substring(1));
                    FileInputStream fin = new FileInputStream(targetFile);

                    System.out.println("fin2: " + fin);
                    byte[] buffer = new byte[1024*8];
                    while(true){
                        int count = fin.read(buffer);
                        if (count == -1){break;}
                        outputStream.write(buffer, 0, count);
                    }

                    fin.close();

                }else if (target.startsWith("/bmi")){                   //startWiths은 "bmi로 시작한다면" 을 뜻함
                    outputStream.write(new String("Content-Type: text/html;\r\n\r\n").getBytes());
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