package homeworks.VKS_07;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BookManager {

    private File findBook(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the title of the book in camelCase format");
        String bookTitle = scanner.nextLine();

        File file = new File("java\\homeworks\\VKS_07\\books\\" + bookTitle);

        if(!file.exists()){
            System.out.println("Book not found, please try again");
            file = findBook();
        }

        return file;
    }

    public void getBookStatistic(){
        StringBuilder bookBuild = new StringBuilder();
        File book = findBook();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(book))) {
            while(bufferedReader.ready()){
                bookBuild.append(bufferedReader.readLine()).append(" ");
            }
        } catch (IOException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return;
        }
        String withoutSpecialChar = bookBuild.toString().replaceAll("[.,"\'-?:!;]", "").toLowerCase();

        int uniqueWords = Arrays.stream(withoutSpecialChar.split(" ")).collect(Collectors.toSet()).size();

        Map<String, Integer> mostUsedWord = tenMostUsedWord(withoutSpecialChar);

        String bookTitle = Arrays.stream(book.getName().split("\\.")).toList().get(0);

        statisticLog(mostUsedWord, uniqueWords, bookTitle);
    }

    private Map<String, Integer> tenMostUsedWord(String sentence){
        List<String> separatedWords = Arrays.stream(sentence.split(" ")).toList();
        HashMap<String, Integer> usedWords = new HashMap<>();

        separatedWords.stream().filter(word -> word.length() > 2).forEach(word -> {
            if(usedWords.containsKey(word)){
                usedWords.put(word, usedWords.get(word)+1);
            }else{
                usedWords.put(word, 1);
            }
        });

        HashMap<String, Integer> result = new HashMap<>();

        usedWords.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(10).forEach(e -> result.put(e.getKey(), e.getValue()));

        return result;
    }

    private void statisticLog(Map<String, Integer> mostUsedWord, int uniqueWord, String bookTitle){
        StringBuilder bookLog = new StringBuilder();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("java\\homeworks\\VKS_07\\books\\" + bookTitle + "_statistic.txt"))){
            mostUsedWord.forEach((key, value) -> {
                    bookLog.append(key).append(" -> ").append(value).append("\n");
            });
            bookLog.append("Number of unique words - ").append(uniqueWord);
            bufferedWriter.write(bookLog.toString());
            bufferedWriter.flush();
        } catch (IOException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return;
        }
        System.out.println(bookLog);
    }

}
