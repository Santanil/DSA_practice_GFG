https://practice.geeksforgeeks.org/problems/word-ladder/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=word-ladder
https://www.youtube.com/watch?v=tRPda0rcf8E&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=29

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends

class Pair{
    String str;
    int step;
    Pair(String str,int step){
        this.str=str;
        this.step=step;
    }
}
class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        Queue<Pair> q=new LinkedList<>();
        Set<String> set=new HashSet<>();
        //add words to set
        for(String s:wordList)
            set.add(s);
            
        q.add(new Pair(startWord,1));
        
        while(!q.isEmpty()){
            Pair p=q.poll();
            String wrd=p.str;
            int d=p.step;
            int len=wrd.length();
            
            if(wrd.equals(targetWord)==true)
                return d;
            
            for(int i=0;i<len;i++){
                for(char ch='a';ch<='z';ch++){
                    char[] charArray=wrd.toCharArray();
                    charArray[i]=ch;
                    String newWord=new String(charArray);
                    
                    if(set.contains(newWord)==true){
                        set.remove(newWord);
                        q.add(new Pair(newWord,d+1));
                    }
                }
            }
            
        }
        return 0;
    }
}
