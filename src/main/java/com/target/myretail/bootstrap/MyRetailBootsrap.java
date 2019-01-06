package com.target.myretail.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.target.myretail.application.MyRetailApplication;
import com.target.myretail.models.CurrentPrice;
import com.target.myretail.models.Product;
import com.target.myretail.models.ProductDescription;
import com.target.myretail.repositories.ProductDescriptionRepository;
import com.target.myretail.repositories.ProductRepository;

@Component
public class MyRetailBootsrap implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger logger = LoggerFactory.getLogger(MyRetailBootsrap.class);
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductDescriptionRepository productDescriptionRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		logger.info("Loading all the sample data into MongoDB.");
		loadProductsData();
	}

	private void loadProductsData() {
		// 15117729, 16483589, 16696652, 16752456, 15643793
		
		productDescriptionRepository.deleteAll();

		Product p15117729 = new Product();
		CurrentPrice cp15117729 = new CurrentPrice();
		cp15117729.setCurrencyCode("USD");
		cp15117729.setValue((float) 13.49);
		p15117729.setCurrentPrice(cp15117729);
		p15117729.setproductID(15117729);
		
		productRepository.save(p15117729);

		Product p16483589 = new Product();
		CurrentPrice cp16483589 = new CurrentPrice();
		cp16483589.setCurrencyCode("USD");
		cp16483589.setValue((float) 13.09);
		p16483589.setCurrentPrice(cp16483589);
		p16483589.setproductID(16483589);

		productRepository.save(p16483589);

		Product p16696652 = new Product();
		CurrentPrice cp16696652 = new CurrentPrice();
		cp16696652.setCurrencyCode("USD");
		cp16696652.setValue((float) 14.49);
		p16696652.setCurrentPrice(cp16696652);
		p16696652.setproductID(16696652);

		productRepository.save(p16696652);

		Product p16752456 = new Product();
		CurrentPrice cp16752456 = new CurrentPrice();
		cp16752456.setCurrencyCode("USD");
		cp16752456.setValue((float) 15.49);
		p16752456.setCurrentPrice(cp16752456);
		p16752456.setproductID(16752456);

		productRepository.save(p16752456);

		Product p15643793 = new Product();
		CurrentPrice cp15643793 = new CurrentPrice();
		cp15643793.setCurrencyCode("USD");
		cp15643793.setValue((float) 16.49);
		p15643793.setCurrentPrice(cp15643793);
		p15643793.setproductID(15643793);

		productRepository.save(p15643793);

		productDescriptionRepository.save(new ProductDescription(15117729, "shirt"));
		productDescriptionRepository.save(new ProductDescription(16483589, "t-shirt"));
		productDescriptionRepository.save(new ProductDescription(16696652, "polos"));
		productDescriptionRepository.save(new ProductDescription(16752456, "camera"));
		productDescriptionRepository.save(new ProductDescription(15643793, "watch"));
	}

}
