package com.cornevisser.assignment1_2;

import org.springframework.stereotype.Service;

@Service
public abstract class ReversingService {
    public abstract String reverser(String text);
}
