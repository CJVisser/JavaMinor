package com.cornevisser.assignment1_2;

import org.springframework.stereotype.Service;

@Service
public class StringService {

    private StorageRepository _repository;

    public StringService(StorageRepository repository){
        _repository = repository;
    }

    public String reverser(String text) {
        return new StringBuilder(text).reverse().toString();
    }

    public int counter(String text){
        int result = _repository.DoesScoreExist(text);

        if(result == -1){
            result = text.split(" ").length;

            _repository.Save(text, result);
        }

        return result;
    }
}
