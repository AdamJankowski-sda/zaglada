import java.sql.Timestamp;
import java.time.Period;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {

    private HashMap<String, Period> PenaltyMap = new HashMap<>();

    public Program(){
        PenaltyMap.put("Mezczyzna? (y/n)",Period.ofMonths(120));
        PenaltyMap.put("Palisz papierosy?(y,n)",Period.ofMonths(111));
        PenaltyMap.put("Czy żyjesz w stresie?(y,n)",Period.ofMonths(0));




    }

    public void run(){
        Scanner input = new Scanner(System.in);
        Period period = Period.ofMonths(0);

        Timestamp start = new Timestamp(System.currentTimeMillis());
        List<Map.Entry<String,Period>> list = PenaltyMap.entrySet().stream().collect(Collectors.toList());

        for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i).getKey());
            String line = input.nextLine();
            if(line.charAt(0)=='y')
                 period = period.plus(list.get(i).getValue());

        }


        Timestamp end = new Timestamp(System.currentTimeMillis());

        double seconds = (end.getTime() - start.getTime() )/ 1000.0;

        Period lifespan = Period.ofMonths(1200).minusMonths(period.getMonths());

        System.out.println("Grats you have just wasted another "+seconds+" of your life on this test");
        System.out.println("Besides ... your gonna live just until you are "+
                lifespan.getMonths()/12+"y "+lifespan.getMonths()%12+"m  ... I have spoken");

    }

}
