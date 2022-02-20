import java.util.ArrayList;
import java.util.List;

/**
 * @Author: dongmengyang
 */
public class main {
    static class Oom{

    }
    public static void main(String[] args) {

        List<Oom> list = new ArrayList<Oom>();
        while(true){
            list.add(new Oom());
        }
    }
}
