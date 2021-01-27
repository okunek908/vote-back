package digital.future.vote.backend.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestUid {

    @Test
    void testCreateDifferent() {
        UID uid1 = new UID();
        UID uid2 = new UID();
        assertNotEquals(uid1, uid2);
    }

    @Test
    void testToFromString()  {
        UID uid1 = new UID();
        UID uid2 = new UID(uid1.toString());
        System.out.println(uid1.toString());
        assertEquals(uid1, uid2);
    }

    @Test
    void testFromEqualStrings()  {
        UID uid1 = new UID("4XWRu34D9XuVmAQave1QaE3Mk3shP");
        UID uid2 = new UID("4XWRu34D9XuVmAQave1QaE3Mk3shP");
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

    @Test
    void testPrefixed()  {
        UID uid1 = new PrefixedUID();
        UID uid2 = new PrefixedUID(uid1.toString());
        System.out.println(uid1.toString());
        assertEquals(uid1, uid2);
    }

    static class PrefixedUID extends UID {
        public PrefixedUID() {
            super();
        }

        public PrefixedUID(String fromString) throws FormatException {
            super(fromString);
        }

        @Override
        protected String getPrefix() {
            return "A1-";
        }

        @Override
        protected int getSizeBytes() {
            return 4;
        }
    }

}
