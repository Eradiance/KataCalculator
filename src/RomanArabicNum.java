enum RomanArabicNum {
    I("I", 1),
    II("II", 2),
    III("III", 3),
    IV("IV", 4),
    v("V", 5),
    VI("VI", 6),
    VII("VII", 7),
    VIII("VIII", 8),
    IX("IX", 9),
    X("X", 10);

    private final String romanNum;
    private final int arabicNum;

    RomanArabicNum(String romanNum, int arabicNum) {
        this.romanNum = romanNum;
        this.arabicNum = arabicNum;
    }

    public int getArabicNum() {
        return arabicNum;
    }

    public String getRomanNum() {
        return romanNum;
    }

    static int romanToArabic(String romanNum) {
        for (RomanArabicNum i: values())
            if (i.getRomanNum().equals(romanNum))
                return i.getArabicNum();
        return -1;
    }
}
