// // 0
// import java.util.HashMap;

// public class Main {

//     public static void main(String[] args) {
//         HashMap <Integer, String> emp = new HashMap<Integer, String>();
//         emp.put(123456, "Иванов");
//         emp.put(321456, "Васильев");
//         emp.put(234561, "Петрова");
//         emp.put(234432, "Иванов");
//         emp.put(654321, "Петрова");
//         emp.put(345678, "Иванов");
//         for (Integer key : emp.keySet()) {
//             if (emp.get(key).equals("Иванов"))
//             {
//                 System.out.printf("%d: %s\n", key, emp.get(key));
//             }
//         }
//     }
// }

// import java.util.HashMap;
// import java.util.stream.Collectors;

// public class Main {
//     public static boolean isIsomorfStr(String first, String second) {
//         HashMap<Character, Character> stringMap = new HashMap<>();
//         char[] firstChars = first.toCharArray();
//         char[] secondChars = second.toCharArray();
//         if (firstChars.length != secondChars.length) {
//             return false;
//         }
//         for (int i = 0; i < first.length(); i++) {
//             if (!stringMap.containsKey(firstChars[i])) {
//                 if (stringMap.values().contains(secondChars[i])) {
//                     return false;
//                 }
//                 stringMap.put(firstChars[i], secondChars[i]);
//             } else if (!(stringMap.get(firstChars[i]) == secondChars[i])) {
//                 return false;
//             }
//         }
//         return true;
//     }

//     public static void main(String[] args) {
//         System.out.printf(String.valueOf(isIsomorfStr("aia", "poor")));
//     }
// }

// // 1 Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
// import java.util.HashMap;
// import java.util.HashSet;
// import java.util.Set;

// public class Main {

//     public static void main(String[] args) {
//         HashMap<String, Set<String>> emp = new HashMap<String, Set<String>>();
//         Set<String> number = new HashSet();
//         number.add("+73332221122");
//         number.add("+79991115522");
//         emp.put("Иванов", new HashSet(number));
//         number.removeAll(number);
//         number.add("+79991111111");
//         number.add("+79992222222");
//         emp.put("Петров", new HashSet(number));
//         number.removeAll(number);
//         number.add("+44956663331");
//         emp.put("Печкин", new HashSet(number));
//         for (String key : emp.keySet()) {
//             System.out.printf("\n%s ", key);
//             for (String string : emp.get(key)) {
//                 System.out.printf("%s, ", string);      
//             }
//         }
//     }
// }

// Пусть дан список сотрудников: Иван Иванов
// Светлана Петрова
// Кристина Белова
// Анна Мусина
// Анна Крутова
// Иван Юрин
// Петр Лыков
// Павел Чернов
// Петр Чернышов
// Мария Федорова
// Марина Светлова
// Мария Савина
// Мария Рыкова
// Марина Лугова
// Анна Владимирова
// Иван Мечников
// Петр Петин
// Иван Ежов
// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.


import java.util.Scanner;
public class Hw5 {
    String firstName;
    String lastName;

    public Hw5(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public static void input(Hw5[] persons)
    {
        int i = 0;
        String choice = "yes";
        Scanner scanner = new Scanner(System.in);
        do{
            
            System.out.printf("Вы хотите ввести ФИ нового сотрудника? (yes/no)? ");
            Boolean flag = scanner.hasNextLine(); // проверка на корректный ввод
            if (flag == true){
                choice = scanner.nextLine();
                flag = false;
                if (choice.equals("yes")){
                    System.out.printf("Введите имя %d сотрудника: ", i + 1);
                    flag = scanner.hasNextLine();
                    if (flag == true){
                        flag = false;
                        String firstName = scanner.nextLine();
                        System.out.printf("Введите фамилию %d сотрудника: ", i + 1);
                        flag = scanner.hasNextLine();
                        if (flag == true){
                            String lastName = scanner.nextLine();
                            persons[i] = new Hw5(firstName, lastName);
                            System.out.printf(persons[i].firstName);
                            System.out.printf(" ");
                            System.out.printf(persons[i].lastName);
                            System.out.printf("\n");
                            i++;
                        }
                    }
                }
                else if (!choice.equals("no")){
                    System.out.printf("Некорректный ввод!\n");
                }
            }
            
        } while(!choice.equals("no") && i != persons.length);
        if (i == persons.length)
        {
            System.out.printf("К сожалению, программа может работать только со списком из 20 человек.\n");
        }
        scanner.close();
    }
    
    public static void main(String[] args) {
        Hw5 []persons = new Hw5[20];
        input(persons);
        //count(persons);

    }
}

// import java.util.Random;

// // 3. Реализовать алгоритм пирамидальной сортировки (HeapSort).
// public class Main{
//     public static void HeapSort(int arr[]){
        
//         int n = arr.length;

//         // Построение кучи (перегруппируем массив)
//         for (int i = n / 2 - 1; i >= 0; i--){
//             Heapify(arr, n, i);
//         }

//         // Один за другим извлекаем элементы из кучи   
//         for (int i = n-1; i >= 0; i--){
//             // Перемещаем текущий корень в конец
//             int temp = arr[0];
//             arr[0] = arr[i];
//             arr[i] = temp;

//             // Вызываем процедуру heapify на уменьшенной куче
//             Heapify(arr, i, 0);
//         }
//     }

//     // Процедура для преобразования в двоичную кучу поддерева с корневым узлом i, что является
// // индексом в arr[]. n - размер кучи
//     public static void Heapify(int arr[], int n, int i){
//         int largest = i; // Инициализируем наибольший элемент как корень
//         int l = 2*i + 1; // левый 
//         int r = 2*i + 2; // правый 

//            // Если левый дочерний элемент больше корня
//         if (l < n && arr[l] > arr[largest])
//             largest = l;

//           // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
//         if (r < n && arr[r] > arr[largest])
//             largest = r;

//        // Если самый большой элемент не корень
//         if (largest != i){
//             int temp = arr[i];
//             arr[i] = arr[largest];
//             arr[largest] = temp;

//           // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
//             Heapify(arr, n, largest);
//         }
//     }

//     // Управляющая программа
//     public static void main(String[] args) {
//         Random rand = new Random();
//         int arr[] = new int[10];
//         for (int i = 0; i < arr.length; i++) {
//             arr[i] = rand.nextInt(20);
//         }
//         System.out.println("Initial array is");
//         for (int i=0; i<arr.length; ++i)
//             System.out.print(arr[i]+" ");
//         System.out.println();

//         HeapSort(arr);

//         System.out.println("Sorted array is");
//         for (int i=0; i<arr.length; ++i)
//             System.out.print(arr[i]+" ");
//         System.out.println();
//     }
// }

// // 4. На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга
// public class Main {

//     static int[] chessboard = {0,0,0,0,0,0,0,0};
//     static int index = 0;
//     static int number = 1;

//     public static void main(String[] args){

//         do {
//             if (Check()){
//                 if (index == 7) {
//                     System.out.println(number++ + " a" + chessboard[0] + " b" + chessboard[1] + " c" + chessboard[2] + " d" + chessboard[3] + " e" + chessboard[4] + " f" + chessboard[5] + " g" + chessboard[6] + " h" + chessboard[7]);
//                     chessboard[index]++;
//                 }
//                 else {
//                     index++;
//                 }
//             }
//             else {
//                 chessboard[index]++;
//             }
//         } while (chessboard[0]<8);
//     }
//     static boolean Check() {
//         if (index == 0) {
//             return true;
//         }
//         else if (chessboard[index]>7){
//             chessboard[index--] = 0;
//             return false;
//         }
//         for (int i = 0; i < index; i++){
//             if ((chessboard[index] == chessboard[i])||((Math.abs(chessboard[index] - chessboard[i])) == (index - i))){
//                 return false;
//             }
//         }
//         return true;
//    }
// }
