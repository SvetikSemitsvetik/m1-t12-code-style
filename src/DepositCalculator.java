import java.util.Scanner;

public class DepositCalculator{

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod ) {
        double pay = amount * Math.pow((1 + yearRate/ 12), 12 * depositPeriod);
        return degreeNumber(pay, 2);
    }

    double calculateSimplePercent(double amount,double yearRate,
                                             int depositPeriod) {
        return degreeNumber(amount + amount * yearRate * depositPeriod, 2);
    }

    double degreeNumber(double value, int places) {
        double degree= Math.pow(10, places);
        return Math.round(value * degree) / degree;
    }

    // Этот метод лучше назвать calculateDeposit, потому что его основная цель - посчитать депозит, а не вывести меню на экран
    void menuDepositCalculator(){
        int period;
        int action;

        Scanner scanner = new Scanner(System.in); // Здесь лучше поставить отступ, чтобы визуально отделить создание объекта и вызов логики
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt(); // Наверно лучше перенести эту переменную к остальным наверх, потому что так будет логичнее

        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt( );
        System.out.println   ("Выберите тип вклада, 1 - вклад с обычным процентом,"
                              + " 2 - вклад с капитализацией:"); // Лучше сделать sout 1-й строчкой, потому что так читабельнее
        action = scanner.nextInt();
        double outDoubleVar = 0; // У этой переменной непонятное название, лучше сделать что-то вроде deposit

        if (action == 1) {
            outDoubleVar = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            outDoubleVar = calculateComplexPercent(amount, 0.06, period);
        } // Здесь лучше поставить отступ
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в "
                           + outDoubleVar);
    }

    public static void main(String[] args) {
        new DepositCalculator().menuDepositCalculator();
    }
}
