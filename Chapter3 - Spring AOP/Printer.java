package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Printer {
    int paper_amount = 20;
    System.out.println("Paper amount: " + paper_amount);
}

