package coffeeMachine;

/**
 * + Делаем массив из 10,5,2,1.
 * + Делаем массив в который будем записывать колличество нужных монет для сдачи.
 * {value} int[] numberOfCoins - массив значений монет определенного номинала.
 * {value} int[] coins - массив всех доступных монет.
 * + После этого делаем вычисление общей суммы сдачи.
 * + Делаем деление на 10 и приводим значение к целому числу.
 * + Данное значение сохраняем в первый элемент массива numberOfCoins.
 * + Вычитаем значение колличества 10 рублёвых монет умноженное на 10
 * из значения полной сдачи.
 * + В цикле перебираем массив с возможными монетами и, если попадается
 * та, которая равна значению из переменной остатка сдачи,
 * записываем значение 1 в массив numberOfCoins, т.к. нужна 1 монета данного номинала.
 * + Если такое значение не нашлось, то делаем перебор массива монет для сдачи.
 * Создадим переменную в которую будем записывать какую еще сумму нужно выдать.
 * При каждой итерации делаем деление. Результат записываем в соответствующую переменную.
 * После этого вычитаем из остатка значение ячейки массива и сохраняем в переменной остатка суммы.
 * Далее мы идем к следующей ячейке массива и уже делим значение переменной остатка на значение ячейки.
 * + В методе создаем массив целых чисел. Длина массива равна сумме значений элементов из массива
 * numberOfCoins.
 * + Записываем получившиеся значения колличества монет в массив из массива numberOfCoins.
 * Если колличество элементов не равно нулю, то записываем элемент в массив.
 * После этого уменьшаем колличество на 1, записываем пока колличество не будент равно 0.
 */
public class CoffeeMachine {
    private int[] coins = {10, 5, 2, 1};
    private int[] numberOfCoins = new int[4];

    /**
     * @param value - колличество денег, которые внесли для покупки кофе.
     * @param price - цена кофе
     * @return - массив монет сдачи.
     * {value} allChange - общее значение сдачи.
     * {value} anotherChange - оставшееся значение сдачи, после вычитания колличества 10 рублёвых монет
     * нужного номинала в {value} anotherChange.
     */
    public int[] changes(int value, int price) {
        if (value < price) {
            System.out.println("Put more money!");
        }
        int allChange = value - price;
        numberOfCoins[0] = allChange / 10;
        int anotherChange = allChange - 10 * numberOfCoins[0];
        for (int index = 1; index < coins.length; index++) {
            if (anotherChange == coins[index]) {
                numberOfCoins[index]++;
                break;
            }
            if (anotherChange > coins[index]) {
                numberOfCoins[index] = anotherChange / coins[index];
                anotherChange -= coins[index];
            }
        }
        int[] amountOfChange = new int[numberOfCoins[0] +
                numberOfCoins[1] + numberOfCoins[2] + numberOfCoins[3]];
        for (int index1 = 0; index1 != amountOfChange.length; index1++) {
            for (int i = 0; i != numberOfCoins.length; i++) {
                if (numberOfCoins[i] != 0) {
                    amountOfChange[index1] = coins[i];
                    numberOfCoins[i]--;
                    break;
                }
            }
        }
        return amountOfChange;
    }
}
