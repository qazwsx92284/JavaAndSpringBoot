import java.io.*;
import java.util.*;



class Solution {
  public static void main(String[] args) {
    System.out.println(findTopIpAddr(new String[] {"10.0.0.1 - GET 2020-08-24", "10.0.0.1 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-20"}));
    System.out.println(findTopIpAddr(new String[] {"10.0.0.3 - GET 2020-08-24", "10.0.0.3 - GET 2020-08-24", "10.0.0.2 - GET 2020-08-20"}));
  }

  public static String findTopIpAddr(String[] ips) {
    /* treemap : The map is sorted according to the natural ordering of its keys, or by a Comparator provided at map creation time, depending on which constructor is used. */
    TreeMap<String, Integer> map = new TreeMap<>();
    int maxFreq = 0;
    int freq = 0;
    for(String ip : ips) {
      String addr = ip.split(" ")[0];
      if(map.containsKey(addr)) {
         freq = map.get(addr);
      }
      map.put(addr, freq +1);
      maxFreq = Math.max(maxFreq, map.get(addr));

    }

    StringBuilder sb = new StringBuilder();
    for(String addr : map.keySet()) {
      if(map.get(addr) == maxFreq) {
        sb.append(addr);
        sb.append(",");
      }
    }
    return sb.substring(0, sb.length()-1).toString();
  }
}
