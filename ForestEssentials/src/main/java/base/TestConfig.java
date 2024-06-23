package base;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.DefaultValue;
import org.aeonbits.owner.Config.Key;

	@Config.LoadPolicy(Config.LoadType.MERGE)
	@Config.Sources({
	        "classpath:configuration.properties",
	        "system:properties",
	        "system:env"
	})
	public interface TestConfig extends Config {

	    @Key("BASE_URL")
	    @DefaultValue("")
	    String baseUrl();
	    
	    @Key("browser")
	    @DefaultValue("")
	    String browser();

}

