package friday;

import friday.jr.Jrlet;

import java.io.FileInputStream;
import java.util.Map;
import java.util.Properties;

public class JrletFactory {

    private Properties prop;

    //Map<String, Jrlet> jrletMap;

    public JrletFactory()throws Exception{
        String path = "C:\\webroot\\jrlet.properties";
        prop = new Properties();
        prop.load(new FileInputStream(path));
    }

    public Jrlet get(String line) throws Exception{

        // /hello /time /bmi?

        int idx = line.indexOf("?"); //?가 없다면 idx가 -1이 나온다.

        String targetURL = idx == -1 ?line:line.substring(0,idx);//idx가 -1이면 그대로 쓰고 그렇지 않으면 처음부터 ?바로 전까지 글자를 저장한다.
        String className = prop.getProperty(targetURL);      //원하는 클래스이름을 가져온다.
        Object obj = Class.forName(className).newInstance(); //인스턴스가 생성되면 객체로 나온다.
        return (Jrlet)obj;

    }

}
