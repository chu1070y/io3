package friday.jr;

import java.io.OutputStream;
import java.util.Map;

public class Bmilet extends AbstractJrlet {
    @Override
    public void service(String line, OutputStream out) throws Exception {

        out.write(new String("Content-Type: text/html;\r\n\r\n").getBytes());
        System.out.println("bmi service");
        out.write("<h1>bmi service</h1>".getBytes());

        Map<String, String> paramMap = parse(line);

        double height = Double.parseDouble(paramMap.get("height"));
        double weight = Double.parseDouble(paramMap.get("weight"));

        double bmi = weight / (height * height);

        out.write(("<h1>" + paramMap.get("height")+"</h1>").getBytes());
        out.write(("<h1>" + paramMap.get("weight")+"</h1>").getBytes());
        out.write(("<hr/>").getBytes());
        out.write(("<h2>" + bmi +"</h2>").getBytes());

    }
}