package alexsgi.utils.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AdvMath {

    public static double sum(double... summands) {
        double sum = 0;
        for (double summand : summands) {
            sum += summand;
        }
        return sum;
    }

    public static double difference(double minuend, double... subtrahends) {
        for (double subtrahend : subtrahends) {
            minuend -= subtrahend;
        }
        return minuend;
    }

    public static double product(double... factors) {
        int product = 1;
        for (double factor : factors) {
            product *= factor;
        }
        return product;
    }

    public static double quotient(double dividend, double... divisors) {
        for (double divisor : divisors) {
            dividend /= divisor;
        }
        return dividend;
    }

    public static BigDecimal bigSum(BigDecimal... summands) {
        BigDecimal sum = new BigDecimal(0);
        for (BigDecimal summand : summands) {
            sum = sum.add(summand);
        }
        return sum;
    }

    public static BigDecimal bigDifference(BigDecimal minuend, BigDecimal... subtrahents) {
        for (BigDecimal subtrahent : subtrahents) {
            minuend = minuend.subtract(subtrahent);
        }
        return minuend;
    }

    public static BigDecimal bigProduct(BigDecimal... factors) {
        BigDecimal product = new BigDecimal(1);
        for (BigDecimal factor : factors) {
            product = product.multiply(factor);
        }
        return product;
    }

    public static BigDecimal bigQuotient(BigDecimal dividend, BigDecimal... divisors) {
        for (BigDecimal divisor : divisors) {
            dividend = dividend.divide(divisor, RoundingMode.HALF_UP);
        }
        return dividend;
    }

}
