package Mod01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListExercise {

    public static void main(String[] args) {
        //songs();
        //ages();
        puppy();

    }

    public static void songs(){
        List<String> songs = new ArrayList<>(List.of("SaveYourTears", "Tourner Dans Le Vide", "Animals"));
        Collections.sort(songs);
        System.out.println(songs);
        songs.remove(0);
        System.out.println(songs);
    }

    public static void ages(){
        ArrayList<Integer> ages = new ArrayList<>(List.of(22, 24, 26, 27));
        Collections.sort(ages);

        ArrayList<Integer> ages2 = new ArrayList<>(List.of(ages.get(0) * 2, ages.get(1) * 2, ages.get(2) * 2, ages.get(3) * 2));
        System.out.println("ages multiplied by 2: "  + ages2);

        int sum = 0;
        for (int age : ages){
            sum += age;
        }
        System.out.println("Sum: " + sum);

        int sum2 = 0;
        int counter = 0;
        for (int age : ages){
            sum2 += age;
            counter++;
        }
        System.out.println("Average: " + (sum2/counter));

    }

    public static void puppy() {
        Puppy puppy = new Puppy("jonny", "pitbull");
        Puppy puppy2 = new Puppy("chad", "chihuahua");
        Puppy puppy3 = new Puppy("scary dog", "wolfdog");

        ArrayList<Puppy> puppies = new ArrayList<>(List.of(puppy, puppy2, puppy3));
        puppies.remove(puppies.size() - 1);
        puppies.add(new Puppy("canelo", "destroyer"));

        int index = 0;
        for (Puppy pup : puppies){
          System.out.println(index+1 + ". Puppy's name: " + puppies.get(index).getName() + " | " + " Puppy's breed: " + puppies.get(index).getBreed());
          index++;
        }

        System.out.println( "\n" + index + " puppies");
    }


}
