import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Advent_Exercise2 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            ArrayList<ArrayList<Integer>> directions = new ArrayList();
            directions.add(new ArrayList<Integer>());
            directions.add(new ArrayList<Integer>());

            String readString;
            int vpos = 0, hpos = 0, counter = 0, aim = 0;

            while ((readString = br.readLine()) != null) {
                switch(readString.split(" ")[0]){
                    case "forward":
                        directions.get(0).add(0);
                        directions.get(1).add(Integer.parseInt(readString.split(" ")[1]));
                        break;

                    case "down":
                        directions.get(0).add(1);
                        directions.get(1).add(Integer.parseInt(readString.split(" ")[1]));
                        break;

                    case "up":
                        directions.get(0).add(2);
                        directions.get(1).add(Integer.parseInt(readString.split(" ")[1]));
                        break;
                }
            }

            for(int n : directions.get(0)) {
                switch(n){
                    case 0:
                        hpos+= directions.get(1).get(counter);
                        vpos+= (directions.get(1).get(counter) * aim);
                        counter++;
                        break;

                    case 1:
                        aim+= directions.get(1).get(counter);
                        counter++;
                        break;

                    case 2:
                        aim-= directions.get(1).get(counter);
                        counter++;
                        break;
                }
            }

            System.out.println("The horizontal position is: " + hpos);
            System.out.println("The vertical position is: " + vpos);
            System.out.println("The vertical*horizontal value is: " + (vpos * hpos));


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
