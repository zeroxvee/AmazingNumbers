package numbers;

public class Number {
    //All Number properties
    public static final String[] numberProps =
            {"BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY", "EVEN", "ODD",
                    "SQUARE", "SUNNY", "JUMPING", "HAPPY", "SAD"};
    //All available to use properties
    public static final String[] allAvailProps =
            {"BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY", "EVEN", "ODD",
                    "SQUARE", "SUNNY", "JUMPING", "HAPPY", "SAD", "-BUZZ", "-DUCK",
                    "-PALINDROMIC", "-GAPFUL", "-SPY", "-EVEN", "-ODD",
                    "-SQUARE", "-SUNNY", "-JUMPING", "-HAPPY", "-SAD"};
    //Mutually exclusive properties, that can't be used in the input
    public static final String[][] mutuallyExclusiveProps = {
            {"ODD", "EVEN"}, {"SPY", "DUCK"},
            {"SUNNY", "SQUARE"}, {"HAPPY", "SAD"},
            {"ODD", "-ODD"}, {"EVEN", "-EVEN"},
            {"SUNNY", "-SUNNY"}, {"SQUARE", "-SQUARE"},
            {"SPY", "-SPY"}, {"HAPPY", "-HAPPY"},
            {"SAD", "-SAD"}, {"BUZZ", "-BUZZ"},
            {"DUCK", "-DUCK"}, {"PALINDROMIC", "-PALINDROMIC"},
            {"GAPFUL", "-GAPFUL"}, {"JUMPING", "-JUMPING"},
            {"-ODD", "-EVEN"}
    };
    public boolean buzz;
    public boolean duck;
    public boolean palindrome;
    public boolean gapful;
    public boolean spy;
    public boolean even;
    public boolean odd;
    public boolean square;
    public boolean sunny;
    public boolean jumping;
    public boolean happy;
    public boolean sad;

    //Number Constructor
    public Number(long num) {
        buzz = isBuzz(num);
        duck = isDuck(num);
        palindrome = isPalindrome(num);
        gapful = isGapful(num);
        spy = isSpy(num);
        even = isEven(num);
        odd = !isEven(num);
        square = isSquare(num);
        sunny = isSunny(num);
        jumping = isJumping(num);
        happy = isHappy(num);
        sad = isSad(num);
    }

    //Methods to calculate number properties
    public static boolean isSpy(long x) {
        long ld;
        long sum = 0;
        long product = 1;
        while (x > 0) {
            ld = x % 10;
            sum = sum + ld;
            product = product * ld;
            x = x / 10;
        }
        return sum == product;
    }

    public static boolean isBuzz(long x) {
        return x % 7 == 0 || x % 10 == 7;
    }

    public static boolean isEven(long x) {
        return x % 2 == 0;
    }

    public static boolean isDuck(long x) {
        return String.valueOf(x).substring(1).contains("0");
    }

    public static boolean isPalindrome(long x) {
        StringBuilder str = new StringBuilder(String.valueOf(x)).reverse();
        return str.toString().equals(String.valueOf(x));
    }

    public static boolean isGapful(long x) {
        String[] str = String.valueOf(x).split("");
        return x % Long.parseLong(str[0] + str[str.length - 1]) == 0 && x >= 100;
    }

    public static boolean isSquare(long x) {
        double sq = Math.sqrt(x);
        return ((sq - Math.floor(sq)) == 0);
    }

    public static boolean isSunny (long x) {
        return isSquare(x + 1);
    }

    public static boolean isJumping(long x) {
        boolean flag = true;
        while (x != 0) {
            long digit1 = x % 10;
            x = x / 10;
            if (x != 0) {
                long digit2 = x % 10;
                if (Math.abs(digit1 - digit2) != 1) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    public static boolean isHappy(long n) {
        if(n < 10) {
            return n == 1 || n == 7;
        }
        long b;
        int sum = 0;
        while(n > 0) {
            b = n % 10;
            sum += b * b;
            n = n / 10;
        }
        return isHappy(sum);
    }

    public static boolean isSad(long x) {
        return !isHappy(x);
    }
}
