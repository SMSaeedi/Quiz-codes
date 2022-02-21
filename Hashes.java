package com.example.demo.hash32Sapmles;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public final class Hashes {
    private static final Charset CHARSET = StandardCharsets.UTF_16;
    private static final HashFunction MURMUR128 = Hashing.murmur3_128();
    private static final HashFunction MURMUR32 = Hashing.murmur3_32();

    /**
     *
     */
    private Hashes() {
    }

    /**
     * Computes a 64bit hash.
     *
     * @param data the data to hash
     * @return a 64bit hash
     */
    public static byte[] hash128(final Object... data) {
        return hashcode(data).asBytes();
    }

    /**
     * Computes a 32bit hash.
     *
     * @param data the data to hash
     * @return a 32bit hash
     */
    public static int hash32(final CharSequence data) {
        return MURMUR32.hashString(data, CHARSET).asInt();
    }

    /**
     * Computes a 32bit hash.
     *
     * @param data the data to hash
     * @return a 32bit hash
     */
    public static int hash32(final double data) {
        return MURMUR32.hashLong(Double.doubleToRawLongBits(data)).asInt();
    }

    /**
     * Computes a 32bit hash.
     *
     * @param data the data to hash
     * @return a 32bit hash
     */
    public static int hash32(final Double data) {
        return hash32(data.doubleValue());
    }

    /**
     * Computes a 32bit hash.
     *
     * @param data the data to hash
     * @return a 32bit hash
     */
    public static int hash32(final float data) {
        return MURMUR32.hashInt(Float.floatToRawIntBits(data)).asInt();
    }

    /**
     * Computes a 32bit hash.
     *
     * @param data the data to hash
     * @return a 32bit hash
     */
    public static int hash32(final Float data) {
        return hash32(data.floatValue());
    }

    /**
     * Computes a 32bit hash.
     *
     * @param data the data to hash
     * @return a 32bit hash
     */
    public static int hash32(final Integer data) {
        return data;
    }

    /**
     * Computes a 32bit hash.
     *
     * @param data the data to hash
     * @return a 32bit hash
     */
    public static int hash32(final long data) {
        return MURMUR32.hashLong(data).asInt();
    }

    /**
     * Computes a 32bit hash.
     *
     * @param data the data to hash
     * @return a 32bit hash
     */
    public static int hash32(final Long data) {
        return hash32(data.longValue());
    }

    /**
     * Computes a 32bit hash.
     *
     * @param data the data to hash
     * @return a 32bit hash
     */
    public static int hash32(final Object... data) {
        final Hasher h = MURMUR32.newHasher();
        if (data.length == 1) {
            populateHasher(data[0], h);
        } else {
            populateHasher(data, h);
        }
        return h.hash().asInt();
    }

    /**
     * Computes a 64bit hash.
     *
     * @param data the data to hash
     * @return a 64bit hash
     */
    public static long hash64(final CharSequence data) {
        return MURMUR128.hashString(data, CHARSET).asLong();
    }

    /**
     * Computes a 64bit hash.
     *
     * @param data the data to hash
     * @return a 64bit hash
     */
    public static long hash64(final double data) {
        return MURMUR128.hashLong(Double.doubleToRawLongBits(data)).asLong();
    }

    /**
     * Computes a 64bit hash.
     *
     * @param data the data to hash
     * @return a 64bit hash
     */
    public static long hash64(final Double data) {
        return hash64(data.doubleValue());
    }

    /**
     * Computes a 64bit hash.
     *
     * @param data the data to hash
     * @return a 64bit hash
     */
    public static long hash64(final float data) {
        return hash32(data);
    }

    /**
     * Computes a 64bit hash.
     *
     * @param data the data to hash
     * @return a 64bit hash
     */
    public static long hash64(final Float data) {
        return hash32(data);
    }

    /**
     * Computes a 64bit hash.
     *
     * @param data the data to hash
     * @return a 64bit hash
     */
    public static long hash64(final Integer data) {
        return data;
    }

    /**
     * Computes a 64bit hash.
     *
     * @param data the data to hash
     * @return a 64bit hash
     */
    public static long hash64(final long data) {
        return MURMUR128.hashLong(data).asLong();
    }

    /**
     * Computes a 64bit hash.
     *
     * @param data the data to hash
     * @return a 64bit hash
     */
    public static long hash64(final Long data) {
        return hash64(data.longValue());
    }

    /**
     * Computes a 64bit hash.
     *
     * @param data the data to hash
     * @return a 64bit hash
     */
    public static long hash64(final Object... data) {
        return hashcode(data).asLong();
    }

    private static HashCode hashcode(final Object... data) {
        final Hasher h = MURMUR128.newHasher();
        if (data.length == 1) {
            populateHasher(data[0], h);
        } else {
            populateHasher(data, h);
        }
        return h.hash();
    }

    private static void populateHasher(final Object data, final Hasher h) {
        if (data != null) {
            if (data instanceof Number) {
                final Number d = (Number) data;
                if (data instanceof Integer) {
                    h.putInt(d.intValue());
                } else if (data instanceof Double) {
                    h.putDouble(d.doubleValue());
                } else if (data instanceof Long) {
                    h.putLong(d.longValue());
                } else if (data instanceof Float) {
                    h.putFloat(d.floatValue());
                } else if (data instanceof Byte) {
                    h.putByte(d.byteValue());
                } else if (data instanceof Short) {
                    h.putShort(d.shortValue());
                } else {
                    h.putInt(data.hashCode());
                }
            } else if (data instanceof CharSequence) {
                h.putString((CharSequence) data, CHARSET);
            } else if (data.getClass().isArray()) {
                final int size = Array.getLength(data);
                for (int i = 0; i < size; i++) {
                    populateHasher(Array.get(data, i), h);
                }
            } else if (data instanceof Iterable) {
               /* for (final Object o : (Iterable < !-- ? -- >) data){
                    populateHasher(o, h);*/
            }
        } else {
            h.putInt(data.hashCode());
        }
    }
}
