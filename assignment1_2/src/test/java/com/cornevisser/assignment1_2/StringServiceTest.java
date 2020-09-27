package com.cornevisser.assignment1_2;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {StringService.class, StorageRepository.class})
class StringServiceTest {
    @Mock
    StorageRepository _storageRepository;

    @InjectMocks
    StringService _stringService;


    @Test
    void reverser() {
        String word = "abc";

        String result = _stringService.reverser(word);

        assertEquals(result, "cba");
    }
}