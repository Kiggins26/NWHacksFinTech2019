import java.util.*;
public class Pred 
{
	int pop=100,diff;
	double predPrice[]=new double[pop];
	double percErr,range;
	double mag;
	public Pred(int ran)	
	{
		range=100;
	}
	public void ret(int p,int n,double act, double strtPrice)
	{
		for(int i=0;i<100;i++)				//start price set
		{
			diff=p-n;
			if(diff<0) 
			{
				mag=(Math.random()*range);
				predPrice[i]=strtPrice-mag;
			}
			if(diff>0) 
			{
				mag=(Math.random()*range);
				predPrice[i]=strtPrice+mag;
			}
		}
	}
	public void nw(double strtPrice,double act)
	{	
		//repeat after every hour
		double min=0; //CHANGE THISSSSSS
		for(int i=0;i<100;i++)
		{
			percErr=(strtPrice-act)/act;
			if(percErr<min)
				min=percErr;
		}
				mag=min;
				
		for(int i=0;i<100;i++)
		{
			if(diff>=0)
				predPrice[i]=strtPrice+(mag);
			if(diff<0)
				predPrice[i]=-1*(strtPrice+(mag));
			range=range-0.5;
		}
	}
	public static void main(String args[])
	{
		//scrape stuff pass here
		//ret(1,2,3,4);
		Timer t = new Timer();
		t.schedule(new TimerTask() {
		    @Override
		    public void run() {
		       System.out.println("Hello World");
		    }
		}, 0, 5000);
	}
}


