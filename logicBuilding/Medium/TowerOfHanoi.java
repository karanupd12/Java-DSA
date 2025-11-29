package logicBuilding.Medium;

public class TowerOfHanoi {
    static int steps = 0;
    static void towerOfHanoi(int n, int from, int to, int aux) {
        if (n == 0) return;
        towerOfHanoi(n - 1, from, aux, to);     // Move n-1 disks from 'from' to 'aux'
        // Move the nth disk
        System.out.println("Move disk " + n + " from rod " + from + " to rod " + to);
        steps++;
        towerOfHanoi(n - 1, aux, to, from);     // Move n-1 disks from 'aux' to 'to'
    }

    public static void main(String[] args) {
        int N = 3;
        towerOfHanoi(N, 1, 3, 2);
        System.out.println("Total moves: " + steps); //or Math.pow(2, n) - 1
    }
}

/*
 direct formula -> total steps : Math.pow(2, n) - 1
 */