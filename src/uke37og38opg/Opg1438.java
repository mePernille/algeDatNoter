package uke37og38opg;

public class Opg1438 {
    public static void f(int a, Integer b) { }

    public static void f(Integer a, int b) { }

    public static void main(String[] args) {
        f(1, (Integer) 1); // om man ikke konvertere en af tallene vet ikke intelleJ hvilken metode den skal vælge

    }
}
