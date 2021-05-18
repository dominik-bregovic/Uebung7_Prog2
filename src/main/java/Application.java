import java.util.Collections;

public class Application {
    public static void main(String[] args) {
        ReadTable read = new ReadTable("src/main/resources/music2021.csv");
        AnalyseTable analyse = new AnalyseTable(read);
        CreateTable table = new CreateTable(analyse);
    }
}
