/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DataAccess.DictionaryDao;
import java.util.HashMap;

/**
 *
 * @author QuaVi
 */
public class DictionaryRepository implements InterfaceDictionaryRepository {
    private HashMap<String, String> NewWord ;
    public DictionaryRepository(){
        this.NewWord = new HashMap<>();
    }
@Override
    public void addNewWord(HashMap<String, String> NewWord) {
        DictionaryDao.Instance().addNewWord(NewWord);
    }
    @Override
    public void deleteWord(HashMap<String, String> NewWord) {
        DictionaryDao.Instance().deleteWord(NewWord);
    }
    @Override
    public void searchWord(HashMap<String, String> NewWord) {
        DictionaryDao.Instance().translate(NewWord);
    }
}
