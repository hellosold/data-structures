import java.util.Arrays;

public class Sort {
    public static void sortAB (String[] letters) {
        int i = 0;
        int j = letters.length - 1;

        while (i < j) {
            while (i < j && letters[i].equals("A")) {
                i++;
            }
            while (i < j && letters[j].equals("B")){
                j--;
            }
            if (i < j) {
                letters[i] = "A";
                letters[j] = "B";
                i++;
                j--;
            }
        }
        System.out.println(Arrays.toString(letters));
    }

    public static void sortAB2 (String[] letters) {
        int i = 0;
        int j = letters.length - 1;

        while (i != j) {
            if (letters[i].equals("A")) {
                i++;
            } else if(letters[j].equals("B")){
                j--;
            } else {
                letters[i] = "A";
                letters[j] = "B";
            }
        }
        System.out.println(Arrays.toString(letters));
    }
    public static String sortAndFindWinner(String[] votes) {
        // FILL IN CODE
        int i = 0;
        int j = votes.length - 1;

        while (i < j) {
            while (i < j && (votes[j].compareTo("B")) > 0) {
                j--;
            }
            while (i < j && (votes[i].compareTo("C")) < 0) {
                i++;
            }
            if (i < j) {
                String temp = votes[i];
                votes[i] = votes[j];
                votes[j] = temp;
            }
        }
        System.out.println(Arrays.toString(votes));
        return "";//
    }
    public static void main (String[] args) {
        String[] s = {"A", "A","A", "B", "A", "B"};
        sortAB2(s);
        String[] votes = {"A", "B", "A", "C", "A", "A", "A", "B", "C", "A", "B"};
        sortAndFindWinner(votes);
    }

}
