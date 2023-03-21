package java.lang;

abstract class CharacterData {

    abstract int getProperties(int ch);

    abstract int toLowerCase(int ch);

    abstract int toUpperCase(int ch);


    static final CharacterData of(int ch) {
        if (ch >>> 8 == 0) {     // fast-path
            return CharacterDataLatin1.instance;
        } else {
            switch(ch >>> 16) {  //plane 00-16
                case(0):
                    return CharacterData00.instance;
                case(1):
                    return CharacterData01.instance;
                case(2):
                    return CharacterData02.instance;
                case(14):
                    return CharacterData0E.instance;
                case(15):   // Private Use
                case(16):   // Private Use
                    return CharacterDataPrivateUse.instance;
                default:
                    return CharacterDataUndefined.instance;
            }
        }
    }
}
