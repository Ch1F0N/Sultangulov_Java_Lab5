package multisport;

import java.util.*;

public class Multisport {

    private static class Athlete {
        String surname;
        String name;
        int[] scores;
        int totalScore;
        int rank;

        Athlete(String surname, String name, int[] scores) {
            this.surname = surname;
            this.name = name;
            this.scores = scores;
            this.totalScore = Arrays.stream(scores).sum();
        }

        @Override
        public String toString() {
            return surname + " " + name + " " + totalScore + " " + rank;
        }
    }

    public static void processAthletes(int N, int M, List<String> athleteLines) {
        if (N <= 0 || N >= 1000) {
            throw new IllegalArgumentException("N должно быть 1 ≤ N < 1000.");
        }
        if (M <= 0) {
            throw new IllegalArgumentException("M должно быть > 0.");
        }
        if (athleteLines.size() != N) {
            throw new IllegalArgumentException("Количество строк с данными не соответствует N.");
        }

        List<Athlete> athletes = new ArrayList<>();

        for (String line : athleteLines) {
            String[] parts = line.trim().split(" ");
            if (parts.length != 2 + M) {
                throw new IllegalArgumentException("Неверный формат строки: " + line);
            }

            String surname = parts[0];
            String name = parts[1];

            int[] scores = new int[M];
            for (int i = 0; i < M; i++) {
                try {
                    scores[i] = Integer.parseInt(parts[2 + i]);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Баллы должны быть целыми числами в строке: " + line);
                }
            }

            athletes.add(new Athlete(surname, name, scores));
        }

        athletes.sort((a, b) -> Integer.compare(b.totalScore, a.totalScore));

        int currentRank = 1;
        for (int i = 0; i < athletes.size(); i++) {
            if (i > 0 && athletes.get(i).totalScore == athletes.get(i - 1).totalScore) {
                athletes.get(i).rank = athletes.get(i - 1).rank;
            } else {
                athletes.get(i).rank = currentRank;
            }
            currentRank++;
        }

        System.out.println("\nРезультаты соревнований:");
        for (Athlete a : athletes) {
            System.out.println(a);
        }
    }
}
