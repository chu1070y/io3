import friday.jr.AbstractJrlet;
import friday.jr.Testlet;

public class Tired {
    public static void main(String[] args) throws Exception {
        AbstractJrlet abc = new Testlet();
        System.out.println(abc.parseList("abc?qno=1&answer=q1&answer=q2"));
    }
}
