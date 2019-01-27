import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Company {
    private int negs;
    private int poss;
    private String company;
    public Company(String company){
        this.company = company;
        this.negs = 0;
        this.poss = 0;
    }
    public void incrementpos(){
        this.poss++;
    }
    public void incrementneg(){
        this.negs++;
    }
    public void enddata(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date) + "|" + company+"|"+poss+"|"+negs);
        //yyyy/MM/dd HH:mm:ss|company|pos|neg
    }
}
