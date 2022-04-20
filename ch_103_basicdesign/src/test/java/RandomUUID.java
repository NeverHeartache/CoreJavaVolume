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
/**
 * cc02be31-b3cc-4779-b0f7-ab9b8b09f597
 * 36
 * ac2dd757-2f82-4562-bb9a-6b4ee4c2d5e1
 * 36
 * ca5defd4-4b58-4166-bc3b-05145f42b484
 * 36
 * 9c64d178-e8b1-425d-a47d-796943b40fea
 * 36
 */