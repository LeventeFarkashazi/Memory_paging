import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        StringBuilder result = new StringBuilder();
        int pageFaults = 0;

        ArrayList<Integer> references = new ArrayList<>();

        ArrayList<PageFrame> pageFrames = new ArrayList<>();

        PageFrame A = new PageFrame('A');
        pageFrames.add(A);
        PageFrame B = new PageFrame('B');
        pageFrames.add(B);
        PageFrame C = new PageFrame('C');
        pageFrames.add(C);

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (!line.isEmpty()) {
                String[] splited = line.split(",");
                for (String s : splited) {
                    references.add(Integer.parseInt(s));
                }
            }
        }

        while (!references.isEmpty()) {
            int CurrentReference = references.get(0);
            references.remove(0);

            boolean pageFault = true;

            for (PageFrame pf : pageFrames) {
                if (pf.pageReference == CurrentReference) {
                    pageFault = false;
                    break;
                }
            }

            if (pageFault) {
                boolean solved = false;
                //TODO
            } else {
                result.append("-");
            }
        }
    }
}


