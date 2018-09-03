package friday.jr;

import friday.service.MessageService;

import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.Map;

public class Messagelet extends AbstractJrlet{

    @Override
    public void service(String line, OutputStream out) throws Exception {

        Map<String,String> paramMap = parse(line);

        System.out.println(paramMap);

        //한글 깨지는거 해결하기
        //브라우저가 get방식으로 데이터를 전송할 때는 자동으로 인코딩을 합니다.
        String content = paramMap.get("content");
        String deContent = URLDecoder.decode(content,"UTF-8");
        String deTarget = URLDecoder.decode(paramMap.get("target"),"UTF-8");
        System.out.println(deContent);

        MessageService service = MessageService.INSTANCE;
        service.sendMessage(deTarget,deContent);

        //한글을 안깨지게 하려면 전송할 때 한글이라고 먼저 알려줘야한다.
        out.write(new String("Content-Type: text/html; charset=UTF-8\r\n\r\n").getBytes());
        System.out.println("message service");
        out.write("<h1>정상적으로 전송되었습니다.</h1>".getBytes("UTF-8"));

    }
}
