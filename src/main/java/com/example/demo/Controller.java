package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class Controller {
    @RequestMapping(value="/test")
    String checkService(){
        return "Application is up";
    }
    @RequestMapping(value = "/checkpyramid/{word}", method = RequestMethod.GET)
    public Boolean checkPyramid(@PathVariable("word") String word) {
        boolean flag = true;
        String input = word.trim().toLowerCase();
        char[] char_array = input.toCharArray();
        Vector<Integer> cnt=new Vector<Integer>();
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for (char c : char_array) {
            if (hm.containsKey(c)) {

                // If char is present in hashmap,
                // incrementing it's count by 1
                hm.put(c, hm.get(c) + 1);
            } else {

                // If char is not present in hashmap,
                // putting this char to charCountMap with 1 as it's value
                hm.put(c, 1);
            }
        }

        for (Map.Entry entry : hm.entrySet()) {
            cnt.add((Integer) entry.getValue());
        }
     Collections.sort(cnt);
      System.out.println(cnt.toString());
        for(int i=0; i < cnt.size(); i++){
            if(cnt.get(i)!=i+1)
            {
                flag=false;
                break;
            }
        }
        return flag;
    }
}
