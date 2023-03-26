package ru.netology.stats;

public class StatsService {

    public int sumSales(long[] sales) { //Сумма всех продаж
        int sum = 0;

        for (long sale : sales) sum = (int) (sum + sale);
        return sum;
    }

    public int averageSales(long[] sales) { //Средняя сумма продаж в месяц
        int average = 0;

        for (long sale : sales) average = sumSales(sales) / sales.length;
        return average;
    }

    public int maxSales(long[] sales) { //Номер месяца, в котором был пик продаж
        int maxMonth = 0;

        for (int i = 0; i < sales.length; i++) {
            if (sales[i] >= sales[maxMonth]) {
                maxMonth = i;
            }
        }

        return maxMonth + 1;
    }

    public int minSales(long[] sales) { //Номер месяца, в котором был минимум продаж
        int minMonth = 0; // номер месяца с минимальными продажами среди просмотренных ранее

        for (int i = 0; i < sales.length; i++) {
            if (sales[i] <= sales[minMonth]) { // значит, в рассматриваемом i-м месяце продаж меньше
                minMonth = i; // запомним его как минимальный
            }
        }

        return minMonth + 1; // месяца нумеруются с 1, а индексы массива с 0, нужно сдвинуть ответ на 1
    }

    public int belowAverageSales(long[] sales) { //Количество месяцев, в которых продажи были ниже среднего
        int average = averageSales(sales);
        int count = 0;

        for (long sale : sales) {
            if (sale < average) {
                count++;
            }
        }
        return count;
    }

    public int aboveAverageSales(long[] sales) { //Количество месяцев, в которых продажи были выше среднего
        int average = averageSales(sales);
        int count = 0;

        for (long sale : sales) {
            if (sale > average) {
                count++;
            }
        }
        return count;
    }
}