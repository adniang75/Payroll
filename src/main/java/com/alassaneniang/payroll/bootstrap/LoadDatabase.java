package com.alassaneniang.payroll.bootstrap;

import com.alassaneniang.payroll.models.Employee;
import com.alassaneniang.payroll.models.Order;
import com.alassaneniang.payroll.models.Status;
import com.alassaneniang.payroll.repositories.EmployeeRepository;
import com.alassaneniang.payroll.repositories.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j( topic = "bootstrap" )
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase ( EmployeeRepository employeeRepository, OrderRepository orderRepository ) {
        return args -> {
            employeeRepository.save( new Employee( "Bilbo", "Baggins", "burglar" ) );
            employeeRepository.save( new Employee( "Frodo", "Baggins", "thief" ) );
            employeeRepository.findAll().forEach( employee ->
                    log.info( "Preloaded " + employee ) );

            orderRepository.save( new Order( "MacBook Pro", Status.COMPLETED ) );
            orderRepository.save( new Order( "iPhone", Status.IN_PROGRESS ) );

            orderRepository.findAll().forEach( order -> log.info( "Preloaded " + order ) );
        };
    }

}
