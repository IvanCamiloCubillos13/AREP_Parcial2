package com.edu.eci.Math;

import java.util.LinkedList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
    @GetMapping("/tribonacci")
    public Tribonacci tribonacci(@RequestParam int numero){
        LinkedList<Integer> secuencia = getTribonacci(numero);
        return new Tribonacci("Secuencia de Tribonacci",numero, secuencia);
    }

    public LinkedList<Integer> getTribonacci(int numero){
        LinkedList<Integer> secuencia = new LinkedList<>();
        for(int i=0;i<=numero+1;i++){
            secuencia.add(tribonacciNum(i));
        }
        secuencia.remove();
        return secuencia;
    }

    public int tribonacciNum(int numero){
        if(numero<0){
            return 0;
        }
        if(numero==3){
            return tribonacciNum(numero-1) + tribonacciNum(numero-2)+1;
        }
        return tribonacciNum(numero-1) + tribonacciNum(numero-2)+tribonacciNum(numero-3);
    }
}
