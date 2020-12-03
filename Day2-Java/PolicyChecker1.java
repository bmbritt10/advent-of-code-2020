import java.io.*; 
import java.lang.*;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PolicyChecker1
{
  public static void main(String[] args)throws Exception {
    File file = new File("passwords.txt"); 
    BufferedReader br = new BufferedReader(new FileReader(file)); 

    String st; 
    ArrayList<String> lines = new ArrayList<String>();
    ArrayList<String[]> data = new ArrayList<String[]>();
    String[] dataArray = new String[4];
    ArrayList<String> validPasswords = new ArrayList<String>();

    while ((st = br.readLine()) != null) 
      lines.add(st);

    String test = "";
    for (int i = 0; i < lines.size(); i++) {
      test = lines.get(i);
      dataArray = test.split(" ");
      String[] dataLine = new String[4];
      dataLine[0] = dataArray[0].split("-")[0];
      dataLine[1] = dataArray[0].split("-")[1];
      dataLine[2] = dataArray[1].replace(":","");
      dataLine[3] = dataArray[2];
      data.add(dataLine);
    }


    Pattern pattern;
    Matcher matcher;
    int count;

    for (int j = 0; j < data.size(); j++) {
      count = 0;
      dataArray = data.get(j);
      pattern = Pattern.compile("[^"+ dataArray[2] + "]*" + dataArray[2]);
      matcher = pattern.matcher(dataArray[3]);
      while (matcher.find()) {
        count++;
      }

      if ((Integer.parseInt(dataArray[0]) <= count) && (count <= Integer.parseInt(dataArray[1]))) {
        validPasswords.add(dataArray[3]);
      }
    }


    System.out.println("TOTAL VALID PASSWORDS:");
    System.out.println(validPasswords.size());
  }
}
