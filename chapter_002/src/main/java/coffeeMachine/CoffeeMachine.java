package coffeeMachine;

/**
 * + Делаем массив из 10,5,2,1.
 * + Для начала мы сделаем три переменные в которые будем
 * записывать колличество монет определенного значения.
 * {value} numberOfFiveCoins - колличество монет номиналом 5.
 * {value} numberOfTwoCoins - колличество монет номиналом 2.
 * {value} numberOfOneCoins - колличество монет номиналом 1.
 * {value} int[] coins - массив всех доступных монет.
 * + После этого делаем вычисление общей суммы сдачи.
 * + Делаем деление на 10 и приводим значение к целому числу.
 * + Данное значение сохраняем в переменную, которая показывает сколько 10 рублёвых
 * монет должно быть в сдаче.
 * + Вычитаем значение колличества 10 рублёвых монет умноженное на 10
 * из значения полной сдачи.
 * + В цикле перебираем массив с возможными монетами и, если попадается
 * та, которая равна значению из переменной остатка сдачи,
 * записываем значение 1 в переменную из п.2., т.к. нужна 1 монета данного номинала.
 * + Если такое значение не нашлось, то делаем перебор массива монет для сдачи.
 * Создадим переменную в которую будем записывать какую еще сумму нужно выдать.
 * При каждой итерации делаем деление. Результат записываем в соответствующую переменную.
 * После этого вычитаем из остатка значение ячейки массива и сохраняем в переменной остатка суммы.
 * Далее мы идем к следующей ячейке массива и уже делим значение переменной остатка на значение ячейки.
 * + В методе создаем массив целых чисел. Длина массива равна сумме
 * четырех переменных, которые создавали в п.2. И возвращаем этот массив.
 * + Записываем получившиеся значения колличества монет в массив из п.3
 * Если колличество элементов не равно нулю, то записываем элемент в массив.
 * После этого уменьшаем колличество на 1, записываем пока колличество не будент равно 0.
 */
public class CoffeeMachine {
    private int numberOfFiveCoins;
    private int numberOfTwoCoins;
    private int numberOfOneCoins;
    private int[] coins = {10, 5, 2, 1};

    /**
     * @param value - колличество денег, которые внесли для покупки кофе.
     * @param price - цена кофе
     * @return - массив монет сдачи.
     * {value} allChange - общее значение сдачи.
     * {value} numberOfTenCoins - колличество монет номиналом 10.
     * {value} anotherChange - оставшееся значение сдачи, после вычитания колличества 10 рублёвых монет.
     * {value} remainder - оставшееся значение сдачи, после нахождения монеты
     * нужного номинала в {value} anotherChange.
     */
    public int[] changes(int value, int price) {
        if (value < price) {
            System.out.println("Put more money!");
        }
        int allChange = value - price;
        int numberOfTenCoins = allChange / 10;
        int anotherChange = allChange - 10 * numberOfTenCoins;
        for (int index = 1; index < coins.length; index++) {
            if (anotherChange == coins[1]) {
                numberOfFiveCoins++;
                break;
            } else if (anotherChange == coins[2]) {
                numberOfTwoCoins++;
                break;
            } else if (anotherChange == coins[3]) {
                numberOfOneCoins++;
                break;
            } else {
                int remainder = 0;
                for (int i = 1; i < coins.length; i++) {
                    if (i == 1 && anotherChange > coins[1]) {
                        numberOfFiveCoins = anotherChange / coins[1];
                        remainder = anotherChange - coins[1];
                    } else if (i == 2 && anotherChange > coins[2]) {
                        if (remainder == 0) {
                            numberOfTwoCoins = anotherChange / coins[2];
                            remainder = anotherChange - coins[2];
                        } else {
                            numberOfTwoCoins = remainder / coins[2];
                            remainder = remainder - coins[2];
                        }
                    } else {
                        numberOfOneCoins = remainder / coins[3];
                    }
                }
            }
        }
        int[] amountOfChange = new int[numberOfTenCoins +
                numberOfFiveCoins + numberOfTwoCoins + numberOfOneCoins];
        for (int index = 0; index != amountOfChange.length; index++) {
            if (numberOfTenCoins != 0) {
                amountOfChange[index] = coins[0];
                numberOfTenCoins--;
            } else if (numberOfFiveCoins != 0) {
                amountOfChange[index] = coins[1];
                numberOfFiveCoins--;
            } else if (numberOfTwoCoins != 0) {
                amountOfChange[index] = coins[2];
                numberOfTwoCoins--;
            } else if (numberOfOneCoins != 0) {
                amountOfChange[index] = coins[3];
                numberOfOneCoins--;
            }
        }
        return amountOfChange;
    }
}
