import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductWriter

{
    public static void main(String[] args) {


    ArrayList<String> personCSVData = new ArrayList<>();
    Scanner in = new Scanner(System.in);
    String ID = "";
    String name = "";
    String description = "";
    double cost = 0;
    String CSV = "";

    File workingDirectory = new File(System.getProperty("user.dir"));
    Path file = Paths.get(workingDirectory.getPath() + "\\src\\ProductTestData.txt");
    boolean done = false;
        do
    {
        ID = SafeInput.getNonZeroLenString(in, "Enter the ID Number");
        name = SafeInput.getNonZeroLenString(in, "Enter the name");
        description = SafeInput.getNonZeroLenString(in, "Enter the description");
        cost = SafeInput.getDouble(in, "Enter the Cost");

        CSV = ID +", " + name +", " + description+", " + cost ;
        personCSVData.add (CSV);
        done = SafeInput.getYNConfirm(in, "Are you done entering");


    }
        while(!done);
        for(String p:personCSVData)
        System.out.println(p);

        try
    {

        OutputStream out =
                new BufferedOutputStream(Files.newOutputStream(file, CREATE));
        BufferedWriter writer =
                new BufferedWriter(new OutputStreamWriter(out));



        for(String rec : personCSVData)
        {
            writer.write(rec, 0, rec.length());

            writer.newLine();
        }
        writer.close();
        System.out.println("Data file written!");
    }
        catch (IOException e)
    {
        e.printStackTrace();
    }


}

}

