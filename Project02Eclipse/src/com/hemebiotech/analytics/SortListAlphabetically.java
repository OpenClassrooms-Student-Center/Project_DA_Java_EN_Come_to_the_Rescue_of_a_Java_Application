package com.hemebiotech.analytics;

import java.util.Collections;
import java.util.List;


public class SortListAlphabetically{
    private List<String> listToSort;
    public SortListAlphabetically(List<String> listToSort){
        this.listToSort = listToSort;
    }


    /**
 * Order the list alphabetically
 */
    public List<String> SortList(){
        try {
            Collections.sort(listToSort);
            return (listToSort);
        } catch (Exception e) {
            return (null);
        }
            
        }
      
        
    }
