package digital.future.vote.backend.util;

import com.google.bitcoin.core.AddressFormatException;
import com.google.bitcoin.core.Base58;

import java.security.SecureRandom;


public class UID {
    static SecureRandom rnd = new SecureRandom();
    static int UID_SIZE = 16; // bytes
    public static class UidFormatException extends Exception {
        UidFormatException(String message) {
            super(message);
        }
        UidFormatException(Throwable th) {
            super(th);
        }
    }

    private final byte[] uid;

    public UID(){
        uid = new byte[UID_SIZE];
        rnd.nextBytes(uid);
    }

    // Validate that the string looks like UID (to avoid manual entering errors) and construct UID.
    public UID(String fromString) throws UidFormatException {
        try {
            byte[] decoded = Base58.decode(fromString);
            if (decoded.length != (UID_SIZE + 1))
                throw new UidFormatException("Incorrect size: " + decoded.length);
            if (validateCrc(decoded))
                throw new UidFormatException("CRC");
            uid = new byte[UID_SIZE];
            System.arraycopy(decoded, 0, uid, 0, UID_SIZE);
        } catch (AddressFormatException e) {
            throw new UidFormatException(e);
        }
    }

    // Base58 encoded string consisting of random bytes + 1 crc byte (to avoid manual entering errors).
    public String toString() {
        return Base58.encode(appendCrc(uid));
    }


    static byte[] appendCrc(byte[] bytes) {
        byte crc = 0;
        for (byte b : bytes) {
            crc ^= b;
        }
        byte[] withCrc = new byte[bytes.length + 1];
        System.arraycopy(bytes, 0, withCrc, 0, bytes.length);
        withCrc[bytes.length] = crc;
        return withCrc;
    }

    static boolean validateCrc(byte[] array) {
        byte crc = 0;
        for (byte b : array) {
            crc ^= b;
        }
        return crc == 0;
    }
}
