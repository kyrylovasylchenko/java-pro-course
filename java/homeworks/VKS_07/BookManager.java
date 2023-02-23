package homeworks.VKS_07;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BookManager {
    private final String CLEAN_UP = "[.,\"'-?:!;]";

    public void getBookStatistic(){
        System.out.println("Please enter the title of the book in camelCase format or 'exit' to exit");
        StringBuilder bookBuild = new StringBuilder();
        Scanner getTitle = new Scanner(System.in);
        String title;
        while(!(title = getTitle.nextLine()).equalsIgnoreCase("exit")){
            File book = new File("java\\homeworks\\VKS_07\\books\\" + title);
            try(BufferedReader bookBody = new BufferedReader(new FileReader(book))) {
                while(bookBody.ready()){
                    bookBuild.append(bookBody.readLine()).append(" ");
                }
            } catch (IOException e) {
                System.out.println("Can't find book, please try again");
                continue;
            }
            String withoutSpecialChar = bookBuild.toString().replaceAll(CLEAN_UP, "").toLowerCase();

            int uniqueWords = Arrays.stream(withoutSpecialChar.split(" ")).collect(Collectors.toSet()).size();

            Map<String, Integer> mostPopularWord = topTen(withoutSpecialChar);

            String bookTitle = Arrays.stream(book.getName().split("\\.")).toList().get(0);

            statisticLog(mostPopularWord, uniqueWords, bookTitle);
            System.out.println("If you want get statistics about another book just print book title or 'exit' to exit");
        }
    }

    private Map<String, Integer> topTen(String sentence){
        List<String> words = Arrays.stream(sentence.split(" ")).toList();
        HashMap<String, Integer> popularWords = new HashMap<>();

        words.stream().filter(word -> word.length() > 2).forEach(word -> {
            if(popularWords.containsKey(word)){
                popularWords.put(word, popularWords.get(word)+1);
            }else{
                popularWords.put(word, 1);
            }
        });

        HashMap<String, Integer> result = new HashMap<>();

        popularWords.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(10).forEach(e -> result.put(e.getKey(), e.getValue()));

        return result;
    }

    private void statisticLog(Map<String, Integer> mostPopularWord, int uniqueWord, String bookTitle){
        StringBuilder bookLog = new StringBuilder();
        mostPopularWord.forEach((key, value) -> bookLog.append(key).append(" -> ").append(value).append("\n"));
        bookLog.append("Number of unique words - ").append(uniqueWord);
        try (BufferedWriter statisticLog = new BufferedWriter(new FileWriter("java\\homeworks\\VKS_07\\books\\" + bookTitle + "_statistic.txt"))){
            statisticLog.write(bookLog.toString());
            statisticLog.flush();
        } catch (IOException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            return;
        }
        System.out.println(bookLog);
    }

}
