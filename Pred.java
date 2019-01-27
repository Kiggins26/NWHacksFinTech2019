import java.util.*;
public class Pred{
    private static int iter = 1;
    private double[] pop = new double[100];
    private double startPrice;
    private int numberOfNeg;
    private int numberOfPos;
    private double finalpred;
    private double margin;
    private double range;
    private double actPrice;
    private double prevError;
    private double preError1;
    public Pred(double startPrice, int numberOfNeg, int numberOfPos, double margin){
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
                pop[i] = startPrice + (diff/(-1*diff))*(Math.random() * 100);
                iter++;
            }
        }
        else{
            for(int i = 0; i < pop.length;i++){
                pop[i] = startPrice + (diff/(-1*diff))*(margin +(Math.random() * range));
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

    public static void main(String[] args) {

        /*Pred obj=new Pred(1,2,3,4,"nanithefuck"); //int pos,int neg,double actualprice, double startingprice, string name
		obj.calcPredPrice();
		Timer t = new Timer();
		t.schedule(new TimerTask() {
		    @Override
		    public void run() 
		    {
		    	System.out.println(obj.getPred());
		       obj.everyHour();
		    }
}, 0, 3600000);*/
    }
}
