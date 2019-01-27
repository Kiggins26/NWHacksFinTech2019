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
    public Pred(String name,double startPrice, int numberOfNeg, int numberOfPos, double margin){
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
                pop[i] = startPrice + (-1*diff/(-1*Math.abs(diff))*(Math.random() * 100);
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
    public void getFinalpred(){
        finalpred =  Arrays.stream(pop).average().orElse(Double.NaN);
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
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("Data.txt"));
        String[] data = s.nextLine().split("|");
        HashMap<String,Pred> stuff =  new HashMap<>();
        
        
		Timer t = new Timer();
		t.schedule(new TimerTask() {
		    @Override
		    public void run()
		    {
		    	
		    }
}, 0, 3600000);
    }
}
