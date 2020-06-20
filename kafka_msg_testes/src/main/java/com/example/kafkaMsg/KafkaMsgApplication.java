package com.example.kafkaMsg;

import java.io.Console;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class KafkaMsgApplication {

	public static void main(String[] args) throws InterruptedException {

		ApplicationContext ctx = SpringApplication.run(KafkaMsgApplication.class, args);
		
		Producer producerKafka = ctx.getBean(Producer.class);		
		String str = "";
		Console con = null;

		try {
			con = System.console();
			promptKafkaMsg();

			while (!str.equalsIgnoreCase("stop")) {
				str = con.readLine();
				producerKafka.enviarMsg(str);				
				Thread.sleep(500);
				promptKafkaMsg();
			}
			System.exit(0);
		} catch (Exception ex) {
			System.out.println(ex);

		}
	}

	static void promptKafkaMsg(){
		System.out.println("\n\n========================================| KAFKA MSG |==================================");
		System.out.print("Digite sua mensagem: ");
	}


}
