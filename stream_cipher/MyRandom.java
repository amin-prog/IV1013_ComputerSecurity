import java.util.Random;
import java.lang.Override;
import java.lang.IllegalArgumentException;
import java.lang.System;

/**
 * This class, implements a Pseudo Random Number Generator (PRNG) using linear congruential generation algorithm
 * @since 7april2021
 * @author Amin Nouiser (anouiser@kth.se)
 */
public class MyRandom extends Random {

    private long seed;
    final private long multiplier = 3L, offset = 0L; //a multiplier, b offset
    final private long m = 257L;

    private boolean haveNextNextGaussian;
    private double nextNextGaussian;
    private static final long serialVersionUID = 3905348978240129619L;




    /**
     * This constructor uses System.currentTimeMillis() as seed
     */
    MyRandom(){ this( System.currentTimeMillis()); } //some other parameter instead?



    /**
     * This constructor uses user inputted seed
     * @param seed the seed
     * @throws IllegalArgumentException if seed is <=0 see setSeed(long seed)
     */
    MyRandom(long seed) throws IllegalArgumentException { setSeed(seed); }



    /**
     * Get next random number
     * @param bits ow many bits to be utilized, [1, 8]
     * @return a pseudo random number between 0 and 255
     */
    @Override
    public int next(int bits) throws IllegalArgumentException{
        if (bits <= 0 || bits > 32)
            throw new IllegalArgumentException();

        seed = (seed * multiplier + offset) % m;

        if (seed == 256L)    //We don't want this since it will result in 0x00
            return next(bits);

        return (int) (seed & (0xFFFF_FFFFL >>> 32-bits));  //Mask out unwanted bits
    }



    /**
     * Set seed for this PRNG
     * @param seed the seed
     * @throws IllegalArgumentException if seed is 0 or negative
     */
    @Override
    public void setSeed(long seed) throws IllegalArgumentException{
        if (seed <= 0)
            throw new IllegalArgumentException();
        this.seed = seed % m;
    }
}
