package com.edu.eci.Math;

import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
    @GetMapping("/tribonacci")
    public Tribonacci tribonacci(@RequestParam int numero){
        LinkedList<Integer> secuencia = getTribonacci(numero,0);
        return new Tribonacci(numero, secuencia);
    }

    public LinkedList<Integer> getTribonacci(int numero, int contador){
        LinkedList<Integer> secuencia = new LinkedList<>();
        
        secuencia.add(0);
        return getTribonacci(numero,contador+1);
    }
}
