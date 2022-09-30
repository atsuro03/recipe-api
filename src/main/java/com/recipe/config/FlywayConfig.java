package com.recipe.config;

import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayConfig {
	
	@Bean
	public FlywayMigrationStrategy  strategy() {
		return flyway -> {
			// flyway_schema_history の初期化
			flyway.clean();
			// マイグレーション実行
			flyway.migrate();
		};
	}
}
