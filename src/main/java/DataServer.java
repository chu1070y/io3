import com.google.gson.Gson;
import domain.Movie;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class DataServer {

    //bad code
    public static void main(String[] args) throws Exception{

        ServerSocket serverSocket = new ServerSocket(7777);

        System.out.println("Ready");

        Socket socket = serverSocket.accept();
        OutputStream out = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(out);

        ArrayList<Movie> arr = new ArrayList<>();

        arr.add(new Movie("히든 피겨스","데오도르 멜피",442,3.8));
        arr.add(new Movie("주토피아","디즈니",470,3.9));

        Gson gson = new Gson();

        String str = gson.toJson(arr);

        System.out.println(str);

        //dos.writeUTF("My name is Steven Chu");
        dos.writeUTF(str);   //Scanner로 주고받으면서 \n을 쓸 필요가 없다!!!

        dos.close();
        socket.close();
        serverSocket.close();


    }
}
