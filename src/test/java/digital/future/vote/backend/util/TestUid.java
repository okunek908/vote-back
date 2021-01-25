package digital.future.vote.backend.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestUid {

    @Test
    void testCreate() {
        UID uid1 = new UID();
        UID uid2 = new UID();
        System.out.println(uid1.toString());
        System.out.println(uid2.toString());
        assertNotEquals(uid1, uid2);
    }

    @Test
    void testFromStringAndEquals() throws UID.FormatException {
        UID uid1 = new UID("7LVJoaKS64ra1sVWMA8xxRXzvMGTM");
        UID uid2 = new UID("7LVJoaKS64ra1sVWMA8xxRXzvMGTM");
        assertEquals(uid1, uid2);
    }

    @Test
    void testThrows() {
        assertThrows(UID.FormatException.class, () -> {
            new UID("");
        });
        assertThrows(UID.FormatException.class, () -> {
            new UID("7LVJoaKS64ra1sVWMA8xxRXzvMGTM ");
        });
        assertThrows(UID.FormatException.class, () -> {
            new UID("7LVJoaKS64ra1sVWMA8xxRXzvMGTN");
        });
    }

}
