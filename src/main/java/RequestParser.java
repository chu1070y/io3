import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RequestParser {

    public static Map<String, String> parse(String str)throws Exception{//파싱하다 잘못되면 저쪽에서 알아야하니 throws를 써줌
        //? <- 끊어내는 기준
        int idx = str.indexOf("?");
        System.out.println(idx);
        String query = str.substring(idx + 1);
        System.out.println(query);

        String[] midArr = query.split("&");      //여러 개가 나올 수 있으므로 split으로 끊음
        System.out.println(Arrays.toString(midArr));
        if(midArr.length == 0){                        //중간에 & 표시가 없는 경우를 뜻함
            midArr = new String[]{query};}

        Map<String, String> paramMap = new HashMap<>();
        for(int i = 0; i < midArr.length; i++){
            String param = midArr[i];
            String[] paramArr = param.split("=");//String 배열로 끊어내는 것
            paramMap.put(paramArr[0], paramArr[1]);      //0번째는 키, 1번째는 값
        }
        return paramMap;
    }

    public static void main(String[] args)throws Exception {
        System.out.println(parse("/bmi?height=133&weight=33"));   //출력하면 4가 나옴.
        System.out.println(parse("/bmi?height=133&weight=33").get("height"));
        System.out.println(parse("/login?id=aaa"));
        System.out.println(parse("/login?id=aaa").get("id"));
    }
}
