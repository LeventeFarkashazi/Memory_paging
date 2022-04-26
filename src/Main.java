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
                    references.add(Math.abs(Integer.parseInt(s)));
                }
            }
        }

        while (!references.isEmpty()) {
            int currentReference = references.get(0);
            references.remove(0);

            boolean pageFault = true;

            for (PageFrame pf : pageFrames) {
                if (pf.pageReference == currentReference) {
                    pf.used = true;
                    pageFault = false;
                    break;
                }
            }

            if (pageFault) {
                pageFaults++;
                boolean solvable = false;
                boolean solved = false;

                for (PageFrame pf : pageFrames) {
                    if(pf.pageLockTime==0)
                        solvable = true;
                }

                if (solvable){
                    while(!solved){
                        PageFrame pf = pageFrames.get(0);
                        pageFrames.remove(0);
                        if(!pf.used && pf.pageLockTime==0){
                            pf.pageReference = currentReference;
                            pf.pageLockTime = 4;
                            solved = true;
                            result.append(pf.frameID);

                        }else if(pf.used && pf.pageLockTime==0) {
                            pf.used = false;
                        }
                    }

                }else{
                    result.append("*");
                }

            } else {
                result.append("-");
            }

            //reduce lock times
            for (PageFrame pf : pageFrames) {
                if (pf.pageLockTime > 0) {
                    pf.pageLockTime--;
                }
            }
        }
        System.out.println(result);
        System.out.println(pageFaults);
    }
}


