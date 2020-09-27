package com.cornevisser.assignment1_2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = StorageRepository.class)
class StorageRepositoryTest {
    @InjectMocks
    StorageRepository _storageRepository;

    @Test
    void save_does_save() {
        String word = "abc";
        int score = 3;
        _storageRepository.Save(word, score);

        Assert.notEmpty(_storageRepository._doneWords);
    }

    @Test
    void save_does_not_save_when_data_already_present(){
        String word = "abc";
        int score = 3;
        _storageRepository.Save(word, score);
        _storageRepository.Save(word, score);

        Assert.isTrue(_storageRepository._doneWords.size() == 1);
    }

    @Test
    void doesScoreExist_not_found() {
        String word = "abc";
        int result = _storageRepository.DoesScoreExist(word);

        Assert.isTrue(result == -1);
    }

    @Test
    void doesScoreExist_found() {
        String word = "abc";
        int score = 3;
        _storageRepository.Save(word, score);

        int result = _storageRepository.DoesScoreExist(word);

        Assert.isTrue(result == score);
    }
}