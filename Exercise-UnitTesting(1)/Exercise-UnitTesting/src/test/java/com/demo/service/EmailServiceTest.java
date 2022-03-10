package com.demo.service;

import com.demo.domain.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class EmailServiceTest {
    @Mock
    Order orderMock;

    @InjectMocks
    EmailService emailServiceMock;

    @Test(expected = RuntimeException.class)
    public void sendEmail() {
        EmailService emailService = new EmailService();
        Order order = new Order(5, "Lays", 50);

        emailService.sendEmail(order);

        verify(emailServiceMock).sendEmail(order);
    }
    @Test
    public void testSendEmail() {
        EmailService emailService = new EmailService();
        Order order = new Order(5, "Lays", 50);

        emailServiceMock.sendEmail(order, "pooja.upreti@tothenew.com");

        assertEquals(true, emailService.sendEmail(order,"pooja.upreti@totthenew.com"));
    }
}
