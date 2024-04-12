package backtracking;

import java.io.*;

public class 골드5_2922_즐거운단어 {

    static char[] word;
    static int[] word_type;
    static char[] vowel = {'A', 'E', 'I', 'O', 'U'};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        word = br.readLine().toCharArray();
        br.close();
        bw.write(getCaseNum() + "\n");
        bw.flush();
        bw.close();
    }

    public static long findCase(int idx, int vowelNum, int consonantNum, int flag) {
        if (vowelNum >= 3 || consonantNum >= 3) {
            return 0;
        }
        if (idx == word.length) {
            return flag;
        }
        long result = 0;
        if (word_type[idx] == 0) {
            result += findCase(idx + 1, 0, consonantNum + 1, flag) * 20;
            result += findCase(idx + 1, vowelNum + 1, 0, flag) * 5;
            result += findCase(idx + 1, 0, consonantNum + 1, 1);
        } else {
            if (word_type[idx] == 1) {
                result += findCase(idx + 1, vowelNum + 1, 0, flag);
            } else {
                if (word_type[idx] == 3) {
                    result += findCase(idx + 1, 0, consonantNum + 1, 1);
                } else {
                    result += findCase(idx + 1, 0, consonantNum + 1, flag);
                }
            }
        }
        return result;
    }

    public static long getCaseNum() {
        word_type = new int[word.length];
        for (int i = 0; i < word.length; i++) {
            if (new String(vowel).indexOf(word[i]) != -1) {
                word_type[i] = 1;
            } else if (word[i] == 'L') {
                word_type[i] = 3;
            } else if (word[i] == '_') {
                word_type[i] = 0;
            } else {
                word_type[i] = 2;
            }
        }
        return findCase(0, 0, 0, 0);
    }
}
