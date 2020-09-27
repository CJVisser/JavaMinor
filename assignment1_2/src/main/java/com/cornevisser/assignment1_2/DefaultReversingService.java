package com.cornevisser.assignment1_2;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("default")
public class DefaultReversingService extends ReversingService {
    public String reverser(String text) {
        return new StringBuilder(text).reverse().toString();
    }
}
