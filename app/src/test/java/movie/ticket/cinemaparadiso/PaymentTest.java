package movie.ticket.cinemaparadiso;

import org.junit.Test;

import static org.junit.Assert.*;

public class PaymentTest {
    @Test
    public void stoI() {
        String input = "256";
        int out[],exp[] = {256};
        Payment payment= new Payment();
        out = new int[]{payment.StoI(input)};
        assertArrayEquals("String to Integer",exp,out);
    }


    @Test
    public void cardNo() {
        String[] inp = {"1234567890123456"},exp = {"1234 5678 9012 3456"},out;
        Payment payment = new Payment();
        out = new String[]{payment.cardNo(inp[0])};
        assertArrayEquals("CardNumber",exp,out);
    }
}