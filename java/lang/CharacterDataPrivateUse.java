package java.lang;

public class CharacterDataPrivateUse extends CharacterData {

    int getProperties(int ch) {
        return 0;
    }

    int toLowerCase(int ch) {
        return ch;
    }

    int toUpperCase(int ch) {
        return ch;
    }

    static CharacterDataPrivateUse instance = new CharacterDataPrivateUse();
}
