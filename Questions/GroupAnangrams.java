package Questions;
import java.util.*;
//https://leetcode.com/problems/group-anagrams/description/


public class GroupAnangrams {
    private List<List<String>> groupAnagramsBr(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        int n = strs.length;
        boolean vis[] = new boolean[n];
        for(int i = 0;i<n;i++){
            if(vis[i]){
                continue;
            }
            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            vis[i] = true;
            for(int j = 1;j<n;j++){
                if(!vis[j]&&checkAnagram(strs[i], strs[j])){
                    group.add(strs[j]);
                    vis[j] = true;
                }
            }
            ans.add(group);
        }
        return ans;
        
}
private List<List<String>> groupAnagramsBrNoSpace(String[] strs) {
    List<List<String>> ans = new ArrayList<>();
    int n = strs.length;
    for(String s:strs){
        boolean placed = false;
        for(List<String> group:ans){
           if(checkAnagram(group.get(0), s)){
            group.add(s);
            placed = true;
            break;
           }
        }
        if(!placed){
            List<String> newGroup = new ArrayList<>();
            newGroup.add(s);
            ans.add(newGroup);
        }
    }

    return ans;
}
private List<List<String>> groupAnagramsOptimized(String[] strs) {
    HashMap<String,List<String>> map = new HashMap<>();
    for(String s:strs){
       char words[] = s.toCharArray();
       Arrays.sort(words);
       String sortedWord = new String(words);
       if(!map.containsKey(sortedWord)){
        map.put(sortedWord,new ArrayList<>());
       }
       map.get(sortedWord).add(s); //Add rest of the words;
    }
    return new ArrayList<>(map.values());
}
private boolean checkAnagram(String a,String b){
    if(a.length()!=b.length()){
        return false;
    }
    int []freq = new int[26];
    for(char c:a.toCharArray()){
        freq[c-'a']++;
    }
    for(char c:b.toCharArray()){
        freq[c-'a']--;
    }
    for(int i = 0;i<freq.length;i++){
        if(freq[i]!=0){
            return false;
        }
    }
    return true;
 }

    public static void main(String[] args) {
    String []strs={"eat","tea","tan","ate","nat","bat"};
    // ["bat"],["nat","tan"],["ate","eat","tea"]]. => This will be our Output
    GroupAnangrams g = new GroupAnangrams();
    List<List<String>> ans = new ArrayList<>();
    for(int i = 0;i<strs.length;i++){
        ans.add(new ArrayList<>());
    }
    ans = g.groupAnagramsOptimized(strs);
    System.out.println(ans);
        
    }
    
}
