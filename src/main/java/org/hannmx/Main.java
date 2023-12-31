package org.hannmx;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        int totalTests = 1000;
        Map<Integer, String> results = new HashMap<>();

        int switchWins = 0;
        int stayWins = 0;

        for (int i = 1; i <= totalTests; i++) {
            // Создаем три двери
            int winningDoor = new Random().nextInt(3) + 1;
            int chosenDoor = new Random().nextInt(3) + 1;

            // Открываем одну из невыбранных дверей, которая не является выигрышной
            int openedDoor;
            do {
                openedDoor = new Random().nextInt(3) + 1;
            } while (openedDoor == chosenDoor || openedDoor == winningDoor);

            // Предложение сменить выбор
            int remainingDoor = 6 - chosenDoor - openedDoor;

            // Подсчет побед при смене выбора и без смены
            if (remainingDoor == winningDoor) {
                switchWins++;
                results.put(i, "Switch Win");
            } else {
                stayWins++;
                results.put(i, "Stay Win");
            }
        }

        // Вывод статистики
        System.out.println("Победы при смене выбора: " + switchWins);
        System.out.println("Победы без смены выбора: " + stayWins);
        System.out.println("Результаты по шагам теста:");
        for (Map.Entry<Integer, String> entry : results.entrySet()) {
            System.out.println("Шаг " + entry.getKey() + ": " + entry.getValue());
        }
    }
}