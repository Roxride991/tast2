package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ввод значения X (не используется в данном примере, но может быть полезен)
        double X = sc.nextDouble();

        // Массив точностей
        double[] E = {1e-3, 1e-4, 1e-5, 1e-6};

        // Оформляем таблицу
        System.out.printf("%-10s %-15s %-10s%n", "Epsilon", "Sum", "Terms");

        // Для каждой точности считаем сумму и количество учтённых слагаемых
        for (double epsilon : E) {
            double sum = 0;  // Сумма ряда
            int n = 0;       // Количество слагаемых
            double term;     // Текущее слагаемое
            int i = 1;       // Начинаем с 1

            // Цикл суммирования ряда
            do {
                // Вычисляем текущее слагаемое
                term = Math.pow(-1, i) / Math.pow(2 * i + 1, 2);

                // Добавляем слагаемое к сумме
                sum += term;

                // Увеличиваем индекс
                i++;
                n++;  // Увеличиваем количество слагаемых
            } while (Math.abs(term) >= epsilon);  // Условие остановки по точности

            // Выводим результат для данной точности
            System.out.printf("%-10.0e %-15.6f %-10d%n", epsilon, sum, n);
        }
    }
}
