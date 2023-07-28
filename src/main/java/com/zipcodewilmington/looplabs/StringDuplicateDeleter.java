package com.zipcodewilmington.looplabs;

import java.util.Arrays;

/**
 * Created by leon on 1/28/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class StringDuplicateDeleter extends DuplicateDeleter<String> {
    public StringDuplicateDeleter(String[] intArray) {
        super(intArray);
    }

    @Override
    public String[] removeDuplicates(int maxNumberOfDuplications) {
        boolean[] toKeep = new boolean[array.length];
        Arrays.fill(toKeep, true);
        int startingIdx = 0;
        int count = 0;
        int idx = 0;
        int minusLength = 0;
        while(idx <= array.length){
            if(idx == array.length){
                if(count >= maxNumberOfDuplications){
                    for(int i = startingIdx; i < idx; i++){
                        toKeep[i] = false;
                    }
                    minusLength += count;
                }
            }
            else if(array[idx].equals(array[startingIdx])){
                count++;
            }
            else {
                // the two elements are not equal
                if (count >= maxNumberOfDuplications) {
                    for (int i = startingIdx; i < idx; i++) {
                        toKeep[i] = false;
                    }
                    minusLength += count;
                }
                startingIdx = idx;
                count = 1;
            }
            idx++;
        }
        // now populate the new array with the elements to not remove
        String[] result = new String[array.length - minusLength];
        startingIdx = 0;
        for(int i = 0; i < array.length; i++){
            if(toKeep[i]){
                result[startingIdx++] = array[i];
            }
        }
        return result;
    }

    @Override
    public String[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        boolean[] toRemove = new boolean[array.length];
        Arrays.fill(toRemove, false);
        int startingIdx = 0;
        int count = 0;
        int idx = 0;
        int minusLength = 0;
        while(idx <= array.length){
            if(idx == array.length){
                if(count == exactNumberOfDuplications){
                    for(int i = startingIdx; i < idx; i++){
                        toRemove[i] = true;
                    }
                    minusLength += exactNumberOfDuplications;
                }
            }
            else if(array[idx].equals(array[startingIdx])){
                count++;
            }
            else {
                // the two elements are not equal
                if (count == exactNumberOfDuplications) {
                    for (int i = startingIdx; i < idx; i++) {
                        toRemove[i] = true;
                    }
                    minusLength += exactNumberOfDuplications;
                }
                startingIdx = idx;
                count = 1;
            }
            idx++;
        }
        // now populate the new array with the elements to not remove
        String[] result = new String[array.length - minusLength];
        startingIdx = 0;
        for(int i = 0; i < array.length; i++){
            if(toRemove[i]){
                continue;
            }
            result[startingIdx++] = array[i];
        }
        return result;
    }
}
