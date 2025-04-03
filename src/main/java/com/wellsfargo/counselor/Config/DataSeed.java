package com.wellsfargo.counselor.Config;

import com.wellsfargo.counselor.entity.*;
import com.wellsfargo.counselor.repository.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeed {

    @Bean
    CommandLineRunner initData(
        AdvisorRepository advisorRepo,
        ClientRepository clientRepo,
        PortfolioRepository portfolioRepo,
        SecurityRepository securityRepo
    ) {
        return args -> {
            // Create Advisor
            Advisor advisor = new Advisor("John", "Doe", "123 Elm St", "123-456-7890", "john.doe@email.com");
            advisorRepo.save(advisor);

            // Create Client
            Client client = new Client(advisor, "Jane", "Smith", "456 Oak Ave", "555-123-4567", "jane.smith@email.com");
            clientRepo.save(client);

            // Create Portfolio
            Portfolio portfolio = new Portfolio(client, "2025-04-03");
            portfolioRepo.save(portfolio);

            // Create Securities
            Security security1 = new Security(portfolio, "Apple Inc.", "Tech", "2024-01-01", 150.00, 10);
            Security security2 = new Security(portfolio, "Tesla Inc.", "Auto", "2023-12-12", 200.00, 5);
            securityRepo.save(security1);
            securityRepo.save(security2);

            System.out.println("✅ Sample data seeded.");
        };
    }
}
