/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import Common.Validation;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DictionaryDao {
    private static DictionaryDao instance = null;
    private HashMap<String, String> dictionary;

    private DictionaryDao() {
        dictionary = new HashMap<>();
        load(); // Load data when the DictionaryDao is created.
    }

    public static DictionaryDao Instance() {
        if (instance == null) {
            synchronized (DictionaryDao.class) {
                if (instance == null) {
                    instance = new DictionaryDao();
                }
            }
        }
        return instance;
    }

    public void addNewWord(HashMap<String, String> NewWord) {
        System.out.print("Enter English: ");
        String english = Validation.checkInputString();
        if (checkKeywordExist(english)) {
            if (!Validation.checkInputYN()) {
                return;
            }
        }
        System.out.print("Enter Vietnamese: ");
        String vietnam = Validation.checkInputString();
        dictionary.put(english, vietnam);
        save(); // Save data after adding a new word.
        System.err.println("Add successful.");
    }

    public void deleteWord(HashMap<String, String> NewWord) {
        System.out.print("Enter English to delete: ");
        String english = Validation.checkInputString();
        if (dictionary.remove(english) != null) {
            save(); // Save data after deleting a word.
            System.err.println("Delete successful.");
        } else {
            System.err.println("Word not found in the dictionary.");
        }
    }

    public void translate(HashMap<String, String> NewWord) {
        System.out.print("Enter English to translate: ");
        String english = Validation.checkInputString();
        String vietnamese = dictionary.get(english);
        if (vietnamese != null) {
            System.out.println("Vietnamese: " + vietnamese);
        } else {
            System.err.println("Not found in data");
        }
    }

    public void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader("dictionary.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    dictionary.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading data: " + e.getMessage());
        }
    }

    public void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dictionary.txt"))) {
            for (Map.Entry<String, String> entry : dictionary.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }

    public boolean checkKeywordExist(String english) {
        return dictionary.containsKey(english);
    }
}
