import java.io.File;
import java.io.IOException;
import java.util.*;
public class Pred{
    private static int iter = 1;
    private double[] pop = new double[100];
    private String name;
    private double startPrice;
    private int numberOfNeg;
    private int numberOfPos;
    private double finalpred;
    private double margin;
    private double range;
    private double actPrice;
    private double prevError;
    private double preError1;
    public Pred(String name,double startPrice, int numberOfNeg, int numberOfPos){
        this.name = name;
        this.startPrice = startPrice;
        this.numberOfNeg = numberOfNeg;
        this.numberOfPos = numberOfPos;
        this.margin = 0;
        this.range = 100;
        this.preError1 = 0;
    }
    public void setActPrice(double actPrice){
        this.actPrice = actPrice;
    }
    public void poppop(){
       double diff = (double) numberOfPos - (double) numberOfNeg;
        if(iter == 1){
            for(int i = 0; i < pop.length;i++){
                pop[i] = startPrice + (-1*diff/(-1*Math.abs(diff))*(Math.random() * 100));
                iter++;
            }
        }
        else{
            for(int i = 0; i < pop.length;i++){
                pop[i] = startPrice + (-1*diff/(-1*Math.abs(diff)))*(margin +(Math.random() * range));
                iter++;
            }
        }
    }
    public Double getFinalpred(){
        finalpred =  Arrays.stream(pop).average().orElse(Double.NaN);
        return finalpred;
    }
    public void getmargin(){ //can be faster with a modified binary search
        int lowestlocation = 0;
        double percenterror = 0;
        double percenterrorholder = 0;
        for(int i = 0; i < pop.length;i++){
            percenterror = (pop[i] - actPrice)/actPrice;
            if(percenterror < percenterrorholder){
                lowestlocation = i;
                prevError = percenterror;
            }
            percenterrorholder = percenterror;
        }
        margin = pop[lowestlocation] - startPrice;
        range =range - (prevError-preError1);
        preError1 = prevError;
    }
    public static String getKeys(String s1, String s2){
        double x = Double.parseDouble(s1)- Double.parseDouble(s2);
        if(x < 0){
            for(int i = -1; i > -100;i = i -9){
                if(x <= i && x >= i-9){
                    return ""+i + " - "+(i-9);
                }
            }
        }
        if(x > 0){
            for(int i = 1; i < 100;i = i +9){
                if(x <= i && x >= i+9){
                    return ""+i + " - "+(i+9);
                }
            }
        }
        return "0";
    }
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("Data.txt"));
        String[] data = s.nextLine().split("|");
        HashMap<String,Pred> stuff =  new HashMap<>();
		Timer t = new Timer();
		t.schedule(new TimerTask() {
		    @Override
		    public void run()
		    {
		        String[] data = s.nextLine().split("|");
		        String holder = getKeys(data[2],data[3]);
		        Pred val = stuff.get(holder);
		        if(val != null){

                }
                else{
		            stuff.put(holder, new Pred(data[1],100,Integer.parseInt(data[3]),Integer.parseInt(data[2])));
		            Pred newval = stuff.get(holder);
		            newval.poppop();
		            newval.setActPrice(150);
		            newval.getmargin();
		            System.out.println(newval.getFinalpred());
                        
                }

		    }
}, 0, 3600000);
    }
}
