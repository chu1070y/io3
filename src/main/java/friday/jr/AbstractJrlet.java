package friday.jr;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public abstract class AbstractJrlet implements Jrlet{

    public Map<String, String> parse(String str)throws Exception{
        int idx = str.indexOf("?");
        String query = str.substring(idx + 1);
        String[] midArr = query.split("&");
        if(midArr.length == 0){
            midArr = new String[]{query};
        }
        Map<String, String> paramMap = new HashMap<>();
        for(int i = 0; i < midArr.length; i++){
            String param = midArr[i];
            String[] paramArr = param.split("=");
            paramMap.put(paramArr[0],paramArr[1]);
        }
        return paramMap;
    }

    //문찐 문제에서 체크한 것들을 뽑아오기
    public Map<String, List<String>> parseList(String str)throws Exception{

        int idx = str.indexOf("?");
        String query = str.substring(idx + 1);
        String[] midArr = query.split("&");

        if(midArr.length == 0){
            midArr = new String[]{query};
        }
        Map<String, List<String>> paramMap = new HashMap<>();

        for(int i = 0; i < midArr.length; i++){
            String param = midArr[i];
            String[] paramArr = param.split("=");

            List<String> list = paramMap.get(paramArr[0]);

            if(list == null){
                list = new ArrayList<String>();
                paramMap.put(paramArr[0], list);
            }
            list.add(paramArr[1]);
        }
        return paramMap;
    }
}
