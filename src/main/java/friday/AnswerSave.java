package friday;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum AnswerSave {

    INSTANCE;

    Map<Integer, List<String>> answerMap;

    AnswerSave(){
        answerMap = new HashMap<>();
    }

    public void save(Integer qno, List<String> userAnswers){
        answerMap.put(qno, userAnswers);
        System.out.println("debug......................");
        System.out.println("debug......................");
        System.out.println(answerMap);
        System.out.println("debug......................");
        System.out.println("debug......................");
    }

    public List<String> getAnswerMap(int qno){

        return answerMap.get(qno);
    }
}