package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<Character, Integer> chars = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        String file;
        try {
            System.out.println("File to analyse :");
            file = scan.next();
            File myObj = new File(file);
            Scanner reader = new Scanner(myObj);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                for(int i = 0; i < data.length(); i++){
                    if (chars.containsKey(data.charAt(i))){
                        chars.put(data.charAt(i),chars.get(data.charAt(i))+1);
                    }else{
                        chars.put(data.charAt(i),1);
                    }
                }
                //System.out.println(data);
            }
            reader.close();
            chars.forEach((k,v)->{
                System.out.println("'"+k+"' (unicode: "+(int)k+") : "+v);
            });
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            System.err.println(e.getMessage());
        }
    }
}
