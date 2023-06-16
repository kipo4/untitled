import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.LinkedList;

public class ex1 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        LinkedList<Double> list = new LinkedList<Double>();
        while (true) {
            if (in.nextToken() == StreamTokenizer.TT_EOF)
                break;
            list.addFirst(Math.sqrt(in.nval));
        }
        for (Double i : list)
            System.out.printf("%.4f\n", i);
    }
}
