import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.google.gson.*;
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
         JsonParser parser = new JsonParser();
        JsonObject a = parser.parse("{\"company\": \""+company+"\"}").getAsJsonObject();  
        JsonObject b = parser.parse("{\"pos\": \""+poss+"\"}").getAsJsonObject();
        JsonObject c = parser.parse("{\"neg\": \""+negs+"\"}").getAsJsonObject();
    }
}
