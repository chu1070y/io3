package friday.service;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public enum MessageService {

    INSTANCE;

    private Map<String, String> ipMap;

    //Map<String, Jrlet> jrletMap;

    MessageService(){
        ipMap = new HashMap<>();
        ipMap.put("이은상","10.10.10.85");
        ipMap.put("문지인","10.10.10.86");
        ipMap.put("김현정","10.10.10.87");
        ipMap.put("박가영","10.10.10.94");
        ipMap.put("이호중","10.10.10.95");
        ipMap.put("추연훈","10.10.10.96");
        ipMap.put("김가익","10.10.10.97");
        ipMap.put("조성익","10.10.10.84");
        ipMap.put("김진솔","10.10.10.83");
        ipMap.put("주은지","10.10.10.82");
        ipMap.put("정영준","10.10.10.93");
        ipMap.put("박고은","10.10.10.92");
        ipMap.put("홍아람","10.10.10.91");
        ipMap.put("황인재","10.10.10.90");
    }

    public void sendMessage(String target, String msg) throws Exception{

        String ipAddr = ipMap.get(target);
        Socket socket = new Socket(ipAddr,7777);
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream()); //데이터 보내기 준비

        dos.writeUTF(msg); //데이터 보내기
        dos.flush();
        dos.close();
        socket.close();
    }


}
