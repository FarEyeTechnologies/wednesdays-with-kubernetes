import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    private final DataSourceProperties dataSourceProperties;

    @Autowired
    public IndexController(DataSourceProperties dataSourceProperties) {
        this.dataSourceProperties = dataSourceProperties;
    }

    @GetMapping("/api")
    public String index() {
        System.out.println("insideapplication");
        String username = dataSourceProperties.getUsername();
        String company = dataSourceProperties.getCompany();
        String employid = dataSourceProperties.getEmployid();
        String password = dataSourceProperties.getPassword();

        return "Welcome to Wednesday's with Kubernetes by " + username + " from " + company + ". Employee ID: " + employid;
    }
}
