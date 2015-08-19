package Life;

import java.util.ArrayList;
import java.util.List;

public class Life implements Runnable {
    static int n;
    static int k;

    public void run() {
        LifeFrame frame = new LifeFrame(n, k);
        LifePanel lifePanel = new LifePanel();
        frame.add(lifePanel);

        int count, cycleCount;
        count = 0;
        cycleCount = 0;
        boolean cycle = false;
        int[][] round = new int[n][k];
        final int[][] zero = new int[n][k];
        List<int[][]> lifeCycle = new ArrayList<int[][]>();

        lifeCycle.add(Life.fillRand(round));

        while (true) {
            lifeCycle.add(Life.newRound(lifeCycle.get(count)));

            // Остановка если все елементы 0
            if (Life.equals(lifeCycle.get(count + 1), zero)) {
                Life.showLife(lifeCycle.get(count + 1), count + 1, "Life ends", lifePanel);
                break;
            }

            // Сравнение всех предыдущих состояний с текущим и вычисление шага на каком найдено совпадение
            for (int i = lifeCycle.size() - 2; i >= 0; i--) {
                if (Life.equals(lifeCycle.get(count + 1), lifeCycle.get(i))) {
                    cycleCount = i;
                    cycle = true;
                    break;
                }
            }

            // Останотвка при совпадении текущего состояния с каким-либо из предыдущих
            if (cycle) {
                if (cycleCount == count)
                    Life.showLife(lifeCycle.get(count), count, "Stable stance", lifePanel);
                else
                    Life.showLife(lifeCycle.get(count), count, "Stable stance after round " + cycleCount, lifePanel);
                break;
            }
            Life.showLife(lifeCycle.get(count), count, "", lifePanel);
            count++;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //отображение массива
    public static void showLife(int[][] array, int count, String stateMes, LifePanel panel) {
            panel.array = array;
            panel.count = count;
            panel.stateMes = stateMes;
        }

    //заполнение массива n*k случайным образом значениями 0 либо 1
    public static int[][] fillRand(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int) (Math.random() * 2);
            }
        }
        return array;
    }

    // подсчет кол-ва живых соседей точки (i,j)
    public static int neighborhoodQuantity(int[][] array, int i, int j) {
        int count = 0;
        if (elemExist(i - 1, j - 1, array.length, array[i].length)) {
            if (array[i - 1][j - 1] == 1)
                count++;
        }
        if (elemExist(i - 1, j, array.length, array[i].length)) {
            if (array[i - 1][j] == 1)
                count++;
        }
        if (elemExist(i - 1, j + 1, array.length, array[i].length)) {
            if (array[i - 1][j + 1] == 1)
                count++;
        }
        if (elemExist(i, j - 1, array.length, array[i].length)) {
            if (array[i][j - 1] == 1)
                count++;
        }
        if (elemExist(i, j + 1, array.length, array[i].length)) {
            if (array[i][j + 1] == 1)
                count++;
        }
        if (elemExist(i + 1, j - 1, array.length, array[i].length)) {
            if (array[i + 1][j - 1] == 1)
                count++;
        }
        if (elemExist(i + 1, j, array.length, array[i].length)) {
            if (array[i + 1][j] == 1)
                count++;
        }
        if (elemExist(i + 1, j + 1, array.length, array[i].length)) {
            if (array[i+1][j+1] == 1)
                count++;
        }
        return count;
    }


    // проверка наличия елемента (i,j) в массиве n*k
    public static boolean elemExist(int i, int j, int n, int k) {
        Boolean exist = false;
        if (i >= 0 && j >= 0) {
            if (i < n && j < k) exist = true;
        }
        return exist;
    }


    // создание нового массива с учетом правил игры Ver 1
    public static int[][] newRound(int[][] array) {
        int[][] nextRound = new int[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 0 && Life.neighborhoodQuantity(array, i, j) == 3)
                    nextRound[i][j] = 1;
                else if (array[i][j] == 1 && (Life.neighborhoodQuantity(array, i, j) < 2 || Life.neighborhoodQuantity(array, i, j) > 3))
                    nextRound[i][j] = 0;
                else nextRound[i][j] = array[i][j];
            }
        }
        return nextRound;
    }

    // сравнение елементов
    public static boolean equals(int[][] arr, int[][] otherArr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != otherArr[i][j])
                    return false;
            }
        }
        return true;
    }
}
