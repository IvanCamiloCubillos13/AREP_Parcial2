package com.edu.eci.Math;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
    @GetMapping("/tribonacci")
    public Tribonacci tribonacci(@RequestParam int numero){
        List<Integer> secuencia = getTribonacci(numero,0);
        return new Tribonacci(numero, secuencia);
    }

    public int getTribonacci(Integer numero, int contador){
        
        if(contador<=3){
            return 0;
        }

        if(contador==numero){
            return secuencia;
        } 
        
        secuencia.add(contador+anterior1+anterior2);
        return getTribonacci(numero,contador+1);
    }
}
