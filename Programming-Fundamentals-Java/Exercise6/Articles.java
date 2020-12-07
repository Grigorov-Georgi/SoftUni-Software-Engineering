import java.util.Arrays;
import java.util.Scanner;

public class Articles {

    static class Article{

        String title;
        String content;
        String author;

        Article(String title, String content, String author){
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public String getAuthor() {
            return author;
        }

        public void rename(String title) {
            this.title = title;
        }

        public void editContent(String content) {
            this.content = content;
        }

        public void changeAuthor(String author) {
            this.author = author;
        }
        public String toString(){
            return String.format("%s - %s: %s", getTitle(), getContent(), getAuthor());
        }
    }




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        String[] arr = line.split(", ");

        Article article = new Article(arr[0], arr[1], arr[2]);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n ; i++) {
            String command = scanner.nextLine();
            String[] tokens = command.split(": ");
            switch (tokens[0]){
                case "Edit":
                    article.editContent(tokens[1]);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(tokens[1]);
                    break;
                case "Rename":
                    article.rename(tokens[1]);
                    break;
            }
        }
        System.out.println(article.toString());
    }
}
