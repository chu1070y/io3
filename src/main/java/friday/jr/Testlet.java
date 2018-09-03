package friday.jr;

import friday.AnswerSave;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Testlet extends AbstractJrlet{

    @Override
    public void service(String line, OutputStream out) throws Exception {

        System.out.println("Testlet running");
        System.out.println("test service");

        Map<String, List<String>> paramMap = parseList(line);
        System.out.println("현재 문제번호: ");
        int qno = Integer.parseInt(paramMap.get("qno").get(0));
        System.out.println(qno+"번 문제 입니다.");

        AnswerSave.INSTANCE.save(qno,paramMap.get("answer")); //체크한 것 저장하기


        System.out.println("-------------------------1");
        System.out.println("-------------------------1");
        System.out.println("-------------------------1");
        System.out.println(paramMap);
        System.out.println("-------------------------1");
        System.out.println("-------------------------1");
        System.out.println("-------------------------1");

        out.write(new String("HTTP/1.1 301 MovedPermanently\r\n").getBytes());
        System.out.println("-------------------------2");
        if(qno<5){
            String fileName="question"+ ++qno + ".html";
            System.out.println("-------------------------3");
            out.write(("Location: " + fileName + "\r\n").getBytes());
        }else {
            out.write(new String("Content-Type: text/html;charset=UTF-8\r\n\r\n").getBytes());
            out.write(("<h1>" + "문제1: " + Integer.toString(AnswerSave.INSTANCE.getAnswerMap(1).size()) + "개 체크하셨습니다.</h1>").getBytes());
            out.write(("<h1>" + "문제2: " + Integer.toString(AnswerSave.INSTANCE.getAnswerMap(2).size()) + "개 체크하셨습니다.</h1>").getBytes());
            out.write(("<h1>" + "문제3: " + Integer.toString(AnswerSave.INSTANCE.getAnswerMap(3).size()) + "개 체크하셨습니다.</h1>").getBytes());
            out.write(("<h1>" + "문제4: " + Integer.toString(AnswerSave.INSTANCE.getAnswerMap(4).size()) + "개 체크하셨습니다.</h1>").getBytes());
            out.write(("<h1>" + "문제5: " + Integer.toString(AnswerSave.INSTANCE.getAnswerMap(5).size()) + "개 체크하셨습니다.</h1>").getBytes());

        }
    }
}
