package friday.jr;

import java.io.OutputStream;
import java.util.Map;

public class Discomfortlet extends AbstractJrlet{

    @Override
    public void service(String line, OutputStream out)throws Exception{
        out.write(new String("Content-Type: text/html;\r\n\r\n").getBytes());
        System.out.println("discomfort service");
        out.write("<h1>Discomfort service</h1>".getBytes());

        //RequestParser클래스를 이용해서 입력한 값 받기
        Map<String, String> paramMap = parse(line);

        double temper = Double.parseDouble(paramMap.get("temper"));
        double humid = Double.parseDouble(paramMap.get("humid"));

        double discomfort = 1.8*temper-0.55*(1-humid)*(1.8*temper-26)+32;

        out.write(("<h1> Temperature:" + paramMap.get("temper")+"</h1>").getBytes());
        out.write(("<h1> Humidity   :" + paramMap.get("humid")+"</h1>").getBytes());
        out.write(("<hr/>").getBytes());
        out.write(("<h2> Discomfort : " + discomfort +"</h2>").getBytes());

    }
}
