import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindString {
    public static List<Integer> findString(String str, String[] words){
        List<Integer> result=new ArrayList<>();
        if(str==null||words==null||words.length==0)
        {
            return result;
        }
        int length=words[0].length();
        Map<String,Integer> map=new HashMap<>();
        for(String word:words){
            map.put(word,map.containsKey(word)?map.get(word)+1:1);
        }
        for(int i=0;i<=str.length()-length*words.length;i++){
            Map<String,Integer> copy=new HashMap<>(map);
            for(int j=0;j<words.length;j++){
                String strs=str.substring(i+j*length,i+j*length+length);
                if(copy.containsKey(strs)){
                    int count=copy.get(strs);
                    if(count==1){
                        copy.remove(strs);
                    }else{
                        copy.put(strs,count-1);
                    }
                    if(copy.isEmpty()){
                        result.add(i);
                        break;
                    }
                }else{break;}
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str="barfootherfoobarman";
        String[] words={"foo","bar"};
        System.out.println(findString(str,words));

    }
}
