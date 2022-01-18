package com.company;

import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here

        // NIVÅ 1:
        // # 1: Skapa en lista med 10 olika siffror
        List<Integer> numberList = List.of(6, 6, 6, 55, 122, 9, 448, 2, 2550, 3);


        // # 2: Skapa en stream av din sifferlistaa som plockar ut alla siffror större än 3 och samlar dessa i en lista
        numberList
                .stream()
                .filter(number -> number > 3)
                .toList()
                .forEach(System.out::println);
        System.out.println("-----");

        // # 3: Skapa en stream av din sifferlista som multiplicerar alla tal med 7 och sedan samlar dessa i en ny lista
        numberList
                .stream()
                .map(number -> number * 7)
                .toList()
                .forEach(System.out::println);
        System.out.println("-----");


        // # 4: Skapa en stream som sorterar alla dina tal i storleksordning och sedan samlar dessa i en ny lista
        numberList
                .stream()
                .sorted()
                .toList()
                .forEach(System.out::println);
        System.out.println("-----");


        // # 5: Skapa en stream av din sifferlista som filtrerar bort alla värden över 10'
        // och sedan multiplicerar de som är kvar med 5,
        // sorterar dessa från högst till lägst,
        // plockar bort ev. multipler (dubletter etc)
        // och slutligen skriver ut de tre högsta värdena.
        numberList
                .stream()
                .filter(number -> number < 10)
                .map(number -> number * 5)
                .sorted(Comparator.reverseOrder())
                .distinct()
                .limit(3)
                .forEach(System.out::println);
        System.out.println("----");


        // NIVÅ 2:
        // 1. Skapa en lista med 7 anställda som har ett namn, lön och en könsidentitet
        List<Employees> employeesList = List.of(
                new Employees("Haris", 25_000, "Male"),
                new Employees("Karl", 35_000, "Male"),
                new Employees("Albin", 28_000, "Male"),
                new Employees("Filip", 40_000, "Male"),
                new Employees("Linda", 22_500, "Female"),
                new Employees("Johanna", 30_000, "Female"),
                new Employees("Sofie", 20_000, "Female"));


        // 2. Plocka ut en lista med de anställda rankade 3 till 5 i lönelistan (dvs den som tjänar 3:e,4:e och 5:e mest).
        employeesList
                .stream()
                .sorted(Comparator.comparing(Employees::getSalary).reversed()) // Hight to low salary
                .skip(2)
                .limit(3)
                .toList()
                .forEach(System.out::println);
        System.out.println("----");

        // 3. Plocka ut en lista med (enbart) den kvinna som har nästa högst lön.
        employeesList
                .stream()
                .filter(sex -> sex.getSex().equals("Female"))
                .sorted(Comparator.comparing(Employees::getSalary).reversed())
                .skip(1)
                .limit(1)
                .toList()
                .forEach(System.out::println);
        System.out.println("----");

        // 4. Räkna ut hur många olika angivna könsidentiteter som finns bland dina anställda (man, kvinna osv)

        System.out.println(
                employeesList
                        .stream()
                        .map(Employees::getSex)
                        .distinct()
                        .toList()
                        .size()
        );


        System.out.println("----");

        // 5. Returnera sant eller falskt beroende på om det är någon av dina 3 högst betala anställda är en kvinna.
        System.out.println(
                employeesList
                        .stream()
                        .sorted(Comparator.comparing(Employees::getSalary).reversed())
                        .anyMatch(employees -> employees.getSex().equals("Female"))
        );


    }
}
