import java.io.*; 
import java.lang.*;
import java.util.ArrayList;

public class PolicyChecker2
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


    String pw;
    int p1;
    int p2;
    char c;
    for (int j = 0; j < data.size(); j++) {
      dataArray = data.get(j);
      c = dataArray[2].charAt(0);
      pw = dataArray[3];
      p1 = Integer.parseInt(dataArray[0]) - 1;
      p2 = Integer.parseInt(dataArray[1]) - 1;
      if ((((pw.charAt(p1) == c) && (pw.charAt(p2) != c))) || (((pw.charAt(p1) != c) && (pw.charAt(p2) == c)))) {
        validPasswords.add(pw);
      }
    }


    System.out.println("TOTAL VALID PASSWORDS:");
    System.out.println(validPasswords.size());
  }
}
