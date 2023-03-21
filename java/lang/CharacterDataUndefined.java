package java.lang;

public class CharacterDataUndefined extends CharacterData {

    int getProperties(int ch) {
        return 0;
    }

    int toLowerCase(int ch) {
        return ch;
    }

    int toUpperCase(int ch) {
        return ch;
    }

    static CharacterDataUndefined instance = new CharacterDataUndefined();
}
