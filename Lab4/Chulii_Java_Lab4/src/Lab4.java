public class Lab4 {
    public static void main(String[] args) throws Exception {
        System.setProperty("file.encoding", "UTF-8");

        System.out.println("Лабораторна робота №4 з Java\n Виконавець: Чулiй Михайло\n Варiант №24\n");

        Text text = new Text("Андрій Іван Олег Євгенія Уляна Ірина Оксана Анна. Я вчора ходив у зал, там зустрів Антона та Аанга.");
        text.vowelsStringBuilder();
    }
}

class Letter{
    char symbol;

    public Letter(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}

class Word{
    Letter[] letters;

    public Word(String word) {
        this.letters = new Letter[word.length()];
        for (int i = 0; i < word.length(); i++) {
            letters[i] = new Letter(word.charAt(i));
        }
    }

    public String GetWord() {
       StringBuilder sb = new StringBuilder();
       for (Letter letter : letters) {
           sb.append(letter.getSymbol());
       }
        return sb.toString();
    }

    public char GetFirstLetter() {
        return letters[0].getSymbol();
    }

    public char getSecondLetter() {
        if (letters.length > 1) {
            return letters[1].getSymbol();
        }
        return '\0';
    }
}

class Punctuation {
    char symbol;

    public Punctuation(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}

class Sentence{
    Word[] words;
    Punctuation[] punctuation;

    public Sentence(String sentence) {
        String cleaned = sentence.replaceAll("[,.!?]", ""); // прибрати розділові
        String[] wordArray = cleaned.split(" ");
        words = new Word[wordArray.length];
        for (int i = 0; i < wordArray.length; i++) {
            words[i] = new Word(wordArray[i]);
        }

        char[] chars = sentence.toCharArray();
        int pCount = 0;
        for (char c : chars) {
            if (",.!?".indexOf(c) != -1) pCount++;
        }
        punctuation = new Punctuation[pCount];
        int idx = 0;
        for (char c : chars) {
            if (",.!?".indexOf(c) != -1) punctuation[idx++] = new Punctuation(c);
        }
    }


    public Word[] getWords() {
        return words;
    }
}
class Text{
    Sentence[] sentences;

    public Text(String text) {
        String[] sentenceArray = text.split("[.!?]");
        sentences = new Sentence[sentenceArray.length];
        for (int i = 0; i < sentenceArray.length; i++) {
            sentences[i] = new Sentence(sentenceArray[i].trim());
        }
    }


     public void vowelsStringBuilder() {
        int count = 0;
        for (Sentence s : sentences) {
            for (Word w : s.getWords()) {
                if (startsWithVowel(w.GetFirstLetter()) && w.getSecondLetter() != '\0') {
                    count++;
                }
            }
        }

        Word[] vowelWords = new Word[count];
        int index = 0;
        for (Sentence s : sentences) {
            for (Word w : s.getWords()) {
                 if (startsWithVowel(w.GetFirstLetter()) && w.getSecondLetter() != '\0') {
                    vowelWords[index++] = w;
                }
            }
        }

        sortBySecondLetter(vowelWords);

        System.out.println("Результат:");
        for (Word w : vowelWords) {
            System.out.print(w.GetWord() + " ");
        }
        System.out.println();
    }

    public void sortBySecondLetter(Word[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
        for (int j = 0; j < arr.length - i - 1; j++) {
            char second1 = arr[j].getSecondLetter();
            char second2 = arr[j + 1].getSecondLetter();


            if (second1 == '\0' || second2 == '\0') {
                continue;
            }

            if (Character.toLowerCase(second1) > Character.toLowerCase(second2)) {
                Word temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}
    public boolean startsWithVowel(char firstLetter) {
        String vowels = "АОІУЕЄИЮЯаоіуеєиюя";
        return vowels.indexOf(firstLetter) != -1;
    }
}

