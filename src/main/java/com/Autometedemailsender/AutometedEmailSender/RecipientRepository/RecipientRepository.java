package com.Autometedemailsender.AutometedEmailSender.RecipientRepository;

import com.Autometedemailsender.AutometedEmailSender.Recipient.Recipient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipientRepository extends JpaRepository<Recipient,Long> {
}
