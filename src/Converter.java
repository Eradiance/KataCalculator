import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Converter {
    Map<String, Integer> nums = new HashMap<String, Integer>();

    List<Integer> arabicNums = List.of(100, 90, 50, 40, 10, 9, 5, 4, 1);
    List<String> romanNums = List.of("C", "XC", "L", "XL", "X", "IX", "V", "IV", "I");

    public Converter() {
        nums.put("I", 1);
        nums.put("II", 2);
        nums.put("III", 3);
        nums.put("IV", 4);
        nums.put("V", 5);
        nums.put("VI", 6);
        nums.put("VII", 7);
        nums.put("VIII", 8);
        nums.put("IX", 9);
        nums.put("X", 10);
    }

    public Integer romanToArabic(String roman) {
       return nums.getOrDefault(roman, null);
    }

    public String arabicToRoman(int arabic) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < arabicNums.size(); i++) {
            while ((arabic - arabicNums.get(i)) >= 0) {
                arabic -= arabicNums.get(i);
                res.append(romanNums.get(i));
            }
        }
        return res.toString();
    }

    public boolean checkOperation(String operation) {
        return operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/");
    }

    public boolean isRoman(String roman) {
        return nums.containsKey(roman);
    }

    public boolean isArabic(String arabic) {
        try {
            Integer.parseInt(arabic);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isValidNum(Integer num) {
        if (num > 0 && num <= 10) {
            return true;
        }
        throw new CalculatorException("Операнд должен быть в диапазоне от 1 до 10");
    }
}
