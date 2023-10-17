/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import java.util.HashMap;

/**
 *
 * @author QuaVi
 */
public interface InterfaceDictionaryRepository {

    void addNewWord(HashMap<String, String> NewWord);

    void deleteWord(HashMap<String, String> NewWord);

    void searchWord(HashMap<String, String> NewWord);

}
