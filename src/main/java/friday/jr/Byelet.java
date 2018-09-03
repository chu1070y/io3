package friday.jr;

import java.io.OutputStream;

public class Byelet extends AbstractJrlet {
    @Override
    public void service(String line, OutputStream out)throws Exception{
        out.write(new String("Content-Type: text/html;\r\n\r\n").getBytes());
        System.out.println("bye service");
        out.write("<h1>Bye service</h1>".getBytes());
    }
}
