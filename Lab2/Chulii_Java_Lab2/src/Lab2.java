public class Lab2 {
    public static void main(String[] args) throws Exception {
        
        System.out.println("Лабораторна робота №2 з Java\n Виконавець: Чулiй Михайло\n Варiант №24\n");
        StringWorker stringWorker = new StringWorker("Андрій Іван Олег Євгенія Уляна Ірина Оксана Анна");
        stringWorker.vowelsStringBuilder();
    }
}

class StringWorker { 
    StringBuilder text = new StringBuilder();
    int count = 0;

    public StringWorker(String str) {
        text.append(str);
    }

    public void vowelsStringBuilder(){
        String[] words = text.toString().split(" ");
        for (String word : words) {
            if (startsWithVowel(word)) {
                count++;
            }
        }

        StringBuilder[] vowelWords = new StringBuilder[count];
        int index = 0;
        for (String w : words) {
            if (startsWithVowel(w)) {
                vowelWords[index] = new StringBuilder(w);
                index++;
            }
        }
        sortBySecondLetter(vowelWords);
    }

    public void sortBySecondLetter(StringBuilder[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].length() < 2 || arr[j + 1].length() < 2) {
                    continue;
                }
                if (arr[j].charAt(1) > arr[j + 1].charAt(1)) {
                    StringBuilder temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
          StringBuilder result = new StringBuilder();
        for (StringBuilder w : arr) {
            result.append(w).append(" ");
        }

        System.out.println("Результат:");
        System.out.println(result.toString().trim());
    }



    public boolean startsWithVowel(String word) {
        if(word.length() == 0) {
            return false;
        }
        String vowels = "АОІУЕЄИЮЯаоіуеєиюя";
        return vowels.indexOf(word.charAt(0)) != -1;
    }
}
