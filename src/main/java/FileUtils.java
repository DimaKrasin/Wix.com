import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class FileUtils {

    public Map<String,String> readAlphabetAsMap(String alphabetFileName){

        Map<String,String> alphabet = new HashMap<String, String>();

        String[] charWithValueCouples = readFile(alphabetFileName).split("\n");

        for(int i=0;i<charWithValueCouples.length;i++){
            String[] tmp = charWithValueCouples[i].split(" ");
            alphabet.put(tmp[0],tmp[1]);
        }

        return  alphabet;
    }

    private String readFile(String fileName){

        //InputStream inputStream =   getClass().getResourceAsStream(fileName);
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);

        String result = null;

        try(BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            result = br.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }


}
