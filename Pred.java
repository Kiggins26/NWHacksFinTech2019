import java.util.*;
public class Pred 
{
	int pop=100,diff,n,p;
	double predPrice[]=new double[pop];
	double percErr,act,strtPrice,mag,range;
	String cmpName;

	public Pred(int pos,int neg,double actp, double strtP, String name)	
	{
		p=pos;
		n=neg;
		act=actp;
		strtPrice=strtP;
		range=100;
		cmpName=name;
	}
	
	public void calcPredPrice()
	{
		for(int i=0;i<100;i++)			
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
	public void everyHour()
	{	
		double min=99999999; 
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
	public double[] getPred()
	{
		return predPrice;
	}
	public static void main(String args[])
	{
		//scrape stuff pass here
		Pred obj=new Pred(1,2,3,4,"nanithefuck"); //int pos,int neg,double actualprice, double startingprice, string name
		obj.calcPredPrice();
		Timer t = new Timer();
		t.schedule(new TimerTask() {
		    @Override
		    public void run() 
		    {
		    	System.out.println(obj.getPred());
		       obj.everyHour();
		    }
		}, 0, 3600000);
	}
}


