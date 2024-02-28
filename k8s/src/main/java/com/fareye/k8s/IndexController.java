package com.fareye.k8s;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fareye.k8s.DataSourceProperties;
import org.springframework.web.client.RestTemplate;



@RestController
public class IndexController {

    private final DataSourceProperties dataSourceProperties;

    public IndexController(DataSourceProperties dataSourceProperties) {
        this.dataSourceProperties = dataSourceProperties;
    }

    @GetMapping("/")
    public String index() {
        System.out.println("insideapplication");
        String username = dataSourceProperties.getUsername();
        String company = dataSourceProperties.getCompany();
        String employid = dataSourceProperties.getEmployid();
        String password = dataSourceProperties.getPassword();

        // Assuming the REST API URL is "http://example.com/api/employee/{employid}"
        String apiUrl = dataSourceProperties.getApiUrl();

        // Create a RestTemplate instance
        RestTemplate restTemplate = new RestTemplate(); 

        // Make a GET request to the API and retrieve the response
        String apiresponseDetails = restTemplate.getForObject(apiUrl, String.class);


        return "Welcome to Wednesday's with Kubernetes by " + username + " from " + company +
                ".\nEmployee ID: " + employid + "<br>Password from secret:<br>" + password +
                ".<br>-----------------------------------------<br>" +
            "<div style=\"text-align: center; font-weight: bold; font-size: larger;\">Service call api output:</div>" +
                apiresponseDetails;                
    }
}
