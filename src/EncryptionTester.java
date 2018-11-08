public class EncryptionTester {

    public static void main (String[] args){
        VigenereCipher vc = new VigenereCipher();

        String testMsg = "Hello there";

        System.out.println(vc.encrypt("1", testMsg));
        System.out.println(vc.decrypt("1", vc.encrypt("1", testMsg)));

    }
}
