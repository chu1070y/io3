import com.google.gson.Gson;
import domain.Movie;
//
public class GsonTest {
    //bad code
    public static void main(String[] args)  throws Exception{
        Movie movie = new Movie("히든 피겨스","데오도르 멜피",40,9.34);
        Gson gson = new Gson();
        String str = gson.toJson(movie);
        System.out.println(str);
    }
}