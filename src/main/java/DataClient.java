import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import domain.Movie;

import java.io.DataInputStream;
import java.lang.reflect.Type;
import java.net.Socket;
import java.util.List;

public class DataClient {
    //bad code
    public static void main(String[] args) throws Exception{

        Socket socket = new Socket("10.10.10.96",7777);

        DataInputStream din = new DataInputStream(socket.getInputStream());

        String msg = din.readUTF();
        System.out.println(msg);

        Gson gson = new Gson();

        Type listType = new TypeToken<List<Movie>>(){ }.getType(); // 타입을 만들어준다.

        List<Movie> movieList = gson.fromJson(msg, listType); //단순히 ArrayList쓰면 Movie 타입은 만들어지지 않는다.

        System.out.println(movieList);

        for(Movie m:movieList){
            System.out.println(m);
        }

        din.close();
        socket.close();
    }
}
