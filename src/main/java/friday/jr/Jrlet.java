package friday.jr;

import java.io.OutputStream;

public interface Jrlet {
    void service(String line, OutputStream out)throws Exception;
}
