package com.cornevisser.assignment1_2;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("caps")
public class CapsReversingService extends ReversingService {
    public String reverser(String text) {
        return text.toUpperCase();
    }
}
