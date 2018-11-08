public class VigenereCipher {

    private final String ALPHA = " ABCDEFGHIJKLMNOPQRSTUVWXYZ"; //Defines the Alphabet

    /**
     * @param k must not be null, k is the key that will be used to encrypt the message
     * @param m must not be null, m is the message that will be encoded using the string
     * @return This method will return a string that contains the encrypted message using the
     *          key
     */
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

    /**
     * @param k must not be null, k is the key that will be used to decrypt the message, it must be the same as the one used
     *          to encode the message
     * @param m must not be null, m is the encrypted message that will be decrypted using the key
     * @return This method will return a string that contains the decrypted message
     */
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

    /**
     * @param letter must not be null, letter is the character that we would like to find in the ALPHA constant.
     * @param key must not be null, key is the amount of movements left that we must do to get the original character
     * @return This method will return a string that contains a single character which is the original non-encrypted character
     */
    private String getLetterFromALPHADecrypt(char letter, int key){
        int index;
        if ((ALPHA.indexOf(letter) - key) < 0){
            index = ALPHA.length() + (ALPHA.indexOf(letter) - key);
        }else{
            index = (ALPHA.indexOf(letter) - key);
        }
        return String.valueOf(ALPHA.toCharArray()[index]);
    }

    /**
     * @param letter is the character that we would like to find in the ALPHA constant.
     * @param key is the amount of spaces moved right that we must do to get the new character
     * @return This method will return a string that contains a single character which is the new encrypted character
     */
    private String getLetterFromALPHAEncrypt(char letter, int key){
        int index;
        if ((ALPHA.indexOf(letter) + key) > ALPHA.length()-1){
            index = (ALPHA.indexOf(letter) + key) - ALPHA.length();
        }else{
            index = (ALPHA.indexOf(letter) + key);
        }
        return String.valueOf(ALPHA.toCharArray()[index]);
    }

    /**
     * @param key must not be null, key is the string of numbers that will be used to encrypt the data
     * @return This method will return an int array with each individual number at an specific index in the array
     */
    private int[] convertKey(String key){
        int[] keys = new int[key.length()];

        for (int i = 0; i < keys.length; i++){
            keys[i] = key.charAt(i) - '0';
        }

        return keys;
    }

}
