package ballrun;

import pond.Duck;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.File;

public class Pond implements Serializable{
    private int size=10;
    public static void main(String[] args) {
        //Pond myPond=new Pond();
        Duck duck=new Duck("duck",1);
        System.out.println("sdfgztj");
        try{
           File file=new File("Pond.ser");
            System.out.println("gfxhdfz "+file.getPath());
           FileOutputStream fileStream=new FileOutputStream(file);
           ObjectOutputStream objStream= new ObjectOutputStream(fileStream);
           objStream.writeObject(duck);
           objStream.close();
        }
        catch(Exception exception){
            exception.printStackTrace();
        }
    }
    public int getPondSize(){
        return size;
    }
}

