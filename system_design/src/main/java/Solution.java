import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

// use helper.print("") or helper.println("") for printing logs else logs will not be visible.
public class Solution implements Q06WebpageVisitCounterInterface {
    private Helper06 helper;
    private ConcurrentHashMap<Integer, Integer> pageVisits;

    public Solution(){}

    public void init(int totalPages, Helper06 helper){
        this.helper=helper;
         helper.println("Initialising my pageVisits hash map");

         for(int i=0;i<totalPages; i++) {
             pageVisits.put(i, 0);
         }
    }

    // increment visit count for pageIndex by 1
    public void incrementVisitCount(int pageIndex) {
        if(pageIndex < 0) return;
        pageVisits.replace(pageIndex, pageVisits.get(pageIndex) + 1);
    }

    // return total visit count for a given page
    public int getVisitCount(int pageIndex) {
        if(pageIndex < 0 || pageVisits.isEmpty()) return 0;
        return pageVisits.get(pageIndex);
    }
}

interface Q06WebpageVisitCounterInterface {
    void init(int totalPages, Helper06 helper);
    void incrementVisitCount(int pageIndex);
    int getVisitCount(int pageIndex);
}

class Helper06 {
    void print(String s){System.out.print(s);}
    void println(String s){System.out.println(s);}
}