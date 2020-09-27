package com.cornevisser.assignment1_2;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class StorageRepository {
    HashMap<String, Integer> _doneWords = new HashMap<>();

    public void Save(String word, int score){
        _doneWords.putIfAbsent(word, score);
    }

    public int DoesScoreExist(String word){
        int result = _doneWords.getOrDefault(word, -1);

        return result;
    }
}
