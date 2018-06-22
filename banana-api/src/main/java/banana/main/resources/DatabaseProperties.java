package banana.main.resources;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties("dbase")
public class DatabaseProperties {
	
	private String url;
	private String datastore;
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getDatastore() {
		return datastore;
	}
	
	public void setDatastore(String datastore) {
		this.datastore = datastore;
	}
	
}
