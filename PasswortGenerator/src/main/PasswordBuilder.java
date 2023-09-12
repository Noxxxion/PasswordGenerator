package main;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//INTERFACE DEFINING A METHOD TO GENERATE A CHAR
interface CharacterGenerator {
    char generate();
}

public class PasswordBuilder {
	
	//METHOD WITH LAMBDA EXPRESION IMPLEMENTING THE CHARACTERGENERATOR INTERFACE FOR UPPERCASELETTERS
    private static CharacterGenerator randomUppercase = () -> {
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int randomIndex = new Random().nextInt(uppercase.length());
        return uppercase.charAt(randomIndex);
    };

    //METHOD WITH LAMBDA EXPRESION IMPLEMENTING THE CHARACTERGENERATOR INTERFACE FOR LOWERCASELETTERS
    private static CharacterGenerator randomLowercase = () -> {
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        int randomIndex = new Random().nextInt(lowercase.length());
        return lowercase.charAt(randomIndex);
    };

	//METHOD WITH LAMBDA EXPRESION IMPLEMENTING THE CHARACTERGENERATOR INTERFACE FOR NUMBERS
    private static CharacterGenerator randomNumber = () -> {
        String numbers = "0123456789";
        int randomIndex = new Random().nextInt(numbers.length());
        return numbers.charAt(randomIndex);
    };

	//METHOD WITH LAMBDA EXPRESION IMPLEMENTING THE CHARACTERGENERATOR INTERFACE FOR SYMBOLS
    private static CharacterGenerator randomSymbols = () -> {
        String symbols = "!@#$%^*(){}<>";
        int randomIndex = new Random().nextInt(symbols.length());
        return symbols.charAt(randomIndex);
    };

    
    public String passwordBuilder(int n, boolean u, boolean l, boolean nr, boolean s) {
        List<CharacterGenerator> optionsAvailable = new ArrayList<>();
        //ADD SELECTED CHARACTERGENERATOR TO LIST
        if (u) {
            optionsAvailable.add(randomUppercase);
        }
        if (l) {
            optionsAvailable.add(randomLowercase);
        }
        if (nr) {
            optionsAvailable.add(randomNumber);
        }
        if (s) {
            optionsAvailable.add(randomSymbols);
        }

        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < n; i++) {
        	//GENERATE A RANDOM INDEX TO SELECT A CHAR
            int randomOption = random.nextInt(optionsAvailable.size());
            //GENERATE A RANDOM CHAR FROM LIST
            char randomChar = optionsAvailable.get(randomOption).generate();
            sb.append(randomChar);
        }
        
        //CONVERT STRINGBUILDER TO STRING AND RETURN
        return sb.toString();
    }
}
