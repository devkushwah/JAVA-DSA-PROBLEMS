package Graph.BFS_And_DFS;
import java.util.*;

public class word_ladder_1 {
   static class Pair {
        String first;
        int second;
        Pair(String _first, int _second) {
            this.first = _first;
            this.second = _second;
        }
    }
    public static int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        // Creating a queue ds of type {word,transitions to reach ‘word’} or {word, steps}.
        Queue < Pair > q = new LinkedList < > ();

        // BFS traversal with pushing values in queue
        // when after a transformation, a word is found in wordList.
        q.add(new Pair(startWord, 1));

        // Push all values of wordList into a set
        // to make deletion from it easier and in less time complexity.
        Set < String > st = new HashSet<>();
        int len = wordList.length;
        for (int i = 0; i < len; i++) {
            st.add(wordList[i]);
        }
        st.remove(startWord);

        // yha se bfs() start hai
        while (!q.isEmpty()) {
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();

            // we return the steps as soon as
            // the first occurrence of targetWord is found.
            if (word.equals(targetWord)) return steps;

            // Now, replace each character of ‘word’ with char
            // from a-z then check if ‘word’ exists in wordList.
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    //aur ek char Array banakr isme daal diya = humne is word ko toda aur character array bana diya
                    char[] replacedCharArray = word.toCharArray();
                    // i = 0, 1, 2 { 1st letter, 2nd letter, 3rd letter } of word
                    replacedCharArray[i] = ch;  // ye character replace ho raha hai word mese, jo word Array me hai
                    // replaced hone ke baad array ko String bana diya
                    String replacedWord = new String(replacedCharArray);

                    // agar ye sab replaces karke koi set wala word mile to usko set se hata denge taaki baadme koi
                    // revisiting na ho aur queue me daal denge aur step++ krdenge
                    if (st.contains(replacedWord)) {
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord, steps + 1));
                    }
                }

            }
        }
        // If there is no transformation sequence possible
        // agar queue khaali hai iska mtlb set ke saare words check ho gaye jitne steps bhadne the wo bhad gaye
        return 0;
    }


    public static void main(String[] args){
       // ye humne first and last word de diya iska matlb hai first word se last word tak kitne changes huye hai
        String startWord = "der", targetWord = "dfs";
        String[] wordList = {
                "des",
                "der",
                "dfr",
                "dgt",
                "dfs"
        };


        int ans = wordLadderLength(startWord, targetWord, wordList);

        System.out.print(ans);

        System.out.println();
    }
}



