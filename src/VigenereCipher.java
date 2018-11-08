public class VigenereCipher {

    private final String ALPHA = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String encrypt(String k, String m){
        int[] keys = convertKey(k);
        char[] msg = m.toUpperCase().toCharArray();
        String encryptedMsg = "";

        for (int i = 0, j = 1; i < msg.length; i++,j++){
            if (j == keys.length){
                j = 0;
            }
            encryptedMsg += getLetterFromALPHAEncrypt(msg[i], keys[j]);
        }

        return encryptedMsg;

    }

    public String decrypt(String k, String m){
        int[] keys = convertKey(k);
        char[] msg = m.toUpperCase().toCharArray();
        String decyrptedMsg = "";

        for (int i = 0, j = 1; i < msg.length; i++,j++){
            if (j == keys.length){
                j = 0;
            }
            decyrptedMsg += getLetterFromALPHADecrypt(msg[i], keys[j]);
        }

        return decyrptedMsg;

    }

    private String getLetterFromALPHADecrypt(char letter, int key){
        int index;
        if ((ALPHA.indexOf(letter) - key) < 0){
            index = ALPHA.length() + (ALPHA.indexOf(letter) - key);
        }else{
            index = (ALPHA.indexOf(letter) - key);
        }
        return String.valueOf(ALPHA.toCharArray()[index]);
    }

    private String getLetterFromALPHAEncrypt(char letter, int key){
        int index;
        if ((ALPHA.indexOf(letter) + key) > ALPHA.length()-1){
            index = (ALPHA.indexOf(letter) + key) - ALPHA.length();
        }else{
            index = (ALPHA.indexOf(letter) + key);
        }
        return String.valueOf(ALPHA.toCharArray()[index]);
    }

    private int[] convertKey(String key){
        int[] keys = new int[key.length()];

        for (int i = 0; i < keys.length; i++){
            keys[i] = key.charAt(i) - '0';
        }

        return keys;
    }

}
