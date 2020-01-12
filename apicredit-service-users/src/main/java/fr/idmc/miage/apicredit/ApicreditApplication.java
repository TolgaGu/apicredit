package fr.idmc.miage.apicredit;

import fr.idmc.miage.apicredit.worker.AuthenticationWorker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


@SpringBootApplication
public class ApicreditApplication {

    public static void main(String[] args) {

        SpringApplication.run(ApicreditApplication.class, args);
    }


}

@Component
class LaunchWorker implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(1);
		AuthenticationWorker worker = new AuthenticationWorker();
		executor.scheduleAtFixedRate(worker,0, 1750, TimeUnit.SECONDS);
	}
}
