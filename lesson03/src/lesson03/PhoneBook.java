package lesson03;

import java.util.TreeMap;
import java.util.TreeSet;

public class PhoneBook extends TreeMap<String, TreeSet<String>> {
    public void add(String ivName, String ivPhone){
        TreeSet<String> ltPhones = get(ivName);
        if (ltPhones != null)
            ltPhones.add(ivPhone);
        else{
            ltPhones = new TreeSet<String>();
            ltPhones.add(ivPhone);
            put(ivName, ltPhones);
        }
    }

    @Override
    public String toString(){
        String rvString = super.toString();
        return "*************************\nТелефонный справочник\n*************************\n"
                + rvString.replaceAll("], ", "],\n");
    }
}
