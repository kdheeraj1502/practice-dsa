import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapExample {


    public static void main(String[] args) {
//        List<Map<String, Map<String, String>>> list = new ArrayList<>();
//
//        Map<String, String> map = new HashMap<>();
//        map.put("puja", "puja1");
//        Map<String , Map<String , String>> map2 = new HashMap<>();
//        map2.put("outerPuja", map);
//
//        list.add(map2);
//
//        List<String> listOfKeys = list.stream().flatMap(m-> m.keySet().stream()).collect(Collectors.toList());
//
//        System.out.println(listOfKeys);
//
//        List<Map<String, String>> listOfMap = list.stream().flatMap(m-> m.values().stream()).collect(Collectors.toList());
//
//        System.out.println(listOfMap);
//
//        List<String> ineerListKey = listOfMap.stream().flatMap(m-> m.keySet().stream()).collect(Collectors.toList());
//
//        List<String> ineerListValue = listOfMap.stream().flatMap(m-> m.values().stream()).collect(Collectors.toList());
//
//        System.out.println("keys : "  + ineerListKey);
//        System.out.println("values : "  + ineerListValue);

        String str = "puja";

        Map<Character , Long> countMap = str.chars().mapToObj(c-> Character.toLowerCase((char)c))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


        countMap.forEach((e, v)->
                System.out.println("key :" + e ));


    }
}
