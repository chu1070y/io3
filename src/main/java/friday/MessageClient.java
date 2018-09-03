package friday;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class MessageClient {
    //bad code
    public static void main(String[] args) throws Exception{

        String i1 = "⊂_ヽ \n" +
                "　 ＼＼ Λ＿Λ \n" +
                "　　 ＼( 'ㅅ' ) 두둠칫 \n" +
                "　　　 >　⌒ヽ \n" +
                "　　　/ 　 へ＼ \n" +
                "　　 /　　/　＼＼ \n" +
                "　　 ﾚ　ノ　　 ヽ_つ \n" +
                "　　/　/두둠칫 \n" +
                "　 /　/| \n" +
                "　(　(ヽ \n" +
                "　|　|、＼ \n" +
                "　| 丿 ＼ ⌒) \n" +
                "　| |　　) / \n" +
                "`ノ )　　Lﾉ";

        Map<String,String> iconMap = new HashMap<>();
        iconMap.put("@i1","\n"+i1+"\n");

        ServerSocket serverSocket = new ServerSocket(7777);

        System.out.println("CLIENT READY");

        while(true){
            try(
                    Socket socket = serverSocket.accept();
                    DataInputStream din = new DataInputStream(socket.getInputStream());//데이터 읽는 역할
            ) {
                System.out.println(socket);//연결되었는지 확인
                String message = din.readUTF();
                System.out.println(message);

                if(message.contains("@i1")){
                    System.out.println(iconMap.get("@i1"));
                }

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }//end while


    }
}
