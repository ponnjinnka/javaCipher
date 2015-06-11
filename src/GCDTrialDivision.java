import java.math.BigInteger;

/**
 * @author Ryota Kato
 * @since 1.0
 */
public class GCDTrialDivision {
    public BigInteger gcd(BigInteger a, BigInteger b) {
        if (a.signum() != 1 || b.signum() != 1) {
            throw new IllegalArgumentException();
        }

        BigInteger g = BigInteger.ONE;
        if (a.compareTo(b) < 0) {
            BigInteger t = a;
            a = b;
            b = t;
        }

        for (BigInteger n = BigInteger.valueOf(2); n.compareTo(b) <= 0; n = n.add(BigInteger.ONE)) {
            while (a.remainder(n).equals(BigInteger.ZERO) && b.remainder(n).equals(BigInteger.ZERO)) {
                g = n.multiply(g);
                a = a.divide(n);
                b = a.divide(n);
            }
        }
        return g;
    }
}
