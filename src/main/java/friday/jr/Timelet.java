package friday.jr;

import java.io.OutputStream;

public class Timelet extends AbstractJrlet{

    public void service(String line, OutputStream out)throws Exception{
        out.write(new String("Content-Type: text/html;\r\n\r\n").getBytes());
        System.out.println("time service");
        out.write("<h1>Time service</h1>".getBytes());
    }
}
