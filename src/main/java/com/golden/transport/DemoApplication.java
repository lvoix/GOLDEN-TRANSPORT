package com.golden.transport;

import com.golden.transport.domain.Invoice;
import com.golden.transport.repository.InvoiceRepository;
import com.golden.transport.service.FilesStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import javax.annotation.Resource;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Resource
	FilesStorageService storageService;

	@Autowired
	InvoiceRepository  invoiceRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... arg) throws Exception {
		//storageService.deleteAll();
		//storageService.init();
		//Invoice inv = new Invoice();
		for (int i =0; i < 4; i++) {
			Invoice inv = new Invoice();
			invoiceRepository.save(inv);
		}
	}
    /*@Bean
    public ServletWebServerFactory servletWebServerFactory() {
        return new TomcatServletWebServerFactory();
    }*/

}
