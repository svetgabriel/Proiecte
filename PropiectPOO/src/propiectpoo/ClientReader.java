
package propiectpoo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClientReader {
    public static List<Client> citesteClienti(String numefis){
        List <Client> c = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(numefis))){
            String linie;
            while((linie = br.readLine()) != null){
                String[] info = linie.split(" ");
                String nume = info[0];
                String prenume = info[1];
                String cnp = info[2];
                Client client = new Client(nume,prenume,cnp);
                c.add(client);
            }
            br.close();
        }
        
        catch (IOException e) {
            e.printStackTrace();
        }
        return c;
    }
}
