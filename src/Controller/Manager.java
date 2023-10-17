/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Repository.DictionaryRepository;
import Repository.InterfaceDictionaryRepository;
import View.Menu;
import java.util.HashMap;

/**
 *
 * @author QuaVi
 */
public class Manager extends Menu<String> {

    static String[] mc = {"1. Add new word.",
        "2. Delete word.",
        "3. Search word.",
        "4. Exit."};
    protected InterfaceDictionaryRepository repo;
    private HashMap<String, String> NewWord;

    public Manager() {
        super("\n\tDictionary PROGRAM", mc);
        repo = new DictionaryRepository();
        NewWord = new HashMap<>();
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1 ->
                repo.addNewWord(NewWord);
            case 2 ->
                repo.deleteWord(NewWord);
            case 3 ->
                repo.searchWord(NewWord);
            case 4 ->
                System.exit(0);

        }
    }
}
