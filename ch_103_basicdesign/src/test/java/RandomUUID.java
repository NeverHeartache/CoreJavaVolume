import java.util.UUID;

public class RandomUUID {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            String uuidStr = UUID.randomUUID().toString();
            System.out.println(uuidStr);
            System.out.println(uuidStr.length());
        }
    }
}
