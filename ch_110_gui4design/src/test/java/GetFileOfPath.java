import java.io.File;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetFileOfPath {

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        String rootPath = "/";
//        Path path = Paths.get(URI.create(rootPath));
        List<File> fileList = new ArrayList<>();
        String a1 = GetFileOfPath.class.getResource("/").getPath();
        System.out.println("通过类获取resources的方法："+a1);
        File file = new File(a1);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            Arrays.stream(files).forEach(e -> {
                System.out.println(e.getPath() + e.getName());
            });
        }
    }
}
