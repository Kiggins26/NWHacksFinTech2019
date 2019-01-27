import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class DataInterp {
    public static void main(String[] args) throws IOException {
        Scanner dataReader = new Scanner(new File("test.txt"));
        String[] negWords = {"fraud","fined","left","trouble","nervous"," shutting down","scam","harms","expensive","costly","shrinks","decrease","bad","bad news",
                "awful","alarming","contradictory","dishonorable","dirty","faulty","hostile","malicious","offensive","oppressive"};
        String[] posWords = {"first","better","develop","lets you", "new","product","love","built","sale","getting","fast","adding","will support","donation",
                "good","good news"};
        Company facebook = new Company("facebook");
        Company google = new Company("google");
        Company apple = new Company("apple");
        Company amazon = new Company("amazon");
        Company netflix = new Company("netflix");
        String holder = "";
        String holder1 = "";
        Scanner holderreader = new Scanner(holder);
        while (dataReader.hasNextLine()){
            holder = dataReader.nextLine();
            holderreader = new Scanner(holder);
            if(holder.contains("facebook")){
                while(holderreader.hasNext()){
                    holder1 = holderreader.next();
                    if(Arrays.stream(negWords).anyMatch(holder1::equals) && !Arrays.stream(posWords).anyMatch(holder1::equals)){
                     facebook.incrementneg();
                    }
                    if(!Arrays.stream(negWords).anyMatch(holder1::equals) && Arrays.stream(posWords).anyMatch(holder1::equals)){
                        facebook.incrementpos();
                    }
                }
            }
            if(holder.contains("google")){
                while(holderreader.hasNext()){
                    holder1 = holderreader.next();
                    if(Arrays.stream(negWords).anyMatch(holder1::equals) && !Arrays.stream(posWords).anyMatch(holder1::equals)){
                        google.incrementneg();
                    }
                    if(!Arrays.stream(negWords).anyMatch(holder1::equals) && Arrays.stream(posWords).anyMatch(holder1::equals)){
                        google.incrementpos();
                    }
                }
            }
            if(holder.contains("apple")){
                while(holderreader.hasNext()){
                    holder1 = holderreader.next();
                    if(Arrays.stream(negWords).anyMatch(holder1::equals) && !Arrays.stream(posWords).anyMatch(holder1::equals)){
                        apple.incrementneg();
                    }
                    if(!Arrays.stream(negWords).anyMatch(holder1::equals) && Arrays.stream(posWords).anyMatch(holder1::equals)){
                        apple.incrementpos();
                    }
                }
            }
            if(holder.contains("amazon")){while(holderreader.hasNext()){
                holder1 = holderreader.next();
                if(Arrays.stream(negWords).anyMatch(holder1::equals) && !Arrays.stream(posWords).anyMatch(holder1::equals)){
                    amazon.incrementneg();
                }
                if(!Arrays.stream(negWords).anyMatch(holder1::equals) && Arrays.stream(posWords).anyMatch(holder1::equals)){
                    amazon.incrementpos();
                }
            }
            }
            if(holder.contains("netflix")){
                while(holderreader.hasNext()){
                    holder1 = holderreader.next();
                    if(Arrays.stream(negWords).anyMatch(holder1::equals) && !Arrays.stream(posWords).anyMatch(holder1::equals)){
                        netflix.incrementneg();
                    }
                    if(!Arrays.stream(negWords).anyMatch(holder1::equals) && Arrays.stream(posWords).anyMatch(holder1::equals)){
                        netflix.incrementpos();
                    }
                }
            }

        }
        try{
            FileWriter writer = new FileWriter("Data.txt",true);
            writer.write(facebook.enddata() + "\n");
            writer.write(amazon.enddata()+ "\n");
            writer.write(apple.enddata()+ "\n");
            writer.write(netflix.enddata()+ "\n");
            writer.write(google.enddata()+ "\n");

        }
        catch(Exception e){
            System.out.println();
        }
    }
}



